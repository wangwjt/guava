import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author wangjiantao
 * @date 2020/5/16 21:59
 */
public class ListTest {

    /**
     * 使用Lists.newArrayList构造list
     */
    @Test
    public void test1(){
        // 用Lists.newArrayList方式创建对象
        ArrayList<String> list = Lists.newArrayList("aa", "bb");
        System.out.println(list);
    }

    /**
     * 构造笛卡尔积
     */
    @Test
    public void test2(){
        // 构造笛卡尔积
        List<List<String>> lists = Lists.cartesianProduct(Lists.newArrayList("1", "2"),
                Lists.newArrayList("a", "b"));
        assertThat(lists.toString(), equalTo("[[1, a], [1, b], [2, a], [2, b]]"));
    }

    /**
     * 逆序
     */
    @Test
    public void test3(){
        ArrayList<String> list = Lists.newArrayList("a", "b", "c");
        List<String> reverse = Lists.reverse(list);
        assertThat(reverse.toString(), equalTo("[c, b, a]"));
    }

    /**
     * 分组
     */
    @Test
    public void test4(){
        ArrayList<String> list = Lists.newArrayList("a", "b", "c", "d", "e", "f", "g");
        // 分组
        List<List<String>> partition = Lists.partition(list, 3);
        assertThat(partition.toString(), equalTo("[[a, b, c], [d, e, f], [g]]"));
    }
}
