package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import BEAN.vocabularycontent;
import DB.MySQL;

public class DAOvocabularycontent {
public static int checkNoiDung(int id)
{
	try {
		String sql = "select * from vocabularycontent where vocabularyguidelineid = ?";
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

public static void deleteByID(int id)
{
	try {
		Connection con = MySQL.getConnection();
		String sql = "delete from vocabularycontent where vocabularyguidelineid = ?";
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
		// TODO: handle exceptione
		e.printStackTrace();
	}
}

public static void insertVocab(vocabularycontent v)
{
	try {
		
		String sql = "insert into vocabularycontent (vocabularycontentname, transcribe,  audiomp3 ,audiogg, mean, vocabularyguidelineid) values (?,?,?,?,?,?) ";
		Connection con = MySQL.getConnection();
		PreparedStatement p = con.prepareStatement(sql);
		p.setString(1, v.getVocabularycontentname());
		p.setString(2, v.getTranscribe());
		p.setString(3, v.getAudiomp3());
		p.setString(4, v.getAudiogg());
		p.setString(5, v.getMean());
		p.setInt(6, v.getVocabularyguidelineid());
		
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

public static ArrayList<vocabularycontent> selectByID(int id)
{
	ArrayList<vocabularycontent> arr = new ArrayList<vocabularycontent>();
	try {
		Connection con = MySQL.getConnection();
		String sql = "select * from vocabularycontent where vocabularyguidelineid = ?";
		PreparedStatement p = con.prepareStatement(sql);
		p.setInt(1, id);
		ResultSet rs  = p.executeQuery();
		while (rs.next()) {
					arr.add(new vocabularycontent(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
		}
		con.close();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return arr;
}




}
