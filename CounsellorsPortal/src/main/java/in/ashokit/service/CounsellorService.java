package in.ashokit.service;

import java.util.List;
import java.util.Optional;
import in.ashokit.repo.Counsellors;

	public interface CounsellorService {

	    Counsellors createCounsellor(Counsellors counsellor);

	    Optional<Counsellors> getCounsellorById(Long counsellorId);

	    List<Counsellors> getAllCounsellors();

	    Counsellors updateCounsellor(Counsellors counsellor);

	    void deleteCounsellor(Long counsellorId);

	    Optional<Counsellors> findByEmail(String email);
	}

