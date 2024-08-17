package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import in.ashokit.repo.Enquiry;

public interface EnquiryService {


    Enquiry createEnquiry(Enquiry enquiry);

    Optional<Enquiry> getEnquiryById(Long enqId);

    List<Enquiry> getAllEnquiries();

    Enquiry updateEnquiry(Enquiry enquiry);

    void deleteEnquiry(Long enqId);

    List<Enquiry> findByCounsellorId(Long counsellorId);

    List<Enquiry> findByStatus(String status);
}
