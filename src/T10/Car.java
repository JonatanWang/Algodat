/*
 * Car
 */
package T10;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class Car implements Comparable<Car> {

    private String brand;
    private String year;
    private String milage;

    public Car(String brand, String year, String milage) {
        this.brand = brand;
        this.year = year;
        this.milage = milage;
    }
    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMilage() {
        return milage;
    }

    public void setMilage(String milage) {
        this.milage = milage;
    }  

    @Override
    public int compareTo(Car car) {
        Car other = car;
        // Compare this Car to other using brand names
        int res = brand.compareTo(other.brand);
        return res;
    }
    
    @Override
    public String toString() {
        return "[" + brand + ", "
                + year + ", " + milage
                +"]";
    }
}
