public privileged aspect aspect1 {
    // Q4
    declare parents: Circle implements Shape;
    declare parents: Rectangle implements Shape;

    public String Circle.getName(){
        return "Circle";
    }
    public String Rectangle.getName(){
        return "Rectangle";
    }

    // Q5
    @Override
    public String Circle.toString(){
      return this.getName() + "("+ (int)this.radius + ")";
    }

    @Override
    public String Rectangle.toString(){
        return this.getName() + "(" + (int)this.width + ", " + (int)this.height + ")";
    }

    // Q6
    double around(Circle c) : execution(* Circle.getArea()) && target(c){
        double area = Math.PI * c.radius * c.radius;
        return Math.round(area * 100000.0)/100000.0;
    }

    // Q7
    double around (Circle c) : (execution(* Circle.getPerimeter()) || execution(* Circle.getArea())) && target(c){
        double value = proceed(c);
        if(c.radius < 0) {
            value = 0;
        }
        return value;
    }

    double around(Rectangle r) : (execution(* Rectangle.getPerimeter()) || execution(* Rectangle.getArea())) && target(r){
        double value = proceed(r);
        if(r.width < 0 || r.height < 0){
            value = 0;
        }
        return value;
    }

    // Q8
    declare parents: Circle implements Identifiable;
    declare parents: Rectangle implements Identifiable;

    private static int counter = -1;

    public int Circle.getId(){
        return counter;
    }
    public int Rectangle.getId(){
        return counter;
    }
    after(Circle c): execution(Circle.new(..)) && target(c){
        counter++;
    }
    after(Rectangle c): execution(Rectangle.new(..)) && target(c){
        counter++;
    }
}
