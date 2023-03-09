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


    public static TimeDuration parseFromHMSString(String time) {
        int hIndex = time.indexOf("h");
        int mIndex = time.indexOf("m");
        int sIndex = time.indexOf("s");
        int hours = Integer.parseInt(time.substring(0, hIndex-1));
        int minutes = Integer.parseInt(time.substring(hIndex+3, mIndex-1));
        int seconds = Integer.parseInt(time.substring(mIndex+3, sIndex-1));
        TimeDuration result = new TimeDuration(hours, minutes, seconds);
        return result;
    }

    public static TimeDuration parseFromColonString(String time) {
        int colonIndex = time.indexOf(":");
        int minutes = Integer.parseInt(time.substring(0, colonIndex));
        int seconds = Integer.parseInt(time.substring(colonIndex+1,time.length()));
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
        System.out.println(parseFromHMSString("12 h, 30 m, 7 s"));
        System.out.println(parseFromColonString("2:20"));
    }
}
