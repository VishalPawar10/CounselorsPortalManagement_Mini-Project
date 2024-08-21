package in.ashokit.service;

import java.util.List;

import in.ashokit.dto.ViewEnqFilterRequest;
import in.ashokit.entity.Enquiry;

public interface EnquiryService {


	// add new enquiry 
	public boolean addEnquiry(Enquiry enq, Integer counsellorId) throws Exception;

	public Enquiry getEnquriyById(Integer enqId);

	public List<Enquiry> getAllEnquiries(Integer counsellorId);

	public List<Enquiry> getEnquiresWithFilter(ViewEnqFilterRequest filterReq, Integer counsellorId);

}
