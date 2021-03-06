class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] buckets = new List[nums.length + 1];  
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) 
            map.put(num, map.getOrDefault(num, 0) + 1);    
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (buckets[freq] == null)                     
                buckets[freq] = new ArrayList<Integer>();  
            buckets[freq].add(key);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length; i >= 0 && k > 0; i--) {    
            List<Integer> l = buckets[i];
            while (l != null && l.size() > 0 && k > 0) {
                list.add(l.get(l.size() - 1));
                l.remove(l.size() - 1);
                k--;
            }
        }
        return list;
    }
}
// 注意14行，是不是null和大小是不是0是两个概念，要分开判断，
// 注意第3行如何声明一个元素为list的数组，
// 注意第6行如何不用判断元素是否存在于map中而添加元素，
// 第9，10行不能少，少了会有nullpointer异常
