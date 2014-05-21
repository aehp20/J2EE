package com.aehp.template.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aehp.template.dao.IStudentDao;

@Controller
public class IndexController {

	@Inject
    private IStudentDao studentDao;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showIndex(Model model) {
		model.addAttribute("msg", "hello world");
		
		
		
		return "index";
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public ModelAndView showIndex() {
		Map map = new HashMap();
		map.put("msg", "hello world");
		return new ModelAndView("index", "model", map);
	}
}
