
package dao;
import clases.Compra;

import java.sql.SQLException;
import java.util.List;

import dao.MainMoves;
public class DaoCompra extends MainMoves implements MainMovesInterface{
	public static final String TABLE_NAME="Compra";
	public static final String PRIMARY_KEY="id";
	public static final String SECONDARY_KEY="";

	@Override
	public Object getObject(String key){
		try {
			return new Compra(getRow(TABLE_NAME,PRIMARY_KEY,key));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public Object getObject(String cliente,String fecha){
		String qry="SELECT * FROM "+TABLE_NAME+" WHERE cliente= '"+cliente+"' and fecha = '"+fecha+"';";
		int cols= countColsFromTable(TABLE_NAME);
		try {
			rs = st.executeQuery (qry);
			String arg[]=new String[cols];
			while(rs.next()){
				for(int i=0;i<cols;i++){
					arg[i]=rs.getString((i+1));
				}
			}
			printQry(qry);
			return new Compra(arg);
		} catch (SQLException e) {
			System.out.println(e);
			printQry(qry);
			return null;
		}catch (Exception e){
			return null;
		}
	}
	@Override
	public Object getObjectBySecondaryKey(String key){
		try {
			return new Compra(getRow(TABLE_NAME,SECONDARY_KEY,key));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean objectToNewRow(Object obj){
		Compra _Compra=(Compra)obj;
		String qry=getPStatementInsertInto(TABLE_NAME);
		try{
			ps=conn.prepareStatement(qry);
			ps.setInt(1, _Compra.getId());
			ps.setInt(2, _Compra.getCliente().getPersona().getId());
			ps.setInt(3, _Compra.getVendedor().getPersona().getId());
			ps.setDouble(4, _Compra.getTotal());
			ps.setString(5, _Compra.getFecha());
			System.out.println(ps.toString());
			ps.executeUpdate();
			printQry(qry);
			return true;
		}catch(Exception e){
			printQry(qry);
			System.out.println(e);
			return false;
		}
	}
	@Override
	public String getCellValue(String fieldToGet, String key){
		return getCell(fieldToGet, TABLE_NAME, PRIMARY_KEY, key);
	}
	@Override
	public boolean deleteRow(String id){
		if(deleteRow(TABLE_NAME, PRIMARY_KEY, id))return true;
		return false;
	}
	@Override
	public boolean modify(String fieldToModify, String newValue, String key){
		if(modifyField(TABLE_NAME, fieldToModify, newValue, PRIMARY_KEY, key))return true;
		return false;
	}
	@Override
	public String[] rowToString(String key){
		return getRow(TABLE_NAME, PRIMARY_KEY, key);
	}
	@Override
	public String[] rowToStringBySecondaryKey(String key){
		return getRow(TABLE_NAME, SECONDARY_KEY, key);
	}
	@Override
	public List<String[]> getAllToList(){
		return getAllToList(new Compra(), TABLE_NAME);
	}
	@Override
	public List<String[]> getSearchToList(String field, String key){
		return getSearchToList(new Compra(), TABLE_NAME,field,key);
	}
	@Override
	public String[] getItemsToArray(int item){
		try{
			List<String[]> l=getAllToList();
			String[]array=new String[l.size()];
			for(int i=0;i<l.size();i++){
				array[i]=l.get(i)[item];
			}
			return array;
		}catch(Exception e){
			e.printStackTrace();
		return null;
		}
	}
}
