import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author wangjiantao
 * @date 2020/5/18 9:25
 */
public class SetTest {

    @Test
    public void test1(){
        // 创建set
        HashSet<String> set = Sets.newHashSet("1", "2", "3");
        assertThat(set.size(), equalTo(3));

        ArrayList<String> list = Lists.newArrayList("a", "b", "b", "c");
        // 由list数据创建set(去重)
        HashSet<String> set2 = Sets.newHashSet(list);
        assertThat(set2.size(), equalTo(3));

        // 笛卡尔集
        Set<List<String>> set3 = Sets.cartesianProduct(Sets.newHashSet("1", "2"), Sets.newHashSet("1", "3"));
        assertThat(set3.toString(), equalTo("[[1, 1], [1, 3], [2, 1], [2, 3]]"));

        // 产生子集
        HashSet<String> set4 = Sets.newHashSet("1", "2", "3");
        Set<Set<String>> combinations = Sets.combinations(set4, 2);
        /**
         * [1, 2]
         * [1, 3]
         * [2, 3]
         */
        combinations.forEach(System.out::println);
    }

    /**
     * 两个集合的差集
     */
    @Test
    public void test2(){
        HashSet<Integer> set5 = Sets.newHashSet(1, 2, 3);
        HashSet<Integer> set6 = Sets.newHashSet(1, 4, 5);
        // 差集：在set5里不在set6里
        Sets.SetView<Integer> difference = Sets.difference(set5, set6);
        // [2, 3]
        System.out.println(difference);
    }

    /**
     * 两个集合的交集
     */
    @Test
    public void test3(){
        HashSet<Integer> set7 = Sets.newHashSet(1, 2, 3);
        HashSet<Integer> set8 = Sets.newHashSet(1, 4, 5);
        Sets.SetView<Integer> intersection = Sets.intersection(set7, set8);
        // [1]
        System.out.println(intersection);
    }

    /**
     * 两个集合的并集
     */
    @Test
    public void test4(){
        HashSet<Integer> set1 = Sets.newHashSet(1, 2, 3);
        HashSet<Integer> set2 = Sets.newHashSet(1, 4, 5);
        Sets.SetView<Integer> intersection = Sets.union(set1, set2);
        // [1, 2, 3, 4, 5]
        System.out.println(intersection);
    }
}
