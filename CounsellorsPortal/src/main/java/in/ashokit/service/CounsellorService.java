package in.ashokit.service;

import java.util.List;

import in.ashokit.dto.DashboardResponse;
import in.ashokit.entity.Counsellors;

	public interface CounsellorService {

	    public Counsellors createCounsellor(Counsellors counsellor);
	    
	    public Counsellors login(String email, String pwd);

	    List<Counsellors> getAllCounsellors();

		public DashboardResponse getDashboardInfo(Integer counsellorId);

	    void deleteCounsellor(Long counsellorId);

	}

