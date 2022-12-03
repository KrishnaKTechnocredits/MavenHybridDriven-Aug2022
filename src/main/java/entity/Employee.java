package entity;

import java.util.Objects;

public class Employee {

    String empNum;
    String firstName;
    String lastName;
    String userName;

    public Employee(String empNum, String firstName, String lastName, String userName) {
        this.empNum = empNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }


    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(empNum, other.empNum) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(userName, other.userName);
	}

    @Override
	public int hashCode() {
		return Objects.hash(empNum, firstName, lastName, userName);
	}

    @Override
    public String toString() {
        return "Employee{" +
                "empNum='" + empNum + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
