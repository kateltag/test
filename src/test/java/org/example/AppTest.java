package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    App<Integer> app1 = new App();
    App<String> app2 = new App();

//    List of Integers
    @Test
    public void arrayOfInt()
    {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<List> solution = Arrays.asList(Arrays.asList(1, 2),
                Arrays.asList(3, 4), Arrays.asList(5, 6), Arrays.asList(7));

        List computedSolution =  app1.partition(list, 2);
        boolean isEqual = compareLists(computedSolution, solution);

        assertTrue(isEqual);
    }

//    List of Strings
    @Test
    public void arrayOfString() {
        List<String> list = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six", "Seven");
        List<List> solution = Arrays.asList(
                Arrays.asList("One", "Two", "Three"),
                        Arrays.asList("Four", "Five", "Six"), Arrays.asList("Seven"));

        List computedSolution = app2.partition(list, 3);
        boolean isEqual = compareLists(computedSolution, solution);
        System.out.println(Arrays.deepToString(computedSolution.toArray()));
        System.out.println(Arrays.deepToString(solution.toArray()));
        assertTrue(isEqual);
    }

    // It shall Throws the correct exception given an Illegal argument
    @Test(expected = IllegalArgumentException.class)
    public void invalidParam1() {
        app1.partition(null, 1);
    }

    // It shall Throws the correct exception given an Illegal argument
    @Test(expected = IllegalArgumentException.class)
    public void invalidParam2() {
        app1.partition(new ArrayList(1), 10);
    }

    //Helper function tests
    @Test
    public  void testHelper1() {
        List list1 = null;
        List list2 = new ArrayList();
        assertFalse(compareLists(list1, list2));
    }

    @Test
    public  void testHelper2() {
        List list1 = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3));
        assertTrue(compareLists(list1, list1));
    }

    //Different size
    @Test
    public  void testHelper3() {
        List list1 = new ArrayList();
        List list2 = new ArrayList();
        list1.add(1);
        list1.add(1);
        list2.add(2);
        System.out.println(compareLists(list1, list2));
        assertFalse(compareLists(list1, list2));
    }


    // Helper function. Deep compare of Two 2D Lists
    public boolean compareLists(List<List> list1, List<List> list2) {
        if(list1 == list2) return true;
        if(list1 == null) return list2 == null;
        if(list1.size() == 0) return list2.size() == 0;
        if(list1.size() != list2.size()) return false;
        for (int i = 0; i < list1.size(); i++) {
            if(list1.get(i) == list2.get(i)) continue;
            for (int j = 0; j < list1.get(i).size(); j++)
                if(!list1.get(i).get(j).equals(list2.get(i).get(j))) return false;
        }
        return true;
    }
}
