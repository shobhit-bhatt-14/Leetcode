class Solution {
    private boolean checkSquare(int[] matchsticks, int[] sidesTLBR, int index, int side) {
        if (index == matchsticks.length)
            return (sidesTLBR[0] == sidesTLBR[1] && sidesTLBR[1] == sidesTLBR[2] && sidesTLBR[2] == sidesTLBR[3]
                    && sidesTLBR[3] == side) ? true : false;

        for (int i = 0; i < 4; i++) {
            int j = i - 1;
            while (j >= 0) {
                if (sidesTLBR[i] == sidesTLBR[j])
                    break;

                j--;
            }

            if(j != -1)
                continue;

            if (sidesTLBR[i] + matchsticks[index] <= side) {
                sidesTLBR[i] += matchsticks[index];

                if (checkSquare(matchsticks, sidesTLBR, index + 1, side))
                    return true;

                sidesTLBR[i] -= matchsticks[index];
            }
        }

        return false;
    }

    public boolean makesquare(int[] matchsticks) {
        int len = matchsticks.length;
        if (len < 4)
            return false;

        Arrays.sort(matchsticks);
        if (len == 4)
            return (matchsticks[0] == matchsticks[3]) ? true : false;

        int perimeter = 0;
        for (int i : matchsticks)
            perimeter += i;

        if (perimeter % 4 != 0)
            return false;
        else {
            int side = perimeter / 4;
            int[] sidesTLBR = new int[4];

            return checkSquare(matchsticks, sidesTLBR, 0, side);
        }
    }
}