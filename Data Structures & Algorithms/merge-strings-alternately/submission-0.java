class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder b = new StringBuilder();
        int i = 0;
        int j = 0;
        for(;b.length() < word1.length() + word2.length();){
            int sum = i + j;
            if (sum % 2 == 0){
                if(i < word1.length())
                    b.append(word1.charAt(i));
                i++;
            }else {
                if(j < word2.length())
                    b.append(word2.charAt(j));
                j++;
            }
        }

        return b.toString();
    }
}