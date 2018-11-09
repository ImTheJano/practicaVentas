
package dao;
import clases.Persona;

import java.sql.SQLException;
import java.util.List;

import dao.MainMoves;
public class DaoPersona extends MainMoves implements MainMovesInterface{
	public static final String TABLE_NAME="Persona";
	public static final String PRIMARY_KEY="id";
	public static final String SECONDARY_KEY="";

	@Override
	public Object getObject(String key){
		try {
			return new Persona(getRow(TABLE_NAME,PRIMARY_KEY,key));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public Object getObjectBySecondaryKey(String key){
		return null;
		/**/
	}
	public Object getObject(String nombre, String apPat, String apMat) {
		String qry="SELECT * FROM "+TABLE_NAME+" WHERE nombre = '"+nombre+"' and apellidoPat= '"+apPat+"' and apellidoMat= '"+apMat+"'";
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
			return new Persona(arg);
		} catch (SQLException e) {
			System.out.println(e);
			printQry(qry);
			return null;
		}catch (Exception e){
			return null;
		}
	}
	@Override
	public boolean objectToNewRow(Object obj){
		Persona _Persona=(Persona)obj;
		String qry=getPStatementInsertInto(TABLE_NAME);
		try{
			ps=conn.prepareStatement(qry);
			ps.setInt(1, _Persona.getId());
			ps.setString(2, _Persona.getNombre());
			ps.setString(3, _Persona.getApellidoPat());
			ps.setString(4, _Persona.getApellidoMat());
			ps.setString(5, _Persona.getFechaNac());
			ps.setString(6, _Persona.getDireccion());
			ps.setString(7, _Persona.getEmail());
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
		return getAllToList(new Persona(), TABLE_NAME);
	}
	@Override
	public List<String[]> getSearchToList(String field, String key){
		return getSearchToList(new Persona(), TABLE_NAME,field,key);
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
