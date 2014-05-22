package com.aehp.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//import javax.inject.Inject;



import com.aehp.example.dao.CustomerDAO;
import com.aehp.example.impl.JdbcCustomerDAO;

//import com.aehp.template.dao.IStudentDao;

@Controller
public class IndexController {

	@Inject
//    private CustomerDAO customerDAO;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showIndex(Model model) {

//        List<Map<String,Object>> customers = customerDAO.findByCustomers();

		String count = "String.valueOf(customers.size())";

		model.addAttribute("msg", "hello world " + count);

		return "index";
	}

	@RequestMapping(value="/test", method=RequestMethod.GET)
	public ModelAndView showIndex() {
		Map map = new HashMap();
		map.put("msg", "hello world");
		return new ModelAndView("index", "model", map);
	}
}
