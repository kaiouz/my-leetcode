package p5525;

import java.util.*;

class ThroneInheritance {

    private Map<String, List<String>> cache = new HashMap<>();
    private Set<String> dead = new HashSet<>();
    private String king;

    public ThroneInheritance(String kingName) {
        king = kingName;
    }

    public void birth(String parentName, String childName) {
        List<String> child = cache.get(parentName);
        if (child == null) {
            child = new ArrayList<>();
            cache.put(parentName, child);
        }
        child.add(childName);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        LinkedList<String> order = new LinkedList<>();
        Successor(king, order);
        return order;
    }

    private void Successor(String x, List<String> set) {
        if (!dead.contains(x)) {
            set.add(x);
        }
        List<String> child = cache.get(x);
        if (child != null) {
            for (String c : child) {
                Successor(c, set);
            }
        }
    }

    public static void main(String[] args) {
        ThroneInheritance t= new ThroneInheritance("king"); // 继承顺序：king
        t.birth("king", "andy"); // 继承顺序：king > andy
        t.birth("king", "bob"); // 继承顺序：king > andy > bob
        t.birth("king", "catherine"); // 继承顺序：king > andy > bob > catherine
        t.birth("andy", "matthew"); // 继承顺序：king > andy > matthew > bob > catherine
        t.birth("bob", "alex"); // 继承顺序：king > andy > matthew > bob > alex > catherine
        t.birth("bob", "asha"); // 继承顺序：king > andy > matthew > bob > alex > asha > catherine
        System.out.println(t.getInheritanceOrder()); // 返回 ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
        t.death("bob"); // 继承顺序：king > andy > matthew > bob（已经去世）> alex > asha > catherine
        System.out.println(t.getInheritanceOrder()); // 返回 ["king", "andy", "matthew", "alex", "asha", "catherine"]
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
