package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.ashokit.entity.Enquiry;
import in.ashokit.service.EnquiryService;

@Controller
public class EnquiryController {
	
	private EnquiryService enquiryService;
	
	public EnquiryController(EnquiryService enquiryService) {
		 this.enquiryService = enquiryService;
	}

	@GetMapping("/addEnquiry")
	public String getEnquiryPage(Model model) {
		Enquiry eObj = new Enquiry();
		model.addAttribute("enquiry", eObj);
		return "addEnquiry";
	}
}
