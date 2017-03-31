package utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Julia on 15.03.2017.
 */
public class CurrentDate {

    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        return date1;
    }
}
