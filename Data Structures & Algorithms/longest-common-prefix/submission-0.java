class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        for(int i = 0;; i++){
            char prev = '0';
            for(int j = 0; j < strs.length; j++){
                String s = strs[j];
                if (s.length() == i) return s.substring(0, i);

                char c = s.charAt(i);
                if (j == 0) prev = c;

                if (c != prev) return s.substring(0, i);
            }
        }

    }
}