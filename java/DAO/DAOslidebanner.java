package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import BEAN.slidebanner;
import DB.MySQL;

public class DAOslidebanner {
   public static ArrayList<slidebanner> selectAll()
   {
	   ArrayList<slidebanner> arr = new ArrayList<slidebanner>();
	   
	   try {
		Connection con = MySQL.getConnection();
		String sql = "select * from slidebanner";
		PreparedStatement p = con.prepareStatement(sql);
		ResultSet rs = p.executeQuery();
		while(rs.next())
		{
			arr.add(new slidebanner(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4)));
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	   return arr;
   }  
}
