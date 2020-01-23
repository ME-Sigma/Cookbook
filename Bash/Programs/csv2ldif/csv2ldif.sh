#!/bin/bash

#write ldif file
#function parameters: Filename uidNumber givenName sn email/uid description password
function write_file () {
	echo "# Gerke, Users, oc, cs.uni-saarland.de
dn: uid=$5,ou=People,ou=defponch,dc=uni-saarland,dc=de
objectClass: top
objectClass: person
objectClass: organizationalPerson
objectClass: posixAccount
objectClass: shadowAccount
objectClass: inetOrgPerson
cn: $3 $4
givenName: $3
sn: $4
uid: $5
userPassword: $7
uidNumber: $2
gidNumber: $2
displayName: $3 $4
description: $6
homeDirectory: /home/$3$4
loginShell: /bin/nologin
gecos: $3 $4
mail: $5
shadowLastChange: 18157
shadowMax: 9999
shadowExpire: 18627">"ldif_files/$1"
	echo "Created $1"
}

#Check for existing file
function check_if_file_exists () {
	FILE=$1
	if test -f "$FILE"; then
		echo "$FILE exists"
		return 0
	else
		echo "$FILE does not exist"
		return 1
	fi
}

########################
###   Main Program   ###
########################

echo "Run csv2ldif.sh"

#Read config file
input="csv2ldif.conf"
while IFS=';' read -r col1 col2
do
	ID=$col2
	Parametername=$col1
  	#echo "Current ID: $ID"
done < "$input"

#Read User input file
input="users.csv"
{
read									#omitting first line
while IFS=';' read -r gName sName email description pw rest
do
	uid=$(echo "$gName$sName"|tr '[:upper:]' '[:lower:]')
	echo "ID: $ID   Given Name: $gName   Surname: $sName    Email: $email   UID: $uid"
	write_file "$gName$sName.ldif" "$ID" "$gName" "$sName" "$email" "$description" "$pw"
	((ID=ID+1))
done
} < "$input"


#update config file
echo "$Parametername;$ID;">csv2ldif.conf

#write_file
#check_if_file_exists csv2ldif.conf
