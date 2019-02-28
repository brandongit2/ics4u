import java.util.Random;

public class Die {
    private int numSides;
    private double[] bias;
    private Random random = new Random();
    
    public int getNumSides() {
        return numSides;
    }
    
    public void setNumSides(int N) {
        numSides = N;
    }
    
    public void setBias(double[] bias) throws Exception {
        double sum = 0.0;
        for (double n : bias) {
            sum += n;
        }
        if (!(Math.abs(sum - 1) < 0.00001)) throw new Exception("Bias does not add up to 1.");
        
        this.bias = bias;
    }
    
    public int roll() {
        while (true) {
            double randDouble = Math.random();
            int randInt = random.nextInt(numSides);
            if (bias[randInt] >= randDouble) return randInt + 1;
        }
    }
}
