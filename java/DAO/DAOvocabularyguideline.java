package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import BEAN.vocabularyguideline;
import DB.MySQL;

public class DAOvocabularyguideline {
public static ArrayList<vocabularyguideline> selectFrom(int start, int count)
{
	ArrayList<vocabularyguideline> arr = new ArrayList<vocabularyguideline>();
	try {
		Connection con = MySQL.getConnection();
		String sql = "select * from vocabularyguideline limit "+(start-1)+ ",  "+count+ "";
		PreparedStatement p = con.prepareStatement(sql);
		ResultSet rs = p.executeQuery();
		while(rs.next())
		{
			arr.add(new vocabularyguideline(rs.getInt(1), rs.getString(2),rs.getString(3), DAOvocabularycontent.checkNoiDung(rs.getInt(1))));
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return arr;
}

public static void insertvocabularyguideline(vocabularyguideline v)
{
	try {
		String sql = "insert into vocabularyguideline (vocabularyname, vocabularyimage) values (?,?)";
		Connection con = MySQL.getConnection();
		PreparedStatement p = con.prepareStatement(sql);
		p.setString(1, v.getVocabularyname());
		p.setString(2, v.getVocabularyimage());
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
		String sql = "select count(*) from vocabularyguideline";
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

public static void deletebyID(int id)
{
	try {
		Connection con = MySQL.getConnection();
		String sql = "delete from vocabularyguideline where vocabularyguidelineid = ?";
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

public static String getName(int id)
{
	try {
		Connection con = MySQL.getConnection();
		String sql = "select vocabularyname from vocabularyguideline where vocabularyguidelineid = ?";
		PreparedStatement p = con.prepareStatement(sql);
		p.setInt(1, id);
		ResultSet rs = p.executeQuery();
		rs.next();
		return rs.getString(1);
		} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return "";
	}
}



}
