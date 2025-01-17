public class CountNoOfNiceSubArrays {
    public static void main(String[] args) {
        int[] arr = {2,2,2,1,2,2,1,2,2,2};
        int ans = new CountNoOfNiceSubArrays().numberOfSubarrays(arr, 2);
        System.out.println(ans);
    }

    public int numberOfSubarrays(int[] nums, int k) {
        if(k == 0) return 0;
        int count = 0, range = 0, firstSeen = -1, ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                count++;
                if (firstSeen == -1) {
                    firstSeen = i;
                }

                if (count > k) {
                    count--;
                    firstSeen++;
                    range = firstSeen;
                    while (nums[firstSeen] % 2 == 0) {
                        firstSeen++;
                    }
                }
            }
            if (count == k) {
                ans += firstSeen - range + 1;
            }
        }
        return ans;
    }
}
