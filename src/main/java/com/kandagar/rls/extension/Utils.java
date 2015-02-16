package com.kandagar.rls.extension;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class Utils {

	public static Date convertStringToDate(String date, String format)
	{
	    Date dateValue = null;
	    DateFormat df = new SimpleDateFormat(format);
	    try{
	    	dateValue = df.parse(date);
	    }catch ( Exception ex ){
	    }
	    return dateValue;
	}
	
    public static String plural(Integer val, String[] plurals) {
        String result = StringUtils.EMPTY;
        if(val != null){
	    	int index = (val % 10 == 1 && val % 100 != 11 ? 0 :
	                (val % 10 >= 2 && val % 10 <= 4 &&
	                        (val % 100 < 10 || val % 100 >= 20) ? 1 : 2));
	    	result = String.format("%s %s", val, plurals[index]);
        }
        return result;
    }

    public static String pluralAge(Integer age) {
        return plural(age, new String[] {"год", "года", "лет"});
    }
	
}
