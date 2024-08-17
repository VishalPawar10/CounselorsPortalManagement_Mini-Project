package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.repo.Enquiry;
import in.ashokit.repo.EnquiryRepository;

@Service
public class EnquiryServiceImpl implements EnquiryService {

    @Autowired
    private EnquiryRepository enquiryRepo;
    
    public EnquiryServiceImpl(EnquiryRepository enquiryRepo) {
		this.enquiryRepo = enquiryRepo;
	}

    @Override
    public Enquiry createEnquiry(Enquiry enquiry) {
        return enquiryRepo.save(enquiry);
    }

    @Override
    public Optional<Enquiry> getEnquiryById(Long enqId) {
        return enquiryRepo.findById(enqId);
    }

    @Override
    public List<Enquiry> getAllEnquiries() {
        return enquiryRepo.findAll();
    }

    @Override
    public Enquiry updateEnquiry(Enquiry enquiry) {
        return enquiryRepo.save(enquiry);
    }

    @Override
    public void deleteEnquiry(Long enqId) {
        enquiryRepo.deleteById(enqId);
    }

    @Override
    public List<Enquiry> findByCounsellorId(Long counsellorId) {
        return enquiryRepo.findByCounsellor_CounsellorId(counsellorId);
    }

    @Override
    public List<Enquiry> findByStatus(String status) {
        return enquiryRepo.findByEnqStatus(status);
    }
}
