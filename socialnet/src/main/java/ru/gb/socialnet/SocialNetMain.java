package ru.gb.socialnet;

import ru.gb.socialnet.db.DatabaseHandler;
import ru.gb.socialnet.domain.UserProfile;
import ru.gb.socialnet.domain.UserProfileBuilder;

public class SocialNetMain {

    public static void main(String[] args) {
        UserProfile user = new UserProfile();
        user.setFName("User");
        System.out.println(user.toString());

        UserProfileBuilder userBuilder = new UserProfileBuilder();
        userBuilder.setId(1);
        userBuilder.setFName("User1");
        System.out.println(userBuilder.getResult().toString());

        DatabaseHandler dbh = DatabaseHandler.getDbh();
        DatabaseHandler dbh1 = DatabaseHandler.getDbh();
        System.out.println(dbh);
        System.out.println(dbh1);
    }
}
