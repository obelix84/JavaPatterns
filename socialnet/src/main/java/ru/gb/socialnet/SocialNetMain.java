package ru.gb.socialnet;

import ru.gb.socialnet.db.DatabaseHandler;
import ru.gb.socialnet.domain.UserProfile;
import ru.gb.socialnet.domain.UserProfileBuilder;
import ru.gb.socialnet.repository.FriendsRepository;
import ru.gb.socialnet.repository.UserProfileRepository;
import ru.gb.socialnet.service.UserProfileService;

public class SocialNetMain {

    public static void main(String[] args) {

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

        DatabaseHandler dbh = DatabaseHandler.getDbh();
        UserProfileService userServ = new UserProfileService(dbh);
        System.out.println(userServ.findUserProfileById(1L));
        System.out.println(userServ.findUserProfileById(2L));
        System.out.println(userServ.findUserProfileById(3L));

        //upRepo.disconnect();
    }
}
