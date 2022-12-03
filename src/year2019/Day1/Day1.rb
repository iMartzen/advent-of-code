#!/usr/bin/env ruby

sum_part1 = 0;
sum_part2 = 0;

File.read('input/day1.txt').lines do |line|
    fuel = ((line.chomp.to_i / 3) - 2)
    sum_part1 += fuel
    sum_part2 += fuel

    fuel_to_fuel = ((fuel / 3) - 2)
    sum_part2 += fuel_to_fuel

    if (!fuel_to_fuel.negative?())
        while (!fuel_to_fuel.negative?())
            extra_fuel = ((fuel_to_fuel / 3) - 2)
            if (!extra_fuel.negative?())
                sum_part2 += extra_fuel
            end
            fuel_to_fuel = extra_fuel
        end
    end
end

# Puzzle 1 
puts "Answer Part 1:"
puts sum_part1

# # Puzzle 2
puts "Answer Part 2:"
puts sum_part2
