#include <iostream>
#include <math.h>

using namespace std;

class Solution {
public:
    // naive one
    int reverse(long long x) {
        int prev_rev = 0, current_digit;
        long long rev = 0;
        bool isNeg = false;
        if(x < 0) {
            isNeg = true;
            // cout << x << endl;
            x = abs(x);
            // cout << x << endl;
        }

        while(x > 0) {
            // cout << "here " << rev << endl;
            current_digit = x % 10;
            rev = rev * 10 + current_digit;
            if(rev > INT32_MAX) {
                // cout << "heere";
                return 0;
            }
            prev_rev = rev;
            x = x / 10;
        }

        if(isNeg) {
            rev = -rev;
        }

        return rev;
    }

    // smart one
    int reverse1(int x) {
        int ans = 0;
        while (x) {
            // the result of "-1%10" in C++ is -1
            if(ans > INT32_MAX / 10 || ans < INT32_MIN / 10) return 0;
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        return ans;
    }
};

int main() {
    Solution sol;
    int num = sol.reverse(-214748364);
    cout << num;
    return num;
}   