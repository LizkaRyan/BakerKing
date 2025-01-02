package mg.itu.bakerking.controller;

import mg.itu.bakerking.controller.affichage.Dispatcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public ModelAndView index(){
        return new Dispatcher("stock/index.jsp");
    }
}
