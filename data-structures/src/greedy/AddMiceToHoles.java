package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AddMiceToHoles
{
    public static Set<Integer> usedPos = new HashSet<>();
    public static int mice(ArrayList<Integer> a, ArrayList<Integer> b) {
        Collections.sort(a);
        Collections.sort(b);
        int ans = Integer.MIN_VALUE;
        for (int i=0; i< a.size(); i++) {
            ans = Math.max(ans, Math.abs(a.get(i) - b.get(i)));
        }
        return ans;
    }

    public static int bestPos(ArrayList<Integer> holes, int micePos) {
        int start = Integer.MAX_VALUE;
        int used = -1;
        for (int i=0; i< holes.size();i++) {
            if (!usedPos.contains(holes.get(i))) {
                if (start > Math.abs(holes.get(i) - micePos))
                start = Math.abs(holes.get(i) - micePos);
                used = holes.get(i);
            }
        }
        usedPos.add(used);
        return start;
    }

    public static void main(String[] args)
    {
        ArrayList<Integer> a = new ArrayList<>();
        a.addAll(Arrays.asList(-49, 58, 72, -78, 9, 65, -42, -3));
        ArrayList<Integer> b = new ArrayList<>();
        b.addAll(Arrays.asList(30, -13, -70, 58, -34, 79, -36, 27));
        System.out.println(mice(a, b));
    }
}
