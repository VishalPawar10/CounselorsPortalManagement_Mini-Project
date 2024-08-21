package in.ashokit.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.Counsellors;

@Repository
public interface CounsellorsRepository extends JpaRepository<Counsellors, Integer>{

	public Counsellors findByEmailAndPwd(String email, String pwd);
	
	public Counsellors findByEmail(String email);
}
