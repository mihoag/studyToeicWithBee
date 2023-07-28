package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import BEAN.listenquestion;
import DB.MySQL;

public class DAOlistenquestion {
public static void deleteLQ(int id)
{
	try {
	    Connection con = MySQL.getConnection();
		String sql = "delete from listenquestion where listenexerciseid = ?";
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
public static int checkNoiDung(int id)
{
	try {
		Connection con = MySQL.getConnection();
		String sql = "select * from listenquestion where listenexerciseid = ?";
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
public static void insertlistenquestion(listenquestion l)
{
	try {
		Connection con = MySQL.getConnection();
		String sql = "insert into listenquestion (imagename,audiomp3,audiogg,question,option1,option2,option3,option4,correctanswer,listenexerciseid) values (?,?,?,?,?,?,?,?,?,?) ";
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

public static ArrayList<listenquestion> selectFromByID(int id, int start, int count)
{
	ArrayList<listenquestion> arr = new ArrayList<listenquestion>();
	try {
		String sql = "select * from listenquestion where listenexerciseid = ?" + " limit "+(start-1)+ ", " +count;
		Connection con = MySQL.getConnection();
		PreparedStatement p = con.prepareStatement(sql);
		p.setInt(1, id);
		ResultSet rs  = p.executeQuery();
		while(rs.next())
		{
			arr.add(new listenquestion(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),  rs.getString(9),
					rs.getString(10), rs.getInt(11)));
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
		String sql = "select count(*) from listenquestion where listenexerciseid = ?";
		Connection con = MySQL.getConnection();
		PreparedStatement p = con.prepareStatement(sql);
		p.setInt(1, id);
		ResultSet rs = p.executeQuery();
		rs.next();
		return rs.getInt(1);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return 0;
	}
}
public static ArrayList<listenquestion> selectFromByID(int id1, int id2)
{
	ArrayList<listenquestion>  arr = new ArrayList<listenquestion>();
	try {
		String sql = "select * from listenquestion where listenquestionid = ? and listenexerciseid = ?";
		Connection con = MySQL.getConnection();
		PreparedStatement p = con.prepareStatement(sql);
		p.setInt(1, id1);
        p.setInt(2, id2);
        
        ResultSet rs = p.executeQuery();
        while(rs.next())
        {
        	arr.add(new listenquestion(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),  rs.getString(9),
					rs.getString(10), rs.getInt(11)));
        }
        
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return arr;
}
}
