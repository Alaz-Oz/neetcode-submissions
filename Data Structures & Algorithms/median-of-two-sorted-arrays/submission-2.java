class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        boolean twoVal = (totalLength % 2 == 0);

        int targetPos1 = ((totalLength + 1) / 2) - 1;
        int targetPos2 = targetPos1 + 1;

        double firstVal = numberAtMergedTarget(nums1, nums2, targetPos1);
        System.out.println("f: " + firstVal + " at: " + targetPos1);
        if (twoVal) {
            double secondVal = numberAtMergedTarget(nums1, nums2, targetPos2);
            System.out.println("s: " + secondVal + " at: " + targetPos2);

            firstVal = (firstVal + secondVal)/2;
        }
        

        return firstVal;
        // 5 / 2 -> 2 [0, 1, 2, 3, 4]
        // 4 / 2 -> 1 [0, 1, 2, 3]

        // int mid = 0;

        // int left = 0, right = nums1.length - 1;
        // while(left <= right){
        //     mid = left + (right - left) / 2;
        //     int pos = mid + leftOf(nums2, nums1[mid]);
            
        //     if (pos == targetPos) {
        //         return parse(nums1, nums2, mid, pos);
        //         // break;
        //     } else if (pos < targetPos) {
        //         // need to increase to get to the target
        //         left = mid + 1;
        //     } else {
        //         // need to reduce to get to the target
        //         right = mid - 1;
        //     }
        // }


        // while(mid + leftOf(nums2, nums1[mid]) > targetPos) {
        //     mid--;
        // }
        // System.out.println("firstSelection: " + mid);

        // // Mid is now == median, or less than that
        // int select = mid;

        // // Now we need to check nums2 that can 
        // left = 0;
        // right = nums2.length - 1;

        // while (left <= right){
        //     mid = left + (right - left) / 2;
        //     int pos = select + mid;

        //     if (pos == targetPos) {
        //         // found
        //         return parse(nums2, nums1, mid, pos);
        //         // break;
        //     } else if (pos < targetPos) {
        //         left = mid + 1;
        //     } else {
        //         right = mid - 1;
        //     }

        // }

        // System.out.println("hi");
        // return -1;

    }

    /**
      * Gives the number at the targetPos in the merged array
    */
    int numberAtMergedTarget(int[] nums1, int[] nums2, int targetPos) {
        int left = 0, right = nums1.length - 1;
        if (right < 0) return nums2[targetPos];
        int mid = 0;
        int posInMergedArr = 0;

        while(left <= right) {
            mid = left + (right - left) / 2;
            int curValue = nums1[mid];
            int elementsBefore = elementsBeforeTarget(nums2, curValue);
            posInMergedArr = elementsBefore + mid;

            if (posInMergedArr == targetPos) return curValue;
            if (posInMergedArr < targetPos){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        

        // We want only less value than the targetPos, so we can reach there by adding
        if (posInMergedArr < targetPos) mid++;
        
        System.out.println("testingIdx: " + mid + " mergedIdx: " + posInMergedArr);

        int posInOtherArr = targetPos - mid;
        return nums2[posInOtherArr];
    }


    // Tested code (Gives the pos of target or greater than it if absent)
    int elementsBeforeTarget(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        if (right < 0) return 0;
        int mid = 0;
        while(left <= right){
            mid = left + (right - left)/2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        if (arr[mid] < target) return mid + 1;

        return mid;
    }

    // double parse(int[] primary, int[] sec, int first, int targetPos){
    //     System.out.println("firstIdx: " + first + " targetPos: " + targetPos);
    //     int length = primary.length + sec.length;
    //     if (length % 2 == 1) return primary[first];

    //     targetPos++; // Seond median
    //     int firstVal = primary[first];

    //     // Two possibility indexes
    //     int one = first + 1;
    //     int two = leftOf(sec, 0, sec.length - 1, primary[first]) + 1;

    //     int valOne = (one < primary.length)? primary[one] : Integer.MAX_VALUE;
    //     int valTwo = (two < sec.length)? sec[two] : Integer.MAX_VALUE;

    //     int secondVal = Math.min(valOne, valTwo);

    //     return (firstVal + secondVal) / 2.0;
    // }



    // int leftOf(int[] arr, int target){
    //     return leftOf(arr, 0, arr.length - 1, target);
    // }


    // int leftOf(int[] arr, int left, int right, int target){
    //     int mid = 0;
    //     while (left <= right){
    //         mid = left + (right - left) / 2;
    //         if (arr[mid] == target) break;

    //         if (target < arr[mid]) {
    //             right = mid - 1;
    //         } else {
    //             left = mid + 1;
    //         }
    //     }
        
    //     while(mid >= 0 && arr[mid] >= target) mid--;

    //     return mid + 1; // Could be -1 too
    // }
}
