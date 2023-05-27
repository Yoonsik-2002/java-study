package other_knowledge._01_package;

import java.util.Scanner;

public class ImportExample01 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
      
    System.out.println("Enter your name : ");
    String name = scanner.nextLine();
    
    System.out.println(name);
      
    scanner.close();
  }
}