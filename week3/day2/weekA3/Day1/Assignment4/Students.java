package week3.Day1.Assignment4;

public class Students {

	public void studentGetInfo(int ID,String name) {
		System.out.println("ID - "+ID);
		System.out.println("Name - "+name);
	}
	public void studentGetInfo(String Email, long phoneNumber) {
		// TODO Auto-generated method stub
		System.out.println("EMail - "+Email);
		System.out.println("PhoneNumber - "+phoneNumber);

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Student Details");
		System.out.println("================");
		
		Students stu = new Students();
		stu.studentGetInfo(26, "Swetha");
		stu.studentGetInfo("swetha123@yahoo.com", 9876543210L);
	}

}
