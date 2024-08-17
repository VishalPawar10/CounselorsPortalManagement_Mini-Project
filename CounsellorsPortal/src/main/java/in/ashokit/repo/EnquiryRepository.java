package in.ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnquiryRepository extends JpaRepository<Enquiry, Long>{

	public List<Enquiry> findByCounsellor_CounsellorId(Long counsellorId);
	
	public List<Enquiry> findByEnqStatus(String status);
}
