package ph.com.bpi.hello;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


public class group1_main {
	static double average;
	static String fullname;
	static int studnum;
	public static void showMenuScreen2() {
    	// Display the main screen
		group1_main obj = new group1_main();
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("*          GROUP6'S STUDENT GRADING SYSTEM        *");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("*            A | UPDATE STUDENT INFO              *");
        System.out.println("*            B | COMPUTE STUDENT AVERAGE          *");
        System.out.println("*            C | DISPLAY STUDENT INFO             *");
        System.out.println("*            D | EXIT                             *");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        // Ask for an input
      //  obj.choiceMain = obj.scanner.next();
    }
	
    public static void main(String[] args) {
    	
	Double tempGrades = 0.0;
	int subjectCount = 0;
    Map<String, Double> subjectGrades = new HashMap<>();
	
	 while (true) {
    	// Display the main screen
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("*          GROUP6'S STUDENT GRADING SYSTEM        *");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("*            A | ADD STUDENT INFO                 *");
        System.out.println("*            B | COMPUTE STUDENT AVERAGE          *");
        System.out.println("*            C | DISPLAY STUDENT INFO             *");
        System.out.println("*            D | EXIT                             *");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        // Ask for an input
        System.out.print("* Hello there! How can I help? --> ");
        Scanner scanner = new Scanner(System.in);
        String choiceMain = scanner.next();

        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        
        switch (choiceMain.toUpperCase()) {
        case "A":

                // codes for adding the student
            	System.out.println("You selected A.");
        		System.out.print("Enter Student Name: ");
        		Scanner scanner0 = new Scanner(System.in);
        		fullname = scanner0	.nextLine();
        		System.out.print("Enter Sutdent ID: ");
        		Scanner scannerA = new Scanner(System.in);
        		studnum = scannerA.nextInt();

                System.out.println("* SUBJECT:                                        *");
                System.out.print("* How many subjects do you have? ");
         
                Scanner scanner1 = new Scanner(System.in);
                subjectCount = Integer.parseInt(scanner1.next());
                // scanner1.close();

                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                
                for (int i = 1; i <= subjectCount; i++) {
                	
                    Scanner scanner2 = new Scanner(System.in);
                    

                    System.out.print("* What's your Subject " + i + "? ");
                    String tempSubject = scanner2.next();
                   
                    // scanner2.close();

                    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                    
                    Scanner scanner3 = new Scanner(System.in);

                    System.out.print("* Your grade in [" + tempSubject + "]? ");
                    tempGrades = Double.parseDouble(scanner3.next());
                    //  scanner3.close();
                	
                	subjectGrades.put(tempSubject, tempGrades);

                    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
				}
                
              //  System.out.println("* Thanks Henry! Save complete!                    *");
                System.out.println("* Returning to the main menu                      *");

            	
/**        	} else {

            	// codes for updating the student
            	System.out.println("You selected A pa rin.");
            	firstName = "";
        	}
*/        	
            continue;
        case "B":
            // codes to show average (bakit compute ung tawag e auto na un?)
            System.out.println("You selected B.");
            

            double sum = 0.0;
            int count = 0;

            for (double value : subjectGrades.values()) {
                sum += value;
                count++;
            }

            average = (count > 0) ? sum / count : 0.0;

            System.out.println("Average = " + average);

            continue;
        case "C":
            
            System.out.println("You selected C.");
            System.out.println("*-*-*-*-*-*-*-*- STUDENT SUMMARY -*-*-*-*-*-*-*-*-*");
            System.out.println("Student Name: " + fullname);
            System.out.println("Student ID: "+ studnum);
            System.out.println("Average Grade: " + average);
            if (average<60) {
            	System.out.println("Status: FAILED");
            } else {
            	System.out.println("Status: PASSED");
            }
            
            continue;
        case "D":
            System.out.println("* Removing temporary information in the system... *");
            System.out.println("* Thank you, see you again soon!                  *");
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            return;
        default:
            System.out.println("Invalid choice. Please select A, B, C, or D.");
            continue;
            
        }
	 

    }
	 
    }
    
}
