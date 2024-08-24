package in.ashokit.service;

import java.util.List;


import in.ashokit.dto.ViewEnqFilterRequest;
import in.ashokit.entity.Enquiry;


public interface EnquiryService {


	// add new enquires based on counsellorId
	public boolean addEnquiry(Enquiry enq, Integer counsellorId) throws Exception;

	public Enquiry getEnquriyById(Integer enqId);

	//fetch all enquires added by same counsellorId
	public List<Enquiry> getAllEnquiries(Integer counsellorId);

	//filter the enquires dynamically using EBQ based on same counsellorId
	public List<Enquiry> getEnquiresWithFilter(ViewEnqFilterRequest filterReq, Integer counsellorId);

}
