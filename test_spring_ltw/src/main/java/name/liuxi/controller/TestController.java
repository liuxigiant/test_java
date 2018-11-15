package name.liuxi.controller;

import com.service.TestLTWService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class TestController {

    @Autowired
    private TestLTWService testLTWService;

    @RequestMapping("/")
    public void index(HttpServletResponse response) throws Exception{
        String name = String.valueOf(System.currentTimeMillis());
        boolean isSuc = false;
        try{
            isSuc = testLTWService.addUser(name);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (isSuc){
            response.getWriter().write("test sucess,add user " + name);
        } else {
            response.getWriter().write("test failed");
        }
    }
}
