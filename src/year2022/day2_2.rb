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

# Ultimate Strategy 
# X = 1 = Lose 
# Y = 2 = Draw
# Z = 3 = Win 

score = 0
me = 0 

File.read('input/test.txt').lines do |line|
    shape = line.split(' ')

    elf = shape[0]
    result = shape[1]

    #shape to number for elf
    case elf when "A"; elf = 1; when "B"; elf = 2; else "C"; elf = 3; end

    # shape to results 
    case result when "X"; result = 1; when "Y"; result = 2; else "Z"; result = 3 end

    # result to me 
    case result 
    when 1; case elf when 1; me = 3; when 2; me = 1; else; me = 2; end;
    when 2; case elf when 1; me = 1; when 2; me = 2; else; me = 3; end;
    else 3; case elf when 1; me = 2; when 2; me = 3; else; me = 1; end;
    end

    # actual rps game 
    me == elf ? score = score + me + 3 : ((((me == 1 && elf == 3) ? score = score + me + 6 : (me == 3 && elf == 1) ? score = score + me + 0 : (((me == 2 && elf == 1) ? score = score + me + 6 : (me == 1 && elf == 2) ? score = score + me + 0 : ((me == 3 && elf == 2) ? score = score + me + 6 : ((me == 2 && elf == 3) ? score = score + me + 0 : 0)))))))
end

# Puzzle 2
puts "Answer Part 2:"
puts score
