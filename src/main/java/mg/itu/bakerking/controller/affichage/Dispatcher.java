package mg.itu.bakerking.controller.affichage;

import org.springframework.web.servlet.ModelAndView;

public class Dispatcher extends ModelAndView {
    public Dispatcher(String url){
        super("template");
        this.addObject("body","views/"+url);
    }
}
