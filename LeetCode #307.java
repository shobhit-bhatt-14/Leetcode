class NumArray {
    int n;

    public int[] segTree;

    public void createSegTree(int[] nums, int l, int r, int i) {
        if (l == r)
            segTree[i] = nums[l];
        else {
            int mid = (l + r) >> 1;
            createSegTree(nums, l, mid, (2 * i) + 1);
            createSegTree(nums, mid + 1, r, (2 * i) + 2);

            segTree[i] = segTree[(2 * i) + 1] + segTree[(2 * i) + 2];
        }
    }

    public int getSegTree(int l, int r, int left, int right, int i) {
        if (l > right || r < left)
            return 0;
        else if (l >= left && r <= right)
            return segTree[i];
        else {
            int mid = (l + r) >> 1;

            return getSegTree(l, mid, left, right, (2 * i) + 1) + getSegTree(mid + 1, r, left, right, (2 * i) + 2);
        }
    }

    public void updateSegTree(int l, int r, int i, int index, int val) {
        if (l == r) {
            segTree[i] = val;
        } else {
            int mid = (l + r) >> 1;

            if (index <= mid) {
                updateSegTree(l, mid, (2 * i) + 1, index, val);
            } else {
                updateSegTree(mid + 1, r, (2 * i) + 2, index, val);
            }

            segTree[i] = segTree[(2 * i) + 1] + segTree[(2 * i) + 2];
        }
    }

    public NumArray(int[] nums) {
        n = nums.length;

        segTree = new int[(4 * n) + 1];

        createSegTree(nums, 0, n - 1, 0);
    }

    public void update(int index, int val) {
        updateSegTree(0, n - 1, 0, index, val);
    }

    public int sumRange(int left, int right) {
        return getSegTree(0, n - 1, left, right, 0);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */