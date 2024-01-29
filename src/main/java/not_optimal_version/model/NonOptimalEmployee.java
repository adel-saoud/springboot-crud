package not_optimal_version.model;

public class NonOptimalEmployee {


	//static = don't need to create an instance of the class to access it ->
	// MyClass f = new MyClass()
	// f.doStuff();
	//use directly MyClass.doSomething();

	private static Long idCounter = 1L;

	//static = non-changeable (impossible to inherit or override), variable to always store the same value
	private final Long employeeId;
	private String firstName;
	private String lastName;
	private String email;

	public NonOptimalEmployee(String firstName, String lastName, String email) {
		this.employeeId = idCounter++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	// Getters and setters
	public Long getEmployeeId() {
		return employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}