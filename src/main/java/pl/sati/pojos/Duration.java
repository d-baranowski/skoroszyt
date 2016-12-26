package pl.sati.pojos;

import java.util.concurrent.TimeUnit;

public class Duration {
    private long millis;

    public Duration(long from, long to) {
        millis = to - from;
    }

    public Duration() {
        millis = 0;
    }


    public void add(Duration d) {
        this.millis += d.getMillis();
    }

    private long getMillis() {
        return millis;
    }

    public String getDurationBreakdown() {
        if(millis < 0) {
            throw new IllegalArgumentException("Duration must be greater than zero!");
        }


        StringBuilder sb = new StringBuilder(64);
        sb.append(" Ulamek: ");

        double a = millis / (1000.00 * 60.00 * 60.00);
        double roundOff = (double) Math.round(a * 100) / 100;
        sb.append(roundOff);

        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);

        sb.append(" Godziny: ");
        sb.append(hours);
        sb.append(" Minuty: ");
        sb.append(minutes);


        return sb.toString();
    }
}
