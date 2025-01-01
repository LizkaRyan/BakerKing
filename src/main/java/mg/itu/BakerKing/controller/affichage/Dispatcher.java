package mg.itu.BakerKing.controller.affichage;

import org.springframework.web.servlet.ModelAndView;

public class Dispatcher extends ModelAndView {
    public Dispatcher(String url){
        super("template");
        this.addObject("body",url);
    }
}
