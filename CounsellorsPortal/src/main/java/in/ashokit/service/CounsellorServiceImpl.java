package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import in.ashokit.repo.Counsellors;
import in.ashokit.repo.CounsellorsRepository;
import jakarta.transaction.Transactional;

@Service
public class CounsellorServiceImpl implements CounsellorService{
	
	@Autowired
	private CounsellorsRepository counsellorRepo;
	
	public CounsellorServiceImpl(CounsellorsRepository counsellorRepo) {
		this.counsellorRepo = counsellorRepo;
	}

	@Override
	public Counsellors createCounsellor(Counsellors counsellor) {
		return counsellorRepo.save(counsellor);
	}
	
	@Override
	public void deleteCounsellor(Long counsellorId) {
		counsellorRepo.deleteById(counsellorId);
		
	}
	
	@Override
	public Optional<Counsellors> findByEmail(String email) {
		return counsellorRepo.findByEmail(email);
	}
	
	@Override
	public List<Counsellors> getAllCounsellors() {
		return counsellorRepo.findAll();
	}
	
	@Override
	public Optional<Counsellors> getCounsellorById(Long counsellorId) {
		// TODO Auto-generated method stub
		return counsellorRepo.findById(counsellorId);
	}
	
    @Override
    @Transactional
    @Modifying
    public Counsellors updateCounsellor(Counsellors counsellor) {
    	return counsellorRepo.save(counsellor);
    }
}
