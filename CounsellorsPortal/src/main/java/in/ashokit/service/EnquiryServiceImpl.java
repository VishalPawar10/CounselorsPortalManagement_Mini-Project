package in.ashokit.service;

import java.util.List;

import org.springframework.data.domain.Example;

import in.ashokit.dto.ViewEnqFilterRequest;
import in.ashokit.entity.Counsellors;
import in.ashokit.entity.Enquiry;
import in.ashokit.repo.CounsellorsRepository;
import in.ashokit.repo.EnquiryRepository;
import io.micrometer.common.util.StringUtils;

public class EnquiryServiceImpl implements EnquiryService {
	
	private EnquiryRepository enqRepo;
	
	private CounsellorsRepository conRepo;
	
	public EnquiryServiceImpl(EnquiryRepository enqRepo, CounsellorsRepository conRepo) {
		this.enqRepo = enqRepo;
		this.conRepo = conRepo;
	}
	

	@Override
	public boolean addEnquiry(Enquiry enq, Integer counsellorId) throws Exception{
		Counsellors counsellors = conRepo.findById(counsellorId).orElse(null);
		
		if(counsellorId == null) {
			throw new Exception("No coounsellor Found..");
		}
		
		enq.setCounsellor(counsellors);
		Enquiry save = enqRepo.save(enq);
		if(save != null) {
			return true;
		}
		return false;
	}

	@Override
	public Enquiry getEnquriyById(Integer enqId) {
		return enqRepo.findById(enqId).orElse(null);
	}

	@Override
	public List<Enquiry> getAllEnquiries(Integer counsellorId) {
		return enqRepo.findByCounsellor(counsellorId);
	}

	

	@Override
	public List<Enquiry> getEnquiresWithFilter(ViewEnqFilterRequest filterReq, Integer counsellorId) {
		
		Enquiry enq = new Enquiry();
		
		Example<Enquiry> of = Example.of(enq);
		
		
		if(StringUtils.isNotEmpty(filterReq.getClassMode()))
			enq.setClassMode(filterReq.getClassMode());
		
		if(StringUtils.isNotEmpty(filterReq.getCourse()))
			enq.setClassMode(filterReq.getCourse());
		
		if(StringUtils.isNotEmpty(filterReq.getStatus()))
			enq.setClassMode(filterReq.getStatus());
		
		Counsellors counsellors = conRepo.findById(counsellorId).orElse(null);
		enq.setCounsellor(counsellors);
		
		List<Enquiry> list = enqRepo.findAll(of);
		return list;
	}

}
