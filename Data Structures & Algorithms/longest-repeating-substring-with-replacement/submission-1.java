class Solution {
    public int characterReplacement(String s, int k) {
        /*
            state
                windowFreq: chars in the window currently
                otherChars: totalFreq - maxFrequentElement
            
            transition:
                increase windowSize every step
                if otherChars > k : shrink from left
                save curLen
            




        */

        int[] windowFreq = new int[26];
        // int windowSize = 0;
        int n = s.length();

        int result = 0;

        for(int left = 0, right = 0; right < n; right++){
            char c = s.charAt(right);
            windowFreq[c - 'A']++;
            // windowSize++;


            int maxFrequency = 0;
            int totalCount = 0;
            for(int i = 0; i < 26; i++){
                if (windowFreq[i] > maxFrequency) maxFrequency = windowFreq[i];
                totalCount += windowFreq[i];
            }
            int otherChars = totalCount - maxFrequency;

            if (otherChars > k) {
                windowFreq[s.charAt(left++) - 'A']--;
            }
            int winLen = right - left + 1;
            if (winLen > result) result = winLen;
        }

        return result;
    }
}
