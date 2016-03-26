/*
 * Copyright (c) 2014 Agung Gugiaji <gugiaji.wordpress.com>
 * 
 * All rights reserved. No warranty, explicit or implicit, provided.
 *
 * Use it at your own risk.
 */

package controller;

import model.mdlLeave;
import model.mdlStaff;
import mvc.Leave;
import mvc.Staff;
import mvc.Director;
import mvc.Employee;
import java.util.ArrayList;
import java.util.Date;

public class ctrlMasterTrans {
    public static void ActivateStaff() {
        mdlStaff.ActivateStaff();
    }
    public static void ActivateLeave() {
        mdlLeave.ActivateLeave();
    }
    
    public static ArrayList<Staff> ListOfStaff() {
        return mdlStaff.get_StaffList();
    }
    
    public static ArrayList<Leave> ListOfLeave() {
        return mdlLeave.get_LeaveList();
    }
    
    public static boolean Add_Employee(int ID, String name, String title, int supervisorid) {
        try {
            Staff stf = new Employee(ID, name, title, supervisorid);
            mdlStaff.Add_Staff(stf);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
    public static boolean Delete_Employee(int ID) {
        try {
            mdlStaff.Delete_Staff(ID);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
    public static boolean Assign_Supervisor(int ID, int supervisorid) {
        try {
            mdlStaff.Assign_Supervisor(ID, supervisorid);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
    public static boolean Add_Leave(int leaveID, int requestorID, Date startDate, Date endDate) {
        try {
            mdlLeave.Add_Leave(leaveID, requestorID, startDate, endDate);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
    public static boolean Approve_Leave(int leaveId, int yourstaffid) {
        try {
            mdlLeave.Approve(leaveId, yourstaffid);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
    public static boolean Reject_Leave(int leaveId, int yourstaffid) {
        try {
            mdlLeave.Reject(leaveId, yourstaffid);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
}
