public class RemoveDuplicatesFromSortedArray {
    
    public static void main(String[] args) {
        int[] nums = [1,1,2]; // Input array
        int[] expectedNums = [1,2]; // The expected answer with correct length

        int k = removeDuplicates(nums); // Calls your implementation

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }

    public static int removeDuplicates(int[] nums) {


        return 0;
    }
}
