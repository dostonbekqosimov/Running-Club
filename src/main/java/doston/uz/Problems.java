package doston.uz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problems {
    public static void main(String[] args) throws IOException {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int res = Arrays.binarySearch(arr, 4);

        System.out.println(res);


//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(bufferedReader.readLine().trim());
//
//        for (int i = 1; i <= 10; i++) {
//            System.out.println(N + " x " + i + " = " + N * i);
//        }

    }
}
