#!/usr/bin/env ruby

full_match = 0
overlap = 0

File.read('input/day4.txt').lines do |line|
    pairs = line.chomp.split(",")

    e1 = pairs[0].split("-")
    e2 = pairs[1].split("-")
    e1s = e1[0].to_i
    e1e = e1[1].to_i
    e2s = e2[0].to_i
    e2e = e2[1].to_i

    e1s <= e2s && e2e <= e1e || e2s <= e1s && e1e <= e2e ? full_match +=1 : full_match +=0
    e1s <= e2e && e2s <= e1e ? overlap +=1 : overlap +=0
end

# Puzzle 1 
puts "Answer Part 1:"
puts full_match

# Puzzle 2
puts "Answer Part 2:"
puts overlap
