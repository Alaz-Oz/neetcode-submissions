class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        /*
            0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10
                3       3   2       2       2       2
                                    3       3

            Traversing the postion left to right
            pushing into the stack (waiting to join fleet)
            if someone behind is waiting to join the fleet (top of the stack < cur)
            if the behind one has higher speed then cur. and If target / cur_speed >= target / waiting_speed
                then it joins the current fleet, pop the other one.

            Puth this one onto the stack; Just need array to be sorted

        */
        int n = position.length;
        Integer[][] posSpeed = new Integer[n][2];
        for(int i = 0; i < n; i++){
            posSpeed[i][0] = position[i];
            posSpeed[i][1] = speed[i];
        }

        Arrays.sort(posSpeed, (a, b) -> Integer.compare(a[0], b[0]));
        Deque<Integer[]> waitingBehind = new ArrayDeque<>();

        waitingBehind.push(posSpeed[0]);

        for(int i = 1; i < n; i++){
            int curPos = posSpeed[i][0];
            int curSpeed = posSpeed[i][1];
            int behindPos = waitingBehind.peek()[0];
            int behindSpeed = waitingBehind.peek()[1];
            
            int lhs = (target - behindPos) * curSpeed;
            int rhs = (target - curPos) * behindSpeed;

            // System.out.println(lhs + " " + rhs);

            while (lhs <= rhs) {
                // System.out.println("satisfied");
                waitingBehind.pop();
                if (waitingBehind.isEmpty()) break;
                behindPos = waitingBehind.peek()[0];
                behindSpeed = waitingBehind.peek()[1];
                lhs = (target - behindPos) * curSpeed;
                rhs = (target - curPos) * behindSpeed;
            }

            waitingBehind.push(posSpeed[i]);
        }



        return waitingBehind.size();
    }
}
