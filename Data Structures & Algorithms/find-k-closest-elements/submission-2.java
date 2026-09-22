class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x){
        //Find the starting position with binary search
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] < x) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        r = l;
        l = l - 1;
        while (r - l - 1 < k) {
            //Use two pointers to slowly expand
            //We chooes not to add immediately since we want a sorted array at the end
            if (l < 0) { 
                r++;
            } else if (r >= arr.length) {
                l--;
            } else if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                l--;
            } else {
                r++;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = l + 1; i < r; i++) { 
            res.add(arr[i]);
        }

        return res;
    }
}