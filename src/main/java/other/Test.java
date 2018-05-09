package other;

import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.INTERNAL;
import utils.DateUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) throws InterruptedException {
//        int k = 3;
//        System.out.println(k>>>2);
//
//        Long k1 = 222l;
//        Long k2 = 222l;
//        System.out.println(k1.equals(k2) );

//        System.out.println(getExcelName(27));
//        String d = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        String s = hex10ToAnly(d, 26, 1);
//        System.out.println(s);

//        String name = "2222";
//        BigDecimal kk = null;
//        BigDecimal ll = BigDecimal.ZERO;
//        System.out.println(testNull(kk));

//        String kl = "14%";
//        System.out.println(kl.substring(0,kl.length()-1));
//
//        String kj = "-kk";
//        String kkk = "-";
//        System.out.println(kj.split("-")[1]);
//        String[] split = kkk.split("-");
//        System.out.println(split);
//
//        String kk = null;
//        System.out.println(StringUtils.isBlank(kk));
//
//        String startDate = null;
//        String endDate = null;
//        if(StringUtils.isBlank(startDate) || StringUtils.isBlank(endDate)){
//            String newStartDate = DateUtils.getBeforeAfterDateByDateParam(new Date(),-5);
//            endDate = DateUtils.getBeforeAfterDateByDateParam(new Date(),1);
//            startDate = newStartDate;
//        }
//        System.out.println(startDate);
//        System.out.println(endDate);
//
//
//        //
//        String regex = "get|select|query";
//        boolean first = matcherUrl(regex, "selectFirst");
//        System.out.println(first);


//        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
////        List<Integer> integers1 = integers.subList(1, 3);
////        System.out.println(integers1);
//
//        List<Integer> integers2 = integers.subList(8, 10);
//        System.out.println(integers2);
//        int k = 1;
//        System.out.println(k++);

//        List<Integer> integers = new ArrayList<>();
//        for (int k = 0; k < 1000000; k++) {
//            integers.add(k);
//        }
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//
//        int i = 0;
//        List<Integer> integers2 = new ArrayList<>();
//        while (true) {
//            System.out.println("i=" + i);
////            if(i < integers.size()){
//            for (; i < integers.size(); i++) {
//                executorService.submit(() -> {
//                    integers2.add(2);
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("+++++++++线程" + Thread.currentThread().getName() + " 开始导入++++++++++++++++++++++");
//                });
//            }
////            }
//
//            if (i == integers.size() && integers2.size() == integers.size()) {
//                System.out.println("break");
//                break;
//            } else {
//                Thread.sleep(1000);
//            }
//        }


//        String str = "www&<222";
//        boolean kk = str.contains("&<");
//        String s = str.replaceAll("&<", "&amp;");
//        System.out.println(s);
//        System.out.println(kk);

//        String s = str.replaceAll("<","&lt;");
//        System.out.println(s);
//        String kk = s.replaceAll(">","&gt;");
//        System.out.println(kk);
//        String kl = str.replaceAll("&","&amp;");
//        System.out.println(kl);
//        String kkk= str.replaceAll("\"","&quot;");
//        System.out.println(kkk);
//        String str = "www&>\"<222";
//        String kk = str.replaceAll("<","&lt;").replaceAll(">","&gt;")
//                .replaceAll("&","&amp;").replaceAll("\"","&quot;");
//        System.out.println(kk);


//        String kl = null;
//        String kk = null;
//
//        if(kl == null || kk == null || kl.equals("22")){
//            System.out.println("0000000000000000000");
//        }


//        String kk = "11";
//        System.out.println(kk.length());


//        String k = "sun1234";
//        String sun = "sun";
//        System.out.println(k.substring(sun.length(),k.length()));
//
//        List<String> list = new LinkedList<>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//
//        List<String> list2 = new LinkedList<>();
//        list2.add("1");
//        list2.add("2");
//
//        list.removeAll(null);
//        System.out.println(list);
//

//        String k = "e|2|4";
//        System.out.println(k.split("\\|")[1]);
        int k = 1;
        User user = new User();
        user.setAge(k++);

        System.out.println(user.getAge());


    }

    static class User{
        private String name;
        private Integer age;

        public User() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

    private static String testNull(Object object) {
        Optional<Object> op = Optional.ofNullable(object);
        if (op.isPresent()) {
            return op.get().toString();
        } else {
            return "33";
        }
    }

    private static String getExcelName(int i) {
        char[] allChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder sb = new StringBuilder();
        while (i > 0) {

            sb.append(allChar[i % 26 - 1]);

            i /= 26;

        }
        return sb.reverse().toString();
    }

    public static String hex10ToAnly(String digths, int num, int length) {
        StringBuffer str = new StringBuffer("");
        int base = digths.trim().length();
        if (0 == num) {
            str.append(digths.charAt(0));
        } else {
            Stack<Character> s = new Stack<Character>();
            while (num != 0) {
                s.push(digths.charAt(num % base));
                num /= base;
            }
            while (!s.isEmpty()) {
                str.append(s.pop());
            }
        }
        String prefix = "";
        String suffix = str.toString();
        if (length > suffix.length()) {
            for (int count = 0; count < length - suffix.length(); count++) {
                prefix = prefix + digths.charAt(0);
            }
        }
        return prefix + suffix;
    }


    public static boolean matcherUrl(String regex, String uri) {
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(uri);
        return matcher.find();
    }

    public static void tet(Boolean flag){
        flag = false;
    }
}