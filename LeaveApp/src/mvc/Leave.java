package mvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Leave {
	public int leaveID;
	public int requestorID;
	public Date startDate;
	public Date endDate;
	public String Status;
	public Integer approverID;
	
	public Leave(int leaveID, int requestorID, Date startDate, Date endDate,
			String status, Integer approverID) {
		super();
		this.leaveID = leaveID;
		this.requestorID = requestorID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.Status = status;
		this.approverID = approverID;
	}
	
	public Leave() {
		
	}
	
	public int getLeaveID() {
		return leaveID;
	}
	public void setLeaveID(int leaveID) {
		this.leaveID = leaveID;
	}
	public int getRequestorID() {
		return requestorID;
	}
	public void setRequestorID(int requestorID) {
		this.requestorID = requestorID;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Integer getApproverID() {
		return approverID;
	}
	public void setApproverID(Integer approverID) {
		this.approverID = approverID;
	}
	
	
    public List<String> ColumnNames() {
        List<String> cols = new ArrayList<String>();
        cols.add("Leave id");
        cols.add("requester id");
        cols.add("Start date");
        cols.add("End date");
        cols.add("Status");
        cols.add("approver id");
        return cols;
    }
}
