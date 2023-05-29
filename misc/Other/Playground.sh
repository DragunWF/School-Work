user=$(whoami)
datetime=$(date)

echo "Welcome $user! I hope you enjoy your stay here..."
echo "The time now is currently: $datetime"

echo "What else would you like to be called as?"
nickname=$(read)

echo "Hello, $nickname"
echo "The current filename is $0"

echo "Type a random number: "
read num
if [ $num -gt 3 ]; then
    echo "The number is greater than 3"
else
    echo "The number is not greater than 3"
fi
let "sum = $num + 5"
echo $sum

echo "Now say anything: "
read response
case $response in
    hi)
        echo "Hello there!"
        ;;
    farewell)
        echo "Goodbye!"
        ;;
    *)
        echo "Okay"
        ;;
esac

echo "Say the word"
read answer
until [ $answer == "word" ]; do
    echo "You did not say the word"
    read answer
done;
echo "Congrats, you said the word"