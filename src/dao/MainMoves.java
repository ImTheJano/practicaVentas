
package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.General;
import bd.ConnectionDB;
public class MainMoves extends ConnectionDB {
	public static PreparedStatement ps;
	public static Statement st;
	public static ResultSet rs;
	private static final String DATA_BASE_NAME=General.DB_NAME;
	
	public MainMoves(){
		try {
			connect();
			st=conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initMoves(){
		try {
			connect();
			st=conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static int countColsFromTable(String tableName){
		String qry="SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME='"
				+tableName+"' AND TABLE_SCHEMA='"+DATA_BASE_NAME+"';";
		try {
			rs = st.executeQuery (qry);
			int arg=0;
			while(rs.next()){
				arg=rs.getInt((1));
			}
			printQry(qry);
			return arg;
		} catch (SQLException e) {
			System.out.println(e);
			printQry(qry);
			return 0;
		}
	}
	public String[] getRow(String fromTableName, String keyField, String keyValue){
		String qry="SELECT * FROM "+fromTableName+" WHERE "+keyField+"= '"+keyValue+"'";
		int cols= countColsFromTable(fromTableName);
		try {
			rs = st.executeQuery (qry);
			String arg[]=new String[cols];
			while(rs.next()){
				for(int i=0;i<cols;i++){
					arg[i]=rs.getString((i+1));
				}
			}
			printQry(qry);
			return arg;
		} catch (SQLException e) {
			System.out.println(e);
			printQry(qry);
			return null;
		}catch (Exception e){
			return null;
		}
	}
	public String getCell(String fieldToGet, String fromTableName, String keyField, String keyValue){
		String qry="SELECT "+fieldToGet+" FROM "+fromTableName+" WHERE "+keyField+"= '"+keyValue+"'";
		try {
			rs = st.executeQuery (qry);
			String arg="";
			while(rs.next()){
				arg=rs.getString((1));
			}
			printQry(qry);
			return arg;
		} catch (SQLException e) {
			System.out.println(e);
			printQry(qry);
			return "";
		}
	}
	public String getPStatementInsertInto(String tableName){
		int n=countColsFromTable(tableName);
		String qry="INSERT INTO "+tableName+" VALUES ( ";
		for(int i=0;i<n;i++){
			qry+=" ?";
			if (i<n-1){
				qry+=",";
			}
		}
		qry+=" )";
		return qry;
	}
	public ResultSet getAllToRS(String fromTableName){
		String qry="SELECT * FROM "+fromTableName+";";
		try {
			rs = st.executeQuery (qry);
			printQry(qry);
			return rs;
		} catch (SQLException e) {
			System.out.println(e);
			printQry(qry);
			return null;
		}
	}
	public ResultSet consult(String qry){
		try {
			rs = st.executeQuery (qry);
			return rs;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}
	public List<String[]> getAllToList(Object obj, String fromTableName){
		ArrayList<String[]> list=new ArrayList<String[]>();
		String qry="SELECT * FROM "+fromTableName+";";
		try {
			int cols=countColsFromTable(fromTableName);
			rs = st.executeQuery (qry);
			while(rs.next()){
				String arg[]=new String[cols];
				for(int i=0;i<cols;i++){
					arg[i]=rs.getString((i+1));
				}
				list.add(arg);
			}
			printQry(qry);
			return list;
		} catch (SQLException e) {
			System.out.println(e);
			printQry(qry);
			return null;
		}
	}
	public List<String[]> getSearchToList(Object obj, String fromTableName,String field,String key){
		ArrayList<String[]> list=new ArrayList<String[]>();
		String qry="SELECT * FROM "+fromTableName+" WHERE "+field+" LIKE '%"+key+"%' ;";
		try {
			int cols=countColsFromTable(fromTableName);
			rs = st.executeQuery (qry);
			while(rs.next()){
				String arg[]=new String[cols];
				for(int i=0;i<cols;i++){
					arg[i]=rs.getString((i+1));
				}
				list.add(arg);
			}
			printQry(qry);
			return list;
		} catch (SQLException e) {
			System.out.println(e);
			printQry(qry);
			return null;
		}
	}
	public boolean modifyField(String tableName,String fieldToModify,String newValue,String keyField, String keyValue){
		String qry="UPDATE "+tableName+" "+" SET "+fieldToModify+"=\""+newValue+"\" WHERE "+keyField+"="+keyValue;
		try{
			ps =conn.prepareStatement(qry);
			ps.executeUpdate();
			printQry(qry);
			return true;
		}catch(Exception e){
			System.out.println(e);
			printQry(qry);
			return false;
		}
	}
	public boolean deleteRow(String tableName, String fieldId, String id){
		String qry="DELETE FROM "+tableName+" WHERE "+fieldId+"="+id;
		try{
			ps =conn.prepareStatement(qry);
			ps.executeUpdate();
			printQry(qry);
			return true;
		}catch(Exception e){
			System.out.println(e);
			printQry(qry);
			return false;
		}
	}
	public boolean isThere(String fromTableName, String keyField, String keyValue){
		boolean a=false;
		String qry="SELECT * FROM "+fromTableName+" WHERE "+keyField+"= '"+keyValue+"'";
		try {
			rs = st.executeQuery (qry);
			printQry(qry);
			if (rs.next()){
				System.out.println("row found");
				a= true;
			}
			else
				a= false;
		} catch (SQLException e) {
			System.out.println(e);
		printQry(qry);
			a= false;
		}
		return a;
	}
	public int countRows(String tableName){
		String qry="SELECT COUNT(*) FROM "+tableName+";";
		try {
			rs = st.executeQuery (qry);
			int arg=0;
			while(rs.next()){
			arg=rs.getInt((1));
		}
		printQry(qry);
		return arg;
		} catch (SQLException e) {
			System.out.println(e);
			printQry(qry);
			return 0;
		}
	}
	public static void printQry(String qry) {
		System.out.println(qry);
	}
	public int getLastId(String tableName, String idField){
		String qry="SELECT MAX("+idField+") AS MAXID FROM "+tableName;
		try {
			rs = st.executeQuery (qry);
			System.out.println(st.toString());
			int id=0;
			if(rs.next())
				id=rs.getInt(1);
			return id;
		} catch (SQLException e) {
			printQry(qry);
			System.out.println(e);
			return 0;
		}
	}
}

