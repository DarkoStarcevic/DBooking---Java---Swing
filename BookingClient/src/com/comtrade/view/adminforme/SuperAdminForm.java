package com.comtrade.view.adminforme;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.comtrade.controlerUI.ControlerUI;
import com.comtrade.domen.Reservation;
import com.comtrade.domen.Residence;
import com.comtrade.domen.Room;
import com.comtrade.domen.User;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SuperAdminForm extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private List<Reservation>reservationList;
	private List<Residence>listResidence;
	private JLabel lblSum;
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();
	private DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	
	public SuperAdminForm() throws ClassNotFoundException, IOException {
		reservationList = (List<Reservation>) ControlerUI.getInstanca().getReservationBack().getServer_object_response();
		listResidence =  (List<Residence>) ControlerUI.getInstanca().putAllResidenceIntoTable().getServer_object_response();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 519, 386);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME BOSS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(24, 24, 274, 45);
		contentPane.add(lblNewLabel);
		
		lblSum = new JLabel("0.00");
		lblSum.setForeground(Color.RED);
		lblSum.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblSum.setBounds(171, 252, 198, 52);
		contentPane.add(lblSum);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(24, 80, 457, 166);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		
		Object[]column = new Object [4];  
		
		column[0] = "id_reservation";
		column[1] = "residence";
		column[2] = "earning";
		column[3] = "commission fee";
		
		dtm.addColumn(column[0]);
		dtm.addColumn(column[1]);
		dtm.addColumn(column[2]);
		dtm.addColumn(column[3]);

		setDataInTable();
		
		JLabel lblNewLabel_1 = new JLabel("Total profit");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(10, 267, 116, 26);
		contentPane.add(lblNewLabel_1);
		earningsSum();
		//earningsSum(reservationList);
	}

	private void setDataInTable() {
		dtm.setRowCount(0);
		Object[] row = new Object[11];
		String residenceName = null;
			for (Reservation reservation : reservationList) {
				for (Residence residence : listResidence) {
                    if(reservation.getId_residence() == residence.getId_residence()) {
				
                    	 residenceName = residence.getNameOfResidence();
					
                   
			}
			 	row[0] = reservation.getId_reservation();
				row[1] = residenceName;
				row[2] = reservation.getTotal_price();
				row[3] = df2.format(reservation.getTotal_price() * 0.12);

				
					
				}
				dtm.addRow(row);
			}
		}



		private void earningsSum() {
		double profit = 0;
		
			for(Reservation reservation : reservationList) {
				profit += reservation.getTotal_price();
			
	}
			lblSum.setText(Double.toString(profit*0.12));
			
}
}
