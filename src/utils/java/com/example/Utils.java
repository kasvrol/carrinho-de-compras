import java.text.*;
import java.util.Locale;

public class Utils {
    static NumberFormat numberFormat = new DecimalFormat("R$ #,##0.00",
            new DecimalFormatSymbols(new Locale("pt", "BR")));

    public static String doubleToString(String value) {
        return numberFormat.format(value);
    }
}