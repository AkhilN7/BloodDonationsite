package com.blooddonation.blooddonation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class BlooddonationController {
    List<Blooddonation> sample = new ArrayList<>();

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required=false) UUID id) {
        int index=getblood(id);
        if(index==-1000){
            model.addAttribute("blood", new Blooddonation());
        }
        else{
            model.addAttribute("blood", sample.get(index));
        }
        //model.addAttribute("blood", new Blooddonation());
        return "sign-up";
    }

    @PostMapping("/handleSubmit")
    public String handleData(Blooddonation blood) {
        //blood.setName(blood.getName()); // Set the name
        //blood.setGroup(blood.getGroup()); // Set the group
        
        System.out.println("Name:" + blood.getName() + " Blood Group:" + blood.getGroup());
        int index=getblood(blood.getId());
        if(index==-1000){
            sample.add(blood);
        }
        else{
            sample.set(index,blood);
        }
        //sample.add(blood);
        return "redirect:/info";
    }

    @GetMapping("/info")
    public String getinfo(Model model) {
        model.addAttribute("sample", sample);
        return "info";
    }

    public int getblood(UUID id){
        for(int i=0;i<sample.size();i++){
            if(sample.get(i).getId().equals(id))
                return i;
        }
        return -1000;
    }
}
