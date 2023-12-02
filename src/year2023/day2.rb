#!/usr/bin/env ruby

def read_games_from_file(filename)
  games = {}
  File.foreach(filename) do |line|
    game_name, rounds_str = line.split(':')
    rounds = rounds_str.split(';').map do |round|
      round.strip.split(',').map do |cube|
        count, color = cube.strip.split
        [color, count.to_i]
      end
    end
    games[game_name.strip] = rounds
  end
  games
end

def puzzle_one(games)
  def is_round_possible(round, required_cubes)
    round.each do |color, count|
      if count > required_cubes[color]
        return false
      end
    end
    true
  end

  required_cubes = { 'red' => 12, 'green' => 13, 'blue' => 14 }
  possible_games = []

  games.each do |game_name, rounds|
    game_possible = true

    rounds.each do |round|
      unless is_round_possible(round, required_cubes)
        game_possible = false
        break
      end
    end
    
    possible_games << game_name if game_possible
  end

  sum_of_ids = 0
  possible_games.each do |game|
    game_id = game.split(' ')[1].to_i
    sum_of_ids += game_id
  end

  puts sum_of_ids
end

def puzzle_two(games)
  def find_minimum_set_for_game(rounds)
    min_set = { 'red' => 0, 'green' => 0, 'blue' => 0 }
    rounds.each do |round|
      round.each do |color, count|
        min_set[color] = [min_set[color], count].max
      end
    end
  
    min_set
  end
  
  total_power = 0
  games.each do |game_name, rounds|
    min_set = find_minimum_set_for_game(rounds)
    power = min_set['red'] * min_set['green'] * min_set['blue']
    total_power += power
  end
  puts total_power
end

games = read_games_from_file('input/day2.txt')

# Puzzles 
aoc = [["🎄 "],["Advent of Code 2023"],[" 🎄"]].join
puts aoc
# Puzzle 1 
puts "Answer Part 1:"
puzzle_one(games) 

# Puzzle 2
puts "Answer Part 2:"
puzzle_two(games)
