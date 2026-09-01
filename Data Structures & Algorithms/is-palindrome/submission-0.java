class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int n2 = n / 2;
        n--;
        for(int i = 0; i < n; i++){
            if (!Character.isLetterOrDigit(s.charAt(i))) continue;
            while(!Character.isLetterOrDigit(s.charAt(n))){
                n--;
            }
            if (Character.toLowerCase(s.charAt(i)) != (Character.toLowerCase(s.charAt(n)))) return false;
            n--;
        }

        return true;
    }
}
