package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.emp.model.EmpData;
import com.emp.service.EmpService;

@Controller
public class EmpController {

	@Autowired
	private EmpService empService;
	
	@GetMapping("/")
	public String HomePage(Model model) {
		return findPaginate(1, model);
	}
	@GetMapping("/addEmpForm")
	public String addEmployee(Model model) {
//		EmpData empData =new EmpData();
		model.addAttribute("employee", new EmpData());
		return "addEmpForm";
	}
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") EmpData employee) {
		empService.addEmployee(employee);
		
		return "redirect:/";
	}
	@GetMapping("updateForm/{id}")
	public String updateForm(@PathVariable(value = "id") int id,Model model) {
		EmpData empData=empService.getEmpById(id);
		
		model.addAttribute("employee",empData);
		return "updateEmployee";
	}
	@GetMapping("/DeleteEmpForm/{id}")
	public String deleteEmployee(@PathVariable(value = "id") int id,Model model) {
		this.empService.deleteEmloyee(id);
		return "redirect:/";
	}
	@GetMapping("/page/{pageNo}")
	public String findPaginate(@PathVariable (value = "pageNo") int pageNo,Model model) {
		int pagesize=5;
		Page<EmpData> page = empService.findPegignation(pageNo, pagesize);
		List<EmpData>listEmployees=page.getContent();
		
		model.addAttribute("currentPages",pageNo);
		model.addAttribute("totalPage",page.getTotalPages());
		model.addAttribute("totalItems",page.getTotalElements());
		model.addAttribute("listEmployees",listEmployees);
		
		return "index";
	}
}
