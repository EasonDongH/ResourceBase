import com.easondongh.domain.Options;
import com.easondongh.service.OptionsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class MybatisTest {

    @Autowired
    private OptionsService optionsService;

    @Test
    public void testGetOne(){
        Options options = optionsService.getOne();
        System.out.println(options);
    }
}
