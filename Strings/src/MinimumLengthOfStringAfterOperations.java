public class MinimumLengthOfStringAfterOperations {
    public static void main(String[] args) {

    }

    public int minimumLength(String s) {
        int[] arr = new int[26];

        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            if(arr[s.charAt(i) - 'a'] == 3) {
                arr[s.charAt(i) - 'a'] = 1;
            }
        }

        int ans = 0;
        for(int i = 0; i < arr.length; i++) {
            ans += arr[i];
        }
        return ans;
    }

//    Optimized Code :

    public int minimumLengthOptimized(String s) {
        int[] arr = new int[26];
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            ans ++;
            if(arr[s.charAt(i) - 'a'] == 3) {
                arr[s.charAt(i) - 'a'] = 1;
                ans -= 2;
            }
        }
        return ans;
    }

}
