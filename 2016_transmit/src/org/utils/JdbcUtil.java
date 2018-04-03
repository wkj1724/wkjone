package org.utils;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
  
  
  
public class JdbcUtil {  
    private static String url = "jdbc:oracle:thin:@192.168.1.15:1521:szzfdb";  
    private static String username = "jtcs";  
    private static String password = "jtcs123";  
    private static String driverName = "oracle.jdbc.driver.OracleDriver";  
  
    public JdbcUtil() {  
        super();  
        // TODO Auto-generated constructor stub  
    }    
    static {  
        try {  
            Class.forName(driverName);  
        } catch (ClassNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }    
    public static Connection getConnection() throws SQLException {  
        return DriverManager.getConnection(url, username, password);  
    }    
    public static void close(ResultSet rs, Statement st,Statement st2, Connection conn) {  
        try {  
            if (rs != null) {  
                rs.close();    
            }  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }finally{  
            try {  
                if(st!=null){  
                    st.close();  
                }  
            } catch (SQLException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }finally{  
            	try{if(st2!=null)
            		st2.close();
            	}catch (SQLException e) {
					// TODO: handle exception
            		e.printStackTrace();
				}finally{
	                if(conn!=null){  
	                    try {  
	                        conn.close();  
	                    } catch (SQLException e) {  
	                        // TODO Auto-generated catch block  
	                        e.printStackTrace();  
	                    }  
	                }  
				}
            }  
        }  
  
    }  
    public static void main(String[] agrs) throws SQLException{
    	System.out.println(JdbcUtil.getConnection());
    }
  
}  