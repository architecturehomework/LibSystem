package util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TimeUtil {

    public static Timestamp calScheduleTime(Timestamp timestamp, int month) {
        String s = "";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            s = df.format(timestamp);
            System.out.println(s);
            int y = Integer.parseInt(s.substring(0, 4));
            int m = Integer.parseInt(s.substring(5, 7));
            String newY = String.valueOf(y + (month + m - 1) / 12);
            String newM = String.valueOf((month + m - 1) % 12 + 1);
            return Timestamp.valueOf(newY + "-" + newM + s.substring(7));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return timestamp;
    }

    public static String getTimeString(Timestamp timestamp) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(timestamp);
    }

    public static int getOverdue(Timestamp scheduleTime, Timestamp endTime) {
        return (int)((endTime.getTime() - scheduleTime.getTime())/(3600*1000*24));
    }
}
