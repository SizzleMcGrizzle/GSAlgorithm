import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgorithmTest {

    @Test
    public void test4() {
        int[] test = new Algorithm<Person>(new int[][]{
                {3, 1, 0, 2},
                {3, 2, 1, 0},
                {1, 2, 0, 3},
                {3, 0, 2, 1}
        }, new int[][]{
                {1, 2, 3, 0},
                {0, 2, 3, 1},
                {1, 3, 2, 0},
                {1, 2, 0, 3},
        }).getResult();

        assertEquals(test[0], 1);
        assertEquals(test[1], 3);
        assertEquals(test[2], 2);
        assertEquals(test[3], 0);
    }
    @Test
    public void test5() {
        int[] test = new Algorithm<Person>(new int[][]{
                {1, 2, 0, 3, 4},
                {3, 0, 1, 4, 2},
                {4, 3, 0, 2, 1},
                {4, 2, 0, 1, 3},
                {3, 2, 0, 1, 4}
        }, new int[][]{
                {1, 3, 4, 2, 0},
                {3, 0, 1, 2, 4},
                {3, 0, 4, 1, 2},
                {2, 4, 1, 3, 0},
                {0, 1, 3, 2, 4}
        }).getResult();

        assertEquals(test[0], 1);
        assertEquals(test[1], 0);
        assertEquals(test[2], 3);
        assertEquals(test[3], 4);
        assertEquals(test[4], 2);
    }

    @Test
    public void test6() {
        int[] test = new Algorithm<Person>(new int[][]{
                {1, 0, 2, 3, 4, 5},
                {1, 2, 4, 3, 5, 0},
                {4, 1, 2, 5, 3, 0},
                {3, 4, 5, 0, 1, 2},
                {4, 5, 0, 3, 1, 2},
                {4, 0, 5, 2, 3, 1}
        }, new int[][]{
                {5, 1, 3, 2, 4, 0},
                {0, 2, 3, 5, 4, 1},
                {2, 5, 4, 3, 1, 0},
                {4, 3, 5, 2, 0, 1},
                {5, 4, 0, 2, 1, 3},
                {0, 5, 1, 3, 2, 4}
        }).getResult();

        assertEquals(test[0], 1);
        assertEquals(test[1], 5);
        assertEquals(test[2], 2);
        assertEquals(test[3], 3);
        assertEquals(test[4], 0);
        assertEquals(test[5], 4);
    }

    @Test
    public void test7() {
        int[] test = new Algorithm<Person>(new int[][]{
                {0, 3, 4, 1, 2, 5, 6},
                {0, 6, 3, 5, 4, 2, 1},
                {2, 4, 0, 6, 5, 3, 1},
                {1, 5, 4, 2, 0, 6, 3},
                {3, 5, 6, 2, 1, 4, 0},
                {3, 6, 5, 2, 1, 0, 4},
                {6, 4, 5, 2, 0, 3, 1}
        }, new int[][]{
                {4, 1, 5, 3, 0, 2, 6},
                {1, 6, 0, 2, 5, 4, 3},
                {4, 6, 5, 2, 3, 0, 1},
                {6, 1, 5, 4, 0, 3, 2},
                {4, 5, 6, 3, 1, 2, 0},
                {5, 4, 3, 0, 1, 2, 6},
                {6, 5, 0, 1, 4, 3, 2}
        }).getResult();

        assertEquals(test[0], 4);
        assertEquals(test[1], 0);
        assertEquals(test[2], 2);
        assertEquals(test[3], 1);
        assertEquals(test[4], 5);
        assertEquals(test[5], 3);
        assertEquals(test[6], 6);
    }
}
