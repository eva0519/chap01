import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class algo {


// 요일 구하기
    public static String solutionOne(int a, int b) {

        String answer = "";
        LocalDate date = LocalDate.of(2016, a, b);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        answer = (dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US)).toUpperCase();
        return answer;
    }


// 나누어 떨어지는 숫자 배열
    public static int[] solutionTwo(int[] arr, int divisor) {
        int[] answer = {};
        ArrayList<Integer> a1 = new ArrayList<Integer>();

        for(int i=0; i<arr.length; i++) {
            if(arr[i]%divisor==0)
                a1.add(arr[i]);
        }

        if(a1.isEmpty()) {
            a1.add(-1);
        }

        answer = new int[a1.size()];

        for(int i=0; i<a1.size(); i++) {
            answer[i] = a1.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }


// 수박수박수박수박수박수?
    public static String solutionThree(int n) {
        String answer = "";

        for (int i = 0; i < n; i++) {
            if(i%2 == 0) {
                answer += "수";
            }

            if(i%2 == 1) {
                answer += "박";
            }
        }

        return answer;
    }


// 완주하지 못한 선수
    public static String solutionFour(String[] participant, String[] completion) {
        String answer = "";

//        정렬시켜서 인덱스를 동일하게 맞춰준다
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i = 0; i < completion.length; i++) {
//            인덱스에 위치한 이름이 다르면 완주하지 못한 사람. 바로 끝내서 동명이인 방지
            if(!(participant[i].equals(completion[i]))) {
                answer = participant[i];
                break;
            }
//            참가자 중 마지막 사람이 완주하지 못했을 때
            if(i == completion.length-1)
                answer = participant[i+1];
        }
        return answer;
    }


// 이상한 문자 만들기
    public static String solutionFive(String s) {
        String answer = "";
        int idx = 0;

//        하나하나 쪼개서 배열로 넣기
        String[] strArr = s.split("");

//        빈 문자열도 배열로 들어갔기 때문에 이제 돌림
        for(int i=0; i<strArr.length; i++) {
            if((" ").equals(strArr[i]))
                idx = 0;
//            빈 문자열을 만나면 idx 값을 초기화 한다
            else {
//                idx가 짝수면 현재 위치의 문자를 대문자로 대입하고 idx증감
                if(idx%2==0) {
                    idx++;
                    strArr[i] = strArr[i].toUpperCase();
//                idx가 홀수면 현재 위치의 문자를 소문자로 대입하고 idx증감
                }else {
                    idx++;
                    strArr[i] = strArr[i].toLowerCase();
                }
            }
//            공백도 다시 넣어서 문자열로 만들어 준다
            answer += strArr[i];
        }

        return answer;
    }


// 자릿수 더하기
    public static int solutionSix(int n) {
        int answer = 0;

        while (n != 0) {
            answer += n % 10;
//            int 자료형이라 10으로 나누면 소수점 아래 데이터 손실나서 날려줌
//            마지막에 n % 10 = 0이 될 경우에는 더해봤자 변함이 없으므로 처리하지 않아도 됨
            n /= 10;
        }

//        String s = Integer.toString(n);
//
//        for(int i=0; i<s.length(); i++){
////            스트링 하나하나 자르면서 정수로 변환해서 더하기
//            answer += Integer.parseInt(s.substring(i, i+1));
//        }

        return answer;
    }


// 자연수 뒤집기
    public static int[] solutionSeven(long n) {
        //        n은 10,000,000,000이하인 자연수입니다. 문제 조건
        //        long 변수명1 = 12147483647;    int 범위 -2,147,483,648 ~ 2,147,483,647
        //int 변수명2
        //1. String mA = String.valueOf(변수명1);
        //2. String mB = Long.toString(변수명1);
        //   String mC = Integer.toString(변수명2);
        //3. String mD = 변수명1 + "";
        // 문자열 + 숫자 = 문자열
        String a = "" + n;

        int[] answer = new int[a.length()];
        int cnt = 0;

        while (n > 0) {

            // 1) 12345 % 10 = 5
            // 2) 1234 % 10 = 4
            // 3) 123 % 10 = 3
            // 4) 12 % 10 = 2
            // 5) 1 % 10 = 1
            answer[cnt] = (int) (n % 10);
            // c++ 타임값으로 랜덤값 뽑아낼 때처럼 사용

            // 12345 = 1234
            // 1234 = 123
            // 123 = 12
            // 12 = 1
            // 1 = 0 ( 0.1 )
            n /= 10;

            cnt++;
        }

//            public int[] solution(long n) {
//        return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
//    }
//        바이너리 파일 사용한 3줄 짜리 코드  스트링빌더 객체 인스턴스화해서 append로 문자열로 바꾸고 reverse로 뒤집고

        return answer;
    }


// 내림차순으로 배치하기
    public static long solutionEight(long n) {
        long answer = 0;

        // 버블정렬(Bubble Sort) : 왼쪽(작은값) 오른쪽(큰값)으로 마지막까지 교차 교환
        // 인접한 두 개의 값을 비교하여
        // 더 큰값을 우측으로 보내는 정렬 알고리즘
        // 이미 정렬이 어느 정도 되어 있는 데이터에
        // 대한 수행속도가 매우 빠르며, 구현이 쉽다.
        // 단, 역으로 정렬되어 있는 배열을 정렬 할 때에는
        // 시간 복잡도가 제곱수 배로 증가하여 효율이 급격히 떨어진다.

//        int[] array = {6,4,2,1,3,5}; //array.length = 6, []는 5까지
        // 4, 6, 2, 1, 3, 5
        // 4, 2, 6, 1, 3, 5
        // 4, 2, 1, 6, 3, 5
        // 4, 2, 1, 3, 6, 5
        // 4, 2, 1, 3, 5, 6

        // 2, 4, 1, 3, 5, 6
        // 2, 1, 4, 3, 5, 6
        // 2, 1, 3, 4, 5, 6
        // 2, 1, 3, 4, 5, 6

        // 1, 2, 3, 4, 5, 6
//        int temp = 0; // 교환용 임시 변수

        // 배열의 길이 -1 (마지막 숫자 제외)
//        for(int i = array.length - 1; i > -1; i--) {    // i = 5 → 4 → 3 → 2 → 1 → 0
//            for(int j = 0; j < i; j++) {                 // i = 5 : j = 0 → 1 → 2 → 3 → 4
//                if(array[j] > array[j+1]) {             // 0 < 1 → 1 < 2 → 2 < 3 → 3 < 4 → 4 < 5
//                    temp = array[j];                    // temp에 0을 넣어준다. temp = 6
//                    array[j] = array[j+1];                // 0에 1을 넣어준다. array[0] = 4
//                    array[j+1] = temp;                    // 1에 temp를 넣어준다. // array[1] = 6, 교환 성립.
//                }
//
//            }
//        }

//        System.out.println(Arrays.toString(array)); //arrays클래스의 toString메소드 : []형태로 뽑아서 처리해줌.
        //변수명.toString()를 하게 되면 hashcode값을 가져오게 된다.

        
//        버블 역정렬
        // String.valueof() 메소드를 통하여 long타입을 String타입으로 변경 후,
        // String.toCharArray() 메소드를 통하여 String타입을 char[]로 변경한다.
        char[] arr = String.valueOf(n).toCharArray();
        // 임시 char변수
        char temp = 'a';
        // 버블정렬을 통한 숫자 재배치 , i-- 는 마지막 인덱스부터 하겠다는 의지
        for(int i = arr.length - 1; i > -1; i--) {
//            System.out.println(arr[i]);
            for(int j=0; j < i; j++) {
                if(arr[j] < arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
//                이 반복문을 통해 배열이 내림차순으로 변해가는 과정을 볼 수 있다
//                for (int k = 0; k < arr.length; k++) {
//                    for (int l = 0; l < arr.length; l++) {
//                        System.out.print("[" + arr[l] + "]");
//                    }
//                    System.out.print("\n");
//                }
            }
        }

        // char[] → String
        StringBuilder str = new StringBuilder();
        for(char i : arr) {
            str.append(i);
        }
        // Long.parseLong()메소드를 통하여 String → Long타입 변환
        return Long.parseLong(str.toString());
    }


//    임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
//    n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
//    제한 사항
//    n은 1이상, 50.000.000.000.000 이하인 양의 정수입니다.
// 입출력 예
//n	    return
//121	144
//3	    -1
//입출력 예 설명
//입출력 예#1
//121은 양의 정수 11의 제곱이므로, (11+1)를 제곱한 144를 리턴합니다.
//
//입출력 예#2
//3은 양의 정수의 제곱이 아니므로, -1을 리턴합니다.


// 정수 제곱근 판별
//    Math.sqrt 제곱근, Math.pow 제곱, intValue() 정수 숫자로 변환
    public static long solutionNine(long n) {
        long answer = 0;
        Double x = Math.sqrt(n);
        answer = x == x.intValue()?(long)Math.pow(x + 1, 2):-1;
        return answer;
    }


//    제일 작은 수 제거하기



    public static void main(String[] args) {
        long a = 121;

        System.out.println(solutionNine(a));

    }

}
