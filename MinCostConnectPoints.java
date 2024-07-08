import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class MinCostConnectPoints {

    public static void main(String [] args) {
        System.out.printf("Hello Minimum Cost to Connect Points Solution #1%n");
        if (args != null && args.length == 1 && args[0].toLowerCase().equals("-usage")) {
            System.out.printf("java MinCostConnectPoints%n");
            System.out.printf("    demonstrate how Prim's algorithm works%n");
            return;
        }

        MinCostConnectPoints minCostConnectPoints = new MinCostConnectPoints();

        List<List<Integer>> points = new ArrayList<>();

        int [] point1 = new int [] {0, 0};
        List<Integer> list1 = Arrays.stream(point1).boxed().collect(Collectors.toList());

        int [] point2 = new int [] {2, 2};
        List<Integer> list2 = Arrays.stream(point2).boxed().collect(Collectors.toList());

        int [] point3 = new int [] {3, 10};
        List<Integer> list3 = Arrays.stream(point3).boxed().collect(Collectors.toList());

        int [] point4 = new int [] {5, 2};
        List<Integer> list4 = Arrays.stream(point4).boxed().collect(Collectors.toList());

        int [] point5 = new int [] {7, 0};
        List<Integer> list5 = Arrays.stream(point5).boxed().collect(Collectors.toList());

        points.add(list1);

        points.add(list2);

        points.add(list3);

        points.add(list4);

        points.add(list5);
        
        int result = minCostConnectPoints.findMinimumCost(points);

        System.out.printf("%nminimum cost of connected points = %d%n", result);
    }

    public int findMinimumCost(List<List<Integer>> points) {
        System.out.printf("Find the minimum cost of connected points in a minimum span tree%n");

        PriorityQueue<Integer> intQueue = new PriorityQueue<>();

        intQueue.add(1);
        intQueue.add(5);
        intQueue.add(2);
        intQueue.add(4);
        intQueue.add(3);

        while(intQueue.peek() != null) {
            int value = intQueue.poll();
            System.out.printf("from the top of the heap %d%n", value);
        }

        MinimumTreeSpan span = new MinimumTreeSpan(123, 1);
        System.out.printf("%s%n", span.toString());
        System.out.printf("hash code is %d%n", span.hashCode());
        System.out.printf("equals to span expect true actual = %b%n", span.equals(new MinimumTreeSpan(123,1)));
        System.out.printf("equals to span expect false actual = %b%n", span.equals(new MinimumTreeSpan(123,0)));
        System.out.printf("equals to string expect false actual = %b%n", span.equals("test"));
        System.out.printf("equals to null expect false actual = %b%n", span.equals(null));

        return -1;
    }

}
