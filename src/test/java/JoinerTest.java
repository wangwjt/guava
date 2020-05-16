import com.google.common.base.Joiner;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertThat;

/**
 * Joiner学习
 * @author wangjiantao
 * @date 2020/5/16 17:19
 */
public class JoinerTest {

    List<String> list1 = Arrays.asList("google", "baidu", "sohu");
    List<String> list2 = Arrays.asList("aa", "bb", "cc", null);
    Map<Integer, String> map;

    @Test
    public void testJoiner(){
        // list转换成String，以#分隔
        String result = Joiner.on("#").join(list1);
        // 断言
        assertThat(result, equalTo("google#baidu#sohu"));
    }

    @Test
    public void testJoiner2(){
        map = new HashMap<Integer, String>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        // map转换成String，以#分隔,key和value之间用：分隔
        String result = Joiner.on("#").withKeyValueSeparator(":").join(map);
        System.out.println(result);
        // 断言
        assertThat(result, equalTo("1:a#2:b#3:c"));
    }

    @Test
    public void testJoinerWithNoValue(){
        // list转换成String，以#分隔,跳过空格
        String result = Joiner.on("#").skipNulls().join(list2);
        // 断言
        assertThat(result, equalTo("aa#bb#cc"));
    }

    @Test
    public void testJoinerWithNoValueUseDefaultValue(){
        // list转换成String，以#分隔,遇到null替换成"DEFAULT"
        String result = Joiner.on("#").useForNull("DEFAULT").join(list2);
        // 断言
        assertThat(result, equalTo("aa#bb#cc#DEFAULT"));
    }
    @Test
    public void testJoinerAppenedTo(){
        // list转换成String，以#分隔,遇到null替换成"DEFAULT"
        StringBuilder builder = new StringBuilder();
        StringBuilder resultBuilder = Joiner.on("#").useForNull("DEFAULT").appendTo(builder, list2);
        // 断言 判断同一个实例
        assertThat(resultBuilder, sameInstance(builder));
        assertThat(resultBuilder.toString(), equalTo("aa#bb#cc#DEFAULT"));
        assertThat(builder.toString(), equalTo("aa#bb#cc#DEFAULT"));
    }
}
