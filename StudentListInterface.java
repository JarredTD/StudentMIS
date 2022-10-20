package assg6_desrosiersj20;

import java.util.ArrayList;

public interface StudentListInterface {
	
	public void loadData(String filename);
	
	public void displayRoster();
	
	public Student searchForStudent(String id);
	
	public boolean addStudent(String id, String name, String standing, String major);
	
	public boolean removeStudent(String id);
	
	public ArrayList<Student> getStudentsByMajor(String major);
	
	public void sort();
	
	public void save();
	
}
