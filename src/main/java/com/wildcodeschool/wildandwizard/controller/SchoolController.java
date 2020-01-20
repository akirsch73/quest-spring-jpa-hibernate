package com.wildcodeschool.wildandwizard.controller;

import com.wildcodeschool.wildandwizard.entity.School;
import com.wildcodeschool.wildandwizard.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SchoolController {

@Autowired
private SchoolRepository repository; // TODO : get school repository by dependency injection

    @GetMapping("/schools")
    public String getAll(Model model) {

        model.addAttribute("schools", repository.findAll()); // TODO : find all schools

        return "schools";
    }

    @GetMapping("/school")
    public String getSchool(Model model,
                            @RequestParam(required = false) Long id) {

	      School school = new School();
	      if (ID !=null) {
		    Optional<School> optionalSchool = repository.findbyId(id);
		    if (optionalSchool.isPresent()) {
			  school = optionalSchool.get();
		    }
	   }
	   model.addAttribute("school", school);

	   return "school";
	   }

        // TODO : find one school by id



    @PostMapping("/school")
    public String postSchool(@ModelAttribute School school) {

    repository.save(school);

	// TODO : create or update a school

        return "redirect:/schools";
    }

    @GetMapping("/school/delete")
    public String deleteSchool(@RequestParam Long id) {

	  repository.deleteById(id);
    // TODO : delete a school

        return "redirect:/schools";
    }
}
