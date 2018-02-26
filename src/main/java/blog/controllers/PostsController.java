package blog.controllers;

import blog.forms.PostForm;
import blog.models.Post;
import blog.models.User;
import blog.services.NotificationService;
import blog.services.PostService;
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
public class PostsController {

    @Autowired
    private PostService postService;

    @Autowired
    private NotificationService notifyService;

    @RequestMapping("/posts")
    public String viewposts(Model model) {

        List<Post> latest5Posts = postService.findAll();
        model.addAttribute("latestposts",latest5Posts);
        return "posts/listview";
    }


    @RequestMapping("/posts/view/{id}")
    public String view(@PathVariable("id") Long id, Model model){
        Post post = postService.findById(id);
        if(post == null){
            notifyService.addErrorMessage("Cannot find post #"+id);
            return "redirect:/";
        }
        model.addAttribute("post",post);
        return "posts/view";
    }

    @RequestMapping("/posts/create")
    public String register(PostForm postForm) {
        return "posts/createpost";
    }

    @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
    public String postPage(@Valid PostForm postForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "posts/create";
        }

        Post post = new Post();
        User user = new User();

        post.setTitle(postForm.getTitle());
        post.setBody(postForm.getBody());
        post.setAuthor(user);
        post.setDate(new Date());

        Post newPost = new Post();
        newPost = postService.create(post);

        notifyService.addInfoMessage("Post Created successful");
        return "redirect:/posts";
    }

}
