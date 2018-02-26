package blog.controllers;
import blog.forms.PostForm;
import blog.models.Post;
import blog.models.User;
import blog.services.NotificationService;
import blog.services.PostService;
import blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.List;
/**
 * Created by Developer PC on 2/23/2018.
 */
@Controller
public class UserController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notifyService;

    @RequestMapping("/users")
    public String viewusers(Model model) {

        List<User> userList = userService.findAll();
        model.addAttribute("userList",userList);
        return "users/index";
    }
}
