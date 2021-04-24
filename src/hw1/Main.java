package hw1;


import PolyMath.Integer;
import PolyMath.Rational;
import PolyMath.Scalar;

public class Main {

    public static void main(String[] args) {
        Scalar s = new Integer(5);
        Scalar s1 = new Rational(3,2);

        System.out.println(s);
        System.out.println(s1);
        System.out.println(s.add(s1));
        System.out.println(s1.add(s));

        System.out.println(s.mul(s1));
        System.out.println(s1.mul(s));
    }
}
