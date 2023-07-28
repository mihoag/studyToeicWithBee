package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import BEAN.cmtgrammar;
import DB.MySQL;

public class DAOcmtgrammar {
public static void insertGrammar(cmtgrammar g)
{
	try {
		Connection con = MySQL.getConnection();
		String sql = "insert into cmtgrammar (cmtgrammarcontent, memberid,grammarguidelineid) values (?,?,?)";
		PreparedStatement p = con.prepareStatement(sql);
		p.setString(1, g.getCmtgrammarcontent());
		p.setInt(2, g.getMemberid());
		p.setInt(3, g.getGrammarguidelineid());
		
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

public static ArrayList<cmtgrammar> selectbyID(int id)
{
	ArrayList<cmtgrammar> arr = new ArrayList<cmtgrammar>();
	try {
		Connection con = MySQL.getConnection();
		String sql = "select * from cmtgrammar where grammarguidelineid = ? ";
		PreparedStatement p = con.prepareStatement(sql);
		p.setInt(1, id);
		ResultSet rs = p.executeQuery();
        while(rs.next())
        {
        	int memberid  = rs.getInt(3);
        	arr.add(new cmtgrammar(rs.getString(2), memberid ,rs.getInt(4), DAOmember.getName(rs.getString(2))));
        }
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return arr;
}

public static void deleteByID(int id)
{
	try {
		String sql = "delete from cmtgrammar where grammarguidelineid = ?";
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

public static int countRow()
{
	try {
		String sql = "select count(*) from cmtgrammar";
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
