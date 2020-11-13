package com.comtrade.user.view;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.comtrade.controlerUI.ControlerUI;
import com.comtrade.domen.Residence;
import com.comtrade.domen.Review;
import com.comtrade.transfer.TransferClass;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;


public class ReviewForm extends JFrame implements Serializable {
	
	 private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextArea textArea_Comment;
	private JTextArea textAreaOverallRating;
	private Image img;
	private JPanel panel;
	private List<ImageIcon> starList = new ArrayList<ImageIcon>();
	private int cleanliness;
	private int comfort;
	private int facilities;
	private int location;
	private int staff;
	private int stay;
	private int valueForMoney;
	private double rating;
	private JSlider slLocation, slComfort, slCleanliness, slFacilities, slStaff, slStay, slValueForMoney;
	private List<Residence>listResidence;
	private List<Review> avgReviewList;
	private List<Review>listReview;
	private double average_rating;
	private int id_residence;
	
	
	public ReviewForm(int id_usera, int id_reservation, int id_residence) throws ClassNotFoundException, IOException {
		this.id_residence = id_residence;
		listResidence = (List<Residence>) ControlerUI.getInstanca().putAllResidenceIntoTable().getServer_object_response();
		avgReviewList = (List<Review>) ControlerUI.getInstanca().getAvgReview().getServer_object_response();
		listReview = (List<Review>) ControlerUI.getInstanca().getReviewBack().getServer_object_response();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 478, 679);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStay = new JLabel("How was your stay?");
		lblStay.setBounds(10, 11, 219, 20);
		lblStay.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		contentPane.add(lblStay);
		
		JLabel lblStaff = new JLabel("Staff");
		lblStaff.setBounds(10, 73, 219, 20);
		lblStaff.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		contentPane.add(lblStaff);
		
		JLabel lblFacilities = new JLabel("Facilities");
		lblFacilities.setBounds(10, 135, 219, 20);
		lblFacilities.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		contentPane.add(lblFacilities);
		
		JLabel lblClean = new JLabel("Cleanliness");
		lblClean.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblClean.setBounds(10, 198, 219, 20);
		lblClean.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		contentPane.add(lblClean);
		
		JLabel lblComfort = new JLabel("Comfort");
		lblComfort.setBounds(10, 262, 219, 20);
		lblComfort.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		contentPane.add(lblComfort);
		
		JLabel lblValue = new JLabel("Value for money");
		lblValue.setBounds(10, 325, 219, 20);
		lblValue.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		contentPane.add(lblValue);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(10, 389, 219, 20);
		lblLocation.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		contentPane.add(lblLocation);
		
		JLabel lblComment = new JLabel("If you like leave us a comment");
		lblComment.setBounds(10, 472, 191, 14);
		lblComment.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		contentPane.add(lblComment);
		
		JLabel lblRating = new JLabel("Your overall rating of this accommodation");
		lblRating.setBounds(10, 585, 302, 40);
		lblRating.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		contentPane.add(lblRating);
		
		textAreaOverallRating = new JTextArea();
		textAreaOverallRating.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 14));
		textAreaOverallRating.setVisible(true);
		textAreaOverallRating.setEditable(false);
		textAreaOverallRating.setBounds(258, 587, 54, 38);
		contentPane.add(textAreaOverallRating);
	
		
		ImageIcon defaultIcon = new ImageIcon(getClass().getResource("/Star-Empty-icon.png"));
		ImageProducer ip = defaultIcon.getImage().getSource();
		ImageIcon star = makeStarImageIcon(ip, new SelectedImageFilter(1f, 1f, 0f));
		starList = Arrays.asList(star, star, star, star, star);
		getContentPane().add(makeStarRating("", new LevelBar(defaultIcon, starList, 1)));
		
		/*
		 * starList = Arrays.asList(star, star, star, star, star);
		 * 
		 * i = starList.indexOf(star);
		 * 
		 * 
		 */
	
		JScrollPane scrollPane = new JScrollPane(textArea_Comment);
		scrollPane.setBounds(10, 497, 442, 77);
		contentPane.add(scrollPane);
		
		textArea_Comment = new JTextArea();
		scrollPane.setViewportView(textArea_Comment);
	
		
		JPanel pa = new JPanel((LayoutManager) null);
		pa.setBorder(null);
		pa.setBounds(20, 88, 209, 49);
		contentPane.add(pa);
		pa.setLayout(new FlowLayout(FlowLayout.LEFT));
		pa.add(makeStarRating("", new LevelBar(defaultIcon, starList, 1)));
		
		JPanel p_1 = new JPanel((LayoutManager) null);
		p_1.setBorder(null);
		p_1.setBounds(20, 150, 209, 49);
		contentPane.add(p_1);
		p_1.setLayout(new FlowLayout(FlowLayout.LEFT));
		p_1.add(makeStarRating("", new LevelBar(defaultIcon, starList, 1)));
		
		JPanel p_2 = new JPanel((LayoutManager) null);
		p_2.setBorder(null);
		p_2.setBounds(20, 216, 209, 49);
		contentPane.add(p_2);
		p_2.setLayout(new FlowLayout(FlowLayout.LEFT));
		p_2.add(makeStarRating("", new LevelBar(defaultIcon, starList, 1)));
		
		JPanel p_3 = new JPanel((LayoutManager) null);
		p_3.setBorder(null);
		p_3.setBounds(20, 278, 209, 49);
		contentPane.add(p_3);
		p_3.setLayout(new FlowLayout(FlowLayout.LEFT));
		p_3.add(makeStarRating("", new LevelBar(defaultIcon, starList, 1)));
		
		JPanel p_4 = new JPanel((LayoutManager) null);
		p_4.setBorder(null);
		p_4.setBounds(20, 341, 209, 49);
		contentPane.add(p_4);
		p_4.setLayout(new FlowLayout(FlowLayout.LEFT));
		p_4.add(makeStarRating("", new LevelBar(defaultIcon, starList, 1)));
		
		JPanel p_5 = new JPanel((LayoutManager) null);
		p_5.setBorder(null);
		p_5.setBounds(20, 406, 209, 49);
		contentPane.add(p_5);
		p_5.setLayout(new FlowLayout(FlowLayout.LEFT));
		p_5.add(makeStarRating("", new LevelBar(defaultIcon, starList, 1)));
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Review review = new Review();
				
				if(rating == 0) {
					JOptionPane.showMessageDialog(null, "Please use slider to rate every segment and then click Count button ");
				}else {
					
				review.setId_user(id_usera);
				review.setId_reservation(id_reservation);
				review.setId_residence(id_residence);
				review.setRating(rating);
				review.setComment(textArea_Comment.getText());
				
				
				try {
					review = (Review) ControlerUI.getInstanca().insertRevirew(review).getServer_object_response();
					btnSubmit.setEnabled(false);
					JOptionPane.showMessageDialog(null," Thank you. Your review is going to be visible to other users ");
					
					setAverageRating();
					dispose();
				 
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				}
				
				
				
				
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnSubmit.setBounds(350, 602, 102, 23);
		contentPane.add(btnSubmit);
		
		JLabel lblNewLabel = new JLabel("please rate it from 1 to 5");
		lblNewLabel.setBounds(258, 11, 194, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnCount = new JButton("Count");
		btnCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					cleanliness = slCleanliness.getValue();
					comfort = slComfort.getValue();
					facilities = slFacilities.getValue();
					location = slLocation.getValue();
					staff = slStaff.getValue();
					stay = slStay.getValue();
					valueForMoney = slValueForMoney.getValue();
					
				rating = Double.valueOf(cleanliness + comfort + facilities + location + staff + stay + valueForMoney)/7;
				
				setOverallRating(textAreaOverallRating);
			}
		});
		btnCount.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnCount.setBounds(304, 463, 89, 23);
		contentPane.add(btnCount);
		
		slStay = new JSlider();
		slStay.setSnapToTicks(true);
		slStay.setPaintLabels(true);
		slStay.setValue(3);
		slStay.setMinorTickSpacing(1);
		slStay.setMinimum(1);
		slStay.setMaximum(5);
		slStay.setMajorTickSpacing(1);
		slStay.setPaintTicks(true);
		slStay.setBounds(233, 28, 219, 49);
		contentPane.add(slStay);
		
		slStaff = new JSlider();
		slStaff.setSnapToTicks(true);
		slStaff.setPaintLabels(true);
		slStaff.setValue(3);
		slStaff.setMinorTickSpacing(1);
		slStaff.setMinimum(1);
		slStaff.setMaximum(5);
		slStaff.setMajorTickSpacing(1);
		slStaff.setPaintTicks(true);
		slStaff.setBounds(233, 88, 219, 49);
		contentPane.add(slStaff);
		
		slFacilities = new JSlider();
		slFacilities.setSnapToTicks(true);
		slFacilities.setPaintLabels(true);
		slFacilities.setValue(3);
		slFacilities.setMinorTickSpacing(1);
		slFacilities.setMinimum(1);
		slFacilities.setMaximum(5);
		slFacilities.setMajorTickSpacing(1);
		slFacilities.setPaintTicks(true);
		slFacilities.setBounds(233, 150, 219, 49);
		contentPane.add(slFacilities);
		
		slCleanliness = new JSlider();
		slCleanliness.setSnapToTicks(true);
		slCleanliness.setPaintLabels(true);
		slCleanliness.setValue(3);
		slCleanliness.setMinorTickSpacing(1);
		slCleanliness.setMinimum(1);
		slCleanliness.setMaximum(5);
		slCleanliness.setMajorTickSpacing(1);
		slCleanliness.setPaintTicks(true);
		slCleanliness.setBounds(233, 216, 219, 49);
		contentPane.add(slCleanliness);
		
		slComfort = new JSlider();
		slComfort.setMajorTickSpacing(1);
		slComfort.setMaximum(5);
		slComfort.setMinimum(1);
		slComfort.setMinorTickSpacing(1);
		slComfort.setSnapToTicks(true);
		slComfort.setPaintTicks(true);
		slComfort.setPaintLabels(true);
		slComfort.setValue(3);
		slComfort.setBounds(233, 278, 219, 49);
		contentPane.add(slComfort);
		
		slValueForMoney = new JSlider();
		slValueForMoney.setBounds(233, 341, 219, 49);
		slValueForMoney.setSnapToTicks(true);
		slValueForMoney.setPaintLabels(true);
		slValueForMoney.setValue(3);
		slValueForMoney.setMinorTickSpacing(1);
		slValueForMoney.setMinimum(1);
		slValueForMoney.setMaximum(5);
		slValueForMoney.setMajorTickSpacing(1);
		slValueForMoney.setPaintTicks(true);
		contentPane.add(slValueForMoney);
		
		slLocation = new JSlider();
		slLocation.setSnapToTicks(true);
		slLocation.setPaintLabels(true);
		slLocation.setValue(3);
		slLocation.setMinorTickSpacing(1);
		slLocation.setMinimum(1);
		slLocation.setMaximum(5);
		slLocation.setMajorTickSpacing(1);
		slLocation.setPaintTicks(true);
		slLocation.setBounds(239, 406, 219, 49);
		contentPane.add(slLocation);
		
	}
	
	
				

	protected void setAverageRating() throws ClassNotFoundException, IOException {
		avgReviewList = (List<Review>) ControlerUI.getInstanca().getAvgReview().getServer_object_response();
		listReview = (List<Review>) ControlerUI.getInstanca().getReviewBack().getServer_object_response();
		Residence residence = new Residence();
		for(Review review2 : avgReviewList) {
			if(review2.getId_residence() == id_residence) {
				average_rating = review2.getRating();
				residence.setId_residence(id_residence);
				residence.setAverage_rating(average_rating);
			}
	}
		
		try {
			residence = (Residence) ControlerUI.getInstanca().updateResidenceAvgRating(residence).getServer_object_response();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

private void setOverallRating(JTextArea textAreaOverallRating2) {
		
		textAreaOverallRating2.setText(String.format("%.2f", rating));
	}


	/*
	 * public void getRatingValues() {
	 * 
	 * selectedStars = 0; for (ImageIcon obj : starList) { if (obj == (starList)) {
	 * return selectedStars; } selectedStars += 1; } return selectedStars;
	 * 
	 * }
	 */
	

	/// animacija sa zvezdicama

	public Component makeStarRating(String title, LevelBar label) {
		
		panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.setBounds(20, 28, 209, 49);
		panel.setBorder(null);
	    panel.add(label);
	    return panel;
		
	}


	public ImageIcon makeStarImageIcon(ImageProducer ip, SelectedImageFilter filter) {
		img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(ip, filter));
	     return new ImageIcon(img);
	}
	
	class SelectedImageFilter extends RGBImageFilter {
		  private final float rf;
		  private final float gf;
		  private final float bf;

		  protected SelectedImageFilter(float rf, float gf, float bf) {
		    super();
		    this.rf = Math.min(1f, rf);
		    this.gf = Math.min(1f, gf);
		    this.bf = Math.min(1f, bf);
		    canFilterIndexColorModel = false;
		  }

		  @Override public int filterRGB(int x, int y, int argb) {
		    int r = Math.round(((argb >> 16) & 0xFF) * rf);
		    int g = Math.round(((argb >> 8) & 0xFF) * gf);
		    int b = Math.round((argb & 0xFF) * bf);
		    return (argb & 0xFF_00_00_00) | (r << 16) | (g << 8) | b;
		  }
		}
	class LevelBar extends JPanel {
		  private final int gap;
		  private final List<ImageIcon> iconList;
		  private final List<JLabel> labelList = Arrays.asList(
		      new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel()
		  );
		  protected final ImageIcon defaultIcon;
		  protected int clicked = -1;
		  private transient MouseAdapter handler;

		  protected LevelBar(ImageIcon defaultIcon, List<ImageIcon> list, int gap) {
		    super(new GridLayout(1, 5, gap * 2, gap * 2));
		    this.defaultIcon = defaultIcon;
		    this.iconList = list;
		    this.gap = gap;
		    EventQueue.invokeLater(() -> {
		      for (JLabel l: labelList) {
		        l.setIcon(defaultIcon);
		        add(l);
		      }
		    });
		  }

		  @Override public void updateUI() {
		    removeMouseListener(handler);
		    removeMouseMotionListener(handler);
		    super.updateUI();
		    handler = new MouseAdapter() {
		      @Override public void mouseMoved(MouseEvent e) {
		        repaintIcon(getSelectedIconIndex(e.getPoint()));
		      }

		      @Override public void mouseEntered(MouseEvent e) {
		        repaintIcon(getSelectedIconIndex(e.getPoint()));
		      }

		      @Override public void mouseClicked(MouseEvent e) {
		        clicked = getSelectedIconIndex(e.getPoint());
		      }

		      @Override public void mouseExited(MouseEvent e) {
		        repaintIcon(clicked);
		      }
		    };
		    addMouseListener(handler);
		    addMouseMotionListener(handler);
		  }

		  public void clear() {
		    clicked = -1;
		    repaintIcon(clicked);
		  }

		  public int getLevel() {
		    return clicked;
		  }

		  public void setLevel(int l) {
		    clicked = l;
		    repaintIcon(clicked);
		  }

		  protected int getSelectedIconIndex(Point p) {
		    for (int i = 0; i < labelList.size(); i++) {
		      Rectangle r = labelList.get(i).getBounds();
		      r.grow(gap, gap);
		      if (r.contains(p)) {
		        return i;
		      }
		    }
		    return -1;
		  }

		  protected void repaintIcon(int index) {
		    for (int i = 0; i < labelList.size(); i++) {
		      labelList.get(i).setIcon(i <= index ? iconList.get(i) : defaultIcon);
		    }
		    repaint();
		  }
		  
		}
		
}
