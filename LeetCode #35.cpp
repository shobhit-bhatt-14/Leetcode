class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int len=nums.size();
        int lt=0, rt=len-1, mid;
        
        while(lt <= rt) {
            mid = lt + (rt-lt) / 2;
            
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                lt = mid+1;
            else
                rt = mid-1;  
        }
        
        if(nums[mid] > target)
            return mid;
        
        return mid+1;
    }
};