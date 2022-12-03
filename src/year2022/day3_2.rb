#!/usr/bin/env ruby

index = [*'a'..'z', *'A'..'Z']
priorities = 0

rugsacks = File.readlines('input/day3.txt')
groups = rugsacks.each_slice(3).to_a 
n = groups.length

for i in 1..n do
        r = i-1
        rugsack_one = groups[r][0].split("")
        rugsack_two = groups[r][1].split("")
        rugsack_three = groups[r][2].split("")
        common = rugsack_one & rugsack_two & rugsack_three
        priorities = priorities + (index.find_index(common[0])+1)
end

# Puzzle 2
puts "Answer Part 2:"
puts priorities
