package project.studentGrades;

import java.util.Scanner;

public class Main {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		String name = "";
		String id = "";
		int numSub = 0;
		int[] grades = null;
 
		while (true) {
			System.out.println("===== STUDENT GRADING SYSTEM =====");
			System.out.println("A - Add Student Information");
			System.out.println("B - Compute Student Average");
			System.out.println("C - Display Student Information");
			System.out.println("D - Exit");
			System.out.print("Enter choice: ");
			
			String choice = sc.nextLine().toUpperCase();
 
			if (choice.equals("A")) {
				System.out.print("Enter student name: ");
				name = sc.nextLine();
 
				System.out.print("Enter student ID: ");
				id = sc.nextLine();
 
				System.out.print("Enter number of subjects: ");
				numSub = Integer.parseInt(sc.nextLine());
 
				grades = new int[numSub];
				for (int i = 0; i < numSub; i++) {
					System.out.print("Enter grade for subject " + (i + 1) + ": ");
					grades[i] = Integer.parseInt(sc.nextLine());
				}
				System.out.println("===== STUDENT SAVED =====\n");
 
			} else if (choice.equals("B")) {
				if (grades == null) {
					System.out.println("No student data found. Please input student first.\n");
				} else {
					double sum = 0;
					for (int g : grades)
						sum += g;
					double avg = sum / numSub;
					String status = (avg >= 75) ? "PASS" : "FAIL";
					System.out.printf("Average: %.1f\n", avg);
					System.out.println("Status: " + status + "\n");
				}
			} else if (choice.equals("C")) {
				if (grades == null) {
					System.out.println("No student data found. Please input student first.\n");
				} else {
					double sum = 0;
					for (int g : grades)
						sum += g;
					double avg = sum / numSub;
					String status = (avg >= 75) ? "PASS" : "FAIL";
 
					System.out.println("===== STUDENT SUMMARY =====");
					System.out.println("Student Name: " + name);
					System.out.println("Student ID: " + id);
					System.out.printf("Average Grade: %.1f\n", avg);
					System.out.println("Status: " + status);
					System.out.println("===========================\n");
				}
			} else if (choice.equals("D")) {
				System.out.println("Exit!");
				break;
 
			} else {
				System.out.println("Invalid choice. Please try again.\n");
			}
		}
 
		sc.close();
 
	}
 
}
