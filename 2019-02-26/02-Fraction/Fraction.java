class Util {
    static public int lcm(int a, int b) {
        return a * b / gcf(a, b);
    }
    
    static public int gcf(int a, int b) {
        if (a == b) return a;
        if (a == 0 || b == 0) return -1;
        
        int t = Math.max(a, b) % Math.min(a, b);
        if (t == 0) return Math.min(a, b);
        
        return gcf(Math.min(a, b), t);
    }
    
    static public int[] reduce(int a, int b) {
        return new int[] {a / gcf(a, b), b / gcf(a, b)};
    }
}

public class Fraction {
    private int numerator;
    private int denominator;
    
    public void setNumerator(int a) {
        numerator = a;
    }
    
    public int getNumerator() {
        return numerator;
    }
    
    public void setDenominator(int b) {
        denominator = b;
    }
    
    public int getDenominator() {
        return denominator;
    }
    
    public Fraction mul(int n) {
        Fraction frac = new Fraction();
        frac.setNumerator(numerator * n);
        frac.setDenominator(denominator);
        return frac;
    }
    
    public Fraction divide(int n) {
        Fraction frac = new Fraction();
        frac.setNumerator(numerator);
        frac.setDenominator(denominator * n);
        return frac;
    }
    
    public Fraction add(Fraction b) {
        int commonDenominator = Util.lcm(denominator, b.getDenominator());
        int numerator1 = numerator * (commonDenominator / denominator);
        int numerator2 = b.getNumerator() * (commonDenominator / b.getDenominator());
        
        Fraction frac = new Fraction();
        frac.setNumerator(numerator1 + numerator2);
        frac.setDenominator(commonDenominator);
        return frac;
    }
    
    public Fraction sub(Fraction b) {
        int commonDenominator = Util.lcm(denominator, b.getDenominator());
        int numerator1 = numerator * (commonDenominator / denominator);
        int numerator2 = b.getNumerator() * (commonDenominator / b.getDenominator());
        
        Fraction frac = new Fraction();
        frac.setNumerator(numerator1 - numerator2);
        frac.setDenominator(commonDenominator);
        return frac;
    }
    
    public String toString() {
        int[] reduced = Util.reduce(numerator, denominator);
        if (reduced[0] < 0 && reduced[1] < 0) {
            reduced[0] *= -1;
            reduced[1] *= -1;
        }
        return String.format("%d/%d", reduced[0], reduced[1]);
    }
}
