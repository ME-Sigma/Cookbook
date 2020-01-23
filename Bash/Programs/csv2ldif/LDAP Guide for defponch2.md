############################################
### Title:		LDAP Guide for defponch2 ###
### Author:		Benedikt Roncossek       ###
### Created:	26.09.2019               ###
### Updated:	23.01.2020               ###
############################################

# Table of content

1. General Information
2. LDAP commands
3. Automatically adding new users
  - Bash script manual: csv2ldap.sh
  - csv2ldap.conf
  - user.csv
4. Enable logging for openLDAP (but Alex uses Directory Service from RetHat...)
  - Enable the production of server Logs
  - Consideration of OpenLDAP log in rsyslog
  - Test this functionality of the OpenLDAP server

# 1. General Inforamtion

Name of LDAP service:  
dirsrv@defponch2.service

Directory:  
/etc/dirsrv/

Logfiles (dirsrv) from Alex:  
Config-file:  
/etc/dirsrv/config/ldap-agent.conf  
Logfiles:  
/var/log/dirsrv/slapd-defponch2/


# 2. LDAP commands

Search an entry:
```
ldapsearch -W -D 'cn=Directory Manager' -b dc=uks,dc=de objectclass=* att1 att2
```

Add an entry:
```
ldapadd -D 'cn=Directory Manager' -W -f .../testuser.ldif
```

Modify an entry:
```
ldapmodify -Y external -H ldapi:/// -f example.ldif
```


Delete an entry (user):
```
ldapdelete -D 'cn=Directory Manager' -W "uid=lukefilewalker,ou=People,ou=defponch,dc=uni-saarland,dc=de"
```

# 3. Automatically adding new users
We decided to collect all new users in a csv-file. From that it is possible to automatically generate .ldif files, which in turn can be fed to LDAP.
## Bash script manual: csv2ldap.sh

Bash script to automatically generate .ldif files from a .csv file,
which then can be used with the ldapadd command.  
`csv2ldap.sh` expects `user.csv` and `csv2ldap.conf` in the same folder.
No additional arguments are required.
For every row (excluding the header row) in user.csv a new .ldif file
will be created in ../ldif_files/

Folder structure  
-csv2ldap/  
  &emsp;-`csv2ldap.sh`  
  &emsp;-`user.csv`  
  &emsp;-`csv2ldap.conf`  
  &emsp;-ldif_files/  
    &emsp;&emsp;-`user1.ldif`  
    &emsp;&emsp;-`user2.ldif`  
    &emsp;&emsp;-...  

For now `csv2ldap.sh` only does the conversion, but does not automatically add the entries to LDAP.

## csv2ldap.conf

`csv2ldap.conf` stores the uidNumber.  
This number should be unique for every user and therefore will be incremented for every new .ldif file created.

File structure:  
```
uidNumber;x;
```

Where x is an interger that will be incremented after a new .ldif file was created.  
uidNumber contains the String "uidNumber", which is simply the name of the field.

## user.csv

`user.csv` contains all the user information from which the .ldif files will be created.
This file has one header row.
Every consecutive row will be interpreted as a new user.
The delimiter has to be a ";"
The first five columns are needed in `csv2ldap.sh`.
Every additional column has additional information to the user, which is not needed in this program.

File structure:  
```
Firstname;Lastname;Email;Description;Password;Gender;Title;Address1;Address2;PLZ;City;Country;  
Han;Single;Han@gmx.de;Smuggler;123;;;;;;;;  
...
```

# 4. Enable logging for openLDAP

Sources: 	
- http://tutoriels.meddeb.net/openldap-tutorial-log/
- https://www.openldap.org/doc/admin24/slapdconf2.html

Logging Options for LDAP:

|__Level__|__Keyword__|__Description__|  
|-|-|-|
|-1|	any|	enable all debugging  
|0|	 |	no debugging  
|1|	(0x1 trace)|	trace function calls  |
|2|	(0x2 packets)|	debug packet handling  |
|4|	(0x4 args)|	heavy trace debugging  |
|8|	(0x8 conns)|	connection management  |
|16|	(0x10 BER)|	print out packets sent and received |
|32|	(0x20 filter)|	search filter processing  |
|64|	(0x40 config)|	configuration processing  |
|128|	(0x80 ACL)|	access control list processing  |
|256|	(0x100 stats)|	stats log connections/operations/results  |
|512|	(0x200 stats2)|	stats log entries sent  |
|1024|	(0x400 shell)|	print communication with shell backends  |
|2048|	(0x800 parse)|	print entry parsing debugging  |
|16384|	(0x4000 sync)|	syncrepl consumer processing  |
|32768|	(0x8000 none)|	only messages that get logged whatever log level is set  |

Table 4.1

Possible Combinations:  
olcLogLevel 129  
olcLogLevel 0x81  
olcLogLevel 128 1  
olcLogLevel 0x80 0x1  
olcLogLevel acl trace  

## Enable the production of server Logs
Create a new .ldif file for the ldifmodify command:
```
touch slapdlog.ldif
```

Modify that file so that its content becomes:
```
dn: cn=config
changeType: modify
replace: olcLogLevel
olcLogLevel: 416
```
416 is the Interger combination for 3 different logging options.  
416 = 32+128+256 --> "filter" "ACL" "stats"

Apply changes:
```
sudo ldapmodify -Y external -H ldapi:/// -f slapdlog.ldif
```

If we get the message: modifying entry « cn=config », the operation was successful.  
To check the result:
```
sudo ldapsearch -Y external -H ldapi:/// -b cn=config "(objectClass=olcGlobal)" olcLogLevel
```

## Consideration of OpenLDAP log in rsyslog
Create a configuration file in the folder /etc/rsyslog.d/.  
 E.g.: `myslapd.conf`
```
$template slapdtmpl,"[%$DAY%-%$MONTH%-%$YEAR% %timegenerated:12:19:date-rfc3339%] %app-name% %syslogseverity-text% %msg%\n"
local4.*    /var/log/slapd.log;slapdtmpl
```

Restart rsys-service
```
sudo service rsyslog restart
```

## Test this functionality of the OpenLDAP server
```
sudo ldapsearch -x cn=max -b dc=uks,dc=de
sudo cat /var/log/slapd.log
```
