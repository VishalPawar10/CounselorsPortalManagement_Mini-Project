package in.ashokit.service;


import in.ashokit.dto.DashboardResponse;
import in.ashokit.entity.Counsellors;

	public interface CounsellorService {
		
		public Counsellors checkDuplicate(String email);

	    public boolean register(Counsellors counsellor);
	    
	    public Counsellors login(String email, String pwd);

		public DashboardResponse getDashboardInfo(Integer counsellorId);

	    void deleteCounsellor(Integer counsellorId);

	}

