#!/usr/bin/env ruby

full_match = 0
overlap = 0

File.read('input/day4.txt').lines do |line|
    pairs = line.chomp.split(",")

    e1 = pairs[0].split("-").map(&:to_i)
    e2 = pairs[1].split("-").map(&:to_i)
    
    e1.first <= e2.first && e2.last <= e1.last || e2.first <= e1.first && e1.last <= e2.last ? full_match +=1 : full_match +=0
    e1.first <= e2.last && e2.first <= e1.last ? overlap +=1 : overlap +=0
end

# Puzzle 1 
puts "Answer Part 1:"
puts full_match

# Puzzle 2
puts "Answer Part 2:"
puts overlap