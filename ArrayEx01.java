public class ArrayEx01 {

    public static void main(String[] args) {

        int[] price = { 12000, 35000, 6000, 8400, 430000 };
//        int[] price = new int[]{ 12000, 35000, 6000, 8400, 430000 };

        String[] mbti = { "INFP", "ENFP", "ISTJ", "ESTJ" };
//        String[] mbti = new int[]{ "INFP", "ENFP", "ISTJ", "ESTJ" };


        System.out.println(price);
        System.out.println(mbti);

        System.out.println(price.length);
        System.out.println(mbti.length);


        for (int i = 0; i < mbti.length; i++) {

            System.out.println(mbti[i]);
        }
    }

//    - 최초 선언 시, 자료형 뒤에 `[]` 를 붙여주면 해당 자료형의 배열을 선언할 수 있습니다.
//- `{}` 로 감싼 값들을 배열로 선언된 변수에 대입할 수 있습니다.
//- 배열의 요소는 순서를 의미하는 인덱스값을 가지며 `0` 부터 순서를 셉니다.
//- 전체 배열의 크기, 즉 요소의 갯수는 `length` 함수를 사용하여 확인할 수 있습니다.
//- 특정 인덱스(순서)의 값을 가져오기 위해서는 배열 변수 뒤에 `[인덱스]` 를 작성하면 됩니다.
//- 일반적으로 배열의 모든 요소에 대한 반복문을 적용할 때에는 `for (int i = 0; i < 배열변수.length; i++)` 와 같이 조건을 설정합니다. 인덱스가 `0`부터 시작한다는 점을 활용한 것이죠
//- `System.out.println(배열변수)` 와 같이 직접 배열 변수를 함수에게 전달하면 우리가 예상한 것과는 전혀 다른 내용이 출력됩니다. `[I@1b0375b3`, `[Ljava.lang.String;@2f7c7260` 와 같이 자료형과 뭔지 모를 문자들의 조합이 출력되죠. 이는 기본형 외의 자료형을 담는 변수가 값 자체가 아닌 주소를 가진다는 것을 드러냅니다.
//- `배열변수[인덱스] = 값` 의 형태로 기존 요소의 값을 덮어쓸 수 있습니다.
}