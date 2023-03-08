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
            String curChar = text;
            if (curChar.equals("1")) {
                return 1;
            }
            if (curChar.equals("2")) {
                return 2;
            }
            if (curChar.equals("3")) {
                return 3;
            }
            if (curChar.equals("4")) {
                return 4;
            }
            if (curChar.equals("5")) {
                return 5;
            }
            if (curChar.equals("6")) {
                return 6;
            }
            if (curChar.equals("7")) {
                return 7;
            }
            if (curChar.equals("8")) {
                return 8;
            }
            if (curChar.equals("9")) {
                return 9;
            } else {
                return 0;
            }
    }

    public TimeDuration parseFromHMSString(String time) {
        TimeDuration result = new TimeDuration(hours, minutes, seconds);
        for (int index = 0; index < time.length(); index++) {
            if (time.substring(index+1, index+2).equals("m")) {
                minutes = strToInt(time.substring(index, index+1));
            } else if (time.substring(index+1, index+2).equals(" ") && time.substring(index+2, index+3).equals("m")) {
                minutes = strToInt(time.substring(index, index+1));
            } else if (time.substring(index+1, index+2).equals(" ") && time.substring(index+2, index+3).equals("h")) {
                hours = strToInt(time.substring(index, index+1));
            } else if (time.substring(index+1, index+2).equals("h")) {
                hours = strToInt(time.substring(index, index+1));
            } else if (time.substring(index+1, index+2).equals("s")) {
                seconds = strToInt(time.substring(index, index+1));
            } else if (time.substring(index+1, index+2).equals(" ") && time.substring(index+2, index+3).equals("s")) {
                seconds = strToInt(time.substring(index, index+1));
            }
        }
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
        
    }
}
