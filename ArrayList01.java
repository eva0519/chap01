import java.util.ArrayList;

public class ArrayList01 {

    public static void main(String[] args) {

        ArrayList list1 = new ArrayList(5);
        list1.add(100);
        list1.add("INFP");

        for (int i = 0; i < list1.size(); i++) {

            System.out.println(list1.get(i));
        }



        ArrayList<Integer> list2 = new ArrayList<Integer>(5);
        list2.add(100);
//        list2.add("INFP");

        for (int i = 0; i < list2.size(); i++) {

            System.out.println(list2.get(i));
        }

//        - ArrayList는 기본적으로 Object, 즉 모든 Java 객체를 담을 수 있습니다. 하지만 시스템 안정성을 위해 요소의 자료형을 제한해야 할 경우
//- `add()` 함수를 통해 요소를 추가할 수 있습니다.
//- ArrayList 크기, 요소의 갯수를 확인하기 위해서는 `size()` 함수를 사용합니다.
//- 특정 인덱스의 값을 사용하기 위해서는 `ArrayList변수.get(인덱스)` 와 같이 작성합니다.

    }
}