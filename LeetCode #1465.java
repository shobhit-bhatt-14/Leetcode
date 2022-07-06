class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long maxH = horizontalCuts[0], maxW = verticalCuts[0];

        for (int i = 1; i < horizontalCuts.length; i++) {
            if (maxH < horizontalCuts[i] - horizontalCuts[i - 1])
                maxH = horizontalCuts[i] - horizontalCuts[i - 1];
        }

        for (int i = 1; i < verticalCuts.length; i++) {
            if (maxW < verticalCuts[i] - verticalCuts[i - 1])
                maxW = verticalCuts[i] - verticalCuts[i - 1];
        }

        if (maxH < h - horizontalCuts[horizontalCuts.length - 1])
            maxH = h - horizontalCuts[horizontalCuts.length - 1];

        if (maxW < w - verticalCuts[verticalCuts.length - 1])
            maxW = w - verticalCuts[verticalCuts.length - 1];

        return (int) ((maxH * maxW) % 1000000007);
    }
}