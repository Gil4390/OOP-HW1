package PolyMath;

public class Rational implements Scalar{

    private int numerator;
    private int denominator;

    public Rational(int a, int b){
        numerator = a;
        if(b==0){
            throw new IllegalArgumentException("denominator cannot be 0");
        }
        denominator = b;
        reduce();
        simple();
    }

    private boolean isRational(Scalar s){
        return s.toString().contains("/");
    }

    @Override
    public Scalar add(Scalar s) {
        return s.addRational(this);

    }
    @Override
    public Scalar addRational(Rational s){
         int a = numerator*s.getDenominator() + s.getNumerator()*denominator;
         int b = denominator * s.getDenominator();
         return new Rational(a,b);
    }

    @Override
    public Scalar addInteger(Integer s){
        return s.add(this);
    }


    @Override
    public Scalar mul(Scalar s) {
        return s.mulRational(this);
    }

    @Override
    public Scalar mulRational(Rational s) {
        int a = numerator * s.getNumerator();
        int b = denominator * s.getDenominator();
        return new Rational(a,b);
    }

    @Override
    public Scalar mulInteger(Integer s) {
        return s.mul(this);
    }


    @Override
    public Scalar power(int exponent) {
        int a = (int)Math.pow(numerator, exponent);
        int b = (int)Math.pow(denominator,exponent);

        return new Rational(a,b);
    }

    @Override
    public int sign() {
        if(numerator < 0)
            return -1;
        else if (numerator > 0)
            return 1;
        else
            return 0;
    }

    @Override
    public Scalar neg() {
        return new Rational(-numerator, denominator);
    }

    public Rational reduce(){
        int min = Math.min(numerator, denominator);
        for (int i = 2; i*i < min; i++) {
            if(numerator%i == 0 & denominator%i == 0){
                numerator = numerator/i;
                denominator = denominator/i;
                i = 1;
            }
        }
        return this;
    }

    private void simple(){
        if(numerator<0 & denominator<0){
            numerator = -numerator;
            denominator = -denominator;
        }
        else if(numerator>0 & denominator<0){
            numerator = -numerator;
            denominator = -denominator;
        }

    }

    public String toString(){
        return ""+numerator+'/'+denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
}
