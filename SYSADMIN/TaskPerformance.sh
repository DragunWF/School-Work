#!/bin/sh
echo "Type a name for your new directory"
read dirName
mkdir $dirName

echo "Type another name for your new sub directory"
read subDirName
mkdir "$dirName/$subDirName"

touch "grades"
chmod 755 grades

sudo apt install tree
tree