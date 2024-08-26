package com.framework.utility;

import android.content.Context;

import java.util.Locale;

/**
 * Created by farzad.sarseify on 12/05/2017.
 */

public class LocalizationUtils {

    public enum  LocationEnum {

        DEFAULT  ("default",100),
        AZ("az",4),
        BN("bn",6),
        ZH("zh",7),
        EN("en",9),
        FR("fr",11),
        DE("de",14),
        IN("in",15),
        MS("ms",16),
        FA("fa",18),
        RU("ru",20),
        TH("th",22),
        TR("tr",26),
        ;

        private final String location_code;
        private final int location_int;

        LocationEnum(String location_code, int location_int) {
            this.location_code = location_code;
            this.location_int = location_int;
        }

        public String getLocation_code() {
            return this.location_code;
        }

        public int getLocation_int() {
            return this.location_int;
        }

        public static LocationEnum findLocal(String location_code){
            for(LocationEnum v : values()){
                if( v.getLocation_code().equals(location_code)){
                    return v;
                }
            }
            return DEFAULT;
        }
    }

    Context context;

    private LocalizationUtils() {
    }

    public LocalizationUtils(Context context) {
        this.context = context;
    }


    public static String getDisplayLanguage() {

        return Locale.getDefault().getDisplayLanguage();

    }


    public static String getISO3Language() {

        return Locale.getDefault().getISO3Language();

    }

    public static String getLanguage() {

        return Locale.getDefault().getLanguage();

    }

    /**
     * Used to check localization of device for download new translation files
     *
     * @param language get languages code iso

     */
    public static int checkTranslation(String language) {

        LocationEnum locationEnum = LocationEnum.findLocal(language);

        return locationEnum.getLocation_int();

    }


}
