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

/**
 * @author jarredtd
 *
 */
public class TestStudent {

	Student s1, s2;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		s1 = new Student("12345", "Jarred", "Senior", "Computer Science");
		s2 = new Student("54321", "David", "Freshmen", "Political Science");
	}

	/**
	 * as Test method for
	 * {@link assg6_desrosiersj20.Student#Student(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testStudent() {
		assertEquals("12345", s1.getId());
		assertEquals("Jarred", s1.getName());
		assertEquals("Senior", s1.getStanding());
		assertEquals("Computer Science", s1.getMajor());
	}

	/**
	 * Test method for {@link assg6_desrosiersj20.Student#getMajor()}.
	 */
	@Test
	public void testGetMajor() {
		assertEquals("Political Science", s2.getMajor());
	}

	/**
	 * Test method for
	 * {@link assg6_desrosiersj20.Student#setMajor(java.lang.String)}.
	 */
	@Test
	public void testSetMajor() {
		Student tmp = s1;
		tmp.setMajor("Business");

		assertEquals("Business", tmp.getMajor());
	}

	/**
	 * Test method for {@link assg6_desrosiersj20.Student#getId()}.
	 */
	@Test
	public void testGetId() {
		assertEquals("54321", s2.getId());
	}

	/**
	 * Test method for {@link assg6_desrosiersj20.Student#getName()}.
	 */
	@Test
	public void testGetName() {
		assertEquals("David", s2.getName());
	}

	/**
	 * Test method for {@link assg6_desrosiersj20.Student#getStanding()}.
	 */
	@Test
	public void testGetStanding() {
		assertEquals("Freshmen", s2.getStanding());
	}

	/**
	 * Test method for {@link assg6_desrosiersj20.Student#toString()}.
	 */
	@Test
	public void testToString() {
		assertEquals(String.format("ID: %s, Name: %s, Major: %s, Standing: %s", s2.getId(), s2.getName(), s2.getMajor(),
				s2.getStanding()), s2.toString());
	}

	/**
	 * Test method for {@link assg6_desrosiersj20.Student#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		Student tmp = s2;
		assertTrue(tmp.equals(s2));
		assertFalse(s1.equals(s2));
	}

	/**
	 * Test method for
	 * {@link assg6_desrosiersj20.Student#compareTo(assg6_desrosiersj20.Student)}.
	 */
	@Test
	public void testCompareTo() {
		Student tmp = s2;

		assertTrue(s1.compareTo(s2) < 0);
		assertEquals(0, s2.compareTo(tmp));
		assertTrue(s2.compareTo(s1) > 0);
	}

}
