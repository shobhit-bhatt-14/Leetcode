class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;

        for (int i : arr)
            sum += i;

        if (sum % 3 != 0)
            return false;

        sum /= 3;
        int count = 0;

        if (arr[0] == sum) {
            count++;
            arr[0] = 0;
        }

        for (int i = 1; i < arr.length; i++) {
            if (count == 2)
                return true;

            arr[i] += arr[i - 1];

            if (arr[i] == sum) {
                count++;
                arr[i] = 0;
            }
        }

        return false;
    }
}