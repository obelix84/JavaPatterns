package ru.gb.socialnet.handlers;

import org.json.JSONArray;
import org.json.JSONObject;

public class ChanelHandler extends JSONHandler {
    @Override
    public void handle(JSONArray ja) {
            for (int i = 0; i < ja.length(); i++) {
                JSONObject jo = ja.getJSONObject(i);
                if(jo.getInt("command") == 1) {
                    //Инкапсулируем все действия с ChannelService
                    System.out.println(jo);
                }
            }
            handleNext(ja);
    }
}
