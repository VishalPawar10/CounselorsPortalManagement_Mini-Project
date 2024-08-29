package in.ashokit.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.dto.DashboardResponse;
import in.ashokit.dto.ViewEnqFilterRequest;
import in.ashokit.entity.Enquiry;
import in.ashokit.service.CounsellorService;
import in.ashokit.service.EnquiryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {

	private EnquiryService enquiryService;

	private CounsellorService counsellorService;

	public EnquiryController(EnquiryService enquiryService, CounsellorService counsellorService) {
		this.enquiryService = enquiryService;
		this.counsellorService = counsellorService;
	}

	@GetMapping("/enquiry")
	public String getEnquiryPage(Model model) {
		Enquiry eObj = new Enquiry();
		model.addAttribute("enquiry", eObj);
		return "addEnquiry";
	}

	@PostMapping("/addEnquiry")
	public String AddEnquiryPage(Enquiry enquiry, HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession(false);
		Integer counsellorId = (Integer) session.getAttribute("counsellorId");

		boolean isSaved = enquiryService.addEnquiry(enquiry, counsellorId);
		if (isSaved) {
			model.addAttribute("msg", "Enquiry Added Successfully!!!");
		} else {
			model.addAttribute("emsg", "Failed to Add Enquiry");
		}

		DashboardResponse dbObj = counsellorService.getDashboardInfo(counsellorId);
		model.addAttribute("dashboardInfo", dbObj);

		enquiry = new Enquiry();
		model.addAttribute("enquiry", enquiry);
		return "addEnquiry";
	}

	@GetMapping("/viewEnquiry")
	public String getViewEnquiryPage(Enquiry enquiry, HttpServletRequest request, Model model) {

		HttpSession session = request.getSession(false);
		Integer counsellorId = (Integer) session.getAttribute("counsellorId");

		List<Enquiry> enq = enquiryService.getAllEnquiries(counsellorId);
		model.addAttribute("enquiry", enq);

		ViewEnqFilterRequest filterReq = new ViewEnqFilterRequest();
		model.addAttribute("viewEnqFilterRequest", filterReq);

		return "viewEnquiry";
	}

	@PostMapping("/filter-enqs")
	public String filterEnquiryPage(ViewEnqFilterRequest viewEnqFilterRequest, HttpServletRequest request,
			Model model) {
		HttpSession session = request.getSession(false);
		Integer counsellorId = (Integer) session.getAttribute("counsellorId");

		// Perform the filtering
		List<Enquiry> list = enquiryService.getEnquiresWithFilter(viewEnqFilterRequest, counsellorId);

		// Add the filtered list to the model
		model.addAttribute("enquiry", list);

		// Add the filter request object back to the model for form binding
		model.addAttribute("viewEnqFilterRequest", viewEnqFilterRequest);

		return "viewEnquiry";
	}

}
