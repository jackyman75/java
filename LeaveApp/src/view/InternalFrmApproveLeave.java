/*
 * Copyright (c) 2014 Agung Gugiaji <gugiaji.wordpress.com>
 * 
 * All rights reserved. No warranty, explicit or implicit, provided.
 *
 * Use it at your own risk.
 */

package view;
import controller.ctrlMasterTrans;
import controller.frmController;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.*;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

//JInternalFrame as View Layer. Add Product Form
public class InternalFrmApproveLeave extends JInternalFrame {
	static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	int leaveID;
    public InternalFrmApproveLeave(String title, int initleaveID) {
        super(title, true, true, true, true);
        leaveID = initleaveID;
        initComponents();
    }
    
    private void initComponents() {
    	setBounds(100, 100, 350, 200);
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Input your staff ID");
		getContentPane().add(lblNewLabel, "2, 2");
		
		fdyourStaffID = new JTextField();
		getContentPane().add(fdyourStaffID, "6, 2, fill, default");
		fdyourStaffID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Leave ID");
		getContentPane().add(lblNewLabel_1, "2, 4");
		
		fdLeaveID = new JTextField();
		getContentPane().add(fdLeaveID, "6, 4, fill, default");
		fdLeaveID.setColumns(10);
		fdLeaveID.setText(String.valueOf(leaveID));
		

		
		JButton btnApprove = new JButton("Approve");
		btnApprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (ctrlMasterTrans.Approve_Leave(Integer.parseInt(fdLeaveID.getText()), Integer.parseInt(fdyourStaffID.getText()))) {
						JOptionPane.showMessageDialog(new JInternalFrame(), "Approved and refresh the Leave list","Approve", JOptionPane.INFORMATION_MESSAGE);
			        }
				}catch (Exception ex){
					ex.printStackTrace();
				}
				
			}
		});
		getContentPane().add(btnApprove, "6, 8");
		
		JButton btnReject = new JButton("Reject");
		btnReject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (ctrlMasterTrans.Reject_Leave(Integer.parseInt(fdLeaveID.getText()), Integer.parseInt(fdyourStaffID.getText()))) {
						JOptionPane.showMessageDialog(new JInternalFrame(), "Rejected and refresh the Leave list","Reject", JOptionPane.INFORMATION_MESSAGE);
			        }
				}catch (Exception ex){
					ex.printStackTrace();
				}
				
			}
		});
		getContentPane().add(btnReject, "6, 12");

    }    
    
    
	private JTextField fdLeaveID;
	private JTextField fdyourStaffID;

	
}
