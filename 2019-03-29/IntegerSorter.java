// Brandon Tsang
// March 29, 2019
// ICS4U1-05 | Mr. Radulovic

import java.util.Random;

public class IntegerSorter implements Sorter {
    private int[] list;
    
    public static void main(String[] args) {
        Random generator = new Random();
        IntegerSorter sorter = new IntegerSorter();
        
        int[] arrayLengths = {16, 128, 1024, 16384, 131072, 1048576, 16777216};
        for (int len : arrayLengths) {
            System.out.println("ARRAY LENGTH " + len + "\n-------------------------------------");
            
            int[] test = new int[len];
            for (int i = 0; i < len; i++) {
                test[i] = generator.nextInt();
            }
            
            sorter.setList(test);
            for (int i = 1; i <= 3; i++) {
                long startTime = System.nanoTime();
                sorter.sort(i);
                long timeDiff = System.nanoTime() - startTime;
                
                String sortMethodName = "";
                switch (i) {
                    case 1:
                        sortMethodName = "Bubble sort:    ";
                        break;
                    case 2:
                        sortMethodName = "Selection sort: ";
                        break;
                    case 3:
                        sortMethodName = "Merge sort:     ";
                        break;
                }
                System.out.println(sortMethodName + timeDiff + " ns");
            }
            
            System.out.println();
        }
    }
    
    public void setList(int[] list) {
        this.list = list.clone();
    }
    
    // Bubble sort
    private void sort_method1(int[] list) {
        long startTime = System.nanoTime();
        for (int iter = list.length - 1; iter > 0; iter--) {
            if (System.nanoTime() - startTime > 60000000000L) return;
            for (int idx = 0; idx < iter; idx++) {
                if (list[idx] > list[idx + 1]) {
                    int temp = list[idx];
                    list[idx] = list[idx + 1];
                    list[idx + 1] = temp;
                }
            }
        }
    }
    
    // Selection sort
    private void sort_method2(int[] list) {
        long startTime = System.nanoTime();
        for (int iter = 0; iter < list.length; iter++) {
            if (System.nanoTime() - startTime > 60000000000L) return;
            for (int idx = iter; idx < list.length; idx++) {
                if (list[iter] > list[idx]) {
                    int temp = list[iter];
                    list[iter] = list[idx];
                    list[idx] = temp;
                }
            }
        }
    }
    
    // Merge sort
    private int[] sort_method3(int[] list) {
        if (list.length > 1) {
            int[][] split = splitArray(list);
            
            int[] listA = sort_method3(split[0]);
            int[] listB = sort_method3(split[1]);
            
            return mergeArrays(listA, listB);
        } else {
            return list;
        }
    }
    
    private int[][] splitArray(int[] list) {
        int[][] split = new int[2][list.length / 2];
        for (int i = 0; i < list.length; i++) {
            if (i < list.length / 2) {
                split[0][i] = list[i];
            } else {
                split[1][i - list.length / 2] = list[i];
            }
        }
        
        return split;
    }
    
    private int[] mergeArrays(int[] listA, int[] listB) {
        int[] sorted = new int[listA.length + listB.length];
        
        // These count how many of listA and listB have been consumed.
        int aCounter = 0;
        int bCounter = 0;
        
        for (int i = 0; i < sorted.length; i++) {
            if (aCounter > listA.length - 1) {
                sorted[i] = listB[bCounter];
                bCounter++;
            } else if (bCounter > listB.length - 1) {
                sorted[i] = listA[aCounter];
                aCounter++;
            } else {
                if (listA[aCounter] > listB[bCounter]) {
                    sorted[i] = listB[bCounter];
                    bCounter++;
                } else {
                    sorted[i] = listA[aCounter];
                    aCounter++;
                }
            }
        }
        
        return sorted;
    }
    
    public void sort(int type) {
        switch (type) {
            case 1:
                sort_method1(this.list);
                break;
            case 2:
                sort_method2(this.list);
                break;
            case 3:
                this.list = sort_method3(this.list);
                break;
            default:
                System.out.println("Invalid sort type.");
        }
    }
    
    public String toString() {
        String str = "";
        for (int i = 0; i < this.list.length - 1; i++) {
            str += this.list[i] + ", ";
        }
        str += this.list[this.list.length - 1];
        
        return str;
    }
}
