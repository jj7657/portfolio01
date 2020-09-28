package org.spring.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController {
	
	private final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("doA")
	public void doA() {
		logger.info("doA 부름");
	}
	
	
	@RequestMapping("doB")
	public void doB() {
		logger.info("doB 부름");
	}
	
	@RequestMapping("doC")
	public String doC(@ModelAttribute("msg")String msg) {
		
		logger.info("doC 부름");
		return "home";
	}
	
	@RequestMapping("doD")
	public String doD(Model model){
		logger.info("doD 부름");
		
		String msg = "okok";
		
		model.addAttribute("msg",msg);
		
		return "home";
	}
	@RequestMapping("doE")
	public String doE(RedirectAttributes rttr){
		
		logger.info("doE 부름");
		
		String msg = "doF redirect massege 넘김";
		
		rttr.addFlashAttribute("msg" ,"data redirect ok"); //post 처럼 넘기는 휘발성 데이터
//		rttr.addAttribute("msg" ,"data redirect ok"); // get방식으로 직접 넘김
		
		return "redirect:/doF";
	}
	@RequestMapping("doF")
	public String doF(String msg) {
		logger.info("doF 부름"+msg);
		
		
		return "home";
	}
	
	
}