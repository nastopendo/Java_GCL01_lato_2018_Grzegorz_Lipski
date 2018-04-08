public class FieldCalcuklator {

    public double calculateSquare(double a) throws IllegalArgumentException{
        if(a<=0) throw new IllegalArgumentException("The side length of the square [" + Double.toString(a) + "] can not be negative");
        return a*a;
    }
    public double calculateCircle(double r) throws IllegalArgumentException{
        if(r<=0) throw new IllegalArgumentException("The radious length of the circle [" + Double.toString(r) + "] can not be negative");
        return Math.PI*r*r;
    }
    public double calculateTriangle(double a, double h) throws IllegalArgumentException{
        if(a<=0) throw new IllegalArgumentException("The base length of the triangle [" + Double.toString(a) + "] can not be negative");
        if(h<=0) throw new IllegalArgumentException("The height length of the triangle [" + Double.toString(h) + "] can not be negative");
        return (a*h)/2;
    }
    public double calculateRectangle(double a, double b) throws IllegalArgumentException{
        if(a<=0) throw new IllegalArgumentException("The side length of the rectangle [" + Double.toString(a) + "] can not be negative");
        if(b<=0) throw new IllegalArgumentException("The side length of the rectangle [" + Double.toString(b) + "] can not be negative");
        return a*b;
    }
}