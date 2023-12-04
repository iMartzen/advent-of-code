#!/usr/bin/env ruby

def read_from_file(filename)
    File.readlines(filename).map(&:chomp)
end

def extract_scratchcard_data(scratchcard)
    numeric_data = scratchcard.split(':', 2).last
    winning_numbers, my_numbers = numeric_data.split('|').map { |list| list.split.map(&:to_i) }
    [winning_numbers, my_numbers]
end

def calculate_scratchcard_points(scratchcard)
    winning_numbers, my_numbers = extract_scratchcard_data(scratchcard)
    matches = my_numbers & winning_numbers
    return 0 if matches.empty?
    points = 1
    (matches.count - 1).times { points *= 2 }
    points
end

def process_scratchcards(scratchcard)
    winning_numbers, my_numbers = extract_scratchcard_data(scratchcard)
    calculate_matches(winning_numbers, my_numbers)
end

def calculate_matches(winning_numbers, my_numbers)
    my_numbers.select { |num| winning_numbers.include?(num) }
end

def puzzle_one(scratchcards_data)
    scratchcards_data.sum { |scratchcard| calculate_scratchcard_points(scratchcard) }
end

def puzzle_two(scratchcards_data)
    total_scratchcards = Array.new(scratchcards_data.length, 1)
    scratchcards_data.each_with_index do |row, index|
        winning = process_scratchcards(row)

        unless winning.empty?
            winning.length.times do |i|
                next_index = index + i + 1
                total_scratchcards[next_index] += total_scratchcards[index] if next_index < scratchcards_data.length
            end
        end
    end
    total_scratchcards.sum
end

# Solutions section
puts [["🎄 "],["Advent of Code 2023"],[" 🎄"]].join
file_path = 'input/day4.txt'
scratchcards_data = read_from_file(file_path)

# Puzzle 1
puts "Answer Part 1:"
puts puzzle_one(scratchcards_data)

# Puzzle 2
puts "Answer Part 2:"
puts puzzle_two(scratchcards_data)
