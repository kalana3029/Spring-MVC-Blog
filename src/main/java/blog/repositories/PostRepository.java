package blog.repositories;

import blog.models.Post;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by Developer PC on 2/24/2018.
 */
@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    @Query("SELECT p FROM Post p LEFT JOIN FETCH p.author ORDER BY p.id DESC")
    List<Post> findLatest5Posts(org.springframework.data.domain.Pageable pageable);
}
