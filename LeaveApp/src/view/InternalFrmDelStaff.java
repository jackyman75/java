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
import javax.swing.*;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

//JInternalFrame as View Layer. Add Product Form
public class InternalFrmDelStaff extends JInternalFrame {
    public InternalFrmDelStaff(String title) {
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
		
		JLabel lblNewLabel = new JLabel("ID");
		getContentPane().add(lblNewLabel, "2, 2");
		
		fdID = new JTextField();
		getContentPane().add(fdID, "6, 2, fill, default");
		fdID.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (ctrlMasterTrans.Delete_Employee(Integer.parseInt(fdID.getText()))) {
					JOptionPane.showMessageDialog(new JInternalFrame(), "Success and refresh the staff list","Delete", JOptionPane.INFORMATION_MESSAGE);
		        }
				
			}
		});
		getContentPane().add(btnNewButton, "6, 12");

    }    
    
    
	private JTextField fdID;

}
