/*
 * Copyright (c) 2014 Agung Gugiaji <gugiaji.wordpress.com>
 * 
 * All rights reserved. No warranty, explicit or implicit, provided.
 *
 * Use it at your own risk.
 */

package view;

import mvc.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.frmController;

//JInternalFrame as View. Show List of Products
public class InternalFrmLeaveList extends JInternalFrame {
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
    public InternalFrmLeaveList(String title, final ArrayList<Leave> lstleave, ArrayList<Staff> lststaff) {
        super(title, true, true, true, true);
        JScrollPane jsp =new JScrollPane() ;
        JTable jtb = new JTable();
        DefaultTableModel dtm;
        dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        if (lstleave.size() > 0) {
            List<String> cols = lstleave.get(0).ColumnNames();
            
            for (String columnName : cols) {
                dtm.addColumn(columnName);
               
            }

            

            
            HashMap<Integer, Staff> staffMap = new HashMap<Integer, Staff>();
            for (Staff stf : lststaff) {
            	staffMap.put(stf.getStaffid(), stf);
            }
            
            Vector<String> lst;
            //for (Product prd : lstproduct.) {
            for (Leave lv: lstleave) {
            	 lst= new Vector<String>();
                 
                 lst.add(String.valueOf(lv.getLeaveID()));
                 lst.add(staffMap.get(lv.getRequestorID()).getName());
                 lst.add(df.format(lv.startDate));
                 lst.add(df.format(lv.endDate));
                 lst.add(lv.getStatus());
                 
                 if (lv.getApproverID() != null) {
                	 lst.add(staffMap.get(lv.getApproverID()).getName());
                 }
                
                 dtm.addRow(lst);
            }
            
           
            
            jtb.setModel(dtm);
        }
        jsp.setViewportView(jtb);
        
        add(jsp);
        
        jtb.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
               if (e.getClickCount() == 2) {
                  JTable target = (JTable) e.getSource();
                  int row = target.getSelectedRow();
                  if (lstleave.get(row).getStatus().equals(CONSTANT.APPROVED) || lstleave.get(row).getStatus().equals(CONSTANT.REJECTED)){
                	  JOptionPane.showMessageDialog(new JInternalFrame(), "Approved or rejected application cannot be edited.","Alert", JOptionPane.INFORMATION_MESSAGE);
                  }else{
                	  
                	  frmController.masApproveLeaveActionPerformed("Approve leave", lstleave.get(row).getLeaveID());
                      
                	 
                  }
                  
                 
               }
            }
         });
    }
    
    
    
}
