# Puzzles-MinCostConnectPoints

Learn Prim's algorithm to create a MST (Minimum Spanning Tree)

## Lesson Task

The Minimum spanning tree is a new concept to me.

Prim's algorithm is a new algorithm to me.

The sample solution uses Python's heapq.

There is no direct correlation between heapq and a data structure in java.

The closest fit is the `java.util.PriorityQueue`. It is based on a priority heap.
The head of this queue is the least element with respect to the specified ordering.

Since java is strongly typed, then the constructor of `java.util.PriorityQueue`
that accepts a `Comparator` should be used.

The distance between two given points is the rule in the algorithm
that determines what should be popped next from the heap.
The shortest distances are desired for the minimum spanning tree.

I will have to do some abstract visualizing and experimental code
to ensure the heap has the smallest distant on top,
and the heap eventually is empty.

The goal is to have a minimum spanning tree with
the same number of points as the original set
and the number of edges is one less than the number of points. 
