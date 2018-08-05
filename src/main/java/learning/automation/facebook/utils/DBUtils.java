package learning.automation.facebook.utils;

import java.sql.*;  
class DBUtils{  
  public static void main(String args[]){  
    try{  
      Class.forName("com.mysql.jdbc.Driver");  
      Connection con=DriverManager.getConnection(  
          "jdbc:mysql://172.17.0.6:3306/mysql","tsys","tsys");  
      //here sonoo is database name, root is username and password  
      Statement stmt=con.createStatement();  
      ResultSet rs=stmt.executeQuery("select * from columns_priv");  
      while(rs.next())  
        System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
      con.close();  
    }catch(Exception e){ System.out.println(e);}  
  }  
}  
