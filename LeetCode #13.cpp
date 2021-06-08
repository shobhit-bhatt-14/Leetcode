class Solution {
public:
    int romanToInt(string s) {
        unordered_map<char,int> val{{'I',1} , {'V',5} , {'X',10} , {'L',50} , {'C',100}, {'D',500} , {'M',1000}};
        
        int res=0 , len=s.length();
        for(int i=0 ; i<len ; i++) {
            if(val[s[i]] >= val[s[i+1]])
                res += val[s[i]];
            else {
                res += (val[s[i+1]]-val[s[i]]);
                i++;
            }
        }
        
        return res;
    }
};