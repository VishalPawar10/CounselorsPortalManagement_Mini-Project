package in.ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Enquiry;
import in.ashokit.entity.Counsellors;


public interface EnquiryRepository extends JpaRepository<Enquiry, Integer>{

	public List<Enquiry> findByCounsellor(Integer counsellorId);
	
	public List<Enquiry> findByEnqStatus(String status);
}
