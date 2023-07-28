package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import BEAN.member;
import DB.MySQL;

public class DAOmember {
	public static boolean isExist(member m)
	{
		try {
			String sql = "select * from member where membername = ?";
			Connection con = MySQL.getConnection();
			
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, m.getMembername());
			ResultSet rs = p.executeQuery();
			return rs.next();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public static boolean isExist1(String user, String pass)
	{
		try {
			String sql = "select * from member where membername = ? and memberpass = ?";
			Connection con = MySQL.getConnection();
			System.out.println(user + " " + pass);
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, user);
			p.setString(2, pass);
			ResultSet rs = p.executeQuery();
			return rs.next();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
public static boolean insert(member m)
{
	
	String sql = "insert into member(membername,memberpass,categorymemberid,name) values (?,?,?,?)";
	try {
		Connection con = MySQL.getConnection();
		PreparedStatement p = con.prepareStatement(sql);
		p.setString(1,m.getMembername());
		p.setString(2, m.getMemberpass());
		p.setString(4, m.getName());
		p.setInt(3, m.getCategorymemberid());
		int check= p.executeUpdate();
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

public static String getName(String membername)
{
	try {
		Connection con = MySQL.getConnection();
		String sql = "select * from member where membername = ?";
		PreparedStatement p = con.prepareStatement(sql);
		p.setString(1, membername);
		ResultSet rs = p.executeQuery();
		rs.next();
		return rs.getString(5);

	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
 	
 	return "";
}
public static String getName1(int id)
{
	try {
		Connection con = MySQL.getConnection();
		String sql = "select * from member where memberid = ?";
		PreparedStatement p = con.prepareStatement(sql);
		p.setInt(1, id);
		ResultSet rs = p.executeQuery();
		rs.next();
		return rs.getString(5);

	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
 	
 	return "";
}
public static int getMemberID(String username)
{
     	try {
			Connection con = MySQL.getConnection();
			String sql = "select * from member where membername = ?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, username);
			ResultSet rs = p.executeQuery();
			rs.next();
			return rs.getInt(1);
	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
     	
     	return 0;
}
public static int getID(String user, String pass)
{
	try {
		String sql = "select * from member where membername = ? and memberpass = ?";
		Connection con = MySQL.getConnection();
		System.out.println(user + " " + pass);
		PreparedStatement p = con.prepareStatement(sql);
		p.setString(1, user);
		p.setString(2, pass);
		ResultSet rs = p.executeQuery();
	    rs.next();
	    return rs.getInt(4);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return 0;
}

}
