package week3.Day1.Assignment2;

public class Student extends Department {
	public void studentName() {
		System.out.println("Name : Swetha");
	}
	public void studentDept() {
		System.out.println("Depatment - ECE");
	}
	public void studentID() {
		System.out.println("Student ID - 246");

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student S = new Student();
		System.out.println("College Details");
		System.out.println("===============");
		S.collegeName();
		S.collegeCode();
		S.collegeRank();
		S.deptName();
		System.out.println("Student Details");
		System.out.println("================");
		S.studentName();
		S.studentDept();
		S.studentID();
	}

}
