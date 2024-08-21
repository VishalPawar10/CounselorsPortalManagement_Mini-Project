package in.ashokit.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import in.ashokit.dto.DashboardResponse;
import in.ashokit.entity.Counsellors;
import in.ashokit.entity.Enquiry;
import in.ashokit.repo.CounsellorsRepository;
import in.ashokit.repo.EnquiryRepository;

@Service
public class CounsellorServiceImpl implements CounsellorService {
	
	private CounsellorsRepository repo;
	
	private EnquiryRepository erepo;

	
	public CounsellorServiceImpl(CounsellorsRepository repo, EnquiryRepository erepo) {
		this.repo = repo;
		this.erepo = erepo;
	}
	
	@Override
	public Counsellors checkDuplicate(String email) {
	    Counsellors c = repo.findByEmail(email);
	    return c;
	}

	@Override
	public boolean register(Counsellors counsellor) {
		Counsellors save = repo.save(counsellor);
		if(null != save.getCounsellorId()) {
			return true;
		}
		return false;
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
		
		List<Enquiry> list = erepo.findByCounsellor(counsellorId);
		int totalEnqs = list.size();
		
		int enrolledEnqs = list.stream().filter(e -> e.getEnqStatus().equals("Enrolled"))
			.collect(Collectors.toList())
			.size();
		
		int lostEnqs = list.stream().filter(e -> e.getEnqStatus().equals("Enrolled"))
				.collect(Collectors.toList())
				.size();
		
		int openEnqs = list.stream().filter(e -> e.getEnqStatus().equals("Enrolled"))
				.collect(Collectors.toList())
				.size();

		
		dr.setTotalEnqs(totalEnqs);
		dr.setOpenEnqs(openEnqs);
		dr.setEnrolledEnqs(enrolledEnqs);
		dr.setLostEnqs(lostEnqs);
		return dr;
	}

	@Override
	public void deleteCounsellor(Integer counsellorId) {
		repo.deleteById(counsellorId);
	}

}
