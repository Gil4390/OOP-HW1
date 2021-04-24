package PolyMath;

import java.lang.management.MonitorInfo;

public class Monomial {
    private int exponent;
    private Scalar coefficient;

    public Monomial(int e, Scalar c){
        if(e<0){
            throw new IllegalArgumentException("exponent must be greater or equal to 0");
        }
        exponent = e;
        coefficient = c;
    }

    public Monomial add(Monomial m){
        if(m == null)
            throw new NullPointerException("Monomial cannot be null");
        if(exponent == m.getExponent()){
            return new Monomial(exponent ,coefficient.add(m.coefficient));
        }
        else
            return null;

    }

    public Monomial mult(Monomial m){
        if(m == null)
            throw new NullPointerException("Monomial cannot be null");
        return new Monomial(exponent+m.exponent ,coefficient.mul(m.coefficient));
    }

    public Scalar evaluate(Scalar s){
        if(s == null)
            throw new NullPointerException("Monomial cannot be null");

        return s.power(exponent).mul(coefficient);
    }

    public Monomial derivative(){
        if(exponent == 0)
            return new Monomial(0, new Integer(0));
        return new Monomial(exponent-1, coefficient.mul(new Integer(exponent)));
    }

    public int sign() {
        return coefficient.sign();
    }

    public String toString(){
        if(exponent == 0)
            return "" + coefficient.toString();
        else if(exponent == 1) {
            if(coefficient.toString().equals("1"))
                return "x";
            else if(coefficient.toString().equals("0"))
                return "0";
            else
                return "" + coefficient.toString() + 'x';
        }

        if(coefficient.toString().equals("1"))
            return "x^" + exponent;
        else if(coefficient.toString().equals("0"))
            return "0";
        return "" + coefficient.toString() + "x^" + exponent;

    }

    public int getExponent() {
        return exponent;
    }

    public Scalar getCoefficient() {
        return coefficient;
    }
}
