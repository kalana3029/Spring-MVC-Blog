package blog.forms;

import blog.models.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * Created by Developer PC on 2/23/2018.
 */
public class PostForm {

    @NotNull
    private String title;
    @NotNull
    private String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
