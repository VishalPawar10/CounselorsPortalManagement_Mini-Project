package in.ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry, Integer>{

	public List<Enquiry> findByCounsellor_CounsellorId(Long counsellorId);
	
	public List<Enquiry> findByEnqStatus(String status);
}
