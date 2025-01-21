def main():
    classmates = []
    for i in range(1, 4):
        name = input(f"Classmate Name ({i}): ")
        classmates.append(name)

    print("\nClassmates:")
    for i in range(len(classmates)):
        print(f"{i + 1}. {classmates[i]}")


if __name__ == "__main__":
    main()
