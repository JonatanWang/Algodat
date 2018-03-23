/*
 * Skriv en schemaläggningsfunktion enligt föreläsningen.
 */
package T12;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class N36 {
    
    private static void scheme(ArrayList<Activity> acts) {
        ArrayList<Activity> res = new ArrayList<>();
        Activity act = new Activity();
        while(!acts.isEmpty()) {
            act = findEarliestEndedActivity(acts);
            //System.out.println("earliest ended activity -> " + act.toString());
            res.add(act);
            acts.remove(act);   // can be omitted because of loop below?
            for(int i = 0; i < acts.size(); i ++) {
                if(overlaps(acts.get(i), act)) {
                    acts.remove(acts.get(i));
                }
            }
        }
        print(res);
    }

    private static Activity findEarliestEndedActivity(ArrayList<Activity> acts) {
        Collections.sort(acts);
        return acts.get(0);
    }
          
    private static boolean overlaps(Activity a, Activity b) {
        
        return ((a.getBegin() < b.getEnd()) &&
                b.getBegin() < a.getEnd());
    }

    private static void print(ArrayList<Activity> res) {
        res.forEach((a) -> {
            System.out.println(a.toString());
        });
    }
    
    public static void main(String[] args) {
        Activity math = new Activity("math", 800, 1000);
        Activity geography = new Activity("geography", 800, 900);
        Activity music = new Activity("music", 900, 1000);
        Activity physics = new Activity("physics", 1000, 1200);
        Activity chemistry = new Activity("chemistry", 1300, 1500);
        Activity english = new Activity("english", 900, 930);
        Activity swedish = new Activity("swedish", 1330, 1430);
        Activity politics = new Activity("politics", 1515, 1700);
        Activity sports = new Activity("sports", 1700, 1900);
        Activity programming = new Activity("programming", 1730, 2000);
        Activity biology = new Activity("biology", 1430, 1515);
        ArrayList<Activity> acts = new ArrayList<>();
        acts.add(math);
        acts.add(physics);
        acts.add(chemistry);
        acts.add(english);
        acts.add(swedish);
        acts.add(politics);
        acts.add(sports);
        acts.add(programming);
        acts.add(biology);
        acts.add(music);
        acts.add(geography);
        
        print(acts);
        System.out.println("\nschema: ");
        scheme(acts);
    }
}
