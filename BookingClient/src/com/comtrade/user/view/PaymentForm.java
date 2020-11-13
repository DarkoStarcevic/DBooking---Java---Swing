package com.comtrade.user.view;



import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.comtrade.controlerUI.ControlerUI;
import com.comtrade.domen.Payment;
import com.comtrade.domen.Reservation;
import com.comtrade.domen.Residence;
import com.comtrade.domen.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class PaymentForm extends JFrame {

	private JPanel contentPane;
	private ButtonGroup bg = new ButtonGroup();
	private List<Residence> listResidence; 
	private List<Reservation>listReservation;
	private List<User>listUser;
	private List<Payment>listPayment;
	private JTextField txtCardNumber;
	private JTextField txtSecurityCode;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtMm;
	private JTextField txtYy;
	private int id_reservation, id_usera, id_residence;
	private double total_price;
	private String type_of_payment;
	private JRadioButton rbUponArrival, rbMaster, rbVisa, rbDiners, rbWestern, rbAmerican ;

	public PaymentForm(int id_reservation2, int id_residence2, int id_usera2, double total_price2) throws ClassNotFoundException, IOException {
		this.id_reservation = id_reservation2;
		this.id_residence = id_residence2;
		this.id_usera = id_usera2;
		this.total_price = total_price2;
		listResidence =  (List<Residence>) ControlerUI.getInstanca().putAllResidenceIntoTable().getServer_object_response();
		listReservation = (List<Reservation>) ControlerUI.getInstanca().getReservationBack().getServer_object_response();
		listUser = (List<User>) ControlerUI.getInstanca().getUserListBack().getServer_object_response();
		listPayment = (List<Payment>) ControlerUI.getInstanca().getPaymentBack().getServer_object_response();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 607, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Select a payment method");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		label.setBounds(30, 11, 228, 30);
		contentPane.add(label);
		
		rbUponArrival = new JRadioButton("");
		rbUponArrival.setHorizontalAlignment(SwingConstants.RIGHT);
		rbUponArrival.setBounds(70, 87, 26, 23);
		contentPane.add(rbUponArrival);
		bg.add(rbUponArrival);
		
		JLabel lblUponArrival = new JLabel("");
		lblUponArrival.setVerticalAlignment(SwingConstants.TOP);
		lblUponArrival.setHorizontalAlignment(SwingConstants.LEFT);
		ImageIcon img = new ImageIcon(getClass().getResource("/Cash.png"));
		lblUponArrival.setIcon(img);
		lblUponArrival.setBounds(102, 53, 102, 57);
		contentPane.add(lblUponArrival);
		
		rbMaster = new JRadioButton("");
		rbMaster.setHorizontalAlignment(SwingConstants.RIGHT);
		rbMaster.setBounds(70, 131, 26, 23);
		contentPane.add(rbMaster);
		bg.add(rbMaster);
		
		JLabel lblMaster = new JLabel("");
		lblMaster.setVerticalAlignment(SwingConstants.TOP);
		lblMaster.setHorizontalAlignment(SwingConstants.LEFT);
		ImageIcon img1 = new ImageIcon(getClass().getResource("/mastercard.png"));
		lblMaster.setIcon(img1);
		lblMaster.setBounds(107, 120, 76, 48);
		contentPane.add(lblMaster);
		
		rbVisa = new JRadioButton("");
		//rbVisa.setActionCommand(type_of_payment);
		rbVisa.setHorizontalAlignment(SwingConstants.RIGHT);
		rbVisa.setBounds(70, 189, 26, 23);
		contentPane.add(rbVisa);
		bg.add(rbVisa);
		
		JLabel lblVisa = new JLabel("");
		lblVisa.setVerticalAlignment(SwingConstants.TOP);
		lblVisa.setHorizontalAlignment(SwingConstants.LEFT);
		ImageIcon img2 = new ImageIcon(getClass().getResource("/visa.png"));
		lblVisa.setIcon(img2);
		lblVisa.setBounds(107, 179, 76, 48);
		contentPane.add(lblVisa);
		
		rbDiners = new JRadioButton("");
		rbDiners.setHorizontalAlignment(SwingConstants.RIGHT);
		rbDiners.setBounds(70, 250, 26, 23);
		contentPane.add(rbDiners);
		bg.add(rbDiners);
		
		JLabel lblDiners = new JLabel("");
		lblDiners.setVerticalAlignment(SwingConstants.TOP);
		lblDiners.setHorizontalAlignment(SwingConstants.LEFT);
		ImageIcon img3 = new ImageIcon(getClass().getResource("/dinersclub.png"));
		lblDiners.setIcon(img3);
		lblDiners.setBounds(107, 238, 76, 48);
		contentPane.add(lblDiners);
		
		rbWestern = new JRadioButton("");
		rbWestern.setHorizontalAlignment(SwingConstants.RIGHT);
		rbWestern.setBounds(70, 310, 26, 23);
		contentPane.add(rbWestern);
		bg.add(rbWestern);
		
		JLabel lblWestern = new JLabel("");
		lblWestern.setVerticalAlignment(SwingConstants.TOP);
		lblWestern.setHorizontalAlignment(SwingConstants.LEFT);
		ImageIcon img4 = new ImageIcon(getClass().getResource("/westernunion.png"));
		lblWestern.setIcon(img4);
		lblWestern.setBounds(107, 299, 76, 48);
		contentPane.add(lblWestern);
		
		rbAmerican = new JRadioButton("");
		rbAmerican.setHorizontalAlignment(SwingConstants.RIGHT);
		rbAmerican.setBounds(70, 371, 26, 23);
		contentPane.add(rbAmerican);
		bg.add(rbAmerican);
		
		JLabel lblAmerican = new JLabel("");
		lblAmerican.setVerticalAlignment(SwingConstants.TOP);
		lblAmerican.setHorizontalAlignment(SwingConstants.LEFT);
		ImageIcon img5 = new ImageIcon(getClass().getResource("/americanexpress.png"));
		lblAmerican.setIcon(img5);
		lblAmerican.setBounds(107, 359, 76, 48);
		contentPane.add(lblAmerican);
		
		JButton btnNewButton = new JButton("Confirm payment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Payment payment = new Payment();
					
				String cardNumber = txtCardNumber.getText();
				String security_code = txtSecurityCode.getText();
				type_of_payment = "";
				setTypeOfPayment();
				//bg.getSelection().getActionCommand();
				payment.setId_reservation(id_reservation);
				payment.setId_usera(id_usera);
				payment.setId_residence(id_residence);
				payment.setPrice(total_price);
				payment.setCard_number(cardNumber);
				payment.setSecurity_code(security_code);
				payment.setType_of_payment(type_of_payment);
							
				try {
					
					if(rbUponArrival.isSelected() || (rbUponArrival.isSelected() && cardNumber.trim().equals("") || security_code.trim().equals(""))) {
						JOptionPane.showMessageDialog(null, "your selected payment method is on the site. Have a nice vacation");
						dispose();
					}else
					payment = (Payment) ControlerUI.getInstanca().confirmPayment(payment).getServer_object_response();
					listPayment.add(payment);
					
					JOptionPane.showMessageDialog(null, " Your payment is procesing " );
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "your selected payment method is on the site. Have a nice vacation");
				}
					btnNewButton.setEnabled(false);
					dispose();
			}
		
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton.setBounds(70, 467, 159, 23);
		contentPane.add(btnNewButton);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(222, 57, 457, 290);
		contentPane.add(contentPane_1);
		
		txtCardNumber = new JTextField();
		txtCardNumber.setBounds(51, 0, 296, 20);
		contentPane_1.add(txtCardNumber);
		txtCardNumber.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtCardNumber.setText("");
			}
		});
		txtCardNumber.setText("Card number");
		txtCardNumber.setEditable(true);
		txtCardNumber.setColumns(10);
		
		txtMm = new JTextField();
		txtMm.setBounds(51, 31, 120, 20);
		contentPane_1.add(txtMm);
		txtMm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMm.setText("");
			}
		});
		txtMm.setText("MM");
		txtMm.setEditable(true);
		txtMm.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("/");
		lblNewLabel.setBounds(176, 31, 46, 20);
		contentPane_1.add(lblNewLabel);
		
		txtYy = new JTextField();
		txtYy.setBounds(184, 31, 120, 20);
		contentPane_1.add(txtYy);
		txtYy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtYy.setText("");
			}
		});
		txtYy.setText("YY");
		txtYy.setEditable(true);
		txtYy.setColumns(10);
		
		txtSecurityCode = new JTextField();
		txtSecurityCode.setBounds(51, 62, 265, 20);
		contentPane_1.add(txtSecurityCode);
		txtSecurityCode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtSecurityCode.setText("");
			}
		});
		txtSecurityCode.setText("Security code                                               CVV code");
		txtSecurityCode.setEditable(true);
		txtSecurityCode.setColumns(10);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(51, 93, 143, 20);
		contentPane_1.add(txtFirstName);
		txtFirstName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtFirstName.setText("");
			}
		});
		txtFirstName.setText("First name");
		txtFirstName.setEditable(true);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(204, 93, 143, 20);
		contentPane_1.add(txtLastName);
		txtLastName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtLastName.setText("");
			}
		});
		txtLastName.setText("Last name");
		txtLastName.setEditable(true);
		txtLastName.setColumns(10);
		
		JLabel lblcvvcode = new JLabel("");
		ImageIcon img6 = new ImageIcon(getClass().getResource("/cvv1.png"));
		lblcvvcode.setIcon(img6);
		lblcvvcode.setBounds(320, 54, 53, 31);
		contentPane_1.add(lblcvvcode);
	
	}
	
	public String setTypeOfPayment() {		
		
		if(rbVisa.isSelected()) {
			type_of_payment = " Visa";
		}
		
		if(rbAmerican.isSelected()) {
			type_of_payment = " American Express";
		}
		
		if(rbDiners.isSelected()) {
			type_of_payment = " Diners Club International";
		}
		
		if(rbMaster.isSelected()) {
			type_of_payment = " MasterCard";
		}
		
		if(rbVisa.isSelected()) {
			type_of_payment = " Visa";
		}
		
		if(rbWestern.isSelected()) {
			type_of_payment = " Western Union"; 
		}
		return type_of_payment;
		
   }
	
}
