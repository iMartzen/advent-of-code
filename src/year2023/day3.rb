#!/usr/bin/env ruby

# Interpreter file function
def read_from_file(filename)
  schematic = File.readlines(filename).map(&:strip)
  schematic = schematic.map { |row| '.' + row + '.' }
  width = schematic.first.length
  schematic.unshift('.' * width)
  schematic.push('.' * width)
  schematic
end

def adjacent_symbol?(row_index, col_index, schematic)
  directions = [[-1, -1], [-1, 0], [-1, 1], [0, -1], [0, 1], [1, -1], [1, 0], [1, 1]]

  directions.each do |delta_row, delta_col|
    adjacent_row, adjacent_col = row_index + delta_row, col_index + delta_col
    next if
      row_index.negative? ||
      col_index.negative? ||
      row_index >= schematic.size ||
      col_index >= schematic[row_index].size

    char = schematic[adjacent_row][adjacent_col]
    return [adjacent_row, adjacent_col, char] if char.match?(/[^\d.]/)
  end

  [row_index, col_index, '']
end

# Part 1
def puzzle_one(schematic)

  def has_adjacent_symbol?(row_index, col_index, schematic)
    _, _, symbol = adjacent_symbol?(row_index, col_index, schematic)
    symbol && symbol != ''
  end

  sum = 0
  schematic.each_with_index do |row, row_index|
    current_value = 0
    adjacent_to_symbol = false

    row.chars.each_with_index do |char, col_index|
      if char.match?(/\d/)
        current_value = current_value * 10 + char.to_i
        adjacent_to_symbol = true if has_adjacent_symbol?(row_index, col_index, schematic)
      elsif adjacent_to_symbol
        sum += current_value
        current_value = 0
        adjacent_to_symbol = false
      else
        current_value = 0
        adjacent_to_symbol = false
      end
    end
    sum += current_value if adjacent_to_symbol
  end
  sum
end

# Part 2
def puzzle_two(schematic)
  gear_ratios = []
  gears = {}

  schematic.each_with_index do |row, row_index|
    in_number = false
    value = 0
    gear_coords = nil

    row.chars.each_with_index do |char, col_index|
      if char.match?(/\d/)
        value = value * 10 + char.to_i
        in_number = true
        x, y, symbol = adjacent_symbol?(row_index, col_index, schematic)
        gear_coords = [x, y] if symbol == '*'
      else
        if in_number && gear_coords
          if gears.has_key?(gear_coords)
            gear_ratios << gears[gear_coords] * value
          else
            gears[gear_coords] = value
          end
        end
        in_number = false
        gear_coords = nil
        value = 0
      end
    end
  end
  gear_ratios.sum
end

# Solutions section
puts [["🎄 "],["Advent of Code 2023"],[" 🎄"]].join
file_path = 'input/day3.txt'
schematic = read_from_file(file_path)

# Puzzle 1
puts "Answer Part 1:"
puts puzzle_one(schematic)

# Puzzle 2
puts "Answer Part 2:"
puts puzzle_two(schematic)
