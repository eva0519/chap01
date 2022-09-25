import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0)
                a1.add(arr[i]);
        }

        if (a1.isEmpty()) {
            a1.add(-1);
        }

        answer = new int[a1.size()];

        for (int i = 0; i < a1.size(); i++) {
            answer[i] = a1.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }


    // 수박수박수박수박수박수?
    public static String solutionThree(int n) {
        String answer = "";

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                answer += "수";
            }

            if (i % 2 == 1) {
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

        for (int i = 0; i < completion.length; i++) {
//            인덱스에 위치한 이름이 다르면 완주하지 못한 사람. 바로 끝내서 동명이인 방지
            if (!(participant[i].equals(completion[i]))) {
                answer = participant[i];
                break;
            }
//            참가자 중 마지막 사람이 완주하지 못했을 때
            if (i == completion.length - 1)
                answer = participant[i + 1];
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
        for (int i = 0; i < strArr.length; i++) {
            if ((" ").equals(strArr[i]))
                idx = 0;
//            빈 문자열을 만나면 idx 값을 초기화 한다
            else {
//                idx가 짝수면 현재 위치의 문자를 대문자로 대입하고 idx증감
                if (idx % 2 == 0) {
                    idx++;
                    strArr[i] = strArr[i].toUpperCase();
//                idx가 홀수면 현재 위치의 문자를 소문자로 대입하고 idx증감
                } else {
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

//        버블 정렬
//        int temp = 0;
//        for (int i = answer.length - 1; i > -1; i--) {
//            for (int j = 0; j < i; j++) {
//                if(answer[j] > answer[j+1]) {
//                    temp = answer[j];
//                    answer[j] = answer[j+1];
//                    answer[j+1] = temp;
//                }
//            }
//        }

//        버블 역정렬
        // String.valueof() 메소드를 통하여 long타입을 String타입으로 변경 후,
        // String.toCharArray() 메소드를 통하여 String타입을 char[]로 변경한다.
        char[] arr = String.valueOf(n).toCharArray();
        // 임시 char변수
        char temp = 'a';
        // 버블정렬을 통한 숫자 재배치 , i-- 는 마지막 인덱스부터 하겠다는 의지
        for (int i = arr.length - 1; i > -1; i--) {
//            System.out.println(arr[i]);
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
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
        for (char i : arr) {
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
        answer = x == x.intValue() ? (long) Math.pow(x + 1, 2) : -1;
        return answer;
    }


//    문제 설명
//정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요. 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요.
// 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.
//
//제한 조건
//arr은 길이 1 이상인 배열입니다.
//인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.
//입출력 예
//arr	return
//[4,3,2,1]	[4,3,2]
//[10]	[-1]

    //    제일 작은 수 제거하기
    public static int[] solutionTen(int[] arr) {
        int[] answer = new int[arr.length - 1];
        if (arr.length <= 1) {
            answer = new int[]{-1};
            return answer;
        } else {
            int min = arr[0];
            for (int i = 1; i < arr.length; i++) {
                min = Math.min(min, arr[i]);
            }
//            min 값에 도달해도 계속해서 올라가야할 증가값 설정
            int arrIndex = 0;
            for (int i = 0; i < answer.length; i++) {

                if (min == arr[i]) {
                    answer[i] = arr[i + 1];
//                    arrIndex는 계속 증가
                    arrIndex++;
                }
//                arr[i]가 min 값일 때 다음 인덱스 값을 넣으면 다음에 또 같은 값이 들어가므로 계속 증가해줄 변수가 필요함
                answer[i] = arr[arrIndex++];
                System.out.println((arr[i] + " " + answer[i]));
            }
        }
        return answer;
    }


//    1937년 Collatz란 사람에 의해 제기된 이 추측은, 주어진 수가 1이 될 때까지 다음 작업을 반복하면, 모든 수를 1로 만들 수 있다는 추측입니다. 작업은 다음과 같습니다.
//
//1-1. 입력된 수가 짝수라면 2로 나눕니다.
//1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
//2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.
//예를 들어, 주어진 수가 6이라면 6 → 3 → 10 → 5 → 16 → 8 → 4 → 2 → 1 이 되어 총 8번 만에 1이 됩니다. 위 작업을 몇 번이나 반복해야 하는지 반환하는 함수, solution을 완성해 주세요.
// 단, 주어진 수가 1인 경우에는 0을, 작업을 500번 반복할 때까지 1이 되지 않는다면 –1을 반환해 주세요.
//n	        result
//6	        8
//16	    4
//626331	-1
//입출력 예 설명
//입출력 예 #1
//문제의 설명과 같습니다.
//
//입출력 예 #2
//16 → 8 → 4 → 2 → 1 이 되어 총 4번 만에 1이 됩니다.
//
//입출력 예 #3
//626331은 500번을 시도해도 1이 되지 못하므로 -1을 리턴해야 합니다.

    //  콜라츠 추측
    public static int solution1(int num) {
        int answer = 0;
        int count = 0;

        if (num == 1) return 0;

        while (num != 1) {

            if (count == 500) {
                count = -1;
                break;
            }
            if (num % 2 == 0) {
                num = num / 2;
            }
            if (num % 2 == 1) {
                num = (num * 3) + 1;
            }
            count++;

        }
        answer = count;

        return answer;
    }


//    문제 설명
//양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다. 예를 들어 18의 자릿수 합은 1+8=9이고,
// 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다. 자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.
//    제한 조건
//x는 1 이상, 10000 이하인 정수입니다
//    입출력 예
//arr	return
//10	true
//12	true
//11	false
//13	false
//입출력 예 설명
//입출력 예 #1
//10의 모든 자릿수의 합은 1입니다. 10은 1로 나누어 떨어지므로 10은 하샤드 수입니다.
//
//입출력 예 #2
//12의 모든 자릿수의 합은 3입니다. 12는 3으로 나누어 떨어지므로 12는 하샤드 수입니다.
//
//입출력 예 #3
//11의 모든 자릿수의 합은 2입니다. 11은 2로 나누어 떨어지지 않으므로 11는 하샤드 수가 아닙니다.
//
//입출력 예 #4
//13의 모든 자릿수의 합은 4입니다. 13은 4로 나누어 떨어지지 않으므로 13은 하샤드 수가 아닙니다.

    //    하샤드 수
    public static boolean solution2(int x) {
        boolean answer = true;

        int startNumber = x;
        // 자릿수 계산하기
        int n, temp;
        n = 0;
        temp = x;
        while (temp != 0) {
            n++;
            temp /= 10;
        }
        // 배열 생성
        int[] numbers = new int[n];
        // 각 자릿수를 분해하기
        temp = x;
        for (int i = numbers.length - 1; i >= 0; i--) {
            numbers[i] = temp % 10; // 배열의 맨 뒤에서부터, 입력받은 수의 제일 낮은 자리(1의자리수)를 나머지연산을 통해 저장.
            temp /= 10; // 10으로 나누어 10의자리수가 1의자리가 되도록 함.
        }
        int result = 0;
        for (int numb : numbers) {
            result += numb;
        }
        answer = startNumber % result == 0;

        return answer;
    }


//    문제 설명
//자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//n은 1 이상 100,000,000 이하인 자연수입니다.
//입출력 예
//n	result
//45	7
//125	229
//입출력 예 설명
//입출력 예 #1
//
//답을 도출하는 과정은 다음과 같습니다.
//n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
//45	1200	0021	7
//따라서 7을 return 해야 합니다.
//입출력 예 #2
//
//답을 도출하는 과정은 다음과 같습니다.
//n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
//125	11122	22111	229
//따라서 229를 return 해야 합니다.
//    3진법 뒤집기
public static int solution3(int n) {
    // 1. 3진법 변환의 나머지들을 취하는 변수.
    String str = "";
    // 2. 3진법 -> 10진법에 필요한 변수.
    int temp = 0;
    // 3. 10진법으로 다시 바꾼 변수.
    int answer = 0;
    // 4. n/3의 몫이 0이 될 때 까지 반복.
    while(n / 3 != 0){
        // 4-1. 나머지를 취한 후, n을 갱신.
        str+=n%3;
        System.out.printf("mok:[%d] remains:[%d]\n",n,n%3);
        n/=3;
    }
    // 5. 몫이 0일 때 반복문을 나왔으므로, 마지막 나머지는 n자체가 된다.
    str+=String.valueOf(n);
    System.out.printf("notation change complete:[%s]\n", str);

    // 6. 변환한 3진법을 맨 뒤에서부터 10진법으로 변환 시작.
    for(int i = str.length()-1;i>=0;i--){
        // 6-1. 해당 자릿수 * 3의 제곱수를 누적해간다.
        answer+=((str.charAt(i) - '0') * (int)Math.pow(3,temp));
        temp++;
    }
        System.out.printf("notation reverse + decimal change complete:[%s]\n", answer);

    // 7. 10진법으로 변환 완료.
    return answer;
}
//    Integer 서비스 메소드 써서 자주 쓰는 진법 쉽게 변환하는 법
//    N진법 -> 10진법
//      Integer.parseInt(i, N);
//    10진법 -> N진법
//      Integer.toBinaryString(number); // 2진법
//      Integer.toOctalString(number); // 8진법
//      Integer.toHexString(number); // 16진법

//    쓰지도 않는 이상한 진법을 요구할 때
//        String a = "";
//        while(n > 0){
//            a = (n % 3) + a;
//            n /= 3;
//        }
//        a = new StringBuilder(a).reverse().toString();
//        return Integer.parseInt(a,3);


    public static void main(String[] args) {
        int a = 125;

//        for (int abc :
//                solutionTen(a)) {
//            System.out.printf("[%d]", abc);
//        }
        System.out.println(solution3(a));
    }
}
