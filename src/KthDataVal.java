import java.util.*;


public class KthDataVal {
    public static void main(String[] args) {

        int[] my_array = {2, 2, 4, 4, 6, 6};
        System.out.println(Arrays.toString(calculateModes(my_array)));
        System.out.println(kthDataValue(my_array, 8));
    }

    public static int findMax(int[] nums)
    {
        int pos = 0;
        for(int k = 1; k < nums.length; k++)
            if(nums[k] > nums[pos])
                pos = k;
        return nums[pos];
    }

    public static int[] calculateModes(int[] tally){
        int count=0;
        int max = findMax(tally);
        for (int i=0; i < tally.length; i++){
            if (tally[i] == max){
                count ++;
            }
        }
        int[] modes;
        modes = new int[count];
        int counter = 0;
        for (int i=0; i < tally.length; i++){
            if (tally[i] == max){
                modes[counter] = i;
                counter += 1;
            }
        }
        return modes;
    }

    public static int kthDataValue(int[] tally, int k) {
        // to find the kth value, we have to look for the sum of the frequencies ≥ k, and then the last frequency val is our answer
        // add the frequencies in a loop and when the sum is >= k, return i
        int sum = 0;
        int answer = 0;
        for (int i = 0; i < tally.length - 1; i++) {
            sum += tally[i];
            if (sum >= k) {
                answer = i;
                break;
            }
        }
        return answer;
    }

}



