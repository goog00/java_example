package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 常用工具类
 *
 * @author hetiewei(贺铁伟)
 */
public class JayCommonUtil {


    /**
     * 按指定大小，分隔集合，将集合按规定个数分为n个部分
     *
     * @param list
     * @param len
     * @return
     */
    public static List<List<?>> splitList(List<?> list, int len) {
        if (list == null || list.size() == 0 || len < 1) {
            return null;
        }

        List<List<?>> result = new ArrayList<List<?>>();


        int size = list.size();
        int count = (size + len - 1) / len;


        for (int i = 0; i < count; i++) {
            List<?> subList = list.subList(i * len, ((i + 1) * len > size ? size : len * (i + 1)));
            result.add(subList);
        }
        return result;
    }

    public static void main(String[] args) {

        List<String> list =  new ArrayList<>(Arrays.asList("st","qq","ww","ee","rr","tt","yy"));
        List<List<?>> lists = splitList(list, 3);
        System.out.println(lists);

    }

}