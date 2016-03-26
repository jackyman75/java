package mvc;

import java.util.ArrayList;
import java.util.List;

public abstract class Staff {
	public int staffid;
	public String name;
	public String title;
	public Integer supervisorid;

	public Integer getSupervisorid() {
		return supervisorid;
	}

	public void setSupervisorid(Integer supervisorid) {
		this.supervisorid = supervisorid;
	}
	
	public int getStaffid() {
		return staffid;
	}
	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
    public List<String> ColumnNames() {
        List<String> cols = new ArrayList<String>();
        cols.add("ID");
        cols.add("Name");
        cols.add("Title");
        cols.add("Supervisor ID");
        cols.add("Supervisor Name");
        return cols;
    }
}
