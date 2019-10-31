package cphbusiness.ufo.jvmoptimizations;

import java.util.Arrays;
import java.util.Random;

public class JVMoptimizationsMain {
    public static void main(String[] args)
    {
        // Generate data
        int arraySize = 32768;
        int data[] = new int[arraySize];

        Random rnd = new Random(0);
        for (int c = 0; c < arraySize; ++c)
            data[c] = rnd.nextInt() % 256;


        // !!! With this, the sumDataArray runs faster
        Arrays.sort(data);
        
        long sum = 0;

        // Test
        long start = System.nanoTime();
        for (int i = 0; i < 100000; ++i)
        {
            sum += sumDataArray(data);
        }

        System.out.println((System.nanoTime() - start) / 1000000000.0);
        System.out.println("sum = " + sum);
    }

    private static long sumDataArray(int[] data) {
        // Primary loop
        long sum = 0; 
        int arraySize = data.length;
        for (int c = 0; c < arraySize; ++c)
        {
            if (data[c] >= 128)
                sum += data[c];
        }
        return sum;
    }
}
