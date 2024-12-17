import java.util.Arrays;
import java.util.TreeMap;

public class ConstructStringWithRepeatLimit {
    public static void main(String[] args) {
//        String str = "aababab";
        String str = "zzzzzzzzz";
        int repeatedLimit = 2;
//        String ans = new ConstructStringWithRepeatLimit().repeatLimitedString(str, repeatedLimit);

        String ans = new ConstructStringWithRepeatLimit().repeatLimitedStringOptimized(str, repeatedLimit);
        System.out.println(ans);
    }

    public String repeatLimitedString(String s, int repeatLimit) {
        if (repeatLimit <= 0) {
            return s;
        }

        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        char curr = map.lastKey();

        for (int i = 0; i < s.length(); i++) {
            sb.append(curr);
            count++;
            map.put(curr, map.getOrDefault(curr, 0) - 1);
            if (map.get(curr) == 0) {
                map.remove(curr);
                if (map.isEmpty()) {
                    return sb.toString();
                } else {
                    count = 0;
                    curr = map.lastKey();
                }
            }

            if (count >= repeatLimit) {
                if (map.size() == 1) {
                    return sb.toString();
                }

                int currFreq = map.get(curr);
                map.remove(curr);
                char last = map.lastKey();
                sb.append(last);
                map.put(last, map.getOrDefault(last, 0) - 1);
                if (map.get(last) == 0) {
                    map.remove(last);
                }
                map.put(curr, currFreq);
                count = 0;
            }
        }

        return sb.toString();
    }

    //    Optimized
    public String repeatLimitedStringOptimized(String s, int repeatLimit) {
        int[] arr = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a']++;
        }

        int[] firstAndSecondLargest = findFirstAndSecondLargest(25, arr);
        int firstLargest = firstAndSecondLargest[0];
        int secondLargest = firstAndSecondLargest[1];

        if (secondLargest == -1) {
            return String.valueOf((char)(firstLargest + 'a')).repeat(Math.min(arr[firstLargest], repeatLimit));
        }

        StringBuilder sb = new StringBuilder();
        while (secondLargest >= 0) {
            if (arr[firstLargest] != 0) {
                if (arr[firstLargest] >= repeatLimit) {
                    sb.append(String.valueOf((char)(firstLargest + 'a')).repeat(Math.max(0, repeatLimit)));
                    arr[firstLargest] -= repeatLimit;
                    sb.append((char)(secondLargest + 'a'));
                    arr[secondLargest]--;

                    if (arr[firstLargest] == 0 && arr[secondLargest] == 0) {
                        int[] fstScdLg = findFirstAndSecondLargest(secondLargest - 1, arr);
                        firstLargest = fstScdLg[0];
                        secondLargest = fstScdLg[1];
                    } else if (arr[firstLargest] == 0 && arr[secondLargest] != 0) {
                        firstLargest = secondLargest;
                        if(arr[secondLargest] >= repeatLimit) {
                            sb.deleteCharAt(sb.length() - 1);
                            arr[secondLargest]++;
                        }
                        secondLargest = findFindSecondLargest(secondLargest - 1, arr);
                    } else if (arr[secondLargest] == 0 && arr[firstLargest] != 0) {
                        secondLargest = findFindSecondLargest(secondLargest - 1, arr);
                    }
                } else {
                    sb.append(String.valueOf((char)(firstLargest + 'a')).repeat(Math.max(0, arr[firstLargest])));

                    firstLargest = secondLargest;
                    secondLargest = findFindSecondLargest(secondLargest - 1, arr);
                }
            } else {
                firstLargest = secondLargest;
                secondLargest = findFindSecondLargest(secondLargest - 1, arr);
            }
        }

        if(arr[firstLargest] == sb.charAt(sb.length() - 1)) {
            int repeated = 0;
            int i = sb.length() - 1;
            while(i >= 0) {
                if(sb.charAt(i) != sb.charAt(sb.length() - 1)) {
                    break;
                }
                repeated++;
                i--;
            }
            if(repeated == repeatLimit) {
                return sb.toString();
            }
        }

        if(arr[firstLargest] > 0) {
            sb.append(String.valueOf((char)(firstLargest + 'a')).repeat(Math.min(arr[firstLargest], repeatLimit)));
        }

        return sb.toString();
    }

    public int[] findFirstAndSecondLargest(int st, int[] array) {
        int[] arr = new int[2];
        boolean b = false;
        for (int i = st; i >= 0; i--) {
            if (array[i] != 0 && !b) {
                b = true;
                arr[0] = i;
                continue;
            }
            if (array[i] != 0 && b) {
                arr[1] = i;
                return arr;
            }
        }
        arr[1] = -1;
        return arr;
    }

    public int findFindSecondLargest(int st, int[] array) {
        for (int i = st; i >= 0; i--) {
            if (array[i] != 0) {
                return i;
            }
        }
        return -1;
    }

}
