//Link : https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=inversion-of-array

public class CountInversions {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        int ans = inversionCount(arr);
        System.out.println(ans);
    }

    static int inversionCount(int[] arr) {
        if(arr.length == 1) {
            return 0;
        }

        return mergeSort(arr);
    }

    static int mergeSort(int[] arr) {
        if(arr.length <= 1) {
            return 0;
        }

        int mid = (arr.length) / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[arr.length - mid];

        for(int i = 0; i < leftArr.length; i++) {
            leftArr[i] = arr[i];
        }

        for(int i = mid; i < arr.length; i++) {
            rightArr[i - mid] = arr[i];
        }


        int sp1 = mergeSort(leftArr);
        int sp2 = mergeSort(rightArr);
        int mergeResult = merge(leftArr, rightArr, arr);

        return sp1 + sp2 + mergeResult;
    }

    static int merge(int[] left, int[] right, int[] arr) {
        int i = 0, j = 0;
        int arrInd = 0;
        int count = 0;
        while(i < left.length && j < right.length) {
            if(left[i] <= right[j]) {
                arr[arrInd++] = left[i++];
            } else {
                count += left.length - i;
                arr[arrInd++] = right[j++];
            }
        }

        while(i < left.length) {
            arr[arrInd++] = left[i++];
        }
        while (j < right.length) {
            arr[arrInd++] = right[j++];
        }

        return count;
    }
}
