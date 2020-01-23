#!/bin/bash

clear

# Define Variable which contains the path
#WORKING_DIR=$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )
WORKING_DIR="/home/"
#WORKING_DIR="./FolderInCurrentDirectory"


echo "--- Check if directory is empty ---"
echo "==================================="
echo ""
echo "Content of: $WORKING_DIR"
ls $WORKING_DIR
echo ""



echo "--- first possibility ---"
echo ""

if [ -z "$(ls -A $WORKING_DIR)" ]; then
	echo "if branch: Directory is empty" 
	echo "Second if statement"
else
	echo "else branche: Directory is NOT empty"
	echo "Second else statement"
fi
echo ""



echo "--- second possibility ---"
echo ""
[[ -z "$(ls -A $WORKING_DIR)" ]] && { echo "if branch: Directory is empty"; echo "Second if statement"; } || { echo "else branche: Directory is NOT empty"; echo "Second else statement"; }
echo ""


