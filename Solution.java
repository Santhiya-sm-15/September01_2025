class Solution {
    public int sumOfModes(int[] arr, int k) {
        int n=arr.length;
        int sum=0;
        Map<Integer,Integer> m=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            if(m.get(a)==m.get(b))
                return Integer.compare(a,b);
            return Integer.compare(m.get(b),m.get(a));
        });
        for(int i=0;i<k;i++)
        {
            if(m.containsKey(arr[i]))
            {
                m.put(arr[i],m.get(arr[i])+1);
                pq.remove(arr[i]);
                pq.add(arr[i]);
            }
            else
            {
                m.put(arr[i],1);
                pq.add(arr[i]);
            }
        }
        sum+=pq.peek();
        for(int i=k;i<n;i++)
        {
            if(m.get(arr[i-k])==1)
            {
                m.remove(arr[i-k]);
                pq.remove(arr[i-k]);
            }
            else
            {
                m.put(arr[i-k],m.get(arr[i-k])-1);
                pq.remove(arr[i-k]);
                pq.add(arr[i-k]);
            }
            if(m.containsKey(arr[i]))
            {
                m.put(arr[i],m.get(arr[i])+1);
                pq.remove(arr[i]);
                pq.add(arr[i]);
            }
            else
            {
                m.put(arr[i],1);
                pq.add(arr[i]);
            }
            sum+=pq.peek();
        }
        return sum;
    }
}