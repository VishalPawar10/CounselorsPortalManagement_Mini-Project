package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.repo.Counsellors;
import in.ashokit.service.CounsellorService;
import in.ashokit.service.CounsellorServiceImpl;

@SpringBootApplication
public class CounsellorsPortalApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CounsellorsPortalApplication.class, args);
		CounsellorServiceImpl counsellorServiceImpl = context.getBean(CounsellorServiceImpl.class);
		Counsellors c = new Counsellors();
		c.setCounsellorId((long) 4);
		c.setName("Ron");
		c.setEmail("rahul123@gmail.com");
		c.setPwd("12334");
		c.setPhno("125678923");
		//counsellorServiceImpl.createCounsellor(c);
		//System.out.println(counsellorServiceImpl.findByEmail("rahul@gmail.com"));
		//System.out.println(counsellorServiceImpl.getAllCounsellors());
		//System.out.println(counsellorServiceImpl.updateCounsellor(c));
	}

}
