// The API isBadVersion is defined for you.
// bool isBadVersion(int version);

class Solution {
public:
    int firstBadVersion(int n) {
        if(n == 1)
            return 1;

        int lt=1, rt=n, mid, ans;
        while(lt <= rt) {
            mid = lt + (rt-lt) / 2;
            if( isBadVersion(mid) ) {
                ans=mid;
                rt=mid-1;
            }
            else {
                lt=mid+1;
            }
        }

        return ans;
    }
};