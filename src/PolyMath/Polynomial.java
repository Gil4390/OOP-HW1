package PolyMath;

import java.util.Arrays;

public class Polynomial {

    private Monomial[] monomials;


    public Polynomial(Monomial[] mono){
        monomials = mono;
    }

    public static Polynomial build(String str) {
        if(str == null)
            throw new IllegalArgumentException("string cannot be null");

        Monomial[] mono = new Monomial[str.split(" ").length];
        int exponent = 0;
        for(String s : str.split(" ")) {
            if(s.contains("/")){
                int a = java.lang.Integer.parseInt(s.split("/")[0]);
                int b = java.lang.Integer.parseInt(s.split("/")[1]);
                mono[exponent] = new Monomial(exponent, new Rational(a, b));
            }
            else{
                mono[exponent] = new Monomial(exponent, new Integer(java.lang.Integer.parseInt(s)));
            }
            exponent++;

        }
        return new Polynomial(mono);
    }

    public Polynomial add(Polynomial p1) {
        if(p1 == null)
            throw new IllegalArgumentException("polynomial cannot be null");

        int min = Math.min(monomials.length, p1.getMonomials().length);
        int max = Math.max(monomials.length, p1.getMonomials().length);
        Monomial[] mono = new Monomial[max];
        for(int i=0; i<min; i++)
            mono[i] = p1.getMonomials()[i].add(monomials[i]);

        for (int i = min; i < p1.getMonomials().length; i++)
            mono[i] = p1.getMonomials()[i];

        for (int i = min; i < monomials.length; i++)
            mono[i] = monomials[i];

        return new Polynomial(mono);
    }

    public Polynomial mul(Polynomial p1) {
        if(p1 == null)
            throw new IllegalArgumentException("polynomial cannot be null");
        int max = monomials.length + p1.getMonomials().length -1;
        Monomial[] mono = new Monomial[max];

        for (int i = 0; i < monomials.length; i++){
            for (int j = 0; j < p1.getMonomials().length; j++)
                mono[i+j] = monomials[i].mult(p1.getMonomials()[j]);
        }
        return new Polynomial(mono);
    }

    public Scalar evaluate(Scalar r) {
        if(r == null)
            throw new IllegalArgumentException("Scalar cannot be null");

        Scalar res = new Integer(0);
        for (int i = 0; i < monomials.length; i++)
            res = res.add(monomials[i].evaluate(r));

        return res;
    }

    public Polynomial derivative() {
        Monomial[] mono = new Monomial[monomials.length-1];
        for (int i = 0; i < mono.length; i++) {
            mono[i] = monomials[i + 1].derivative();
        }
        return new Polynomial(mono);
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < monomials.length; i++) {
            if(monomials[i].sign() == 1)
                res = res + "+" + monomials[i].toString();
            else if(monomials[i].sign() == -1)
                res = res + monomials[i].toString();
        }

        if(res.length() != 0 && res.charAt(0) == '+')
            res = res.substring(1);
        if(res == "")
            res = "0";
        return res;
    }

    public Monomial[] getMonomials() {
        return monomials;
    }
}
