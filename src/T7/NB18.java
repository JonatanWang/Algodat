/*
 * Labryint
 */
package T7;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB18 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Maze m = new Maze();
                System.out.println("Labyrint");
		m.print();
		if(m.solve()) System.out.print("\nLyckades");
		System.out.println();
		m.print();

	}	
}
