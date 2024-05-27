package entites;

public class Employee {
	
	private String name;
	private String email;
	private Double salary;

	public Employee(String name, String email, Double salary) {
		this.name = name;
		this.email = email;
		this.salary = salary;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final Double getSalary() {
		return salary;
	}

	public final void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", email=" + email + ", salary=" + salary + "]";
	}
	
	

}