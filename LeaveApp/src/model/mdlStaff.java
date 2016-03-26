/*
 * Copyright (c) 2014 Agung Gugiaji <gugiaji.wordpress.com>
 * 
 * All rights reserved. No warranty, explicit or implicit, provided.
 *
 * Use it at your own risk.
 */


package model;

import mvc.Staff;
import mvc.Director;
import mvc.Employee;
import java.util.ArrayList;

//Model Layer Class. Loading Products and Add New Product methods
public class mdlStaff {
    static ArrayList<Staff> lstStaff;
    public static void ActivateStaff() {
    	lstStaff = new ArrayList<Staff>();
        Staff stf;            
        stf = new Director(1, "Lee Ka Shing", "Director");
        lstStaff.add(stf);            
        stf = new Employee(2, "Chan Kin Hong", "Manager", 1);
        lstStaff.add(stf);
        stf = new Employee(3, "Kwan Wan Cheung", "Manager", 1);
        lstStaff.add(stf);
        stf = new Employee(4, "Peter Chan", "Officer", 2);
        lstStaff.add(stf);
        stf = new Employee(5, "Mary Wong", "Officer", 2);
        lstStaff.add(stf);
        stf = new Employee(6, "Victor Lee", "Officer", 3);
        lstStaff.add(stf);
                
    }
    
    public static ArrayList<Staff> get_StaffList() {
        return lstStaff;
    }
    
    public static void Add_Staff(Staff stf) {
    	lstStaff.add(stf);
    }    
    
    public static void Delete_Staff(int id) {
    	for (Staff tmp : lstStaff) {
    		if (tmp.getStaffid() == id) {
    			lstStaff.remove(tmp);
    		}
    	 }
    }
    public static void Assign_Supervisor(int id, int supervisorid) {
    	for (Staff tmp : lstStaff) {
    		if (tmp.getStaffid() == id) {
    			tmp.setSupervisorid(supervisorid);;
    		}
    	 }
    }  
}
