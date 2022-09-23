public class OperComp01 {

    public static void main(String[] args) {

        int num1 = 1;
        int num2 = 2;
        int num3 = 1;
        String str = "Sparta";

        System.out.println(num1 > num2);
        System.out.println(num1 < num2);

        System.out.println(num1 <= num2);
        System.out.println(num1 <= num3);

        System.out.println(num1 >= num2);
        System.out.println(num1 >= num3);

        System.out.println(num1 == num2);
        System.out.println(num1 == num3);

        System.out.println(num1 != num2);
        System.out.println(num1 != num3);

        System.out.println(str.equals("Sparta"));

//        추가로, 문자열의 값이 같은지의 대한 여부는 == 연산자로 확인할 수 없습니다.
//        변수에 담긴 것이 문자열 값 그 자체가 아닌 메모리의 주소이기 때문이지요.
//        문자열 값에 대한 비교는 equals() 로 수행할 수 있습니다.

    }
}