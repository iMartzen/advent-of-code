import re
import os


def digest_input(input):
    with open(input, "r") as file:
        return file.read()


def find_and_multiply_muls(input):
    pattern = r"mul\((\d{1,3}),(\d{1,3})\)"
    matches = re.findall(pattern, input)
    total_sum = 0
    for x, y in matches:
        total_sum += int(x) * int(y)
    return total_sum


def find_and_multiply_muls_with_conditions(input):
    mul_pattern = r"mul\((\d{1,3}),(\d{1,3})\)"
    do_pattern = r"do\(\)"
    dont_pattern = r"don't\(\)"
    enabled = True
    total_sum = 0
    for match in re.finditer(rf"{mul_pattern}|{do_pattern}|{dont_pattern}", input):
        instruction = match.group(0)
        if instruction == "do()":
            enabled = True
        elif instruction == "don't()":
            enabled = False
        else:
            if enabled:
                x, y = map(int, match.groups())
                total_sum += x * y
    return total_sum


input = os.path.join(os.path.dirname(__file__), "day3.txt")
print(f"Part 1: Totale som {find_and_multiply_muls(digest_input(input))}")
print(f"Part 2: Totale som met condities {find_and_multiply_muls_with_conditions(digest_input(input))}")
