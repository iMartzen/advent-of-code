#!/usr/bin/env ruby

elves = []
current_elf = 0 

File.read('input/day1.txt').lines do |line|
    if line.chomp.empty?
        elves << current_elf
        current_elf = 0
    else 
        current_elf += line.chomp.to_i
    end
end

# Puzzle 1 
puts "Answer Part 1:"
puts elves.max

# Puzzle 2
puts "Answer Part 2:"
puts elves.max(3).sum
