package DATABASE;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.conf.url.SingleConnectionUrl;

import model.BenhNhan;
import model.TaiKhoan;
import view.DanhSach;

public class DatabaseConnector {
    private Connection conn = null;
	private PreparedStatement pstmt;
	 ResultSet resultSet;
    public DatabaseConnector(String url, String user, String password) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);
    }
    
    public DatabaseConnector()  {
    }

    public Connection getConnection() {
        return conn;
    }

    public void close() throws Exception {
        if (conn != null) {
            conn.close();
        }
    }
    
    public ResultSet getDataBenhNhan (BenhNhan bn){
        Statement statement;
        try {
        	statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM benhnhan");
            while(resultSet.next()) {
            	if (bn.getMaBenhNhan() == resultSet.getInt("MaBenhNhan")) {
            		return resultSet;
            	}
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ResultSet timKiemTaiKhoan(TaiKhoan tk) {
	    String sql = "SELECT * FROM taikhoan WHERE TenDangNhap = ? AND MatKhau = ?";
	    try {
				// Khởi tạo PreparedStatement
		        PreparedStatement pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, tk.getHoTen());
		        pstmt.setString(2, tk.getMatKhau());
		        // Thực thi câu lệnh SQL
		        resultSet = pstmt.executeQuery();
		      return resultSet ;
		       
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	
    }
    
    public ResultSet timKiemTaiKhoanBiQuen(TaiKhoan tk) {
	    String sql = "SELECT * FROM taikhoan WHERE email = ?";
	    try {
				// Khởi tạo PreparedStatement
		        PreparedStatement pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, tk.getMail());
		        // Thực thi câu lệnh SQL
		        resultSet = pstmt.executeQuery();
		      return resultSet ;
		       
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	
    }
    
    public void xoaData(Object object) {
    	String sql = "DELETE FROM benhnhan WHERE MaBenhNhan = ?";
    	try {
    		 // Khởi tạo PreparedStatement
 	        PreparedStatement pstmt = conn.prepareStatement(sql);
 	        
 	        // Thiết lập tham số cho PreparedStatement
 	        pstmt.setObject(1, object);
 	        
 	        // Thực thi câu lệnh SQL
 	        pstmt.executeUpdate();
 	        
 	        // Đóng PreparedStatement
 	        pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }
  

    public void chinhsua(BenhNhan bn) {
    	  String sql = "UPDATE benhnhan SET HoTen = ?, NgayKham = ?, GioiTinh = ?, VienPhi = ?, SoPhong = ?, ChuanDoan = ? , BHYT = ? WHERE MaBenhNhan = ?";
		try {
			
			pstmt = conn.prepareStatement(sql);

	        pstmt.setString(1, bn.getHoTen());
	        pstmt.setString(2, bn.getNgayKham());
	        pstmt.setString(3 , bn.getGioiTinh());
	        pstmt.setDouble(4, bn.getVienPhi());
	      	pstmt.setInt(5, bn.getSoPhong());
	     	pstmt.setString(6, bn.getChuanDoan());
	     	pstmt.setString(7, bn.getBHYT());
	     	pstmt.setInt(8, bn.getMaBenhNhan());
	        // Thực thi câu lệnh SQL
 	        pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
    

    public ResultSet timKiemMaBN(BenhNhan bn) {
        PreparedStatement pstmt;
        try {
            String sql = "SELECT * FROM benhnhan WHERE MaBenhNhan = ?";
            pstmt = this.conn.prepareStatement(sql);
            // Đặt giá trị cho tham số
            pstmt.setInt(1, bn.getMaBenhNhan());
            // Thực hiện truy vấn
            ResultSet resultSet = pstmt.executeQuery();
            // Kiểm tra nếu có dữ liệu và trả về ResultSet nếu có sự trùng khớp
            if (resultSet.next()) {
                return resultSet;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public ResultSet timKiemhoTenBN(BenhNhan bn) {
        try {
            String sql = "SELECT * FROM benhnhan WHERE HoTen = ?";
            pstmt = this.conn.prepareStatement(sql);
            // Đặt giá trị cho tham số
            pstmt.setString(1, bn.getHoTen());
            // Thực hiện truy vấn
            ResultSet resultSet = pstmt.executeQuery();
            // Kiểm tra nếu có dữ liệu và trả về ResultSet nếu có sự trùng khớp
            if (resultSet.next()) {
                return resultSet;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
   
    public ResultSet timKiemSoPhong(BenhNhan bn) {
        try {
            String sql = "SELECT * FROM benhnhan WHERE SoPhong = ?";
            pstmt = this.conn.prepareStatement(sql);
            // Đặt giá trị cho tham số
            pstmt.setInt(1, bn.getSoPhong());
            // Thực hiện truy vấn
            ResultSet resultSet = pstmt.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void DoiMK(TaiKhoan tk) {
  	  String sql = "UPDATE taikhoan SET MatKhau = ? WHERE TenDangNhap = ?";
  	  PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);

	        pstmt.setString(1, tk.getMatKhau());
	        pstmt.setString(2, tk.getHoTen());
	        // Thực thi câu lệnh SQL
	        pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
  
    
    public ResultSet timKiemThongTinCN(BenhNhan bn) {
		// TODO Auto-generated method stub
		 Statement statement;
         try {
         	
        	 statement = this.conn.createStatement();
             resultSet = statement.executeQuery("SELECT * FROM taikhoan");
             	
             while(resultSet.next()) {
             	if ((bn.getHoTen().equals(resultSet.getString("TenDangNhap")))) {
             		return resultSet;
             	}
             }
         }catch (SQLException e){
             e.printStackTrace();
         }
		return null;
	}
    
	 
	  
	public int themBenhNhan(BenhNhan bn) {
    	int result = 0 ;
		try {
 	        // Khởi tạo PreparedStatement
    		String sql = "INSERT INTO benhnhan(MaBenhNhan , HoTen , NgayKham , GioiTinh ,VienPhi , SoPhong , ChuanDoan , BHYT ) VALUES (?, ? , ? , ? , ? ,? , ? , ?) ; ";
 	        PreparedStatement pstmt = conn.prepareStatement(sql);
 	        pstmt.setInt(1, bn.getMaBenhNhan());
 	        pstmt.setString(2, bn.getHoTen());
 	        pstmt.setString(3, bn.getNgayKham());
 	        pstmt.setString(4, bn.getGioiTinh());
 	        pstmt.setDouble(5, bn.getVienPhi());
 	        pstmt.setInt(6, bn.getSoPhong());
 	        pstmt.setString(7, bn.getChuanDoan());
 	        pstmt.setString(8, bn.getBHYT());
 	        
 	        result = pstmt.executeUpdate();
 	       
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return result ; 
	}
	
	 public void QuenMK(TaiKhoan tk) {
    	  String sql = "UPDATE taikhoan SET MatKhau = ? WHERE email = ?";
  		try {
  			pstmt = conn.prepareStatement(sql);
  			pstmt.setString(1, tk.getMatKhau());
  	        pstmt.setString(2, tk.getMail());
  	        // Thực thi câu lệnh SQL
  	        pstmt.executeUpdate();
  		} catch (SQLException e) {
  			
  			e.printStackTrace();
  		}
  	}

		public boolean isBenhNhanExists(BenhNhan bn) throws SQLException {
		    String sql = "SELECT COUNT(*) FROM benhnhan WHERE MaBenhNhan = ?";
		    	PreparedStatement preparedStatement = conn.prepareStatement(sql);
		        preparedStatement.setInt(1, bn.getMaBenhNhan());
		        ResultSet resultSet = preparedStatement.executeQuery();
		        if (resultSet.next() && resultSet.getInt(1) > 0) {
		            return true; // Mã bệnh nhân đã tồn tại
		        }
		    return false; // Mã bệnh nhân chưa tồn tại
		}
		
		
		public boolean isTaiKhoanExists(TaiKhoan tk) throws SQLException {
		    String sql = "SELECT COUNT(*) FROM taikhoan WHERE TenDangNhap  = ?";
		    PreparedStatement preparedStatement = conn.prepareStatement(sql);
		    preparedStatement.setString(1, tk.getHoTen());
		    ResultSet resultSet = preparedStatement.executeQuery();
		    if (resultSet.next() && resultSet.getInt(1) > 0) {
		        return true; // Mã bệnh nhân đã tồn tại
		    }
		    return false; // Mã bệnh nhân chưa tồn tại
		}
		

		public boolean isEmailExists(TaiKhoan tk) throws SQLException {
		    String sql = "SELECT COUNT(*) FROM taikhoan WHERE email  = ?";
		    PreparedStatement preparedStatement = conn.prepareStatement(sql);
		    preparedStatement.setString(1, tk.getMail());
		    ResultSet resultSet = preparedStatement.executeQuery();
		    if (resultSet.next() && resultSet.getInt(1) > 0) {
		        return true; // Mã bệnh nhân đã tồn tại
		    }
		    return false; // Mã bệnh nhân chưa tồn tại
		}
		
		public boolean LayThongtinTaiKhoan(TaiKhoan tk) throws SQLException {
		    String sql = "SELECT COUNT(*) FROM taikhoan WHERE  TenDangNhap = ? AND sdt = ?";
		    PreparedStatement pstm = conn.prepareStatement(sql);
		    pstm.setString(1, tk.getHoTen());
		    pstm.setString(2, tk.getSdt());
		    ResultSet rs = pstm.executeQuery();
		    if (rs.next() && rs.getInt(1) > 0) { 
		       return true; // Tài Khoản đã tồn tại
		    }
		    return false; // Tài Khoản chưa tồn tại
		}
		

		public void DangKiTaiKhoan(TaiKhoan taiKhoan) {
			String sql = "INSERT INTO taikhoan ( TenDangNhap, matKhau, NamSinh, GioiTinh, sdt, email ) VALUES (?,?,?,?,?,?)";
			try {
				// Khởi tạo PreparedStatement
	 	        PreparedStatement pstmt = conn.prepareStatement(sql);
	 	        pstmt.setString(1, taiKhoan.getHoTen());
	 	        pstmt.setString(2, taiKhoan.getMatKhau());
	 	        pstmt.setInt(3, taiKhoan.getNamSinh());
	 	        pstmt.setString(4, taiKhoan.getGioiTinh());
	 	        pstmt.setString(5, taiKhoan.getSdt());
	 	       pstmt.setString(6, taiKhoan.getMail());
	 	        // Thực thi câu lệnh SQL
	 	        pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
  
    
}