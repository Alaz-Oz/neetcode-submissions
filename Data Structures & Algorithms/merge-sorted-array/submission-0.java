class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m];
        for(int i = 0; i < m; i++){
            nums3[i] = nums1[i];
        }
        int x = 0;
        for(int i = 0, j = 0; x < m + n;){
            
            int atI = i < m? nums3[i] : Integer.MAX_VALUE;
            int atJ = j < n? nums2[j] : Integer.MAX_VALUE;
            
            if (atI < atJ) {
                nums1[x] = atI;
                i++;
            }else {
                nums1[x] = atJ;
                j++;
            }

            x++;
        }

    }
}