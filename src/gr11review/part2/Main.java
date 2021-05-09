package gr11review.part2;

/* Compiling and running:

javac -d bin src/gr11review/part2/Utility.java
javac -d bin src/gr11review/part2/Main.java
java -classpath bin gr11review.part2.Main
java -classpath bin gr11review.part2.Utility

*/

public class Main {
  public static void main(String[] args) {
    int myInt;
    myInt = Utility.sumNumbers("abc123abc");
    System.out.println(myInt);
  }

}