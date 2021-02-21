package be.thomasmore.party.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeContreller {
   private String appName="Let's Party!!";
   private final String [] venueNames={"De Club","De Loods","De Hanger","Zapoi","Kuub","Cuba Libre"};
    @GetMapping({"/","/home"})
    public String home(Model model) {
        model.addAttribute("appName",appName);
        return "home";
    }

    @GetMapping("/venuelist")
    public String venuelist(Model model){
        model.addAttribute("appName",appName);
        model.addAttribute("venueNames",venueNames);
        return"venuelist";
    }

    @GetMapping({"/venuedetails", "/venuedetails/{venueName}"})
    public String venueDetails(Model model, @PathVariable(required = false) String venueName) {
        model.addAttribute("venuename", venueName==null ? "--no venue specified--" : venueName);
        return "venuedetails";
    }
    @GetMapping({"/venuedetailsbyindex", "/venuedetailsbyindex/{venueId}"})
    public String venueDetails(Model model, @PathVariable(required = false) Integer venueId) {
        model.addAttribute("venuename", (venueId>=0 && venueId < venueNames.length) ? venueNames[venueId] : null);
        String venueName;
        Integer prevIndex=venueId-1;
        Integer nextIndex=venueId+1;
        if(venueId!=null) {
            if(venueId >= 0 & venueId < venueNames.length){
                venueName= venueNames[venueId];
                if(venueId==0){
                    prevIndex=venueNames.length-1;
                }
                else {
                    prevIndex=venueId-1;
                }
                if (venueId==venueNames.length-1){
                    nextIndex=0;
                }
                else {
                    nextIndex=venueId+1;
                }
            }
            else venueName= null;
        }
        else venueName=null;

        model.addAttribute("venueName",venueName);
        model.addAttribute("prevIndex",prevIndex);
        model.addAttribute("nextIndex",nextIndex);

        return "venuedetails";
    }

    @GetMapping("/artistlist")
    public String artistslist(Model model){
        model.addAttribute("appName",appName);
        return"artistlist";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("appName",appName);

        return"about";
    }
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("appName",appName);

        return"login";
    }

}
