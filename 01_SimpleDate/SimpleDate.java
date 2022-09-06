import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class SimpleDate {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.println(today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        System.out.println(today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
        System.out.println(today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        System.out.println(today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));

    }
}