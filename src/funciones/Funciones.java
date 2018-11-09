package funciones;

import java.awt.Toolkit;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Funciones {
	public static String getAbsolutePath(){
		return(new File ("").getAbsolutePath ());
	}
	public static String capitalizeFirstLetter(String string) {
		char[] chars = string.toCharArray();
		boolean found = false;
		for (int i = 0; i < chars.length; i++) {
			if (!found && Character.isLetter(chars[i])) {
				chars[i] = Character.toUpperCase(chars[i]);
				found = true;
			} else if (Character.isWhitespace(chars[i]) || chars[i]=='.' || chars[i]=='\'') { // You can add other chars here
				found = false;
			}
		}
		return String.valueOf(chars);
	}
	public static Date stringToDate(String str) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = formatter.parse(str);
			return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
	public static String dateToString(Date date) {
		try {
			@SuppressWarnings("deprecation")
			String d=(date.getYear()+1900)+"-"+(date.getMonth()+1)+"-"+date.getDate();
			return d;
        } catch (Exception e) {
            return null;
        }
	}
	public static String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return(dateFormat.format(date));
	}
	public static void writeOnFile(String path, String str, boolean overWrite) throws IOException {
		File file=new File(path);
		FileWriter fw=new FileWriter(file,overWrite);
		PrintWriter pw=new PrintWriter(fw);
		pw.println(str);
		fw.close();
	}
	public static String[] readFileByLines(String path) throws IOException {
		File file=new File(path);
		FileReader f = new FileReader(file);
		BufferedReader b = new BufferedReader(f);
		String str;
		List<String> list=new ArrayList<String>();
		while((str = b.readLine())!=null) {
			list.add(str);
		}
		b.close();
		String[] line=new String[list.size()];
		for(int i=0;i<list.size();i++) {
			line[i]=list.get(i);
		}
		return line;
	}
	public void setClipboard(String str){
		try{
			StringSelection ss = new StringSelection(str);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,(ClipboardOwner) this);
			//Notification.showNotification((StringsStd.BFItemCopied[Standars.LANGUAGE]), 2);
		}catch (Exception e){e.printStackTrace();}
	}
	public static boolean isNum(String strNum) {
	    boolean ret = true;
	    try {
	    	Double.parseDouble(strNum);
	    }catch (NumberFormatException e) {
	        ret = false;
	    }
	    return ret;
	}
}
