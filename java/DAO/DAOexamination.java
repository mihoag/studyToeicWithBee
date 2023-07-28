package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import BEAN.examination;
import DB.MySQL;

public class DAOexamination {
  public static ArrayList<examination> selectAll()
  {
	  ArrayList<examination> arr = new ArrayList<examination>();
	  try {
		String sql = "select * from examination";
		Connection con = MySQL.getConnection();
		PreparedStatement p = con.prepareStatement(sql);
		ResultSet rs = p.executeQuery();
		while(rs.next())
		{
			arr.add(new examination(rs.getInt(1), rs.getString(2), rs.getString(3), DAOexaminationquestion.checkQuestion(rs.getInt(1))));
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return arr;   
  }
  
  public static void insertDeThi(String name)
  {
	  String examinationimage = "anh1.png";
	  try {
	     String sql = "insert into examination (examinationname, examinationimage) values (?, ?)";
	     Connection con = MySQL.getConnection();
	     PreparedStatement p = con.prepareStatement(sql);
	     p.setString(1, name);
	     p.setString(2, examinationimage);
	     
	     int check = p.executeUpdate();
	     if(check > 0)
	     {
	    	 System.out.println("Insert thanh cong");
	     }
	     else
	     {
	    	 System.out.println("Insert khong thanh cong");
	     }
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
  }
  
  public static ArrayList<examination> selectFrom(int start, int count)
  {
	  ArrayList<examination> arr = new ArrayList<examination>();
	  String sql = "select * from examination limit "+(start-1)+ ", " +count+ "";
	  try {
	  Connection con = MySQL.getConnection();
	  PreparedStatement p = con.prepareStatement(sql);
	  
	  ResultSet rs = p.executeQuery();
	  while(rs.next())
	  {
		  arr.add(new examination(rs.getInt(1), rs.getString(2), rs.getString(3), DAOexaminationquestion.checkQuestion(rs.getInt(1))));
	  }
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	 return arr; 
  }
  
  public static int countRow()
  {
	  try {
		String sql = "select count(*) from examination";
		Connection con = MySQL.getConnection();
		PreparedStatement p  = con.prepareStatement(sql);
		
		
		ResultSet rs = p.executeQuery();
		rs.next();
		return rs.getInt(1);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	  
	  return 0;
  }
  
  public static void deleteRow(int id)
  {
	  try {
		String sql = "delete from examination where examinationid = ?";
		Connection con = MySQL.getConnection();
		PreparedStatement p = con.prepareStatement(sql);
		p.setInt(1, id);
		int check = p.executeUpdate();
		if(check > 0)
		{
			System.out.println("Xoa thanh cong");
		}
		else
		{
			System.out.println("Xoa khong thanh cong");
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
  }
  
  
}
