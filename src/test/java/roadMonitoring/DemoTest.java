package roadMonitoring;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.platform.Application;
import com.platform.ptcms.dao.DemoDao;
import com.platform.ptcms.entity.WeUserRef;
import com.platform.ptcms.service.iface.IDemoService;

//这是JUnit的注解，通过这个注解让SpringJUnit4ClassRunner这个类提供Spring测试上下文。  
@RunWith(SpringJUnit4ClassRunner.class)  
//这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下  
@SpringBootTest(classes = Application.class)  
@WebAppConfiguration 
public class DemoTest {
	
	@Resource
	private IDemoService demoService;
	
	@Resource
	private DemoDao demoDao;
	
	
	@Test
	public void findByWeid() {
		WeUserRef e = demoService.find("1");
		System.out.println(e.getId());
	}
	
	@Test
	public void findByid() {
		WeUserRef e = demoDao.findByid("1");
		System.out.println(e);
	}

}
