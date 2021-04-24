package hw1;


import PolyMath.Integer;
import PolyMath.Monomial;
import PolyMath.Rational;
import PolyMath.Scalar;

public class Main {

    public static void main(String[] args) {
        Scalar s = new Integer(-5);
        Scalar s1 = new Rational(3,2);
        Scalar s2 = new Rational(-2,3);
        Scalar s3 = new Integer(2);

        System.out.println(s);
        System.out.println(s1);
        System.out.println(s.add(s1));
        System.out.println(s1.add(s));

        System.out.println(s.mul(s1));
        System.out.println(s1.mul(s));
        System.out.println(s.power(-2));

        System.out.println("=============================");
        Monomial m1 = new Monomial(2, s);
        Monomial m2 = new Monomial(1, s3);
        Monomial m3 = new Monomial(2, s1);
        Monomial m4 = new Monomial(1, s2);

        System.out.println(m1);
        System.out.println(m3);
        System.out.println(m1.add(m3));
        System.out.println(m2.mult(m4));






    }
}
