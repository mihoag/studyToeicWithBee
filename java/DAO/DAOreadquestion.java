package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import BEAN.listenquestion;
import BEAN.readquestion;
import DB.MySQL;

public class DAOreadquestion {
 public static int checkNoiDung(int id)
 {
	 try {
		String sql = "select * from readquestion where readexerciseid = ?";
	    Connection con = MySQL.getConnection();
	    PreparedStatement p = con.prepareStatement(sql);
	    p.setInt(1, id);
	    
	    ResultSet rs = p.executeQuery();
	    if(rs.next())
	    {
	    	return 1;
	    }
	    else
	    {
	    return 0;	
	    } 
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	 return 0;
 }
 
 public static void deleteQuestion(int id)
 {
	 try {
		 String sql = "delete from readquestion where readexerciseid = ?";
		 
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
 
 public static void insertReadQues(readquestion r)
 {
	 try {
		String sql = "insert into readquestion (num, paragraph , question, option1, option2 , option3, option4 , correctanswer, readexerciseid ) values (?,?,?,?,?,?,?,?,?) ";
		Connection con = MySQL.getConnection();
		PreparedStatement p = con.prepareStatement(sql);
		p.setInt(1, r.getNum());
		p.setString(2, r.getParagraph());
		p.setString(3, r.getQuestion());
		p.setString(4, r.getOption1());
		p.setString(5, r.getOption2());
		p.setString(6, r.getOption3());
		p.setString(7, r.getOption4());
		p.setString(8, r.getCorrectanswer());
		p.setInt(9, r.getReadexerciseid());
		
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
 public static void insertLQ(listenquestion l)
 {
	try {
		Connection con = MySQL.getConnection();
		String sql = "insert into listenquestion (imagename,audiomp3,audiogg, question ,option1,option2,option3,option4, correctanswer,listenexerciseid) values (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement p = con.prepareStatement(sql);
		p.setString(1, l.getImagename());
		p.setString(2, l.getAudiomp3());
		p.setString(3, l.getAudiogg());
		p.setString(4, l.getQuestion());
		p.setString(5, l.getOption1());
		p.setString(6, l.getOption2());
		p.setString(7, l.getOption3());
		p.setString(8, l.getOption4());
		p.setString(9, l.getCorrectanswer());
		p.setInt(10, l.getListenexerciseid());
		
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
 
 public static ArrayList<readquestion> selectFromByID(int id, int start, int count)
 {
	 ArrayList<readquestion> arr = new ArrayList<readquestion>();
	 try {
		Connection con = MySQL.getConnection();
		String sql = "select * from readquestion " + "where readexerciseid = ? " + "limit "+(start-1)+ ", " +count;
		PreparedStatement p = con.prepareStatement(sql);
		p.setInt(1, id);
		ResultSet rs = p.executeQuery();
		while(rs.next())
		{
			arr.add(new readquestion(rs.getInt(1), rs.getInt(2), rs.getString(3),
					rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getInt(10)  ));
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	 return arr;
	 
 }
 public static int countRow(int id)
 {
	 try {
		String sql = "select count(*) from readquestion where readexerciseid = ?";
		Connection con = MySQL.getConnection();
		PreparedStatement p = con.prepareStatement(sql);
		p.setInt(1, id);
		ResultSet rs = p.executeQuery();
		rs.next();
	    return rs.getInt(1);
	} catch (Exception e) {
		// TODO: handle exceptionr
		return 0;
	}
 }
 
 public static ArrayList<readquestion> selectByNumandID(int num, int id)
 {
	 ArrayList<readquestion> arr = new ArrayList<readquestion>();
	 try {
		String sql = "select * from readquestion where num = ? and readexerciseid = ?";
		Connection con = MySQL.getConnection();
		PreparedStatement p = con.prepareStatement(sql);
		p.setInt(1, num);
		p.setInt(2, id);
		
		ResultSet rs = p.executeQuery();
		while(rs.next())
		{
			arr.add(new readquestion(rs.getInt(1), rs.getInt(2), rs.getString(3),
					rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getInt(10)  ));	
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	 return arr;
 }
 
 

}
