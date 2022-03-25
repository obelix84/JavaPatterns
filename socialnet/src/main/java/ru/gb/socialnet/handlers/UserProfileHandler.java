package ru.gb.socialnet.handlers;

import org.json.JSONArray;
import org.json.JSONObject;

public class UserProfileHandler extends JsonHandler {
    @Override
    public void handle(JSONArray ja) {
        for (int i = 0; i < ja.length(); i++) {
            JSONObject jo = ja.getJSONObject(i);
            if(jo.getInt("command") == 2) {
                //Инкапсулируем все действия с UserProfileService
                System.out.println(jo);
            }
        }
        handleNext(ja);
    }
}
