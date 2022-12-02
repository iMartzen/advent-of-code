#!/usr/bin/env ruby

# Shaped you selected
# A = 1 = Rock
# B = 2 = Paper 
# C = 3 = Sciccors

# Outcome of round 
# Lose = 0
# Draw = 3  
# Win = 6

# Rules
# 1 wins 3
# 3 loses 1
# 2 wins 1 
# 1 loses 2
# 3 wins 2
# 2 loses 3 

score = 0

File.read('input/test.txt').lines do |line|
    shape = line.split(' ')

    elf = shape[0]
    me = shape[1]

    #elf
    case elf when "A"; elf = 1; when "B"; elf = 2; else "C"; elf = 3; end

    #me 
    case me when "X"; me = 1; when "Y"; me = 2; else "Z"; me = 3 end

    # actual rps game 
    me == elf ? score = score + me + 3 : ((((me == 1 && elf == 3) ? score = score + me + 6 : (me == 3 && elf == 1) ? score = score + me + 0 : (((me == 2 && elf == 1) ? score = score + me + 6 : (me == 1 && elf == 2) ? score = score + me + 0 : ((me == 3 && elf == 2) ? score = score + me + 6 : ((me == 2 && elf == 3) ? score = score + me + 0 : 0)))))))
end

# Puzzle 1 
puts "Answer Part 1:"
puts score
