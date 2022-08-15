# COMP 348 Assignment 3
# Q1

require_relative 'Shape.rb'
class Ellipse < Shape
  def initialize(a, b)
    super()
    @a = a
    @b = b
  end

  def area()
    @area = @a * @b * Math::PI
    return @area
  end

  def eccentricity()
    @ecc = Math.sqrt((@a ** 2) - (@b ** 2))
    return @ecc
  end

  def printE()
    puts "\tLinear Eccentricity: #{@ecc}"
  end
end