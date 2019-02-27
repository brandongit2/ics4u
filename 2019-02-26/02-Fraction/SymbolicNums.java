public class SymbolicNums {
    public static void main(String[] args) {
        Fraction frac1 = new Fraction();
        frac1.setNumerator(3);
        frac1.setDenominator(5);
        System.out.println(frac1.mul(2).toString());
        
        Fraction frac2 = new Fraction();
        frac2.setNumerator(3);
        frac2.setDenominator(4);
        System.out.println(frac2.mul(8).toString());
        
        System.out.println(frac1.divide(2).toString());
        
        Fraction frac3 = new Fraction();
        frac3.setNumerator(4);
        frac3.setDenominator(7);
        System.out.println(frac3.divide(2).toString());
        
        Fraction frac4 = new Fraction();
        frac4.setNumerator(1);
        frac4.setDenominator(3);
        System.out.println(frac4.add(frac4).toString());
        
        Fraction frac5 = new Fraction();
        frac5.setNumerator(1);
        frac5.setDenominator(8);
        System.out.println(frac5.add(frac2).toString());
        
        Fraction frac6 = new Fraction();
        frac6.setNumerator(1);
        frac6.setDenominator(2);
        System.out.println(frac6.add(frac4));
        
        Fraction frac7 = new Fraction();
        frac7.setNumerator(1);
        frac7.setDenominator(4);
        System.out.println(frac2.sub(frac7).toString());
        
        Fraction frac8 = new Fraction();
        frac8.setNumerator(2);
        frac8.setDenominator(3);
        System.out.println(frac2.sub(frac8).toString());
    }
}
