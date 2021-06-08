class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        long long int len=nums.size();
        vector<int> res;
        bool x=false;
        for(int i=0 ; i<len ; i++) {
            for(int j=i+1 ; j<len ; j++) {
                if(nums[i]+nums[j] == target) {
                    res.push_back(i);
                    res.push_back(j);
                    x=true;
                    break;
                }
            }
            if(x)
                break;
        }
        return res;
    }
};