/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.nhom07java;

import java.sql.Connection;
import java.sql.DriverManager;
import static java.sql.DriverManager.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CBGVModify {
        public static boolean hasLogin = false;    
    public static int permission = 1;    
    public static int role = 1;
     private static String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=JavaBTL;";
            private static String USER_NAME = "sa";
            private static String PASSWORD = "1234";
            Connection connection;
    public static List<CBGV> findAll() {
        List<CBGV> GiaovienList = new ArrayList<>();
        
        Connection connection = null;
        
        Statement statement = null;
        
        try {
      
            connection = getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("ok");
            
            //query
            String sql = "select * from [giaovien]";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                CBGV std = new CBGV(resultSet.getInt("id"), 
                        resultSet.getString("name"), resultSet.getString("dob"), 
                        resultSet.getString("address"), resultSet.getFloat("luongCung"), 
                        resultSet.getFloat("thuong"),resultSet.getFloat("phat"),resultSet.getFloat("luongThucLinh"));
                GiaovienList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return GiaovienList;
    }
    
    public static List<User> findAllUser() {
        List<User> UserList = new ArrayList<>();
        Connection connection = null;
        
        Statement statement = null;
        
        try {
         
            connection = getConnection(DB_URL, USER_NAME, PASSWORD);
            
            //query
            String sql = "select userName, password, permissionName, [user].permissionID from [user], [permission] where [user].permissionID = [permission].permissionID and [user].roleID = 2";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                User std = new User(resultSet.getString("userName"), 
                        resultSet.getString("password"),
                        resultSet.getString("permissionName"),resultSet.getString("permissionID"));
                System.out.println(std.toString());
                UserList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        
        return UserList;
    }
    
    public static void deleteUser(String u) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection(DB_URL, USER_NAME, PASSWORD);
             String sql = "delete from [user] where userName = ?";
             statement = connection.prepareCall(sql);
            statement.setString(1, u);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static void insertUser(String u, String p, String pe) {
         Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = getConnection(DB_URL, USER_NAME, PASSWORD);
             String sql = "insert into [user] ( userName, password, roleID, permissionID) values(?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            statement.setString(1, u);
            statement.setString(2, p);
            statement.setString(3, "2");            
            statement.setString(4, pe);

            System.out.println(sql);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    public static void update(String u, String p, String pe) {
         Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = getConnection(DB_URL, USER_NAME, PASSWORD);
             String sql = "update [user] set password = ?, roleID = ?, permissionID = ? where userName = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, p);
            statement.setString(2, "2");
            statement.setString(3, pe);            
            statement.setString(4, u);
             System.out.println(sql);
            statement.execute();
           
        } catch (SQLException ex) {
            Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    public static boolean checkUser(String u, String p){
        boolean check = false;
        Connection connection = null;
        
        Statement statement = null;
        
        try {
         
            connection = getConnection(DB_URL, USER_NAME, PASSWORD);
            PreparedStatement pst = null;
            ResultSet rs = null;
            pst = connection.prepareStatement("select * from [user] where userName = ? and password = ? ");
            pst.setString(1, u );
            pst.setString(2, p);
            System.out.println(pst);
            rs = pst.executeQuery();
            if(rs.next()) {
                check = true;
                hasLogin = true;
                role = rs.getInt("roleID");                
                permission = rs.getInt("permissionID");

            }
        } catch (SQLException ex) {
            Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        return check;
    }
    public static boolean checkUser2(String u, String p){
        boolean check = false;
        Connection connection = null;
        
        Statement statement = null;
        
        try {
           
            connection = getConnection(DB_URL, USER_NAME, PASSWORD);
            PreparedStatement pst = null;
            ResultSet rs = null;
            pst = connection.prepareStatement("select * from [user] where userName = ? ");
            pst.setString(1, u );
            System.out.println(pst);
            rs = pst.executeQuery();
            if(rs.next()) {
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        return check;
    }
    
    public static void insert(CBGV std) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
        
            connection = getConnection(DB_URL, USER_NAME, PASSWORD);
            
            //query
            String sql = "insert into [giaovien] ( id,name, dob, address, luongCung, thuong, phat, luongThucLinh) values(?,?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            statement.setInt(1, std.getID());
            statement.setString(2, std.getName());
            statement.setString(3, std.getDob());
            statement.setString(4, std.getAddress());
            statement.setFloat(5, std.getLuongcung());
            statement.setFloat(6, std.getThuong());
            statement.setFloat(7, std.getPhat());
            statement.setFloat(8, std.getLuongthuclinh());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    public static void update(CBGV std, int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
          
            connection = getConnection(DB_URL, USER_NAME, PASSWORD);
            
            //query
            String sql = "update [giaovien] set name = ?, dob =?, address=?, luongCung=?, Thuong=?, phat=?, luongThucLinh=? where id = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, std.getName());
            statement.setString(2, std.getDob());
            statement.setString(3, std.getAddress());
            statement.setFloat(4, std.getLuongcung());
            statement.setFloat(5, std.getThuong());
            statement.setFloat(6, std.getPhat());
            statement.setFloat(7, std.getLuongthuclinh());            
            statement.setFloat(8, id);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    
    
    public static void delete(int ID) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
          
            connection = getConnection(DB_URL, USER_NAME, PASSWORD);
            
            //query
            String sql = "delete from [giaovien] where id = ?";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, ID);
     
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CBGVModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
}
