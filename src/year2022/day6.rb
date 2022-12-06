#!/usr/bin/env ruby
result1 = 0
result2 = 0
NUM1 = 4
NUM2 = 14 

datastream = File.read('input/day6.txt').chars

# Puzzle 1
datastream.length.times do |c|
    set = datastream.slice(c, NUM1)
    if NUM1 == set.uniq.length
        result1 = c + NUM1
        break
    end
end

# Puzzle 2
datastream.length.times do |c|
    set = datastream.slice(c, NUM2)
    if NUM2 == set.uniq.length
        result2 = c + NUM2
        break
    end
end

# Puzzle 1 
puts "Answer Part 1:"
puts result1

# Puzzle 2
puts "Answer Part 2:"
puts result2
