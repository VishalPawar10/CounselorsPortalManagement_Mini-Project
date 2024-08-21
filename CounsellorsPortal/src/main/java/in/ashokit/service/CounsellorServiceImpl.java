package in.ashokit.service;


import org.springframework.stereotype.Service;

import in.ashokit.dto.DashboardResponse;
import in.ashokit.entity.Counsellors;
import in.ashokit.repo.CounsellorsRepository;

@Service
public class CounsellorServiceImpl implements CounsellorService {
	
	private CounsellorsRepository repo;

	
	public CounsellorServiceImpl(CounsellorsRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public Counsellors checkDuplicate(String email) {
	    Counsellors c = repo.findByEmail(email);
	    return c;
	}

	@Override
	public Counsellors createCounsellor(Counsellors counsellor) {
		return repo.save(counsellor);
	}

	@Override
	public Counsellors login(String email, String pwd) {
		Counsellors c = repo.findByEmailAndPwd(email, pwd);
		if(c == null) {
			throw new IllegalArgumentException("Invalid email or password");
		}
		return c;
	}

	@Override
	public DashboardResponse getDashboardInfo(Integer counsellorId) {
		DashboardResponse dr = new DashboardResponse();
		dr.getTotalEnqs();
		dr.getOpenEnqs();
		dr.getEnrolledEnqs();
		dr.getLostEnqs();
		return dr;
	}

	@Override
	public void deleteCounsellor(Integer counsellorId) {
		repo.deleteById(counsellorId);
	}

}
