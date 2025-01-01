package mg.itu.BakerKing.controller;

import mg.itu.BakerKing.controller.affichage.Dispatcher;
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
