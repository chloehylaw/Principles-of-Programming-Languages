# COMP 348 Assignment 3
# Q1

require_relative 'Shape.rb'
class Rhombus < Shape
  def initialize(p, q)
    super()
    @p = p
    @q = q
  end

  def perimeter()
    @perimeter = 4 * Math.sqrt(((@p/2) ** 2) + ((@q/2) ** 2))
    return @perimeter
  end

  def area()
    @area = 2 * (@p / 2) * (@q / 2)
    return @area
  end

  def inradius()
    @inradius = (@p * @q) / (2 * Math.sqrt((@p ** 2) + (@q ** 2)))
    return @inradius
  end

  def printR()
    puts "\tInside radius: #{@inradius}"
  end
end