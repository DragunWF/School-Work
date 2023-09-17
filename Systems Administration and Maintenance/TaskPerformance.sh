#!/bin/sh
echo "Type a name for your new directory"
read dirName
mkdir $dirName

echo "Type another name for your new sub directory"
read subDirName
subDirPath="$dirName/$subDirName"
mkdir $subDirPath

gradesPath="$subDirPath/grades"
touch $gradesPath
chmod 755 $gradesPath

sudo apt install tree
tree