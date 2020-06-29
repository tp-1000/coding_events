package org.launchcode.codingevents.Controllers;

import org.launchcode.codingevents.data.TagRepository;
import org.launchcode.codingevents.models.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("tags")
public class TagController {

    @Autowired
    private TagRepository tagsRepository;

    @GetMapping
    public String displayIndex (Model model) {
        model.addAttribute("title", "All tags");
        model.addAttribute("tags", tagsRepository.findAll());
        return "tags/index";
    }

    @GetMapping("create")
    public String displayCreateTag (Model model) {
        model.addAttribute("title", "Create a tag" );
        model.addAttribute("tags", new Tags());
        return "tags/create";
    }
    //add a tag entity parameter to auto fill for validation error

    @PostMapping("create")
    public String processCreateTag(@ModelAttribute @Valid Tags tag, Errors error, Model model){
        if(error.hasErrors()){
            model.addAttribute("title", "Create a tag" );
            return "tags/create";
        }
        tagsRepository.save(tag);
        return "redirect:";
    }

}
