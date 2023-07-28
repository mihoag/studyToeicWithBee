package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import BEAN.listenexercise;
import DB.MySQL;

public class DAOlistenexercise {
  public static void insertlistenexercise(String name)
  {
	  try {
		Connection con = MySQL.getConnection();
		String anh = "anh1.png";
		String sql = "insert into listenexercise (listenexercisename, listenexerciseimage) values(?,?)";
		PreparedStatement p = con.prepareStatement(sql);
		p.setString(1, name);
		p.setString(2, anh);
		int check = p.executeUpdate();
		if(check > 0)
		{
			System.out.println("Them thanh cong");
		}
		else
		{
			System.out.println("Them khong thanh cong");
		}
	} catch (Exception e) {
		// TODO: handle exception
	  e.printStackTrace();
	}
  }
  public static ArrayList<listenexercise> selectFrom(int start, int count)
  {
	ArrayList<listenexercise> arr = new ArrayList<listenexercise>();
	try {
	Connection con  =  MySQL.getConnection();
	String sql = "select * from listenexercise limit "+(start-1)+", "+count+"";
	PreparedStatement p = con.prepareStatement(sql);
	ResultSet rs = p.executeQuery();
	while(rs.next())
	{
		arr.add(new listenexercise(rs.getInt(1),rs.getString(2), rs.getString(3), DAOlistenquestion.checkNoiDung(rs.getInt(1))));
	}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	return arr;
  }
  
  public static void deleteLQ(int id)
  {
	  DAOlistenquestion.deleteLQ(id);
	  try {
	    Connection con = MySQL.getConnection();
		String sql  = "delete from listenexercise where listenexerciseid = ?";
		PreparedStatement p = con.prepareStatement(sql);
		p.setInt(1, id);
		int check = p.executeUpdate();
	    if(check > 0)
	    {
	    	System.out.println("Them thanh cong");
	    }
	    else
	    {
	    	System.out.println("Them khong thanh cong");
	    }
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
  }
  public static int countRow()
  {
	  
	  try {
		String sql = "select count(*) from listenexercise";
		Connection con = MySQL.getConnection();
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
}
