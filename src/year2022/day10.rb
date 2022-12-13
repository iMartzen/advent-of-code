#!/usr/bin/env ruby

instructions = File.readlines('input/day10.txt').map {|l| l.scan(/\S+/) } 

counter = 0
x = 1 
register = [1]
cycles = [ 20, 60, 100, 140, 180, 220 ]
cycle = []
signal_strength = 0
crt = ""


instructions.each do |i|

  register.push(x)

  instruction = i[0]
  step = i[1].to_i
  counter += 1

  if cycles.include?(counter)
    cycle.push(x)
  end 

  next if instruction == "noop"

  if instruction == "addx"
    counter += 1

    if cycles.include?(counter)
      cycle.push(x)
    end

    x = x + step
    register.push(x)
  end
end

for i in 0..cycles.length-1
  signal_strength += (cycle[i].to_i * cycles[i].to_i)
end

register.each_with_index do |x, index, bool|
  position = index % 40
  overlaps = (x - position).abs <= 1
  crt << (overlaps ?  "#" : ".")
  crt << "\n" if position == 39
end

# Puzzle 1 
puts ""
aoc = [["🎄 "],["Advent of Code 2022"],[" 🎄"]].join
puts aoc
puts "Answer Part 1: #{signal_strength}"

# Puzzle 2
puts "Answer Part 2:"
puts ""
puts crt
