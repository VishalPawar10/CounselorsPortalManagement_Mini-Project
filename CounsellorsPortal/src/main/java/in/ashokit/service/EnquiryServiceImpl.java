package in.ashokit.service;

import java.util.List;

import in.ashokit.dto.ViewEnqFilterRequest;
import in.ashokit.entity.Enquiry;

public class EnquiryServiceImpl implements EnquiryService {

	@Override
	public boolean addEnquiry(Enquiry enq, Integer counsellorId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Enquiry getEnquriyById(Integer enqId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enquiry> getAllEnquiries(Integer counsellorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enquiry updateEnquiry(Enquiry enquiry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEnquiry(Long enqId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Enquiry> findByCounsellorId(Long counsellorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enquiry> getEnquiresWithFilter(ViewEnqFilterRequest filterReq, Integer counsellorId) {
		// TODO Auto-generated method stub
		return null;
	}

}
