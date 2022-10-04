package sk.umb.fpv.peaks.evacc.common;

import java.time.format.DateTimeFormatter;

public class Utils {
    public static DateTimeFormatter EuropeanDateFormatter = DateTimeFormatter.ofPattern("d.M.uuuu");
    public static DateTimeFormatter MadarskyDateFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");
}
