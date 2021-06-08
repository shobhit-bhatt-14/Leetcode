class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string res;
        bool x = false;
        char ch = strs[0][0];
        int len=strs.size() , l=strs[0].length();
        for(int i=0 ; i<l ; i++) {
            if(ch == NULL)
                break;
            for(int j=0 ; j<len ; j++) {
                if(j==0)
                    ch=strs[j][i];
                else if(strs[j][i] != ch) {
                    x=true;
                    break;
                }
                
                if(j == len-1)
                    res.push_back(ch);
            }
            if(x)
                break;
        }
        
        return res;
    }
};