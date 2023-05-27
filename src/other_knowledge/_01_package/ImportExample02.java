package other_knowledge._01_package;

import java.util.*;

public class ImportExample02 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
      
    System.out.println("Enter your name : ");
    String name = scanner.nextLine();
      
    System.out.println(name);
    
    char[] char_arr = {'y', 'o', 'o', 'n', 's', 'i', 'k'};
    System.out.println(Arrays.toString(char_arr));
      
    scanner.close();
  }
}