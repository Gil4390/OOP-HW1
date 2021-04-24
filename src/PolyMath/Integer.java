package PolyMath;

public class Integer implements Scalar{

    private int number;

    public Integer(int n){
        number = n;
    }

    private boolean isRational(Scalar s){
        return s.toString().contains("/");
    }

    @Override
    public Scalar add(Scalar s) {
        if(isRational(s)){
            return s.addRational(new Rational(number, 1));
        }
        else {
            return s.addInteger(this);
        }
    }

    public Scalar addRational(Rational s){
        return new Rational(number*s.getDenominator() + s.getNumerator(),s.getDenominator());
    }

    public Scalar addInteger(Integer s){
        return new Integer(s.getNumber() + this.getNumber());
    }


    @Override
    public Scalar mul(Scalar s) {
        if(isRational(s)){
            return s.mulRational(new Rational(number, 1));
        }
        else {
            return s.mulInteger(this);
        }
    }
    @Override
    public Scalar mulRational(Rational s) {
        return new Rational(number * s.getNumerator(),s.getDenominator());

    }

    @Override
    public Scalar mulInteger(Integer s) {
        return new Integer(s.getNumber() * this.getNumber());
    }


    @Override
    public Scalar power(int exponent) {
        return new Integer((int)Math.pow(number, exponent));
    }

    @Override
    public int sign() {
        if(number < 0)
            return -1;
        else if (number > 0)
            return 1;
        else
            return 0;
    }

    @Override
    public Scalar neg() {
        return new Integer(-number);
    }

    public int getNumber(){
        return number;
    }

    @Override
    public String toString() {
        return ""+number;
    }
}
