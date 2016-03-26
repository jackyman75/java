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
public class InternalFrmAddLeave extends JInternalFrame {
	static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    public InternalFrmAddLeave(String title) {
        super(title, true, true, true, true);
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
		
		JLabel lblNewLabel = new JLabel("Leave ID");
		getContentPane().add(lblNewLabel, "2, 2");
		
		fdLeaveID = new JTextField();
		getContentPane().add(fdLeaveID, "6, 2, fill, default");
		fdLeaveID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Requester ID");
		getContentPane().add(lblNewLabel_1, "2, 4");
		
		fdRequesterID = new JTextField();
		getContentPane().add(fdRequesterID, "6, 4, fill, default");
		fdRequesterID.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Start Date");
		getContentPane().add(lblNewLabel_2, "2, 6");
		
		fdStartDate = new JTextField();
		getContentPane().add(fdStartDate, "6, 6, fill, default");
		fdStartDate.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("End Date");
		getContentPane().add(lblNewLabel_3, "2, 8");
		
		fdEndDate = new JTextField();
		getContentPane().add(fdEndDate, "6, 8, fill, default");
		fdEndDate.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (ctrlMasterTrans.Add_Leave(Integer.parseInt(fdLeaveID.getText()), Integer.parseInt(fdRequesterID.getText()),  formatter.parse(fdStartDate.getText()), formatter.parse(fdEndDate.getText()))) {
						JOptionPane.showMessageDialog(new JInternalFrame(), "Success and refresh the Leave list","Save", JOptionPane.INFORMATION_MESSAGE);
			        }
				}catch (Exception ex){
					ex.printStackTrace();
				}
				
			}
		});
		getContentPane().add(btnNewButton, "6, 12");

    }    
    
    
	private JTextField fdLeaveID;
	private JTextField fdRequesterID;
	private JTextField fdStartDate;
	private JTextField fdEndDate;
	
}
