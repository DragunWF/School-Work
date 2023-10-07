both = set()
n, m = map(int, input().split(" "))


def add_cubes(length: int) -> set:
    global both
    output = []
    for i in range(length):
        num = int(input())
        output.append(num)
        both.add(num)
    return output


def print_cubes(set_of_cubes: set) -> None:
    print(len(set_of_cubes))
    for num in set_of_cubes:
        print(num)


alice, bob = add_cubes(n), add_cubes(m)
print_cubes(alice)
print_cubes(bob)
