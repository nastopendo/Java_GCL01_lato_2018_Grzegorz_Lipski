public class BasicCalculator {

    public double calculateSum(double a, double b){
        return a+b;
    }
    public double caclulateDifference(double a, double b){
        return a-b;
    }
    public double calculateMultiplication(double a, double b){
        return a*b;
    }
    public double calculateDivision(double a, double b) throws IllegalArgumentException{
        if(b==0) throw new IllegalArgumentException("You can not divide by " + Double.toString(b));
        return a/b;
    }
    public double calculatePow(double a, int b) throws IllegalArgumentException{
        if(a==0.0 && b==0) throw new IllegalArgumentException(Double.toString(a) + "^" + Integer.toString(b) + " - undefined expression");
        return Math.pow(a,b);
    }
    public double calculateSqlr(double a, int b) throws IllegalArgumentException{
        if(b<=1) throw new IllegalArgumentException("The exponent [" + Integer.toString(b) +  "] must be greater than 1");
        if(a<0 && (b%2 == 0)) throw new IllegalArgumentException("The exponent of power [" + Integer.toString(b) + "]from the negative number [" + Double.toString(a) + "] must be even");
        //return Math.pow(a,1.0/b);
        return Math.signum(a) * Math.pow(Math.abs(a),1.0/b);
    }

    public static void main(String[] args) {

    }
}
