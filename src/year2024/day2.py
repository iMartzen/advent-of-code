import os


def digest_input(input):
    reports = []
    with open(input, "r") as file:
        for line in file:
            reports.append(list(map(int, line.strip().split())))
    return reports


def is_safe_report(report):
    is_increasing = all(report[i] < report[i + 1] for i in range(len(report) - 1))
    is_decreasing = all(report[i] > report[i + 1] for i in range(len(report) - 1))
    has_valid_differences = all(
        1 <= abs(report[i] - report[i + 1]) <= 3 for i in range(len(report) - 1)
    )
    return (is_increasing or is_decreasing) and has_valid_differences


def can_be_safe_with_dampener(report):
    for level_to_remove_index in range(len(report)):
        subreport = []
        for current_level_index in range(len(report)):
            if current_level_index != level_to_remove_index:
                subreport.append(report[current_level_index])
        if is_safe_report(subreport):
            return True
    return False


def solution_day2_part1(input_file):
    reports = digest_input(input_file)
    safe_reports = sum(1 for report in reports if is_safe_report(report))
    return safe_reports


def solution_day2_part2(input_file):
    reports = digest_input(input_file)
    safe_reports = 0
    for report in reports:
        if is_safe_report(report) or can_be_safe_with_dampener(report):
            safe_reports += 1
    return safe_reports


input = os.path.join(os.path.dirname(__file__), "day2.txt")
print(f"Part 1: # veilige rapporten: {solution_day2_part1(input)}")
print(f"Part 2: # veilige rapporten met demper: {solution_day2_part2(input)}")
