package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import BEAN.examinationquestion;
import BEAN.result;
import DB.MySQL;

public class DAOresult {
   public static void insertresult(result r)
   {
	   try {
		Connection con = MySQL.getConnection();
		String sql = "insert into result(correctanswernum,incorrectanswernum,time,examinationid,memberid) values (?,?,?,?,?)";
		PreparedStatement p= con.prepareStatement(sql);
		p.setInt(1, r.getCorrectanswernum());
		p.setInt(2, r.getIncorrectanswernum());
		p.setString(3, r.getTime());
		p.setInt(4, r.getExaminationid());
		p.setInt(5, r.getMemberid());
		
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
   
   public static ArrayList<result> selectFrom(int start, int count)
   {
	   ArrayList<result> arr = new ArrayList<result>();
	   try {
		Connection con = MySQL.getConnection();
		
		String sql = "select * from result limit " + (start-1) +  ", " + count;
		PreparedStatement p = con.prepareStatement(sql);
		ResultSet rs = p.executeQuery();
		while(rs.next())
		{
			
			arr.add(new result(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getString(4) , rs.getInt(5),rs.getInt(6)));
			
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	   return arr;
   }
   
}
