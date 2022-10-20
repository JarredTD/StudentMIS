package assg6_desrosiersj20;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentMIS {

	public static void main(String[] args) {

		//@formatter:off
		final String menu = String.format("1. Display the roster \n"
				+ "2. Search for a student by id \n"
				+ "3. Add a new student \n"
				+ "4. Remove a student \n"
				+ "5. Search for students by major \n"
				+ "6. Sort and save to file \n"
				+ "7. Save to file \n"
				+ "8. Exit \n"
				+ "Choice: ");
		//@formatter:on

		int choice = 0;
		Student tmpStudent;
		Scanner input = new Scanner(System.in);

		StudentList roster = new StudentList();
		roster.loadData("assg6_data.txt");

		while (choice != 8) { // 8 exits the program.
			System.out.print(menu);
			choice = input.nextInt();
			input.nextLine();

			switch (choice) {

			case 1:
				System.out.println("");
				roster.displayRoster();
				pause();
				break;

			case 2:
				System.out.print("Please enter the Student ID you want to search: ");
				tmpStudent = roster.searchForStudent(input.next());
				if (!(tmpStudent == null)) {
					System.out.println(tmpStudent.toString());
				} else {
					System.out.println("Student not found (Invalid ID).");
				}

				pause();

				break;

			case 3:
				String id, name, standing, major;

				System.out.print("Please enter the Student's ID: ");
				id = input.next();

				System.out.print("Please enter the Student's Name: ");
				name = input.next();

				System.out.print("Please enter the Student's Standing: ");
				standing = input.next();

				System.out.print("Please enter the Student's Major: ");
				major = input.next();

				if (roster.addStudent(id, name, standing, major)) {
					System.out.println("Student Successfully Added.");
				} else {
					System.out.println("Student Unsuccessfully Added (ID already in use).");
				}

				pause();
				break;

			case 4:
				System.out.print("Please enter the Student ID of the student you want to remove: ");
				if (roster.removeStudent(input.next())) {
					System.out.println("Student Successfully Removed.");
				} else {
					System.out.println("Student Unsuccessfully Removed (Invalid ID).");
				}
				pause();
				break;

			case 5:
				System.out.print("Please enter a major to filter by: ");
				ArrayList<Student> tmp = roster.getStudentsByMajor(input.next());

				if (!tmp.isEmpty()) {
					tmp.forEach(student -> System.out.println(student));
				} else {
					System.out.println("No Student's with this major. ");
				}

				pause();
				break;

			case 6:
				roster.sort();
				roster.save();

				System.out.println("Sorted and Saved.");
				pause();
				break;

			case 7:
				roster.save();

				System.out.println("Saved.");
				pause();
				break;

			case 8:
				input.close();
				System.out.println("Program Ended.");
				System.exit(0);
				break;
			}

		}

	}

	public static void pause() {
		System.out.println("Hit enter to continue...");
		try {
			System.in.read();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
