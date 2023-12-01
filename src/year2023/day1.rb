#!/usr/bin/env ruby

# Puzzle 1
# The newly-improved calibration document consists of lines of text; each line originally contained a specific calibration value that the Elves now need to recover. On each line, the calibration value can be found by combining the first digit and the last digit (in that order) to form a single two-digit number.
# For example:
# 1abc2
# pqr3stu8vwx
# a1b2c3d4e5f
# treb7uchet
# In this example, the calibration values of these four lines are 12, 38, 15, and 77. Adding these together produces 142.
# Consider your entire calibration document. What is the sum of all of the calibration values?

sum = 0
File.read('input/day1.txt').lines do |line|
    numbers = line.scan(/\d+/)
    first_digit = numbers.first[0].to_i
    last_digit = numbers.last[-1].to_i
    combined_number = (first_digit * 10) + last_digit
    calibration_value = combined_number
    sum = sum + calibration_value
end

# Puzzle 2 
# Your calculation isn't quite right. It looks like some of the digits are actually spelled out with letters: one, two, three, four, five, six, seven, eight, and nine also count as valid "digits".
# Equipped with this new information, you now need to find the real first and last digit on each line. For example:
# In this example, the calibration values are 29, 83, 13, 24, 42, 14, and 76. Adding these together produces 281.
# What is the sum of all calibration values on the document?

def digit_mapping(word)
  digit_mapping = {
    "one" => 1,
    "two" => 2,
    "three" => 3,
    "four" => 4,
    "five" => 5,
    "six" => 6,
    "seven" => 7,
    "eight" => 8,
    "nine" => 9,
    "eno" => 1,
    "owt" => 2,
    "eerht" => 3,
    "ruof" => 4,
    "evif" => 5,
    "xis" => 6,
    "neves" => 7,
    "thgie" => 8,
    "enin" => 9
  }
  digit_mapping[word] || word.to_i
end

def extract_first_and_last_digits(line)
  first_pattern = line.scan(/one|two|three|four|five|six|seven|eight|nine|\d/).first
  last_pattern = line.reverse.scan(/eno|owt|eerht|ruof|evif|xis|neves|thgie|enin|\d/).first
  first_digit = digit_mapping(first_pattern)
  last_digit = digit_mapping(last_pattern)
  [first_digit, last_digit]
end

sum2 = 0
File.read('input/day1.txt').lines do |line|
  first_digit, last_digit = extract_first_and_last_digits(line)
  combined_number = "#{first_digit}#{last_digit}".to_i
  sum2 += combined_number
end
  
# Puzzles 
aoc = [["🎄 "],["Advent of Code 2023"],[" 🎄"]].join
puts aoc
# Puzzle 1 
puts "Answer Part 1:"
puts sum 

# Puzzle 2
puts "Answer Part 2:"
puts sum2
