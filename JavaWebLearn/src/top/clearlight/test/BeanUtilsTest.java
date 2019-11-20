package top.clearlight.test;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.Test;
import top.clearlight.login.domain.Student;

import java.lang.reflect.InvocationTargetException;

/**
 * 测试BeanUtils是根据setter和getter方法的后缀且首字母小写来获取和设置属性的,
 * 并不是根据实体类的属性来获取设置值.
 */
public class BeanUtilsTest {
    @Test
    public void test() {
        Student stu = new Student();
        try {
            BeanUtils.setProperty(stu, "years", "18");
            System.out.println(stu.getYears());
            String years = BeanUtils.getProperty(stu, "years");
            System.out.println(years);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }


}
