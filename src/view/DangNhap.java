package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import DATABASE.DatabaseConnector;
import model.ACC;
import model.TaiKhoan;

import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.PublicKey;
import java.sql.ResultSet;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.SwingConstants;

public class DangNhap extends JFrame implements MouseListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_username;
	private JPasswordField passwordField;
	protected DangKi capNhatThongTinBenhNhan;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public DangNhap() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DangNhap.class.getResource("/Image/avt.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 421);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel_TenBN = new JLabel("Tên Đăng Nhập:");
		lblNewLabel_TenBN.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_TenBN.setBounds(345, 169, 130, 24);
		contentPane.add(lblNewLabel_TenBN);
		
		JLabel lblNewLabel_MaBN = new JLabel("Mật Khẩu:");
		lblNewLabel_MaBN.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_MaBN.setBounds(353, 211, 81, 24);
		contentPane.add(lblNewLabel_MaBN);
		
		textField_username = new JTextField();
		textField_username.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_username.setBounds(465, 169, 166, 22);
		contentPane.add(textField_username);
		textField_username.setColumns(10);
		
		JButton btnNewButton_Login = new JButton("Đăng Nhập");
		btnNewButton_Login.setForeground(new Color(255, 255, 255));
		btnNewButton_Login.setBackground(new Color(123, 104, 238));
		btnNewButton_Login.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_Login.setBounds(430, 290, 205, 30);
		contentPane.add(btnNewButton_Login);
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBounds(465, 213, 166, 20);
		contentPane.add(passwordField);
		
		
		JCheckBox showPasswordCheckBox = new JCheckBox("Hiển Thị Mật Khẩu");
		showPasswordCheckBox.setBackground(new Color(248, 248, 255));
		showPasswordCheckBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		showPasswordCheckBox.setBounds(459, 257, 130, 20);
		contentPane.add(showPasswordCheckBox);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DangNhap.class.getResource("/Image/bv1.png")));
		lblNewLabel.setBounds(490, 9, 124, 113);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome ");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(480, 121, 120, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(new Color(240, 240, 240));
		lblNewLabel_2.setIcon(new ImageIcon(DangNhap.class.getResource("/Image/temp.png")));
		lblNewLabel_2.setBounds(10, 9, 365, 355);
		contentPane.add(lblNewLabel_2);
		
		JLabel labelQuenMK = new JLabel("Quên Mật Khẩu?");
		labelQuenMK.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelQuenMK.setBounds(533, 331, 130, 24);
		contentPane.add(labelQuenMK);
		labelQuenMK.addMouseListener(this);
		
		JLabel lableDangKi = new JLabel("Đăng Kí Tài Khoản");
		lableDangKi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lableDangKi.setBounds(393, 331, 130, 24);
		contentPane.add(lableDangKi);
		lableDangKi.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DangKiGmail frame = new DangKiGmail();
							frame.setLocationRelativeTo(null);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			    dispose();
			
			}
		});
		
		showPasswordCheckBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				//kiem tra co dc chon khong
				  if (showPasswordCheckBox.isSelected()) {
	                    // Nếu đang được chọn, hiển thị mật khẩu
	                    passwordField.setEchoChar((char) 0); // Hiển thị mật khẩu dưới dạng văn bản thông thường
	                } else {
	                    // Nếu không được chọn, ẩn mật khẩu
	                    passwordField.setEchoChar('\u2022'); // Sử dụng ký tự "•" để ẩn mật khẩu
	                }
	            }
			
		});
		
		
        btnNewButton_Login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					DatabaseConnector connector = null;
					String username = textField_username.getText();
					String password = new String(passwordField.getPassword());
					
				 	TaiKhoan tk = new TaiKhoan();
					tk.setHoTen(username);
					tk.setMatKhau(password);
				
				     try {
						connector = new DatabaseConnector("jdbc:mysql://localhost:3306/quanlybenhnhan", "root", "1234");
						ResultSet rs = connector.timKiemTaiKhoan(tk);
						
						if(rs!= null && rs.next()) {
							 JOptionPane.showMessageDialog(DangNhap.this, "Đăng Nhập Thành Công!");
							 EventQueue.invokeLater(new Runnable() {
									public void run() {
										try {
											TrangChu frame = new TrangChu();
											frame.setLocationRelativeTo(null);
											frame.setVisible(true);
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								});
							ACC account = new ACC(username , password) ; 
							CaNhan.receiverInfor(account);
							DoiMatKhau.receiverInfor(account);
							
							dispose();
							
						}else {
							 JOptionPane.showMessageDialog(DangNhap.this, "Đăng nhập thất bại!" , "Thông Báo", JOptionPane.ERROR_MESSAGE);
						}
						
				     } catch (Exception e1) {
						
						e1.printStackTrace();
					}
				     
				    
			  }
				
		});
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	    if (e.getSource() instanceof JLabel) {
	        JLabel label = (JLabel) e.getSource();
	        if ("Quên Mật Khẩu?".equals(label.getText())) {
	            EventQueue.invokeLater(new Runnable() {
	                public void run() {
	                    try {
	                        QuenMatKhau frame = new QuenMatKhau();
	                        frame.setLocationRelativeTo(null);
	                        frame.setVisible(true);
	                    } catch (Exception ex) {
	                        ex.printStackTrace();
	                    }
	                }
	            });
	            dispose();
	        }
	    }
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
