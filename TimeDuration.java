import java.sql.Time;

public class TimeDuration {
    private int hours;
    private int minutes;
    private int seconds;

    public TimeDuration(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    private static int strToInt(String text) {
            String curNum = text;
            if (curNum.equals("1")) {
                return 1;
            }
            if (curNum.equals("2")) {
                return 2;
            }
            if (curNum.equals("3")) {
                return 3;
            }
            if (curNum.equals("4")) {
                return 4;
            }
            if (curNum.equals("5")) {
                return 5;
            }
            if (curNum.equals("6")) {
                return 6;
            }
            if (curNum.equals("7")) {
                return 7;
            }
            if (curNum.equals("8")) {
                return 8;
            }
            if (curNum.equals("9")) {
                return 9;
            } else {
                return 0;
            }
    }

    public static TimeDuration parseFromHMSString(String time) {
        int hIndex = time.indexOf("h");
        int mIndex = time.indexOf("m");
        int sIndex = time.indexOf("s");
        int hours = strToInt(time.substring(0, hIndex));
        int minutes = strToInt(time.substring(hIndex+1, mIndex));
        int seconds = strToInt((time.substring(mIndex+1, sIndex)));
        TimeDuration result = new TimeDuration(hours, minutes, seconds);
        return result;
    }

    public static TimeDuration parseFromColonString(String time) {
        int colonIndex = time.indexOf(":");
        int minutes = strToInt(time.substring(0, colonIndex));
        int seconds = strToInt(time.substring(colonIndex+1, time.length()));
        TimeDuration result = new TimeDuration(0, minutes, seconds);
        return result;
    }

    public String toString() {
        String result = "";
        if (hours < 10) {
            result += "0"+hours+":";
        } else {
            result += hours+":";
        }
        if (minutes < 10) {
            result += "0"+minutes+":";
        } else {
            result += minutes+":";
        }
        if (seconds < 10) {
            result += "0"+seconds;
        } else {
            result += seconds;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(parseFromColonString("20:04"));
    }
}
