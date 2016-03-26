package mvc;

public class Employee extends Staff{


	
	public Employee(int id, String name, String title, int supervisorid) {
		super.setStaffid(id);
		super.setName(name);
		super.setTitle(title);
		super.setSupervisorid(supervisorid);
		
    }
	
	public Employee(){
		
	}
}
