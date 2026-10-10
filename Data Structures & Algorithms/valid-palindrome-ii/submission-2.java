class Solution {
    public boolean validPalindrome(String s) {
        boolean skipped = false;
        for(int left = 0, right = s.length() - 1; left <= right; left++, right--){
            if (s.charAt(left) != s.charAt(right)) {
                return valid(s, left + 1, right) || valid(s, left, right - 1);
            }
        }


        return true;
    }

    boolean valid(String s, int left, int right) {
        while(left <= right){
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}