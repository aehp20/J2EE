package com.aehp.template.webapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aehp.template.exception.InvalidUserException;
import com.aehp.template.model.SignupForm;
import com.aehp.template.service.SampleService;

@Controller
public class IndexController {

    private final String PAGE_INDEX = "index";
    private final String PAGE_SHOW = "show";

    @Autowired
    SampleService sampleService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView(PAGE_INDEX, "signupForm", new SignupForm());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String search(Model model, @Valid SignupForm signupForm, BindingResult result, RedirectAttributes redirectAttributes) {

        String returnPage = PAGE_INDEX;

        if (!result.hasErrors()) {
            try {
                model.addAttribute("form", sampleService.saveFrom(signupForm));
                returnPage = PAGE_SHOW;
            } catch (InvalidUserException e) {
                model.addAttribute("page_error", e.getMessage());
            }
        }
        return returnPage;
    }

    @RequestMapping(value = "/security-error", method = RequestMethod.GET)
    public String securityError(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("page_error", "You do have have permission to do that!");
        return "redirect:/";
    }

}
