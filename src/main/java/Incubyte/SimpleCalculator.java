package Incubyte;

import java.util.ArrayList;
import java.util.List;

public class SimpleCalculator {
    public static int Add(String numbers) throws Exception {
        if (numbers.equals("")) {
            return 0;
        } else {
            String delimiter = ",";
            if(numbers.startsWith("//")) {
                delimiter = "" + numbers.charAt(2);
                numbers = numbers.substring(4);
            }
            String arr[] = numbers.split("\n|" + delimiter);
            int arr1[] = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                arr1[i] = Integer.parseInt(arr[i]);
            }
            int sum = 0;
            List<Integer> errorList = new ArrayList<>();
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] < 0) {
                    errorList.add(arr1[i]);
                }
                sum += arr1[i];
            }
            if (errorList.size() > 0) {
                if (errorList.size() == 1) {
                    throw new Exception("negatives not allowed");
                }
                throw new Exception("negatives not allowed: " + errorList.toString());
            }
            return sum;
        }

    }

    public static void main(String[] args) throws Exception {
        String s = "//;\n1;2";
        System.out.println(Add(s));
    }
}
