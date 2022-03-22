package ru.gb.socialnet.service;

import ru.gb.socialnet.db.DatabaseHandler;
import ru.gb.socialnet.domain.UserProfile;
import ru.gb.socialnet.domain.UserProfileBuilder;
import ru.gb.socialnet.repository.FriendsRepository;
import ru.gb.socialnet.repository.UserProfileRepository;

public class UserProfileService {
    private final DatabaseHandler dbh;
    private final UserProfileRepository upRepo;
    private final FriendsRepository frRepo;

    public UserProfileService(DatabaseHandler dbh) {
        this.dbh = dbh;
        this.upRepo = new UserProfileRepository(dbh);
        this.frRepo = new FriendsRepository(dbh);
    }

    public UserProfile findUserProfileById(Long id) {
        //не корректная обработка Optional
        UserProfile user = upRepo.findById(id).get();
        user.setFriends(frRepo.findAllById(id));
        return user;
    }
}
