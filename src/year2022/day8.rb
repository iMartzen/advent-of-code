#!/usr/bin/env ruby

input = File.readlines('input/day8.txt').to_a
n = input.length
last_column = input.length-1
last_row = input.length-1

# function grid
def initialize_grid(n, input)
  grid = Array.new(n)
  n.times do |row|
    grid[row] = Array.new(n)
    n.times do |col|
      grid[row][col] = input[row][col].to_i
    end
  end
  grid
end

#initialize grid
grid = initialize_grid(n, input)

#tree outside 
outer_trees = (n + n + n + n - 4)

visible_trees = 0 
scenic_score = 0 

#search grid
1.upto(last_row - 1) do |row|
  1.upto(last_column - 1) do |col|

      height = grid[row][col]
      current_row = grid[row]
      cols = grid.transpose
      current_col = cols[col]
  
      visible = [
        current_row[0...col],
        current_row[(col + 1)..],
        current_col[0...row],
        current_col[(row + 1)..]
      ].any? { |other_trees| 
        other_trees.all? { |other_height|
          other_height < height } 
        }

      current_scenic_score = [
          current_row[0...col].reverse,
          current_row[(col + 1)..],
          current_col[0...row].reverse,
          current_col[(row + 1)..]
      ].inject(1) { |num, trees| 
          num * (trees.inject(0) { |num, h|
            break num + 1 if h >= height
            num + 1 })
        }

      visible ? visible_trees +=1 : visible_trees +=0
      scenic_score = current_scenic_score if current_scenic_score > scenic_score
  end
end

# Puzzle 1 
aoc = [["🎄 "],["Advent of Code 2022"],[" 🎄"]].join
puts aoc
puts "Answer Part 1:"
puts visible_trees + outer_trees

# # Puzzle 2
puts "Answer Part 2:"
puts scenic_score 
