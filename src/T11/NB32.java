/*
 * Skriv en klass som använder en förbindelselista för att representera en viktad graf.
 * Konstruktorn tar ett filnamn på en textfil och skapar utifrån denna en förbindelselista. 
 * Du väljer själv hur du organiserar textfilen för att representera grafen. 
 * Det ska dock vara relativt enkelt att skriva en textfil för att representera en godtycklig graf.
 * Skriv toString som skriver ut en nod per rad följt av noderna som denne har bågar till med vikter. 
 * Skriv en metod som returnera närmsta vägen mellan två noder.
 * Skapa en textfil som representerar grafen från föreläsningen och testkör.
 */
package T11;

/**
 *
 * @author Wang Zheng-Yu <zhengyuw@kth.se>
 */
public class NB32 {
    
    public static void main(String[] args) {
        
        String filePathRead = "src/T11/graph";
        Graph g=new Graph(filePathRead);

	System.out.println(g);
	System.out.println(g.isConnected(1, 4) + "\n");
        System.out.println("Shortest route: " + g.shortestRoute(6,3));
    }
}
