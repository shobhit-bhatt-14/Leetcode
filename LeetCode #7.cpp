class Solution {
public:
    int reverse(int x) {
        if(INT_MIN>x || x>INT_MAX || x==0)
            return 0;
        
        while(x%10 == 0)
            x /= 10;
        
        std::int64_t res = x%10;
        while(x/10) {
            x /= 10;
            res = (res*10)+(x%10);
        }
        if(INT_MIN>res || res>INT_MAX)
            return 0;
        else
            return res;
    }
};