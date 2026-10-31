class Solution {
    public int check(int[] arr, int k, long mid) {
        int students = 1;
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= mid) {
                sum += arr[i];
            } 
            else {
                students++;
                sum = arr[i];
            }
        }
        if(students<=k){
            return 1;
        }else{
            return 0;
        }
    }
    public int findPages(int[] arr, int k) {
        if (k > arr.length)
            return -1;
        long st = 0, en = 0;
        for (int i = 0; i < arr.length; i++) {
            st = Math.max(st, arr[i]);
            en += arr[i];
        }
        long ans = en;
        while (st <= en) {
            long mid = (st + en) / 2;
            int res = check(arr, k, mid);
            if (res == 1) {
                ans = mid;
                en = mid - 1;
            } 
            else {
                st = mid + 1;
            }
        }
        return (int) ans;
    }
}
