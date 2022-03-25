package ru.gb.socialnet;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.gb.socialnet.db.DatabaseHandler;
import ru.gb.socialnet.handlers.ChannelHandler;
import ru.gb.socialnet.handlers.JsonHandler;
import ru.gb.socialnet.handlers.UserProfileHandler;
import ru.gb.socialnet.repository.ChannelRepository;

public class SocialNetMain {

    public static void main(String[] args) {

       ChannelRepository channelRepo = new ChannelRepository(DatabaseHandler.getDbh());
       System.out.println(channelRepo.findById(1L));
        System.out.println(channelRepo.findById(1L));
        System.out.println(channelRepo.findById(1L));


//        JSONArray ja = new JSONArray();
//
//        JSONObject jo = new JSONObject();
//        jo.put("command", "1");
//
//        JSONObject jo1 = new JSONObject();
//        jo1.put("command", "2");
//
//        ja.put(jo);
//        ja.put(jo1);
//
//        System.out.println(ja);
//
//        JsonHandler channelHandler = new ChannelHandler();
//        JsonHandler userProfileHandler= new UserProfileHandler();
//        channelHandler.setNext(userProfileHandler);
//        channelHandler.handle(ja);

//        UserProfileBuilder userBuilder = new UserProfileBuilder();
//        userBuilder.setId(1);
//        userBuilder.setFName("User1");
//        System.out.println(userBuilder.getResult().toString());

//        DatabaseHandler dbh = DatabaseHandler.getDbh();
////        UserProfileRepository upRepo = new UserProfileRepository(dbh);
////        System.out.println(upRepo.findById(3L));
////        System.out.println(upRepo.findById(2L));
////        System.out.println(upRepo.findById(1L));
////
////        FriendsRepository frRepo = new FriendsRepository(dbh);
////        System.out.println(frRepo.findAllById(1L));



        //upRepo.disconnect();
    }
}
