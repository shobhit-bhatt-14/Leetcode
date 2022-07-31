class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int ans = -1;
        int distance = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                int dis = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);

                if (dis < distance) {
                    distance = dis;
                    ans = i;
                }
            }
        }

        return ans;
    }
}