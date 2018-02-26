package blog.repositories;

import blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Developer PC on 2/24/2018.
 */
@Repository
public interface UserReposiory extends JpaRepository<User,Long>{
}
