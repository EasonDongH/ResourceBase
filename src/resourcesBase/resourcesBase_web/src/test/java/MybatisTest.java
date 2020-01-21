import com.easondongh.dao.ArticleDao;
import com.easondongh.domain.Article;
import com.easondongh.domain.ArticleGroup;
import com.easondongh.domain.Category;
import com.easondongh.domain.Options;
import com.easondongh.service.CategoryService;
import com.easondongh.service.OptionsService;
import com.easondongh.util.IdGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class MybatisTest {

    @Autowired
    private OptionsService optionsService;
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private IdGenerator idGenerator;

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
        category.setPid(11L);
        List<Category> parentNodes = this.categoryService.getParentNodeById(category);
        System.out.println(parentNodes);
    }

    @Test
    public void testAddArticle(){
        for(int i=0; i<50; i++) {
            Article article = new Article();
            article.setId(idGenerator.next());
            Date dt = new Date();
            article.setArticleCreateTime(dt);
            article.setArticleUpdateTime(dt);
            article.setArticleTitle("测试内容title");
            article.setArticleContent("测试内容content<p>如何让程序一直运行，很容易实现，只需要一直等待输出即可啦</p><div class=\"dp-highlighter\"><div class=\"bar\"></div><ol class=\"dp-j\" start=\"1\"><li class=\"alt\"><span class=\"keyword\">import</span>&nbsp;java.util.Scanner;</li><li class=\"\"></li><li class=\"alt\"><span class=\"comment\">/*</span></li><li class=\"\"><span class=\"comment\">&nbsp;*&nbsp;@author&nbsp;LiuYanzhao</span></li><li class=\"alt\"><span class=\"comment\">&nbsp;*/</span></li><li class=\"\"><span class=\"keyword\">public</span>&nbsp;<span class=\"keyword\">class</span>&nbsp;Test&nbsp;{</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"keyword\">private</span>&nbsp;<span class=\"keyword\">static</span>&nbsp;<span class=\"keyword\">final</span>&nbsp;String&nbsp;OPERATION_EXIT&nbsp;=&nbsp;<span class=\"string\">\"EXIT\"</span>;</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"keyword\">public</span>&nbsp;<span class=\"keyword\">static</span>&nbsp;<span class=\"keyword\">void</span>&nbsp;main(String[]&nbsp;args)&nbsp;{</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(<span class=\"string\">\"请开始您的输入，EXIT/E&nbsp;退出\"</span>);</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"comment\">//怎么让程序一直运行</span></li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Scanner&nbsp;scan&nbsp;=&nbsp;<span class=\"keyword\">new</span>&nbsp;Scanner(System.in);</li><li class=\"\"></li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"keyword\">while</span>(scan.hasNext())&nbsp;{</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;String&nbsp;in&nbsp;=&nbsp;scan.next().toString();</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"keyword\">if</span>(OPERATION_EXIT.equals(in.toUpperCase())</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;||&nbsp;OPERATION_EXIT.substring(<span class=\"number\">0</span>,&nbsp;<span class=\"number\">1</span>).equals(in.toUpperCase()))&nbsp;{</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(<span class=\"string\">\"您成功已退出！\"</span>);</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=\"keyword\">break</span>;</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}</li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;System.out.println(<span class=\"string\">\"您输入的值：\"</span>+in);</li><li class=\"alt\"></li><li class=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}</li><li class=\"alt\">&nbsp;&nbsp;&nbsp;&nbsp;}</li><li class=\"\">}</li><li></li></ol></div>");
            article.setArticleSummary("测试内容content 如何让程序一直运行，很容易实现，只需要");
            article.setUserId(1L);
            article.setCategoryId(3L);

            this.articleDao.addArticle(article);
        }
    }

    @Test
    public void testArticleGroup() {
        List<Article> articleList = this.articleDao.listPartInfo();
        ArticleGroup articleGroup = new ArticleGroup(articleList);
        Map<String, Map<String, List<Article>>> group = articleGroup.getArticleGroup();
    }
}
