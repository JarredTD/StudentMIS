package assg6_desrosiersj20;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StudentList implements StudentListInterface {

	private ArrayList<Student> studentList;

	public StudentList() {
		studentList = new ArrayList<Student>();
	}

	@Override
	public void loadData(String filename) {
		try {
			Scanner input = new Scanner(new File(filename));

			while (input.hasNextLine()) {
				String line = input.nextLine();
				String[] lineArr = line.split(",");
				this.addStudent(lineArr[0], lineArr[1], lineArr[2], lineArr[3]);
			}

			input.close();
		}

		catch (FileNotFoundException err) {
			System.out.println(err.getMessage());
		}

	}

	@Override
	public void displayRoster() {
		studentList.forEach(student -> System.out.println(student.toString()));
	}

	@Override
	public Student searchForStudent(String id) {
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getId().equals(id)) {
				return studentList.get(i);
			}
		}

		return null;
	}

	@Override
	public boolean addStudent(String id, String name, String standing, String major) {
		if (this.searchForStudent(id) == null) {
			studentList.add(new Student(id, name, standing, major));
			return true;
		}
		return false;
	}

	@Override
	public boolean removeStudent(String id) {

		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getId().equals(id)) {
				studentList.remove(i);
				return true;
			}
		}

		return false;

	}

	@Override
	public ArrayList<Student> getStudentsByMajor(String major) {
		ArrayList<Student> tmp = new ArrayList<Student>();

		studentList.forEach(student -> {
			if (student.getMajor().equals(major)) {
				tmp.add(student);
			}
		});

		return tmp;
	}

	@Override
	public void sort() {
		studentList.sort(Comparator.naturalOrder());

	}

	@Override
	public void save() {
		try {
			PrintStream output = new PrintStream(new File("assg6_data"));
			studentList.forEach(student -> output.println(student.toString()));
			output.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
