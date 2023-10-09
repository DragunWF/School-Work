# https://snakify.org/en/lessons/dictionaries_dicts/problems/english_latin_dict/

dictionary = {}
all_latin_words = []

def print_output() -> None:
    displayed = []
    items = dictionary.items()
    print(len(items))
    for word in all_latin_words:
        for item in items:
            if item[0] == word and not word in displayed:
                print(word + " - " + ", ".join(item[1]))
                displayed.append(word)
                break

def main() -> None:
    n = int(input())
    for i in range(n):
        values = input().split("-")
        latin = [v.strip() for v in values[1].split(",")]
        english = values[0].rstrip()
        for word in latin:
            if not word in dictionary:
                dictionary[word] = []
            dictionary[word].append(english)
            all_latin_words.append(word)
    all_latin_words.sort()
    print_output()

if __name__ == "__main__":
    main()
