class Student implements Comparable<Student> {
	
    private String name;
    private int grade;

   // constructor
    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    // comparable
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.grade, other.grade);
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', grade=" + grade + '}';
    }
}
