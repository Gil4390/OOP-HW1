package PolyMath;

public class Integer implements Scalar{

    private int number;

    public Integer(int n){
        number = n;
    }

    private boolean isRational(Scalar s){
        if(s == null)
            throw new NullPointerException("Scalar cannot be null");
        return s.toString().contains("/");
    }

    @Override
    public Scalar add(Scalar s) {

        if(s == null)
            throw new NullPointerException("Scalar cannot be null");
//        if(isRational(s)){
//            return s.addRational(new Rational(number, 1));
//        }
//        else {
//            return s.addInteger(this);
//        }

        try{
            return s.addRational(new Rational(number, 1));
        }
        catch(Exception e){

        }
        return s.addInteger(this);
    }

    public Scalar addRational(Rational s){
        if(s == null)
            throw new NullPointerException("Rational cannot be null");
        return new Rational(number*s.getDenominator() + s.getNumerator(),s.getDenominator());
    }

    public Scalar addInteger(Integer s){
        if(s == null)
            throw new NullPointerException("Integer cannot be null");
        return new Integer(s.getNumber() + this.getNumber());
    }


    @Override
    public Scalar mul(Scalar s) {
        if(s == null)
            throw new NullPointerException("Scalar cannot be null");
//        if(isRational(s)){
//            return s.mulRational(new Rational(number, 1));
//        }
//        else {
//            return s.mulInteger(this);
//        }

        try{
            return s.mulRational(new Rational(number, 1));
        }
        catch(Exception e){

        }
        return s.mulInteger(this);
    }
    @Override
    public Scalar mulRational(Rational s) {
        if(s == null)
            throw new NullPointerException("Rational cannot be null");
        return new Rational(number * s.getNumerator(),s.getDenominator());

    }

    @Override
    public Scalar mulInteger(Integer s) {
        if(s == null)
            throw new NullPointerException("Integer cannot be null");
        return new Integer(s.getNumber() * this.getNumber());
    }


    @Override
    public Scalar power(int exponent) {
        if(exponent >= 0)
            return new Integer((int)Math.pow(number, exponent));
        else
            return new Rational(1,(int)Math.pow(number, -exponent));
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
