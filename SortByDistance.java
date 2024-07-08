import java.util.Comparator;

public class SortByDistance implements Comparator<MinimumSpanTree> {

    public int compare(MinimumSpanTree a, MinimumSpanTree b) {

        return a.getDistance() - b.getDistance();

    }

}
