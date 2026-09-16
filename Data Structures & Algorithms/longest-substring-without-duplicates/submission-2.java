class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[255];
        Arrays.fill(lastSeen, -1);

        int longest = 0;
        int right, left;
        for(right = 0, left = 0; right < s.length(); right++){
            char cur = s.charAt(right);
            
            if (lastSeen[cur] >= left){
                // Seen after left
                left = lastSeen[cur] + 1;
            }

            longest = Math.max(longest, right - left + 1);

            lastSeen[cur] = right;
        }

   
        // longest = Math.max(longest, right - left);


        return longest;
    }
}
