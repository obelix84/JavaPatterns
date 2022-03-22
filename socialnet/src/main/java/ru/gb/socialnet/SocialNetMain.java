package ru.gb.socialnet;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.gb.socialnet.db.DatabaseHandler;
import ru.gb.socialnet.domain.UserProfile;
import ru.gb.socialnet.domain.UserProfileBuilder;
import ru.gb.socialnet.handlers.ChanelHandler;
import ru.gb.socialnet.handlers.UserProfileHandler;
import ru.gb.socialnet.repository.FriendsRepository;
import ru.gb.socialnet.repository.UserProfileRepository;
import ru.gb.socialnet.service.UserProfileService;

import java.util.List;

public class SocialNetMain {

    public static void main(String[] args) {

        JSONArray ja = new JSONArray();

        JSONObject jo = new JSONObject();
        jo.put("command", "1");

        JSONObject jo1 = new JSONObject();
        jo1.put("command", "2");

        ja.put(jo);
        ja.put(jo1);

        System.out.println(ja);

        ChanelHandler CH = new ChanelHandler();
        UserProfileHandler UPH = new UserProfileHandler();
        CH.setNext(UPH);
        UPH.handle(ja);

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
