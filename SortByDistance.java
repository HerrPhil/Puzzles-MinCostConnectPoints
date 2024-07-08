import java.util.Comparator;

public class SortByDistance implements Comparator<MinimumTreeSpan> {

    public int compare(MinimumTreeSpan a, MinimumTreeSpan b) {

        return a.getDistance() - b.getDistance();

    }

}
