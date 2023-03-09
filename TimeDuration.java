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
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        if (hIndex > -1) {
            if (time.substring(hIndex-1, hIndex).equals(" ")) {
                hours = Integer.parseInt(time.substring(0, hIndex-1));
            } else {
                hours = Integer.parseInt(time.substring(0, hIndex));
            }
        }
        if (mIndex > -1) {
            if (time.substring(mIndex-1, mIndex).equals(" ") && hIndex > -1) {
                minutes = Integer.parseInt(time.substring(hIndex+3, mIndex-1));
            } else if (time.substring(mIndex-1, mIndex).equals(" ") && hIndex == -1) {
                minutes = Integer.parseInt(time.substring(0, mIndex-1));
            } else if (!time.substring(mIndex-1, mIndex).equals(" ") && hIndex > -1) {
                minutes = Integer.parseInt(time.substring(hIndex+3, mIndex));
            } else if (!time.substring(mIndex-1, mIndex).equals(" ") && hIndex == -1) {
                minutes = Integer.parseInt(time.substring(0, mIndex));
            }
        }
        if (sIndex > -1) {
            if (mIndex > -1) {
                if (time.substring(sIndex-1, sIndex).equals(" ")) {
                    seconds = Integer.parseInt(time.substring(mIndex+3, sIndex-1));
                } else {
                    seconds = Integer.parseInt(time.substring(mIndex+3, sIndex));
                }
            } else if (mIndex == -1 && hIndex > -1) {
                if (time.substring(sIndex-1, sIndex).equals(" ")) {
                    seconds = Integer.parseInt(time.substring(hIndex+3, sIndex-1));
                } else {
                    seconds = Integer.parseInt(time.substring(hIndex+3, sIndex));
                }
            } else if (mIndex == -1 && hIndex == -1) {
                if (time.substring(sIndex-1, sIndex).equals(" ")) {
                    seconds = Integer.parseInt(time.substring(0, sIndex-1));
                } else {
                    seconds = Integer.parseInt(time.substring(0, sIndex));
                }
            }
        }
        // int hours = Integer.parseInt(time.substring(0, hIndex-1));
        // int minutes = Integer.parseInt(time.substring(hIndex+3, mIndex-1));
        // int seconds = Integer.parseInt(time.substring(mIndex+3, sIndex-1));
        TimeDuration result = new TimeDuration(hours, minutes, seconds);
        return result;
    }


    public static TimeDuration parseFromColonString(String time) {
        int firstColonIndex = time.indexOf(":");
        int secondColonIndex = time.indexOf(":", firstColonIndex+1);
        int hours = Integer.parseInt(time.substring(0, firstColonIndex));
        int minutes = Integer.parseInt(time.substring(firstColonIndex+1, secondColonIndex));
        int seconds = Integer.parseInt(time.substring(secondColonIndex+1, time.length()));
        TimeDuration result = new TimeDuration(hours, minutes, seconds);
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
        System.out.println(parseFromHMSString("5 m, 12s"));
        System.out.println(parseFromColonString("2:2:2"));
    }
}
