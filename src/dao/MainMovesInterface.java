/*code written by: Alejandro Garcia @jano*/
/*2017/08/31*/
/*imTheJano@facebook.com*/
package dao;
import java.util.List;
public interface MainMovesInterface {
	public Object getObject(String key);
	public Object getObjectBySecondaryKey(String key);
	public boolean objectToNewRow(Object obj);
	public String getCellValue(String fieldToGet, String keyValue);
	public boolean deleteRow(String id);
	public boolean modify(String fieldToModify, String newValue, String keyValue);
	public String[] rowToString(String keyValue);
	public String[] rowToStringBySecondaryKey(String keyValue);
	public List<String[]> getAllToList();
	public List<String[]> getSearchToList(String field, String key);
	public String[] getItemsToArray(int item);
}
/*code written by: Alejandro Garcia @jano*/
/*2017/08/31*/
/*imTheJano@facebook.com*/