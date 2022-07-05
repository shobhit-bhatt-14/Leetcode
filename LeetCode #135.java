class Solution {
    public int candy(int[] ratings) {
        int[] l_2_r = new int[ratings.length];
        int[] r_2_l = new int[ratings.length];
        Arrays.fill(l_2_r, 1);
        Arrays.fill(r_2_l, 1);

        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] < ratings[i + 1])
                l_2_r[i + 1] += l_2_r[i];
        }
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1])
                r_2_l[i - 1] += r_2_l[i];
        }

        int count = 0;
        for (int i = 0; i < ratings.length; i++)
            count += Math.max(l_2_r[i], r_2_l[i]);

        return count;
    }
}