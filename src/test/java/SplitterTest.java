import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author wangjiantao
 * @date 2020/5/16 19:16
 */
public class SplitterTest {

    /**
     * 分隔字符串
     */
    @Test
    public void testSplitter(){
        // 将字符串按指定字符分割
        List<String> result = Splitter.on("@").splitToList("aa@bb@cc@dd@ee");
        // 断言判断不空
        assertThat(result, notNullValue());
        // 断言判断list长度为5
        assertThat(result.size(), equalTo(5));
        // 断言判断各个元素
        assertThat(result.get(0), equalTo("aa"));
        assertThat(result.get(1), equalTo("bb"));
        assertThat(result.get(2), equalTo("cc"));
        assertThat(result.get(3), equalTo("dd"));
        assertThat(result.get(4), equalTo("ee"));
    }

    /**
     * 分隔字符串（忽略分隔后元素null的情况）
     */
    @Test
    public void testSplitter2(){
        // 将字符串按指定字符分割   omitEmptyStrings()忽略掉null
        List<String> result = Splitter.on("@").omitEmptyStrings().splitToList("aa@bb@cc@dd@ee@@@");
        // 断言判断不空
        assertThat(result, notNullValue());
        // 断言判断list长度为5
        assertThat(result.size(), equalTo(5));
        // 断言判断各个元素
        assertThat(result.get(0), equalTo("aa"));
        assertThat(result.get(1), equalTo("bb"));
        assertThat(result.get(2), equalTo("cc"));
        assertThat(result.get(3), equalTo("dd"));
        assertThat(result.get(4), equalTo("ee"));
    }

    /**
     * 按指定长度截取元素
     */
    @Test
    public void testSplitter3(){
        // 按2位截取放入list
        List<String> list = Splitter.fixedLength(2).splitToList("abcdefg");
        // 断言 判断不空
        assertThat(list, notNullValue());
        // 断言 判断长度
        assertThat(list.size(), equalTo(4));
        // 断言 判断元素
        assertThat(list.get(0), equalTo("ab"));
        assertThat(list.get(1), equalTo("cd"));
        assertThat(list.get(2), equalTo("ef"));
    }

    /**
     * 按指定符号截取
     */
    @Test
    public void testSplitter4(){
        // 按指定符号截取
        List<String> list = Splitter.on("#").limit(3).splitToList("aa#bb#cc#dd#ee#ff#gg");
        // 断言 判断不空
        assertThat(list, notNullValue());
        // 断言 判断长度
        assertThat(list.size(), equalTo(3));
        // 断言 判断元素
        assertThat(list.get(0), equalTo("aa"));
        assertThat(list.get(1), equalTo("bb"));
        assertThat(list.get(2), equalTo("cc#dd#ee#ff#gg"));
    }

    /**
     * 按正则表达式规则截取
     * trimResults()去空格
     * omitEmptyStrings()忽略空
     */
    @Test
    public void testSplitter5(){
        // 按正则表达式截取
        List<String> list = Splitter.onPattern("\\|").trimResults().omitEmptyStrings().splitToList("aa|bb|cc|dd|ee|ff|gg| | ||");
        // 断言 判断不空
        assertThat(list, notNullValue());
        // 断言 判断长度
        assertThat(list.size(), equalTo(7));
    }

    /**
     * 拆出来的放到map里
     */
    @Test
    public void testSplitter6(){
        // 按正则表达式截取
        Map<String, String> map = Splitter.onPattern("\\|").trimResults().omitEmptyStrings().withKeyValueSeparator("=").split("aa=6| |cc=dd|||ff=8|| | ||");
        // 断言 判断不空
        assertThat(map, notNullValue());
        // 断言 判断长度
        assertThat(map.size(), equalTo(3));
    }
}
