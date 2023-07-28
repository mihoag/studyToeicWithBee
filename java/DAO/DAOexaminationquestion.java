package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import BEAN.examinationquestion;
import DB.MySQL;

public class DAOexaminationquestion {
public static int checkQuestion(int id)
{
	try {
		Connection con = MySQL.getConnection();
		String sql = "select * from examinationquestion where examinationid = ?";
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

public static void insertExQ(examinationquestion e)
{
	try {
		Connection con = MySQL.getConnection();
		String sql = "insert into examinationquestion (num,imagequestion,audiogg,audiomp3,paragraph,question,option1,option2,option3,option4,correctanswer,examinationid) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement p = con.prepareStatement(sql);
		p.setInt(1, e.getNum());
		p.setString(2, e.getImagequestion() );
		p.setString(3, e.getAudiogg());
		p.setString(4, e.getAudiomp3());
		p.setString(5, e.getParagraph());
		p.setString(6, e.getQuestion());
		p.setString(7, e.getOption1());
		p.setString(8, e.getOption2());
		p.setString(9, e.getOption3());
		p.setString(10, e.getOption4());
		p.setString(11, e.getCorrectanswer());
		p.setInt(12, e.getExaminationid());
		
		int check = p.executeUpdate();
		if(check  > 0)
		{
			System.out.println("Insert thanh cong");
		}
		else
		{
			System.out.println("KHong thanh cong");
		}
	} catch (Exception e2) {
		// TODO: handle exception
		e2.printStackTrace();
	}
}

public static ArrayList<examinationquestion> selectByID(int examinationid)
{
	ArrayList<examinationquestion> arr = new ArrayList<examinationquestion>();
	
	try {
		String sql = "select * from examinationquestion where examinationid = ?";
		Connection con = MySQL.getConnection();
		PreparedStatement p = con.prepareStatement(sql);
		p.setInt(1, examinationid);
		
		ResultSet rs = p.executeQuery();
		while(rs.next())
		{
			arr.add(new examinationquestion(rs.getInt(1), rs.getInt(2), rs.getString(3),
					rs.getString(4),  rs.getString(5) ,  rs.getString(6) ,  rs.getString(7), 
					rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getInt(13)));
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return arr;	
}

public static void deleteExQ(int id)
{
	try {
		Connection con = MySQL.getConnection();
		String sql = "delete from examinationquestion where examinationid = ?";
		PreparedStatement p = con.prepareStatement(sql);
		p.setInt(1, id);
		
		int check = p.executeUpdate();
		if(check  > 0)
		{
			System.out.println("Xoa thanh cong");
		}
		else
		{
			System.out.println("Xoa khong thanh cong");
		}
	} catch (Exception e2) {
		// TODO: handle exception
		e2.printStackTrace();
	}
}

public static ArrayList<examinationquestion> selectFrom(int start, int count, int id)
{
	ArrayList<examinationquestion> arr = new ArrayList<examinationquestion>();
	
	try {
		Connection con = MySQL.getConnection();
		String sql = "select * from examinationquestion  limit "+ (start-1)+ ", " + count + " where examinationquestionid = ?";
		PreparedStatement p = con.prepareStatement(sql);
		p.setInt(1, id);
		
		ResultSet rs = p.executeQuery();
		while (rs.next()) {
	       arr.add(new examinationquestion(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), 
	    		   rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), 
	    		   rs.getString(10), rs.getString(11), rs.getString(12), rs.getInt(13)));	
		}	
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return arr;
}


public static int countRowbyID(int id)
{
	try {
		Connection con = MySQL.getConnection();
		String sql = "select count(*) from  examinationquestion where examinationid = ?";
		PreparedStatement p = con.prepareStatement(sql);
		p.setInt(1, id);
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
