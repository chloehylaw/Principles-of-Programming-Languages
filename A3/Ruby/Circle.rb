# COMP 348 Assignment 3
# Q1

require_relative 'Shape'
class Circle < Shape
  def initialize(radius)
    super()
    @radius = radius
  end

  def perimeter()
    @perimeter = 2 * @radius * Math::PI
    return @perimeter
  end

  def area()
    @area = @radius ** 2 * Math::PI
    return @area
  end

end