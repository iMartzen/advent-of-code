import os
from collections import Counter


def digest_input(input):
    left_list = []
    right_list = []

    with open(input, "r") as file:
        for line in file:
            numbers = line.strip().split()
            if len(numbers) == 2:
                left, right = map(int, numbers)
                left_list.append(left)
                right_list.append(right)
    return left_list, right_list


def solution_day1_part2(file_path):
    left_list, right_list = digest_input(file_path)
    right_counter = Counter(right_list)
    similarity_score = 0
    for num in left_list:
        frequency = right_counter[num]
        similarity_score += num * frequency

    return similarity_score


def solution_day1_part1(file_path):
    left_list, right_list = digest_input(file_path)
    left_list.sort()
    right_list.sort()
    total_distance = sum(
        abs(left - right) for left, right in zip(left_list, right_list)
    )
    return total_distance


input = os.path.join(os.path.dirname(__file__), "day1.txt")
print(f"Part 1: De totale afstand is: {solution_day1_part1(input)}")
print(f"Part 2: De similariteitsscore is: {solution_day1_part2(input)}")
