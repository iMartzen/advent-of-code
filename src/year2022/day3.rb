#!/usr/bin/env ruby

index = [*'a'..'z', *'A'..'Z']
priorities = 0

File.read('input/test.txt').lines do |line|
        rugsack = line.chomp.split("")
        compartments = rugsack.each_slice(rugsack.size/2).to_a       
        common = compartments[0] & compartments[1]
        priorities = priorities + (index.find_index(common[0])+1)
end

# Puzzle 1 
puts "Answer Part 1:"
puts priorities
