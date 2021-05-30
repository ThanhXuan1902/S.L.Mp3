package com.example.mymusicmp3.Service;

public class APIService {
    private static String base_url = "https://adminsun1.000webhostapp.com/server/";

    public static final String PREFERENCE_NAME = "session";
    public static final String KEY_ISE_LOGGED_IN = "isLoggedIn";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_USERNAME = "username";

    public static Dataservice getService(){
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}
