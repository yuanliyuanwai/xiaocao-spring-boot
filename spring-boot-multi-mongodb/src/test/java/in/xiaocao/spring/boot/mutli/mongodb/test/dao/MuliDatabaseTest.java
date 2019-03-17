package in.xiaocao.spring.boot.mutli.mongodb.test.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import in.xiaocao.spring.boot.multi.mongodb.Application;
import in.xiaocao.spring.boot.multi.mongodb.dao.first.FirstMongoObject;
import in.xiaocao.spring.boot.multi.mongodb.dao.first.FirstMongodbDao;
import in.xiaocao.spring.boot.multi.mongodb.dao.second.SecondMongoObject;
import in.xiaocao.spring.boot.multi.mongodb.dao.second.SecondMongodbDao;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {Application.class})
public class MuliDatabaseTest {

    @Autowired
    private FirstMongodbDao firstMongodbDao;

    @Autowired
    private SecondMongodbDao secondMongodbDao;

    @Test
    public void testSave() {

        System.out.println("************************************************************");
        System.out.println("测试开始");
        System.out.println("************************************************************");

        this.firstMongodbDao.save(new FirstMongoObject(null, "第一个库的对象"));
        this.secondMongodbDao.save(new SecondMongoObject(null, "第二个库的对象"));
                

        List<FirstMongoObject> primaries = this.firstMongodbDao.findAll();
        for (FirstMongoObject primary : primaries) {
            System.out.println(primary.toString());
        }

        List<SecondMongoObject> secondaries = this.secondMongodbDao.findAll();

        for (SecondMongoObject secondary : secondaries) {
            System.out.println(secondary.toString());
        }

        System.out.println("************************************************************");
        System.out.println("测试完成");
        System.out.println("************************************************************");
    }

}
