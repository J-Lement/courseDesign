package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckIt {
	public static boolean IsNum(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
 }
	
	public static boolean IsString(String str) {
		if(str == null || "".equals(str)) {
			return false;
		}
		return true;
	}
}
