import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
    HashSet<Integer> visited = new HashSet<>();
    HashMap<Integer, List<Integer>> req = new HashMap<>();

    public boolean check(int c) {
        if (visited.contains(c))
            return false;

        if (req.get(c).isEmpty())
            return true;

        visited.add(c);

        for(int i : req.get(c)) {
            if(!check(i))
                return false;
        }

        req.get(c).clear();

        visited.remove(c);
        
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0)
            return true;

        for (int i = 0; i < numCourses; i++)
            req.put(i, new ArrayList<>());

        for (int[] pre : prerequisites)
            req.get(pre[0]).add(pre[1]);

        for (int i = 0; i < numCourses; i++) {
            if(!check(i))
                return false;
        }

        return true;
    }
}