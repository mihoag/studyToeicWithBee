package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import BEAN.cmtvocabulary;
import DB.MySQL;

public class DAOcmtvocabulary {
public static void insertcmtvocabulary(cmtvocabulary cmt)
{
	try {
		Connection con = MySQL.getConnection();
		String sql = "insert into cmtvocabulary (cmtvocabularycontent,memberid,vocabularyguidelineid) values (?,?,?)";
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, cmt.getCmtvocabularycontent());
        p.setInt(2, cmt.getMemberid());
        p.setInt(3, cmt.getVocabularyguidelineid());
        
        int check = p.executeUpdate();
        if(check >0)
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

public static ArrayList<cmtvocabulary> selectAll()
{
	ArrayList<cmtvocabulary> arr = new ArrayList<cmtvocabulary>();
	
	try {
		String sql = "select * from cmtvocabulary";
		Connection con = MySQL.getConnection();
		PreparedStatement p = con.prepareStatement(sql);
		ResultSet rs = p.executeQuery();
	    
		while(rs.next())
		{
			arr.add(new cmtvocabulary(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), DAOmember.getName1(rs.getInt(3))));
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
		String sql = "select count(*) from cmtvocabulary";
		Connection con = MySQL.getConnection();
		
		PreparedStatement p = con.prepareStatement(sql);
		
		ResultSet rs =p.executeQuery();
		rs.next();
		return rs.getInt(1);	
	} catch (Exception e) {
		// TODO: handle exception
		
		e.printStackTrace();
		return 0;
	}
}
}
