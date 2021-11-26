package util;


import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class Trees {

    private static <T> T genTree(Integer[] vals,
                                 Function<Integer, T> factory,
                                 BiConsumer<T, T> letSetter,
                                 BiConsumer<T, T> rightSetter) {
        List<T> out = new ArrayList<>();
        int i = 0;
        int prev = -1;

        for (Integer val : vals) {
            T node = val == null ? null : factory.apply(val);
            if (i < out.size()) {
                T t = out.get(i);
                if (i > prev) {
                    letSetter.accept(t, node);
                    prev = i;
                } else {
                    rightSetter.accept(t, node);
                    i++;
                }
            }
            if (node != null) {
                out.add(node);
            }
        }

        return out.isEmpty() ? null : out.get(0);
    }
}
