class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Here is my code for Top K Frequent Elements. 
        // Pattern: First idea is to use HashMap. Since we definitely need 
            // to find the num and store the frequency. Then sort by frequency
            // and find the top K and put it in result. Now normal sort using
            // Arrays.sort is QuickSort (O(nlogn)). Can use Bucket Sort. Why??
        // Data Structure: HashMap
        // Core Challenge: Sort a HashMap (convert to List). How to opimize
            // more than just O(nlogn). Use

        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Integer>[] buckets = new List[nums.length+1];
        for (int key: map.keySet()) {
            int frequency = map.get(key);

            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }

            buckets[frequency].add(key);
        }

        int[] result = new int[k];
        int counter = 0;
        for (int i=buckets.length-1; i>=0; i--) {
            if (buckets[i] != null) {
                for (int num: buckets[i]) {
                    result[counter++] = num;
                    if (counter == k) return result;
                }
            }
        }

        return result;
    }
}
