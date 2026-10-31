class Solution {
    public int check(int[] nums, int h, long k) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            long val = Math.ceilDiv(nums[i], k);
            sum += val;
        }
        if (sum <= h) return 1;
        return 0;
    }
    public int minEatingSpeed(int[] nums, int h) {
        long st = 1, end = 0;
        for (int i = 0; i < nums.length; i++)
            end += nums[i];
        long ans = end;
        while(st <= end) {
            long k = (st + end) / 2;
            int res = check(nums, h, k);
            if (res == 1) {
                end = k - 1;
                if (k < ans)
                    ans = k;
            } else {
                st = k + 1;
            }
        }
        return (int)ans;
    }
}
