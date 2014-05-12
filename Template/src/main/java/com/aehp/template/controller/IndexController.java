package com.aehp.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView showIndex() {
		ModelAndView model = new ModelAndView("index");
		model.addObject("msg", "hello world");
		return model;
	}
}
