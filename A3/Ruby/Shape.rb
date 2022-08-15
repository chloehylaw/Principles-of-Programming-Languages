# COMP 348 Assignment 3
# Q1

class Shape
  def initialize()
    @name = "#{self.class.name}"
    @perimeter = "undefined"
    @area = "undefined"
  end

  def print()
    puts "#{@name}, Perimeter: #{@perimeter}, Area: #{@area}"
  end

  def perimeter()
    nil
  end

  def area()
    nil
  end
end