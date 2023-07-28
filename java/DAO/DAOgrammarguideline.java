package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import BEAN.grammarguideline;
import DB.MySQL;

public class DAOgrammarguideline {
  public static void insertGrammarGuideline(grammarguideline g)
  {
	  try {
		Connection con = MySQL.getConnection();
		String sql = "insert into grammarguideline (grammarname,grammarimage,content) values (?,?,?)";
		PreparedStatement p = con.prepareStatement(sql);
		p.setString(1,g.getGrammarname());
		p.setString(2, g.getGrammarimage());
		p.setString(3, g.getContent() );
		
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
  public static grammarguideline selectById(int id)
  {
	  ArrayList<grammarguideline> arr = new ArrayList<grammarguideline>();
	  try {
		  Connection con = MySQL.getConnection();
		  String sql = "select * from grammarguideline where grammarguidelineid = ?";
		  PreparedStatement p = con.prepareStatement(sql);
		  p.setInt(1, id);
		  
		  ResultSet rs = p.executeQuery();
		  while(rs.next())
		  {
			  arr.add(new grammarguideline(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		  }
		  return arr.get(0);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	
	}
	  return new grammarguideline();
  }
 public static boolean insertName(String name)
 {
	 try {
		Connection con = MySQL.getConnection();
		String sql = "insert into grammarguideline (grammarname,grammarimage) values (? , 'anh1.png')";
		PreparedStatement p = con.prepareStatement(sql);
		p.setString(1, name);
		
		int check = p.executeUpdate();
		if(check > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return false;
	}
	
 }
 
 public static int getIDfromName(String name)
 {
	
	  try {
		  Connection con = MySQL.getConnection();
		  String sql = "select * from grammarguideline where grammarname = ?";
		  PreparedStatement p = con.prepareStatement(sql);
		  p.setString(1, name);
		  
		  ResultSet rs = p.executeQuery();
		  rs.next();
		  return rs.getInt(1);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	  return 0;
 }
 
  public static ArrayList<grammarguideline> selectFrom(int start, int count)
  {
	  ArrayList<grammarguideline> arr = new ArrayList<grammarguideline>();
	  try {
		Connection con = MySQL.getConnection();
		String sql = "select * from grammarguideline limit "+(start-1)+", "+count+"";
		PreparedStatement p = con.prepareStatement(sql);
		ResultSet rs = p.executeQuery();
		while(rs.next())
		{
		   	arr.add(new grammarguideline(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	  return arr;
  }
  
  public static int countRow()
  {
	  //nt cnt = 0;
	  try {
		  Connection con = MySQL.getConnection();
		String sql = "select count(*) from grammarguideline";
		PreparedStatement p = con.prepareStatement(sql);
		
		ResultSet rs = p.executeQuery();
		rs.next();
		return rs.getInt(1);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	  return 0;
  }
  public static void updateContent(int ID, String content)
  {
	try {
		Connection con = MySQL.getConnection();
		
		String sql = "update grammarguideline set content = ? where grammarguidelineid = ?";
		PreparedStatement p = con.prepareStatement(sql);
		p.setString(1, content);
		p.setInt(2, ID);
		
		int check = p.executeUpdate();
		if(check > 0)
		{
			System.out.println("Cap nhat thanh cong");
		}
		else
		{
			System.out.println("Cap nhat khong thanh cong");
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}  
  }
  
  public static ArrayList<grammarguideline> searchByName(String grammarname)
  {
	  ArrayList<grammarguideline> arr = new ArrayList<grammarguideline>();
	  try {
		  Connection con = MySQL.getConnection();
		String sql = "select * from grammarguideline where grammarname like '%" + grammarname + "%'";
		 PreparedStatement p = con.prepareStatement(sql);
		 ResultSet rs = p.executeQuery();
		 while(rs.next())
		 {
			 arr.add(new grammarguideline(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		 }
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	  return arr;
  }
  
}
