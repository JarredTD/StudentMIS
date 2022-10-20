package assg6_desrosiersj20;

public class Student implements Comparable<Student> {
	private String id;
	private String name;
	private String standing;
	private String major;

	public Student(String id, String name, String standing, String major) {
		this.id = id;
		this.name = name;
		this.standing = standing;
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getStanding() {
		return standing;
	}

	@Override
	public String toString() {
		return String.format("ID: %s, Name: %s, Major: %s, Standing: %s", this.getId(), this.getName(), this.getMajor(),
				this.getStanding());
	}

	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student tmp = (Student) obj;
			return (tmp.getId().equals(this.getId()));
		}

		else {
			return false;
		}
	}

	@Override
	public int compareTo(Student student) {
		return (this.getId().compareTo(student.getId()));
	}

}
