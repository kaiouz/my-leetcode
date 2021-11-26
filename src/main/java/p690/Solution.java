package p690;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};


class Solution {

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return dfs(map, id);
    }


    private int dfs(Map<Integer, Employee> map, int id) {
        int ans = map.get(id).importance;
        for (int subId : map.get(id).subordinates) {
            ans += dfs(map, subId);
        }
        return ans;
    }

}
