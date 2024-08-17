package in.ashokit.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounsellorsRepository extends JpaRepository<Counsellors, Long>{

	public Optional<Counsellors> findByEmail(String email);
}
