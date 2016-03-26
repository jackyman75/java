/*
 * Copyright (c) 2014 Agung Gugiaji <gugiaji.wordpress.com>
 * 
 * All rights reserved. No warranty, explicit or implicit, provided.
 *
 * Use it at your own risk.
 */


package model;

import mvc.Employee;
import mvc.Leave;
import mvc.Staff;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import mvc.CONSTANT;

//Model Layer Class. Loading Products and Add New Product methods
public class mdlLeave {
	static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    static ArrayList<Leave> lstLeave;
    
    static HashMap<Integer, Staff> staffMap = new HashMap<Integer, Staff>();
    static HashMap<Integer, Leave> leaveMap = new HashMap<Integer, Leave>();
    public static void ActivateLeave() {
    	try{
    		   		
	    	lstLeave = new ArrayList<Leave>();
	    	Leave lv;            
	        lv = new Leave(1,6,formatter.parse("21/3/2016"), formatter.parse("24/3/2016"), CONSTANT.PENDINGAPPROVAL, 3);
	        lstLeave.add(lv);     
	        lv = new Leave(10,5,formatter.parse("21/3/2016"), formatter.parse("24/3/2016"), CONSTANT.PENDINGAPPROVAL, 3);
	        lstLeave.add(lv); 
	        lv = new Leave(15,5,formatter.parse("21/3/2016"), formatter.parse("24/3/2016"), CONSTANT.PENDINGAPPROVAL, 3);
	        lstLeave.add(lv); 
	        
	        
    	} catch (Exception ex)
    	{
    		ex.printStackTrace();
    	}
                
    }
    
    public static ArrayList<Leave> get_LeaveList() {
        return lstLeave;
    }
    
    public static void Add_Leave(int leaveID, int requestorID, Date startDate, Date endDate) {
    	Leave lv = new Leave();
    	lv.setLeaveID(leaveID);
    	lv.setRequestorID(requestorID);
    	lv.setStartDate(startDate);
    	lv.setEndDate(endDate);
    	lv.setApproverID(getSupervisorID(lv.getRequestorID()));
    	if (lv.getApproverID() == null) {
    		lv.setStatus(CONSTANT.APPROVED);
    	}else {
    		lv.setStatus(CONSTANT.PENDINGAPPROVAL);
    	}
    	lstLeave.add(lv);
    }    
    
    public static void refreshLeave(){
    	ArrayList<Leave> tmplstLeave;
    	tmplstLeave = get_LeaveList();
    	leaveMap.clear();
    	for (Leave lv : tmplstLeave) {
    		leaveMap.put(lv.getLeaveID(), lv);
         }
    }
    
    public static void Approve(int leaveId, int yourstaffid) {
    	refreshLeave();
    	Leave lv = leaveMap.get(leaveId);
    	Integer supervisorID = getSupervisorID(yourstaffid);
    	if (supervisorID == null){
    		lv.setStatus(CONSTANT.APPROVED);
    		lv.setApproverID(null);
    	}else{
    		lv.setApproverID(supervisorID);
    	}
    	
    }  
    
    public static void Reject(int leaveId, int yourstaffid) {
    	refreshLeave();
    	Leave lv = leaveMap.get(leaveId);
    	lv.setStatus(CONSTANT.REJECTED);
    	lv.setApproverID(null);
    }
    
    public static Integer getSupervisorID(int staffid) {
    	ArrayList<Staff> lstStaff;
    	lstStaff = mdlStaff.get_StaffList();
    	staffMap.clear();
    	for (Staff stf : lstStaff) {
         	staffMap.put(stf.getStaffid(), stf);
         }
    	Staff stf = new Employee();
    	stf = staffMap.get(staffid);
    	if (stf != null) {
    		return stf.getSupervisorid();
    	}else{
    		return null;
    	}
    }
}
