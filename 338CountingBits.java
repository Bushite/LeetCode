// Time complexity: O(mn)
// Space complexity: O(1)
class Solution {
    public int[] countBits(int num) {
	int[] res = new int[num+1];
	res[0] = 0;
	if (num == 0) return res;
	res[1] = 1;
	if (num == 1) return res;
	for (int highBit = 1; ; highBit++) {
	    int highBit2Dec = 1 << highBit;
	    for (int i = 0; i < 1 << highBit; i++) {
		if (highBit2Dec + i <= num)  res[highBit2Dec+i] = res[i] + 1;
		else                         return res;
	    }     
	}
    }
}
// 没有利用传统的for(int i = 0; i <= num; i++) {}的思想，求每个数的二进制再求里面的1的数量，
// 而是利用生成数组前后的关系，关键在于highBit这个变量。
// 复杂度为O(num)
