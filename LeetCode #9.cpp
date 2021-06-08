class Solution {
public:
    bool isPalindrome(int x) {
        int z=x;
        if(x<0)
            return false;
        
        std::int64_t y=x%10;
        while(x/10 != 0) {
            x /= 10;
            y = (y*10)+(x%10);
        }
        
        if(z != y)
            return false;
        
        return true;
    }
};