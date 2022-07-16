class Solution {
    public String largestTimeFromDigits(int[] arr) {
        String ans = "";

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j)
                    continue;

                for (int k = 0; k < 4; k++) {
                    if (j == k || k == i)
                        continue;

                    String HH = String.valueOf(arr[i]) + String.valueOf(arr[j]);
                    String MM = String.valueOf(arr[k]) + String.valueOf(arr[6 - i - j - k]);
                    String time = HH + ":" + MM;

                    if (HH.compareTo("24") < 0 && MM.compareTo("60") < 0 && ans.compareTo(time) < 0)
                        ans = time;
                }
            }
        }

        return ans;
    }
}