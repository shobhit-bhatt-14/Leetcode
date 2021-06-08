class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int len = digits.size();
        len--;
        digits[len]++;
        
        while(digits[len] == 10) {
            digits[len] = 0;
            len--;
            if(len<0) {
                reverse(digits.begin() , digits.end());
                digits.push_back(1);
                reverse(digits.begin() , digits.end());
                break;
            }
            digits[len]++;
        }
        
        return digits;
    }
};