package com.alrehany.joblisting;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class PostController {

    //every time a request send to the home page
    //it should redirect to the swagger page
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        //redirect the user to swagger home page
        response.sendRedirect("/swagger-ui.html");
    }

}
