#!/bin/sh

for i in 1 "Hmm" 3; do
    echo $i
done

echo "----------------"

let "a = 5 % 3"
while [ $a -lt 10 ]; do
    echo $a
    let "a++"
done

echo "----------------"

let "b = (5 + 7) / 2"
until [ $b -eq 12 ]; do
    let "b++"
    echo $b
done