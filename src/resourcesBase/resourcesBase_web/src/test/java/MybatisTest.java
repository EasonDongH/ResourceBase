import com.easondongh.dao.ArticleDao;
import com.easondongh.domain.Article;
import com.easondongh.domain.Category;
import com.easondongh.domain.Options;
import com.easondongh.service.CategoryService;
import com.easondongh.service.OptionsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class MybatisTest {

    @Autowired
    private OptionsService optionsService;
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private CategoryService categoryService;

    @Test
    public void testGetOne(){
        Options options = optionsService.getOne();
        System.out.println(options);
    }

    @Test
    public void testGetArticleById(){
        Article article = articleDao.getArticleById(1L);
        System.out.println(article);
    }

    @Test
    public void testGetParentNodesById(){
        Category category = new Category();
        category.setPid(11);
        List<Category> parentNodes = this.categoryService.getParentNodeById(category);
        System.out.println(parentNodes);
    }

    @Test
    public void test(){

    }
}
