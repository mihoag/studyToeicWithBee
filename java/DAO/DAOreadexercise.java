package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import BEAN.readexercise;
import DB.MySQL;

public class DAOreadexercise {
public static void insertByName(String name)
{
    try {
    	String sql = "insert into readexercise (readname,readimage) values (?,?)";
		Connection con  = MySQL.getConnection();
		PreparedStatement p = con.prepareStatement(sql);
		p.setString(1, name);
		p.setString(2, "anh1.png");
		
		
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

public static ArrayList<readexercise> selectFrom(int start, int count)
{
        ArrayList<readexercise> arr = new ArrayList<readexercise>();
        try {
			String sql = "select * from readexercise limit "+(start-1)+ ", " +count  + "" ;
			Connection con = MySQL.getConnection();
			
			
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while(rs.next())
			{
				arr.add(new readexercise(rs.getInt(1), rs.getString(2), rs.getString(3), DAOreadquestion.checkNoiDung(rs.getInt(1) )));
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
		String sql = "select count(*) from readexercise ";
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

public static void deleteReadExe(int id)
{
	DAOreadquestion.deleteQuestion(id);
	try {
	    Connection con = MySQL.getConnection();
	    String sql = "delete from readexercise where readexerciseid = ?";
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
