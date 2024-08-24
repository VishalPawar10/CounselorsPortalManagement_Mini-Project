package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.dto.DashboardResponse;
import in.ashokit.entity.Counsellors;
import in.ashokit.service.CounsellorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CounsellorController {

	private CounsellorService counsellorService;

	public CounsellorController(CounsellorService counsellorService) {
		this.counsellorService = counsellorService;
	}

	@GetMapping("/")
	public String index(Model model) {
		Counsellors cObj = new Counsellors();
		model.addAttribute("counsellor", cObj);
		return "index";
	}

	// handle the login button
	@PostMapping("/login")
	public String handleLogin(Counsellors counsellor, HttpServletRequest request, Model model) {
		Counsellors c = counsellorService.login(counsellor.getEmail(), counsellor.getPwd());

		if (c == null) {
			model.addAttribute("emsg", "Invalid Credentials...");
			return "index";
		} else {

			HttpSession session = request.getSession(true);
			session.setAttribute("counsellorId", c.getCounsellorId());

			DashboardResponse dbObj = counsellorService.getDashboardInfo(c.getCounsellorId());
			model.addAttribute("dashboardInfo", dbObj);
			return "dashboard";
		}
		
	}
	
	@GetMapping("/dashboard")
	public String displayDashboardPage(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession(false);
		Integer counsellorId = (Integer)session.getAttribute("counsellorId");

		DashboardResponse dbObj = counsellorService.getDashboardInfo(counsellorId);
		model.addAttribute("dashboardInfo", dbObj);
		return "dashboard";
	}

	@GetMapping("/register")
	public String registrationPage(Model model) {
		Counsellors cObj = new Counsellors();
		model.addAttribute("counsellor", cObj);
		return "registration";
	}

	@PostMapping("/register")
	public String handleRegistration(@ModelAttribute("counsellor") Counsellors counsellor, Model model) {

		Counsellors checkDuplicate = counsellorService.checkDuplicate(counsellor.getEmail());
		if(checkDuplicate!=null) {
			model.addAttribute("emsg","Duplicate Email..");
			return "registration";
		}
		
		boolean isRegister = counsellorService.register(counsellor);
		if (isRegister) {
			model.addAttribute("msg", "Registration Successful!!!");
		} else {
			model.addAttribute("emsg", "Failed to Register");
		}
		return "registration";
	}
	
	

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "redirect:/";
	}

}
