/*
 * Sort characters recursively
 */
package T7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Sort a series of characters in ascended ordering.
 */
public class CharRecSorter {

    // Data fields
    private static char[] characters = {'C', 'C', 'C', 'B', 'A', 'A', 'A'};
    private ArrayList<String> dontCare = new ArrayList<>();

    // Constructor
    public CharRecSorter() {
        dontCare.add(" don't care ");
    }

    // Private class to record the current state of testing.
    private static class CurrentState {

        public final char[] chars;
        public final ArrayList<String> steps;

        public CurrentState(char[] chars, ArrayList<String> steps) {
            this.chars = chars;
            this.steps = steps;
        }
    }

    private static int getIndexOfB(char[] c) {
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'B') {
                return i;
            }
        }
        return -1;
    }

    private static int left(char[] characters) {
        int index = getIndexOfB(characters);
        if (index - 1 >= 0 && characters[index - 1] == 'C') {
            char tmp = characters[index - 1];
            characters[index - 1] = 'B';
            characters[index] = tmp;
            return index;
        }
        return -1;
    }

    private static int left2(char[] characters) {
        int index = getIndexOfB(characters);
        if (index - 2 >= 0 && characters[index - 2] == 'C') {
            char tmp = characters[index - 2];
            characters[index - 2] = 'B';
            characters[index] = tmp;
            return index;
        }
        return -1;
    }

    private static int right(char[] characters) {
        int index = getIndexOfB(characters);
        if (index + 1 <= characters.length - 1 && characters[index + 1] == 'A') {
            char tmp = characters[index + 1];
            characters[index + 1] = 'B';
            characters[index] = tmp;
            return index;
        }
        return -1;
    }

    private static int right2(char[] characters) {
        int index = getIndexOfB(characters);
        if (index + 2 <= characters.length - 1 && characters[index + 2] == 'A') {
            char tmp = characters[index + 2];
            characters[index + 2] = 'B';
            characters[index] = tmp;
            return index;
        }
        return -1;
    }

    /**
     * Check if the characters in the array is well sorted ascended.
     *
     * @param characters The input array of characters
     * @return true if sorted ascended; otherwise, false.
     */
    private static boolean isSorted(char[] characters) {
        char[] target = {'A', 'A', 'A', 'B', 'C', 'C', 'C'};
        return java.util.Arrays.equals(target, characters); 
    }

    /**
     * Wrapper method to call recursive sort().
     *
     * @return The recursive sort()
     */
    public String sort() {
        ArrayList<String> str = sort(characters);
        StringBuilder steps = new StringBuilder();
        str.forEach((s) -> {
            steps.append(s);
        });
        return "Steps: " + steps + "\nTotal: " + str.size() + " steps.";
    }

    /**
     * Recursive method to sort the characters. pre: disordered letters post:
     * letters in alphabet ordering
     *
     * @param chars The input array of char.
     * @return The ordering represented by index
     */
    public ArrayList<String> sort(char[] chars) {

        char[] newArray = chars.clone();
        ArrayList<String> steps = new ArrayList<>();
        Queue<CurrentState> queue = new LinkedList<>();
        CurrentState state = new CurrentState(newArray, steps);

        while (state!=null && !isSorted(state.chars)) {

            newArray = state.chars.clone();
            int left = left(newArray);
            if (left != -1) {
                steps = (ArrayList<String>) state.steps.clone();
                steps.add((left - 1 + 1) + "->" + (left + 1) + ", ");
                queue.offer(new CurrentState(newArray, steps));
            }

            newArray = state.chars.clone();
            int left2 = left2(newArray);
            if (left2 != -1) {
                steps = state.steps;
                steps.add((left2 - 2 + 1) + "->" + (left2 + 1) + ", ");
                queue.offer(new CurrentState(newArray, steps));
            }

            newArray = state.chars;
            int right = right(newArray);
            if (right != -1) {
                steps = state.steps;
                steps.add((right + 1 + 1) + "->" + (right + 1) + ", ");
                queue.offer(new CurrentState(newArray, steps));
            }

            newArray = state.chars;
            int right2 = right2(newArray);
            if (right2 != -1) {
                steps = state.steps;
                steps.add((right2 + 2 + 1) + "->" + (right2 + 1) + ", ");
                queue.offer(new CurrentState(newArray, steps));
            }
            state = queue.poll();
        }
        if(state != null)
            return state.steps;
        else
            return dontCare;
    }

    public static void main(String[] args) {

        CharRecSorter sorter = new CharRecSorter();
        String result = sorter.sort();
        System.out.println(result);
    }
}
