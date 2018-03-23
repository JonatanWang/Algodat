/*
 * Activity with begin & end time & name
 */
package T12;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class Activity implements Comparable<Activity> {

    public Activity(String name, int begin, int end) {
        this.name = name;
        this.begin = begin;
        this.end = end;
    }

    public Activity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Activity{" + "name=" + name + ", begin=" + begin + ", end=" + end + '}';
    }
    
    @Override
    public int compareTo(Activity a) {
        return this.end - a.end;
    }

    private String name;
    // begin & end from 0001 to 2400
    private int begin;
    private int end;
    
}
