class Solution {
public:
    int search(vector<int>& nums, int target) {
        int lt=0, rt=nums.size()-1;
        
        while(lt <= rt) {
            int mid = (lt+rt)/2;
            
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                lt = mid+1;
            else
                rt = mid-1;
        }
        
        return -1;
    }
};