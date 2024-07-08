public class MinimumTreeSpan {

    private int distance;
    private int pointIndex;

    public MinimumTreeSpan(int distance, int pointIndex) {
        this.distance = distance;
        this.pointIndex = pointIndex;
    }

    @Override
    public boolean equals(Object span) {
        if (span == null) return false;
        if (this == span) return true;
        if (!(span instanceof MinimumTreeSpan)) return false;
        MinimumTreeSpan that = (MinimumTreeSpan) span;
        return this.distance == that.distance && this.pointIndex == that.pointIndex;
    }

    @Override
    public String toString() {
        return String.format("Minimum Tree Span of distance = %d and point index = %d%n", distance, pointIndex);
    }

    @Override
    public int hashCode() {
        int offset = 1;
        int temp = pointIndex;
        while(temp > 0) {
            offset *= 10;
            temp /= 10;
        }
        return distance * offset + pointIndex;
    }

    public int getDistance() {
        return distance;
    }

    public int getPointIndex() {
        return pointIndex;
    }

}
