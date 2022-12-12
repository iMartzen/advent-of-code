#!/usr/bin/env ruby

# $ system-update --please --pretty-please-with-sugar-on-top
# Error: No space left on device

# The total size of a directory is the sum of the sizes of the files it contains, directly or indirectly. (structure themselves do not count as having any intrinsic size.)

class Dir
    attr_accessor :path, :dirs, :files, :parent_dir
  
    def initialize path, dirs: [], files: [], parent_dir: nil
      @path       = path
      @dirs       = dirs
      @files      = files
      @parent_dir = parent_dir
    end

    def add_file name, size
        @files.push({name: name, size: size })
    end

    def to_s
      output = "path: #{@path}"
      unless @files.empty?
        output += " files: #{@files}"
      end
      unless @dirs.empty?
        output += " dirs: #{@dirs.map &:to_s}"
      end
      output
    end

    def add_dir path
        dir = Dir.new path, parent_dir: self
        @dirs << dir
        dir
    end

    def size
        @files.sum{ |f| f[:size]} + @dirs.sum{ |d| d.size}
    end

    def dirs_under_100_000()
        output = []
        @dirs.each do |d| 
            if d.size < 100_000
                output << d
            end
            output = output + d.dirs_under_100_000
        end
        output
    end

    def free_up_enough_space()
        disk_size = 700_000_00
        required_size = 300_000_00
        free = required_size - (disk_size - $first_directory.size)
        
        output = []
        @dirs.each do |d|
            if d.size >= free
                output << d 
            end
            output = output + d.free_up_enough_space
        end
        output
    end
end

input = File.readlines('input/day7.txt').map {|l| l.scan(/\S+/) } 

$first_directory = $current_directory = Dir.new '/'

input.each do |command|
    if (command[0] == "$")
        if (command[1] == "cd")
            new_dir = command[2]
            if (new_dir == "..")
                $current_directory = $current_directory.parent_dir
            else
                next if new_dir == "/"
                $current_directory = $current_directory.add_dir(new_dir)
            end
        end
    else
      next if command[0] == "dir"
            size = command[0].to_i
            name = command[1].to_s
            $current_directory.add_file(name, size)
    end
end

# In the example above, these structure are a and e; the sum of their total sizes is 95437 (94853 + 584). (As in this example, this process can count files more than once!) Find all of the structure with a total size of at most 100000. What is the sum of the total sizes of those structure?

score = $first_directory.dirs_under_100_000.each.sum &:size

# Find the smallest directory that, if deleted, would free up enough space on the filesystem to run the update. What is the total size of that directory?

total = 700_000_00
$first_directory.free_up_enough_space.each do |d|
    if d.size < total
        total = d.size
    end
end

# Puzzle 1 
puts ""
aoc = [["🎄 "],["Advent of Code 2022"],[" 🎄"]].join
puts aoc
puts ""
puts "Answer Part 1: #{score}"
# Puzzle 2
puts "Answer Part 2: #{total}"
puts ""
