import java.util.HashMap;

public class HashMap01 {

    public static void main(String[] args) {

        HashMap map01 = new HashMap();
        map01.put("age", 31);
        map01.put("mbti", "INFP");

        System.out.println(map01.get("age"));


        HashMap<String, String> map02 = new HashMap<String, String>();
//        map02.put("age", 31);
        map02.put("mbti", "INFP");

        System.out.println(map02.get("mbti"));
    }
}