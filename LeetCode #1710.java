class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));

        int ans = 0;
        for (int[] box : boxTypes) {
            if (box[0] >= truckSize) {
                ans += truckSize*box[1];
                break;
            }
            else {
                ans += box[0]*box[1];
                truckSize -= box[0];
            }
        }

        return ans;
    }
}