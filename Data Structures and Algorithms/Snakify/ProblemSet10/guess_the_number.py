# https://snakify.org/en/lessons/sets/problems/guess_number/

n = int(input())
numbers = set(input().split(" "))
while True:
    value = input()
    if value == "HELP":
        break
    elif value == "YES" or value == "NO":
        continue
    numbers = numbers.difference(value.split(" "))
print(" ".join(sorted(list(numbers))))
