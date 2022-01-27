import java.util.*;

public class Algorithm<T> {

    private final int[][] a;
    private final int[][] b;
    private final int[] aPref;
    private T[] aGroup;
    private T[] bGroup;

    public Algorithm(int[][] a, int[][] b, T[] aGroup, T[] bGroup) {
        this(a, b);

        this.aGroup = aGroup;
        this.bGroup = bGroup;
    }

    public Algorithm(int[][] a, int[][] b) {
        this.a = a;
        this.b = b;
        this.aPref = new int[a.length];

        // Fill the preferences array with -1
        for (int i = 0; i < a.length; i++)
            aPref[i] = -1;

        // We have an array of preferences. While it contains -1, continue to do logic.
        while (prefContainsNegativeOne()) {

            // Each iteration of the while loop, loop through every a row.
            for (int row = 0; row < a.length; row++) {

                // If the A row already has a preferred value set, skip it!
                if (aPref[row] != -1)
                    continue;

                System.out.println(Arrays.toString(aPref));

                // Assign the preferred values of the a row to a variable
                int[] list = a[row];
                // It's current preferred value will always be the first value in its preferences
                int firstPreferredB = list[0];

                // Get another A value that might have the first preferred B value as its first
                int otherA = getOtherA(firstPreferredB, row);

                // If there isn't another A value matching the condition above, we can set the preference
                //   of this row to the first preferred b value.
                if (otherA == -1) {
                    aPref[row] = firstPreferredB;
                    continue;
                }

                // Here, there is another a value, so we need to check priorities.
                //
                // This returns an array of size 2 with the first value being the more preferred a value,
                //   and the second value being the less preferred value.
                int[] lowHigh = getPreference(firstPreferredB, row, otherA);
                int higher = lowHigh[0];
                int lower = lowHigh[1];

                // With the lower value, we want to remove its first preferred b value as another A
                //   value is more preferred.
                a[lower] = removeFirst(a[lower]);
                // With the more preferred A value, set its preference to the B value
                aPref[higher] = firstPreferredB;
                // Given that the lower is not preferred, we must continue searching for its preferred value,
                //   thus we set this to -1.
                aPref[lower] = -1;
            }
        }

        System.out.println(Arrays.toString(aPref));
    }

    public int[] getResult() {
        return aPref;
    }

    public Map<T, T> getObjectPairings() {
        Map<T, T> map = new HashMap<>();

        for (int i = 0; i < aPref.length; i++)
            map.put(aGroup[i], bGroup[aPref[i]]);

        return map;
    }

    /**
     * @return true if preferences array is contains -1 at least once
     */
    private boolean prefContainsNegativeOne() {
        for (int i : aPref)
            if (i == -1)
                return true;

        return false;
    }

    /**
     * @return -1 or the index of the A row with the first preferred b value
     */
    private int getOtherA(int first, int ignored) {
        for (int i = 0; i < a.length; i++) {
            if (i != ignored && a[i][0] == first)
                return i;
        }

        return -1;
    }

    /**
     * @return an array of size 2 with the higher preferred A index in index 0, and lower preferred at index 1.
     */
    private int[] getPreference(int bRow, int a1, int a2) {
        for (int i : b[bRow]) {
            if (i == a1)
                return new int[]{a1, a2};
            else if (i == a2)
                return new int[]{a2, a1};
        }

        return null;
    }

    /**
     * Does the job an ArrayList would do by removing the first index.
     */
    private int[] removeFirst(int[] array) {
        int[] n = new int[array.length-1];

        for (int i = 1; i < array.length; i++)
            n[i-1] = array[i];

        return n;
    }
}
