package in.ashokit.service;


import org.springframework.stereotype.Service;

import in.ashokit.dto.DashboardResponse;
import in.ashokit.entity.Counsellors;

@Service
	public interface CounsellorService {
		
		//check if counselor exists
		public Counsellors checkDuplicate(String email);

		//register the new counselor
	    public boolean register(Counsellors counsellor);
	    
	    //login based on email and password
	    public Counsellors login(String email, String pwd);

	    //to get Dash_board Information
		public DashboardResponse getDashboardInfo(Integer counsellorId);


	}

