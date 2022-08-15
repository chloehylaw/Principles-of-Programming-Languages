# COMP 348 Assignment 3
# Q2 & Q3

require_relative 'Shape.rb'
require_relative 'Circle.rb'
require_relative 'Ellipse.rb'
require_relative 'Rhombus.rb'

$shapes = 0
$circles = 0
$ellipses = 0
$rhombus = 0

File.foreach("file.txt"){
  |line|
  if line.include? "shape"
    s = Shape.new
    $shapes += 1
    s.print
  elsif line.include? "circle"
    $shapes += 1
    $circles += 1
    arr = line.split(' ')
    if arr[1].to_f < 0 or arr[2].to_f < 0
      puts "Error: Invalid Circle"
    else
      c = Circle.new(arr[1].to_f)
      c.perimeter
      c.area
      c.print
    end
  elsif line.include? "ellipse"
    $shapes += 1
    $ellipses += 1
    arr = line.split(' ')
    if arr[1].to_f < 0 or arr[2].to_f < 0 or arr[1].to_f.negative? or arr[2].to_f.negative?
      puts "Error: Invalid Ellipse"
    elsif arr[1].to_f < arr[2].to_f
      ee = Ellipse.new(arr[2].to_f, arr[1].to_f)
      ee.area
      ee.eccentricity
      ee.print
      ee.printE
    else
      e = Ellipse.new(arr[1].to_f, arr[2].to_f)
      e.area
      e.eccentricity
      e.print
      e.printE
    end
  elsif line.include? "rhombus"
    $shapes += 1
    $rhombus += 1
    arr = line.split(' ')
    if arr[1].to_f < 0 or arr[2].to_f < 0 or arr[1].to_f.negative? or arr[2].to_f.negative?
      puts "Error: Invalid Rhombus"
    else
      r = Rhombus.new(arr[1].to_f, arr[2].to_f)
      r.perimeter
      r.area
      r.inradius
      r.print
      r.printR
    end
  end
}

hash = {"Shape(s)" => $shapes, "Circle(s)" => $circles, "Ellipse(s)" => $ellipses, "Rhombus(es)" => $rhombus}
puts "\nStatistics:"
hash.each_pair do |key, value|
  puts "\t#{key}: #{value}"
end