
package dao;
import clases.ProductoCompra;
import java.util.List;

import dao.MainMoves;
public class DaoProductoCompra extends MainMoves implements MainMovesInterface{
	public static final String TABLE_NAME="ProductoCompra";
	public static final String PRIMARY_KEY="";
	public static final String SECONDARY_KEY="";

	@Override
	public Object getObject(String key){
		return null;
	}
	@Override
	public Object getObjectBySecondaryKey(String key){
		return null;
	}
	@Override
	public boolean objectToNewRow(Object obj){
		ProductoCompra _ProductoCompra=(ProductoCompra)obj;
		String qry=getPStatementInsertInto(TABLE_NAME);
		try{
			ps=conn.prepareStatement(qry);
			ps.setInt(1, _ProductoCompra.getProducto().getId());
			ps.setInt(2, _ProductoCompra.getCompra().getId());
			ps.setInt(3, _ProductoCompra.getCantidad());
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
		return getAllToList(new ProductoCompra(), TABLE_NAME);
	}
	@Override
	public List<String[]> getSearchToList(String field, String key){
		return getSearchToList(new ProductoCompra(), TABLE_NAME,field,key);
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
