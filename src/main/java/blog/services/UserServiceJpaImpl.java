package blog.services;

import blog.models.User;
import blog.repositories.UserReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Developer PC on 2/24/2018.
 */
@Service
@Primary
public class UserServiceJpaImpl implements UserService {

    @Autowired
    private UserReposiory userRepo;

    @Override
    public boolean authenticate(String username, String password) {
        return false;
    }

    @Override
    public boolean regUser(String fullname, String username, String password) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return this.userRepo.findAll();
    }

    @Override
    public User findById(Long id) {
        return this.userRepo.findOne(id);
    }

    @Override
    public User create(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public User edit(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public void deleteById(Long id) {
        this.userRepo.delete(id);
    }
}
