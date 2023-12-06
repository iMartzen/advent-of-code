#!/usr/bin/env ruby

# Interpreter file function
def read_from_file(filename)
    time, record = File.read(filename).split("\n").map { |line| line.split[1..-1].map(&:to_i) }
    [time, record]
end

def calculate_ways(time, record)
    result = 1
    (1..time).each do |j|
      if j * (time - j) > record
          result *= time - j - j + 1
        break
      end
  end
  result
end

# Part 1
def puzzle_one(time, record)
    sum = 1
    time.each_with_index do |time, i|
        sum *= calculate_ways(time, record[i])
    end
    sum
end

# Part 2
def puzzle_two(time, record)
    calculate_ways(time.join.to_i, record.join.to_i)
end

# Solutions section
puts [["🎄 "],["Advent of Code 2023"],[" 🎄"]].join
filename = "input/test.txt"
time, record = read_from_file(filename)

# Puzzle 1
puts "Answer Part 1:"
puts puzzle_one(time, record)
# puts result

# Puzzle 2
puts "Answer Part 2:"
puts puzzle_two(time, record)
