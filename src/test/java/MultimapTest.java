import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import org.junit.Test;

/**
 * Multimap用法
 * 特点：key可以相同，保存不同value
 * 业务场景：当需要构造像Map<K, List<V>>或者Map<K, Set<V>>这样比较复杂的数据结构时，可以采用Multimap
 * @author wangjiantao
 * @date 2020/5/18 12:11
 */
public class MultimapTest {


    /**
     * ArrayListMultimap用法
     * 注意：同一个key下，不同值可以同时存在
     */
    @Test
    public void test1(){
        ArrayListMultimap<Integer, String> map = ArrayListMultimap.create();
        map.put(1, "a");
        map.put(1, "a");
        map.put(1, "b");
        map.put(1, "c");
        map.put(2, "d");
        map.put(3, "d");
        map.put(3, "e");
        // {1=[a, a, b, c], 2=[d], 3=[d, e]}
        System.out.println(map);
    }
    /**
     * HashMultimap用法
     * 注意：同一个key下，不同值"不"可以同时存在
     */
    @Test
    public void test2(){
        HashMultimap<Integer, String> map = HashMultimap.create();
        map.put(1, "a");
        map.put(1, "a");
        map.put(1, "b");
        map.put(1, "c");
        map.put(2, "d");
        map.put(3, "d");
        map.put(3, "e");
        // {1=[a, b, c], 2=[d], 3=[d, e]}
        System.out.println(map);
    }
}
