package android.newapi.Utils;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class utlis {
    private static Date date;
    public static ColorDrawable[] LightColorLists =
            {
                    new ColorDrawable(Color.parseColor("#ffeead")),
                    new ColorDrawable(Color.parseColor("#93cfb3")),
                    new ColorDrawable(Color.parseColor("#1ba798")),
                    new ColorDrawable(Color.parseColor("#6aa9ae")),
                    new ColorDrawable(Color.parseColor("#ffbf27")),
                    new ColorDrawable(Color.parseColor("#d93947")),
                    new ColorDrawable(Color.parseColor("#fd7a7a")),
                    new ColorDrawable(Color.parseColor("#faca5f"))
            };

    public static ColorDrawable getRandomdrawbleColor() {
        int index = new Random().nextInt(LightColorLists.length);
        return LightColorLists[index];
    }

    public static String DateFormat(String oldstringDate){
        String newsDate;
        SimpleDateFormat dateFormat = new SimpleDateFormat("E, d MMM yyyy", new Locale(getCountry()));
        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(oldstringDate);
            newsDate = dateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            newsDate = oldstringDate;
        }
        return newsDate;
    }

    public static String DateToTimeFormats(String oldDate){

        String TimeFomart = null;
        PrettyTime p = new PrettyTime(new Locale(getCountry()));
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'",
                    Locale.ENGLISH);
            date = sdf.parse(oldDate);
            TimeFomart = p.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return TimeFomart;
    }



    public static String getCountry(){
        Locale locale = Locale.getDefault();
        String country = String.valueOf(locale.getCountry());
        return country.toLowerCase();
    }
}
