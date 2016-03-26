/*
 * Copyright (c) 2014 Agung Gugiaji <gugiaji.wordpress.com>
 * 
 * All rights reserved. No warranty, explicit or implicit, provided.
 *
 * Use it at your own risk.
 */

package view;

import mvc.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

//JInternalFrame as View. Show List of Products
public class InternalFrmStaffList extends JInternalFrame {
    public InternalFrmStaffList(String title, ArrayList<Staff> lststaff) {
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
        
        if (lststaff.size() > 0) {
            List<String> cols = lststaff.get(0).ColumnNames();
            
            for (String columnName : cols) {
                dtm.addColumn(columnName);
               
            }

            HashMap<Integer, Staff> staffMap = new HashMap<Integer, Staff>();
            for (Staff stf : lststaff) {
            	staffMap.put(stf.getStaffid(), stf);
            }
            
            Vector<String> lst;
            //for (Product prd : lstproduct.) {
            for (Staff stf: lststaff) {
            	 lst= new Vector<String>();
                 
                 lst.add(String.valueOf(stf.getStaffid()));
                 lst.add(stf.getName());
                 lst.add(stf.getTitle());
                 if (stf.getClass().getSimpleName().equals("Employee")) {
                 	
                	lst.add(String.valueOf(stf.getSupervisorid()));
                	lst.add(staffMap.get(stf.getSupervisorid()).getName());
                }
                 dtm.addRow(lst);
            }
            
           
            
            jtb.setModel(dtm);
        }
        jsp.setViewportView(jtb);
        
        add(jsp);
    }
    
    
    
}
