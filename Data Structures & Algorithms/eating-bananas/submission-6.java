class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        long max_rate = 0;
        long total = 0;

        for(int i = 0; i < piles.length; i++){
            total += piles[i];
            if (piles[i] > max_rate) max_rate = piles[i];
        }

        long min_rate = (long) Math.ceil((double) total / h);
        System.out.println("min: " + min_rate);
        System.out.println("max: " + max_rate);

        // Check solution for range min_rate to max_rate
        // If mid_rate causes totalHours > h : Takes more time to eat, inc the rate
        // If mid_rate causes totalHours < h : Takes less time to eat, dec the rate
        long cur_rate = 0;
        long result = -1;

        while(min_rate <= max_rate){
            cur_rate = min_rate + (max_rate - min_rate) / 2;

            long totalHours = 0;

            for(int i = 0; i < piles.length; i++){
                long cur_pile = piles[i];
                long hoursTaken = (long) Math.ceil((double)cur_pile / cur_rate);
                totalHours += hoursTaken;
                if (totalHours > h)  break;
            }

            if (totalHours > h){
                // Not sufficient rate to eat in limited time
                min_rate = cur_rate + 1;
            }else if (totalHours <= h){
                // sufficient but potentially large
                max_rate = cur_rate - 1;
                result = cur_rate;
            }
        }

        return (int) result;
    }
}
