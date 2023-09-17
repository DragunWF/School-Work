#!/bin/sh

echo "Welcome to my practice program"
read input
if [ $input == "yes" ]; then
    echo "Yes to you too"
else
    echo "Okay"
fi

echo "Now type in a number"
read num
if [ $num -ge 5 ]; then
    echo "Number is greater or equal to 5"
else
    echo "Number is not greater or equal to 5"
fi

echo "Now type in a letter"
read letter
case $letter in
    a) 
        echo "You typed the letter a"
        ;;
    b)
        echo "You typed the letter b"
        ;;
    *)
        echo "You did not type either the letter a or b"
        ;;
esac