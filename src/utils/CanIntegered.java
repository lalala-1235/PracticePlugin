package utils;

public class CanIntegered {
    public static boolean check(String checkstring) {
        try {
            Integer.parseInt(checkstring);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }
}
