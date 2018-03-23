/*
 * CompareCar
 */
package T10;

import java.util.Comparator;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class CompareCar implements Comparator<Car> {

    @Override
    public int compare(Car car1, Car car2) {
        
        int res = car1.getYear().compareTo(car2.getYear());
        return res;
    } 
}
