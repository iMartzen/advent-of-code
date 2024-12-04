import os


def digest_input(input):
    with open(input, "r") as file:
        return [list(line.strip()) for line in file]


def find_word(wordsearch, word):
    rows = len(wordsearch)
    cols = len(wordsearch[0])
    word_length = len(word)
    count = 0

    def check_direction(start_row, start_col, delta_row, delta_col):
        for i in range(word_length):
            row = start_row + i * delta_row
            col = start_col + i * delta_col
            if (
                row < 0
                or col < 0
                or row >= rows
                or col >= cols
                or wordsearch[row][col] != word[i]
            ):
                return False
        return True

    for r in range(rows):
        for c in range(cols):
            directions = [
                (0, 1),  # Rechts
                (0, -1),  # Links
                (1, 0),  # Omlaag
                (-1, 0),  # Omhoog
                (1, 1),  # Diagonaal rechts-omlaag
                (1, -1),  # Diagonaal links-omlaag
                (-1, 1),  # Diagonaal rechts-omhoog
                (-1, -1),  # Diagonaal links-omhoog
            ]
            for delta_row, delta_col in directions:
                if check_direction(r, c, delta_row, delta_col):
                    count += 1

    return count


def find_cross(wordsearch):
    result = 0

    for row, line in enumerate(wordsearch[1:-1], start=1):
        for col, char in enumerate(line[1:-1], start=1):
            if char == "A":
                top_left = wordsearch[row - 1][col - 1]
                top_right = wordsearch[row - 1][col + 1]
                bottom_left = wordsearch[row + 1][col - 1]
                bottom_right = wordsearch[row + 1][col + 1]

                if f"{bottom_right}A{top_left}" in (
                    "MAS",
                    "SAM",
                ) and f"{bottom_left}A{top_right}" in ("MAS", "SAM"):
                    result += 1

    return result


input = os.path.join(os.path.dirname(__file__), "day4.txt")
wordsearch = digest_input(input)
WORD = "XMAS"
print(f"Part 1: # 'XMAS' {find_word(wordsearch, WORD)} keer voor.")
print(f"Part 2: # X-MAS : {find_cross(wordsearch)} keer voor.")
