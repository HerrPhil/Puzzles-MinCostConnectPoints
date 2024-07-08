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

        // The following will be Prim's algorithm to create a MST (Minimum Spanning Tree)
        int n = points.size();
        int totalCost = 0;
        PriorityQueue<MinimumTreeSpan> heap = new PriorityQueue<>(n, new SortByDistance());
        // This special minimum tree span is the distance of the first point from itself.
        heap.add(new MinimumTreeSpan(0, 0));
        Set<Integer> seen = new TreeSet<>();

        while (seen.size() < n) {

            System.out.printf("%n%nwhile the size of seen points is less than n%n");
            int distance = 0;
            int pointIndex = 0;
            MinimumTreeSpan nextMinimumTreeSpan = heap.poll();
            if (nextMinimumTreeSpan != null) {
                distance = nextMinimumTreeSpan.getDistance();
                pointIndex = nextMinimumTreeSpan.getPointIndex();
            }
            System.out.printf("The following is the next minimum tree span%n%s", nextMinimumTreeSpan.toString());
            if (seen.contains(pointIndex)) continue;
            System.out.printf("The seen set does not contain point index = %d%n", pointIndex);
            seen.add(pointIndex);
            System.out.printf("Added pointIndex = %d to seen set%n", pointIndex);
            totalCost += distance;
            System.out.printf("Added distance = %d to total cost%n", distance);
            int xOfPointIndex = points.get(pointIndex).get(0);
            int yOfPointIndex = points.get(pointIndex).get(1);

            for (int j = 0; j < n; j++) {

                System.out.printf("For jth point index = %d%n", j);
                if (!seen.contains(j)) {

                    int xOfPointJ = points.get(j).get(0);
                    int yOfPointJ = points.get(j).get(1);
                    // Since we are not concerned with exact geometry,
                    // it is not necessary to square the differences and square root the sum,
                    // to get the hypotenuse (Pythagorean theorem).
                    // The sum of differences of coordinates is good enough to estimate distance.
                    int nextDistance = Math.abs(xOfPointIndex - xOfPointJ) + Math.abs(yOfPointIndex - yOfPointJ);
                    heap.offer(new MinimumTreeSpan(nextDistance, j));
                    System.out.printf("pushed to heap minimum tree span of distance = %d and point index = %d%n", nextDistance, j);
                }
                System.out.printf("goto to next j%n");

            }

        }

        return totalCost;
    }

}
