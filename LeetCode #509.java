class Solution {
    public HashMap<Integer, Integer> hash = new HashMap<>();

    public int fib(int n) {
        if (n < 2)
            return n;

        if(hash.containsKey(n))
            return hash.get(n);
        else {
            int value = fib(n-1)+fib(n-2);
            hash.put(n, value);
            return value;
        }
    }
}