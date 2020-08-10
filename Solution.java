import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Sum two numbers
 */
class Solution {


    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     */
    static int[] sumOfTwo(int[] nums, int target) {

        // **** ****
        int[] result = new int[2];

        // **** generate a hashmap of values and indices O(n) ****
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {

            // **** generate the complement ****
            int complement = target - nums[i];

            // **** check if complement in hasmap ****
            if (hm.containsKey(complement)) {
                System.out.println(Arrays.toString(new int[] { hm.get(complement), i }));
            }

            // **** add value to hash map ****
            hm.putIfAbsent(nums[i], i);
        }

        // **** traverse the array O(n) ****
        for (int i = 0; i < nums.length; i++) {

            // **** generate the complement ****
            int complement = target - nums[i];

            // **** look up the complement in the hashmap ****
            if (hm.containsKey(complement) && (i != hm.get(complement))) {
                result[0] = i;
                result[1] = hm.get(complement);
                return result;
            }

        }

        // **** instead of returning [0, 0] ****
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * Test scafolding.
     */
    public static void main(String[] args) {

        // **** open scanner ****
        Scanner sc = new Scanner(System.in);

        // **** read the number of integers in the array ****
        int n = sc.nextInt();

        // ???? ????
        System.out.println("main <<< n: " + n);

        // **** allocate array of integers ****
        int[] arr = new int[n];

        // **** populate the array ****
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // **** read the target ****
        int target = sc.nextInt();

        // ???? ????
        System.out.println("main <<< target: " + target);

        // **** close scanner ****
        sc.close();

        // ???? ????
        System.out.println("main <<< arr: " + Arrays.toString(arr));

        // **** generate result (if possible) ****
        int[] result = sumOfTwo(arr, target);

        // **** display result ****
        System.out.println(Arrays.toString(result));
    }
}