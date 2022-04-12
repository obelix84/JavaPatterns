package ru.gb.socialnet.service;

import org.springframework.stereotype.Service;
import ru.gb.socialnet.db.DatabaseHandler;
import ru.gb.socialnet.domain.UserProfile;
import ru.gb.socialnet.repository.FriendsRepository;
import ru.gb.socialnet.repository.UserProfileRepository;

import java.util.List;

@Service
public class UserProfileService {
    private final UserProfileRepository upRepo;
    private final FriendsRepository frRepo;

    public UserProfileService(UserProfileRepository upRepo, FriendsRepository frRepo) {
        this.upRepo = upRepo;
        this.frRepo = frRepo;
    }

    public UserProfile findUserProfileById(Long id) {
        //не корректная обработка Optional
        UserProfile user = upRepo.findById(id).get();
        user.setFriends(frRepo.findAllById(id));
        return user;
    }

    public List<UserProfile> findAll() {
        return upRepo.findAll();
    }
}
