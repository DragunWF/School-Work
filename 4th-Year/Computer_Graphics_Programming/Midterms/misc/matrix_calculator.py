def main() -> None:
    # Expected output: [[6, 8], [10, 12]]
    print(matrix_addition([[1, 2], [3, 4]], [[5, 6], [7, 8]]))

    # Expected output: [[2, -2], [1, 5]]
    print(matrix_subtraction([[4, 2], [1, 6]], [[2, 4], [0, 1]]))

    # Expected output: [[2, 4], [6, 8]]
    print(scalar_multiplication(2, [[1, 2], [3, 4]]))

    # Expected output: [[1, 4, 7], [2, 5, 8], [3, 6, 9]]
    print(transpose_matrix([[1, 2, 3], [4, 5, 6], [7, 8, 9]]))

    # Expected output: True
    print(is_identity_matrix([[1, 0, 0, 0],
                              [0, 1, 0, 0],
                              [0, 0, 1, 0],
                              [0, 0, 0, 1]]))
    # Expected output: False
    print(is_identity_matrix([[1, 0, 0, 0],
                              [0, 1, 2, 0],
                              [0, 0, 1, 0],
                              [0, 3, 0, 1]]))

    # Expected output:[[50, 42, 42], [25, 96, 26]]
    print(matrix_multiplication([[3, 2, 1, 5], [9, 1, 3, 0]], [
          [2, 9, 0], [1, 3, 5], [2, 4, 7], [8, 1, 5]]))


def matrix_addition(matrix_a: list[list[int]], matrix_b: list[list[int]]) -> list[list[int]]:
    return matrix_arithmetic(matrix_a, matrix_b, True)


def matrix_subtraction(matrix_a: list[list[int]], matrix_b: list[list[int]]) -> list[list[int]]:
    return matrix_arithmetic(matrix_a, matrix_b, False)


def matrix_arithmetic(matrix_a: list[list[int]], matrix_b: list[list[int]], is_addition: bool) -> list[list[int]]:
    output = []
    for i in range(len(matrix_a)):
        row = []
        for j in range(len(matrix_a[i])):
            row.append(matrix_a[i][j] + matrix_b[i][j]
                       if is_addition else matrix_a[i][j] - matrix_b[i][j])
        output.append(row)
    return output


def scalar_multiplication(scalar: int, matrix: list[list[int]]) -> list[list[int]]:
    output = []
    for i in range(len(matrix)):
        row = []
        for j in range(len(matrix[i])):
            row.append(scalar * matrix[i][j])
        output.append(row)
    return output


def is_identity_matrix(matrix: list[list[int]]) -> list[list[int]]:
    for i in range(len(matrix)):
        for j in range(len(matrix[i])):
            cell = matrix[i][j]
            if (i == j and cell != 1) or (i != j and cell != 0):
                return False
    return True


def transpose_matrix(matrix: list[list[int]]) -> list[list[int]]:
    output = []
    for i in range(len(matrix)):
        row = []
        for j in range(len(matrix[i])):
            row.append(matrix[j][i])
        output.append(row)
    return output


def matrix_multiplication(matrix_a: list[list[int]], matrix_b: list[list[int]]) -> list[list[int]]:
    output = []
    for i in range(len(matrix_a)):
        row = []
        for j in range(len(matrix_b[0])):
            cell_sum = 0
            for k in range(len(matrix_b)):
                cell_sum += matrix_a[i][k] * matrix_b[k][j]
            row.append(cell_sum)
        output.append(row)
    return output


if __name__ == "__main__":
    main()
