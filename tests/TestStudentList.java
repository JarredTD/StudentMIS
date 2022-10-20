/**
 * 
 */
package assg6_desrosiersj20.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import assg6_desrosiersj20.Student;
import assg6_desrosiersj20.StudentList;

/**
 * @author jarredtd
 *
 */
public class TestStudentList {
	StudentList list;
	Student s1, s2;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list = new StudentList();

		s1 = new Student("12345", "Jarred", "Senior", "Computer Science");
		s2 = new Student("54321", "David", "Freshmen", "Political Science");

		list.addStudent("12345", "Jarred", "Senior", "Computer Science");
		list.addStudent("54321", "David", "Freshmen", "Political Science");
		list.addStudent("123456", "Jerhald", "Sophmore", "Computer Science");

	}

	/**
	 * Test method for
	 * {@link assg6_desrosiersj20.StudentList#searchForStudent(java.lang.String)}.
	 */
	@Test
	public void testSearchForStudent() {
		assertEquals(s1, list.searchForStudent("12345"));
	}

	/**
	 * Test method for
	 * {@link assg6_desrosiersj20.StudentList#addStudent(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAddStudent() {
		StudentList tmpList = list;
		Student tmp = new Student("123", "Test", "Freshmen", "Test Major");

		assertTrue(tmpList.addStudent("123", "Test", "Freshmen", "Test Major"));
		assertEquals(tmp, tmpList.searchForStudent("123"));

		assertFalse((tmpList.addStudent("123", "Test", "Freshmen", "Test Major")));
	}

	/**
	 * Test method for
	 * {@link assg6_desrosiersj20.StudentList#removeStudent(java.lang.String)}.
	 */
	@Test
	public void testRemoveStudent() {
		StudentList tmpList = list;

		assertTrue(tmpList.removeStudent("12345"));
		assertEquals(null, tmpList.searchForStudent("12345"));

		assertFalse(tmpList.removeStudent("12345"));
	}

}
