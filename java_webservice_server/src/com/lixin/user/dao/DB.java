package com.lixin.user.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lixin.model.Role;
import com.lixin.model.StuAndRole;

public class DB {
	
	private Connection  conn;
	
	public  DB()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/thzmdb2", 
					"root", "123456");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List   queryRoleData()
	{
		String sql="SELECT  *  FROM   t_role";
		
		List<Role>  lists  = new ArrayList<Role>();
		
		try {
			PreparedStatement  pstmt=conn.prepareStatement(sql);
		 
			ResultSet  rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				Role  role  = new Role();
				role.setRid(rs.getInt(1));
				role.setRname(rs.getString(2));
				
				lists.add(role);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(null!=conn)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return lists;
	}
	public  List   queryRoleGroupCount()
	{
    String sql="SELECT  rname,COUNT(sjob)    FROM  t_stus  RIGHT  JOIN  t_role ON sjob=rid  GROUP BY  rname";
		
		List<StuAndRole>  lists  = new ArrayList<StuAndRole>();
		
		try {
			PreparedStatement  pstmt=conn.prepareStatement(sql);
		 
			ResultSet  rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				StuAndRole  crole  = new StuAndRole();
				crole.setRname(rs.getString(1));
				crole.setRcount(rs.getInt(2));
				
				lists.add(crole);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(null!=conn)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return lists;
	}
	
	public  String   queryStuAndkmCount(String  stuName)
	{
       String sql="SELECT COUNT(kid),sname  FROM (SELECT   * FROM  t_stus  WHERE  sname=?) tmp INNER  JOIN  " +
    		" t_score  ON tmp.sid=t_score.sid  GROUP  BY sname";
		
       String data="";
		
		try {
			PreparedStatement  pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,stuName);
			ResultSet  rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				data=rs.getInt(1)+","+rs.getString(2);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(null!=conn)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return data;
	}
}
