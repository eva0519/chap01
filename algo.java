import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;

public class algo {


    // 요일 구하기
    public String solutionOne(int a, int b) {

        String answer = "";
        LocalDate date = LocalDate.of(2016, a, b);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        answer = (dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US)).toUpperCase();
        return answer;
    }


    // 나누어 떨어지는 숫자 배열
    public int[] solutionTwo(int[] arr, int divisor) {
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
    public String solutionThree(int n) {
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
    public String solutionFour(String[] participant, String[] completion) {
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
    public String solutionFive(String s) {
        String answer = "";
        int idx = 0;

//        하나하나 쪼개서 배열로 넣기 공백도 배열에다 넣기
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
    public int solutionSix(int n) {
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
    public int[] solutionSeven(long n) {
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
    public long solutionEight(long n) {
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
    public long solutionNine(long n) {
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
    public int[] solutionTen(int[] arr) {
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
    public int solution1(int num) {
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
    public boolean solution2(int x) {
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
    public int solution3(int n) {
        // 3진법 변환의 나머지들을 취하는 변수.
        String str = "";
        // 3진법 -> 10진법에 필요한 변수.
        int temp = 0;
        // 10진법으로 다시 바꾼 변수.
        int answer = 0;
        // n/3의 몫이 0이 될 때 까지 반복.
        while (n / 3 != 0) {
            // 나머지를 취한 후, n을 갱신.
            str += n % 3;
            System.out.printf("mok:[%d] remains:[%d]\n", n, n % 3);
            n /= 3;
        }
        // 5. 몫이 0일 때 반복문을 나왔으므로, 마지막 나머지는 n자체가 된다.
        str += String.valueOf(n);
        System.out.printf("notation change complete:[%s]\n", str);

        // 6. 변환한 3진법을 맨 뒤에서부터 10진법으로 변환 시작.
        for (int i = str.length() - 1; i >= 0; i--) {
            // for문으로 배열을 거꾸로 돌려서 뒤집은 것처럼 10진법으로 변화시킨다.
            // 해당 자릿수 * 3의 제곱수를 누적해간다.
            answer += ((str.charAt(i) - '0') * (int) Math.pow(3, temp));
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


//    문제 설명
//명함 지갑을 만드는 회사에서 지갑의 크기를 정하려고 합니다. 다양한 모양과 크기의 명함들을 모두 수납할 수 있으면서, 작아서 들고 다니기 편한 지갑을 만들어야 합니다.
// 이러한 요건을 만족하는 지갑을 만들기 위해 디자인팀은 모든 명함의 가로 길이와 세로 길이를 조사했습니다.
//
//아래 표는 4가지 명함의 가로 길이와 세로 길이를 나타냅니다.
//
//명함 번호	가로 길이	세로 길이
//1	60	50
//2	30	70
//3	60	30
//4	80	40
//가장 긴 가로 길이와 세로 길이가 각각 80, 70이기 때문에 80(가로) x 70(세로) 크기의 지갑을 만들면 모든 명함들을 수납할 수 있습니다.
// 하지만 2번 명함을 가로로 눕혀 수납한다면 80(가로) x 50(세로) 크기의 지갑으로 모든 명함들을 수납할 수 있습니다. 이때의 지갑 크기는 4000(=80 x 50)입니다.
//
//모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다. 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때,
// 지갑의 크기를 return 하도록 solution 함수를 완성해주세요.

//    머리 속에서 카드를 뒤집어서 정리한 그림을 상상한다
//    일단 카드를 더 긴 쪽이 눕도록 뒤집어야 한다 같은 행 배열안의 두 수 중 더 큰 값을 가져오고
//    다른 한 쪽은 세로로 정하고 더 작은 쪽을 가져오기로 하자 현재 스코프 안에서 가로 세로 변수를 사용한다치면 명함은 예쁘게 정리한거나 마찬가지인 상태가 된다
//    이러면 기존 명함의 가로 세로 상태는 아무 의미가 없어진다 그러면 그냥 정리된 가로 세로 필드 중 가장 큰 값을 뽑아내기만 하면 된다
//    현재 상태에서 다른 명함과의 가로 세로를 비교해 더 큰 값들을 뽑아내 다른 곳에 담아둔다
//    명함의 수만큼 비교와 저장을 반복한다

//    최소직사각형

    public int solution4(int[][] sizes) {
//        가장 큰 가로 값을 대입할 변수
        int max_v = 0;
//        가장 큰 세로 값을 대입할 변수
        int max_h = 0;
        for (int i = 0; i < sizes.length; i++) {
//            같은 카드의 가로 세로중 더 큰 값을 저장한다
            int v = Math.max(sizes[i][0], sizes[i][1]);
//            같은 카드의 가로 세로중 더 작은 값을 저장한다
            int h = Math.min(sizes[i][0], sizes[i][1]);
//            현재 상태에서 사실상 카드를 더 긴 쪽을 가로로, 짧은 쪽을 세로로 하기로 뒤집어서 정리한 상태 
//            위에서 저장된 더 큰 값을 현재의 가장 큰 값과 비교하여 더 큰 값을 가로로 저장한다
            max_v = Math.max(max_v, v);
//            위에서 저장된 더 작은 값을 현재의 가장 큰 값과 비교하여 더 큰 값을 세로로 저장한다 (안그러면 지갑 위로 명함이 뚫고나온다)
            max_h = Math.max(max_h, h);
        }
        return max_v * max_h;
    }


//문제 설명
// 배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 
// 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. 
// 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 예를 들면,
//
//arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
//arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
//배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
//
//제한사항
//배열 arr의 크기 : 1,000,000 이하의 자연수
//배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
//입출력 예
//arr	answer
//[1,1,3,3,0,1,1]	[1,3,0,1]
//[4,4,4,3,3]	[4,3]
//입출력 예 설명
//입출력 예 #1,2
//문제의 예시와 같습니다.

    //    같은 숫자는 싫어
    public int[] solution5(int[] arr) {
        if (arr.length == 0 || arr.length == 1)
            return arr;
        ArrayList<Integer> list = new ArrayList<>();
//        0번 인덱스에 무조건 넣은 뒤 그 다음 인덱스부터 비교하려면?
//        처음 비교를 무조건 넘기는 중복 체크 변수에 -1을 넣어서 만든다
        int dupCheck = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != dupCheck) {
                list.add(arr[i]);
                dupCheck = arr[i];
            }
        }
//        현재 인덱스랑 앞에 인덱스랑 비교해서 넣어주면 마지막 인덱스까지 들어간다
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }


//문제 설명
//정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로
// 담아 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//numbers의 길이는 2 이상 100 이하입니다.
//numbers의 모든 수는 0 이상 100 이하입니다.
//입출력 예
//numbers	    result
//[2,1,3,4,1]	[2,3,4,5,6,7]
//[5,0,2,7]	    [2,5,7,9,12]
//입출력 예 설명
//입출력 예 #1
//
//2 = 1 + 1 입니다. (1이 numbers에 두 개 있습니다.)
//3 = 2 + 1 입니다.
//4 = 1 + 3 입니다.
//5 = 1 + 4 = 2 + 3 입니다.
//6 = 2 + 4 입니다.
//7 = 3 + 4 입니다.
//따라서 [2,3,4,5,6,7] 을 return 해야 합니다.
//입출력 예 #2
//
//2 = 0 + 2 입니다.
//5 = 5 + 0 입니다.
//7 = 0 + 7 = 5 + 2 입니다.
//9 = 2 + 7 입니다.
//12 = 5 + 7 입니다.
//따라서 [2,5,7,9,12] 를 return 해야 합니다.

    //    두 개 뽑아서 더하기
    public int[] solution6(int[] numbers) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
//            같은 인덱스에 있는 값 끼리 더해지지 않게 해야 한다 i를 오른쪽으로 한칸씩 움직이거나 왼쪽으로 한칸씩 움직이게 만듬
            for (int j = 0; j < i; j++) {
                if (!arr.contains(numbers[i] + numbers[j])) {
                    arr.add(numbers[i] + numbers[j]);
                }
            }
        }
        Collections.sort(arr);
        int[] answer = new int[arr.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }

//문제 설명
//로또 6/45(이하 '로또'로 표기)는 1부터 45까지의 숫자 중 6개를 찍어서 맞히는 대표적인 복권입니다. 아래는 로또의 순위를 정하는 방식입니다. 1
//
//순위	당첨 내용
//1	6개 번호가 모두 일치
//2	5개 번호가 일치
//3	4개 번호가 일치
//4	3개 번호가 일치
//5	2개 번호가 일치
//6(낙첨)	그 외
//로또를 구매한 민우는 당첨 번호 발표일을 학수고대하고 있었습니다. 하지만, 민우의 동생이 로또에 낙서를 하여, 일부 번호를 알아볼 수 없게 되었습니다. 당첨 번호 발표 후, 민우는 자신이 구매했던 로또로 당첨이 가능했던 최고 순위와 최저 순위를 알아보고 싶어 졌습니다.
//알아볼 수 없는 번호를 0으로 표기하기로 하고, 민우가 구매한 로또 번호 6개가 44, 1, 0, 0, 31 25라고 가정해보겠습니다. 당첨 번호 6개가 31, 10, 45, 1, 6, 19라면, 당첨 가능한 최고 순위와 최저 순위의 한 예는 아래와 같습니다.
//
//당첨 번호	31	10	45	1	6	19	결과
//최고 순위 번호	31	0→10	44	1	0→6	25	4개 번호 일치, 3등
//최저 순위 번호	31	0→11	44	1	0→7	25	2개 번호 일치, 5등
//순서와 상관없이, 구매한 로또에 당첨 번호와 일치하는 번호가 있으면 맞힌 걸로 인정됩니다.
//알아볼 수 없는 두 개의 번호를 각각 10, 6이라고 가정하면 3등에 당첨될 수 있습니다.
//3등을 만드는 다른 방법들도 존재합니다. 하지만, 2등 이상으로 만드는 것은 불가능합니다.
//알아볼 수 없는 두 개의 번호를 각각 11, 7이라고 가정하면 5등에 당첨될 수 있습니다.
//5등을 만드는 다른 방법들도 존재합니다. 하지만, 6등(낙첨)으로 만드는 것은 불가능합니다.
//민우가 구매한 로또 번호를 담은 배열 lottos, 당첨 번호를 담은 배열 win_nums가 매개변수로 주어집니다. 이때, 당첨 가능한 최고 순위와 최저 순위를 차례대로 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//lottos는 길이 6인 정수 배열입니다.
//lottos의 모든 원소는 0 이상 45 이하인 정수입니다.
//0은 알아볼 수 없는 숫자를 의미합니다.
//0을 제외한 다른 숫자들은 lottos에 2개 이상 담겨있지 않습니다.
//lottos의 원소들은 정렬되어 있지 않을 수도 있습니다.
//win_nums은 길이 6인 정수 배열입니다.
//win_nums의 모든 원소는 1 이상 45 이하인 정수입니다.
//win_nums에는 같은 숫자가 2개 이상 담겨있지 않습니다.
//win_nums의 원소들은 정렬되어 있지 않을 수도 있습니다.
//입출력 예
//  lottos	                    win_nums	                    result
//  [44, 1, 0, 0, 31, 25]	    [31, 10, 45, 1, 6, 19]	        [3, 5]
//  [0, 0, 0, 0, 0, 0]	        [38, 19, 20, 40, 15, 25]	    [1, 6]
//  [45, 4, 35, 20, 3, 9]	    [20, 9, 3, 45, 4, 35]	        [1, 1]
//입출력 예 설명
//입출력 예 #1
//문제 예시와 같습니다.
//
//입출력 예 #2
//알아볼 수 없는 번호들이 아래와 같았다면, 1등과 6등에 당첨될 수 있습니다.
//
//당첨 번호	38	19	20	40	15	25	결과
//최고 순위 번호	0→38	0→19	0→20	0→40	0→15	0→25	6개 번호 일치, 1등
//최저 순위 번호	0→21	0→22	0→23	0→24	0→26	0→27	0개 번호 일치, 6등
//입출력 예 #3
//민우가 구매한 로또의 번호와 당첨 번호가 모두 일치하므로, 최고 순위와 최저 순위는 모두 1등입니다.
//
//실제로 사용되는 로또 순위의 결정 방식과는 약간 다르지만, 이 문제에서는 지문에 명시된 대로 로또 순위를 결정하도록 합니다.  ↩


    //    로또의 최고 순위와 최저 순위
    public int[] solution7(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        ArrayList<Integer> tempLotto = new ArrayList<>();
        for (int i = 0; i < lottos.length; i++) {
            tempLotto.add(lottos[i]);
        }
        int winCount = 0;
        int zeroCount = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (tempLotto.contains(win_nums[i]))
                winCount++;
            if (tempLotto.get(i) == 0)
                zeroCount++;
        }

        if (zeroCount == 6) {
            answer[0] = 1;
            answer[1] = 6;
            return answer;
        }

        switch (winCount + zeroCount) {
            case 6:
                answer[0] = 1;
                break;
            case 5:
                answer[0] = 2;
                break;
            case 4:
                answer[0] = 3;
                break;
            case 3:
                answer[0] = 4;
                break;
            case 2:
                answer[0] = 5;
                break;
            case 1:
            case 0:
                answer[0] = 6;
                break;
        }

        switch (winCount) {
            case 6:
                answer[1] = 1;
                break;
            case 5:
                answer[1] = 2;
                break;
            case 4:
                answer[1] = 3;
                break;
            case 3:
                answer[1] = 4;
                break;
            case 2:
                answer[1] = 5;
                break;
            case 1:
            case 0:
                answer[1] = 6;
                break;
        }

        return answer;
    }
//    다른 분이 하신 거 rank를 미리 배열로 잡아놓음
//        public int[] solution(int[] lottos, int[] win_nums) {
//        int[] rank = {6, 6, 5, 4, 3, 2, 1};
//        int answer = 0;
//        int hidden = 0;
//
//        Arrays.sort(win_nums);
//        for (int i = 0; i < lottos.length; i++)
//            if (Arrays.binarySearch(win_nums, lottos[i]) > -1)
//                answer++;
//            else if (lottos[i] == 0)
//                hidden++;
//
//        return new int[] {rank[answer + hidden], rank[answer]};
//    }


//문제 설명
//수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
//
//1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
//2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
//3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
//
//1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
//
//제한 조건
//시험은 최대 10,000 문제로 구성되어있습니다.
//문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
//가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
//입출력 예
//answers	return
//[1,2,3,4,5]	[1]
//[1,3,2,4,2]	[1,2,3]

    //    모의고사
    public int[] solution8(int[] answers) {
        int[] firstPerson = {1, 2, 3, 4, 5};
        int[] secondPerson = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] thirdPerson = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] count = new int[3];
// 정답 1, 3, 2, 4, 2
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == firstPerson[i % 5]) count[0]++;
            if (answers[i] == secondPerson[i % 8]) count[1]++;
            if (answers[i] == thirdPerson[i % 10]) count[2]++;
        }
//      최대 수 구하기
        int maxScore = 0;
        for (int i : count) {
            if (i > maxScore)
                maxScore = i;
        }
//      돌아가면서 최대 수와 같으면 가변 배열에 넣어준다
        ArrayList<Integer> topScorePersons = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == maxScore) topScorePersons.add(i + 1);
        }
//      int[] 로 돌려주길 원하므로 변환해준다
        int[] result = new int[topScorePersons.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = topScorePersons.get(i);
        }

        return result;
    }

//    문제 설명
//문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
// 예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.
//
//제한 조건
//strings는 길이 1 이상, 50이하인 배열입니다.
//strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
//strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
//모든 strings의 원소의 길이는 n보다 큽니다.
//인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
//입출력 예
//strings	                    n	        return
//["sun", "bed", "car"]	        1	        ["car", "bed", "sun"]
//["abce", "abcd", "cdx"]	    2	        ["abcd", "abce", "cdx"]
//입출력 예 설명
//입출력 예 1
//"sun", "bed", "car"의 1번째 인덱스 값은 각각 "u", "e", "a" 입니다. 이를 기준으로 strings를 정렬하면 ["car", "bed", "sun"] 입니다.
//
//입출력 예 2
//"abce"와 "abcd", "cdx"의 2번째 인덱스 값은 "c", "c", "x"입니다. 따라서 정렬 후에는 "cdx"가 가장 뒤에 위치합니다.
// "abce"와 "abcd"는 사전순으로 정렬하면 "abcd"가 우선하므로, 답은 ["abcd", "abce", "cdx"] 입니다.

    // 문자열 내 마음대로 정렬하기
    public String[] solution9(String[] strings, int n) {
        String[] answer = {};
// sort 해야되니깐 list로 만들어준다
        ArrayList<String> str = new ArrayList<>();
        for (int i = 0; i < strings.length; i++)
            str.add(strings[i].charAt(n) + strings[i]);
//    >> ["sun", "bed", "car"] >> ["usun", "ebed", "acar"] n번째 글자만 가져와서 sort하기 편하게 앞에 붙여버린다
        Collections.sort(str);
//    정렬
//    이제 앞에걸 떼줘야 한다 떼는 김에 원하는 리턴 타입으로 돌려준다
        answer = new String[str.size()];
        for (int i = 0; i < str.size(); i++) {
            answer[i] = str.get(i).substring(1);
        }
        return answer;
    }

//문제 설명
//문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
//s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
//
//제한 사항
//str은 길이 1 이상인 문자열입니다.
//입출력 예
//      s	            return
//      "Zbcdefg"	    "gfedcbZ"

    //문자열 내림차순으로 배치하기
    public String solution10(String s) {
        String answer = "";

        ArrayList<String> str = new ArrayList<>();
        char[] splitChar = s.toCharArray();
        for (int i = 0; i < splitChar.length; i++) {
            str.add(String.valueOf(splitChar[i]));
        }
        Collections.sort(str);
        Collections.reverse(str);
        for (int i = 0; i < str.size(); i++) {
            answer += str.get(i);
        }
        return answer;
    }


//문제 설명
//주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때,
// nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
//nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
//입출력 예
//          nums	        result
//          [1,2,3,4]	    1
//          [1,2,7,6,4]	    4
//입출력 예 설명
//입출력 예 #1
//[1,2,4]를 이용해서 7을 만들 수 있습니다.
//
//입출력 예 #2
//[1,2,4]를 이용해서 7을 만들 수 있습니다.
//[1,4,6]을 이용해서 11을 만들 수 있습니다.
//[2,4,7]을 이용해서 13을 만들 수 있습니다.
//[4,6,7]을 이용해서 17을 만들 수 있습니다.

    //소수 만들기
    public int solution11(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < j; k++) {
                    if (sosu(nums[i] + nums[j] + nums[k]) == 1) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    //    소수 판별식 만들기
    public int sosu(int num) {
        if (0 == num || num == 1) return 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return 0;
        }
        return 1;
    }


//    네오와 프로도가 숫자놀이를 하고 있습니다. 네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.
//
//다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.
//
//  1478 → "one4seveneight"
//  234567 → "23four5six7"
//  10203 → "1zerotwozero3"
//이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다. s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.
//
//참고로 각 숫자에 대응되는 영단어는 다음 표와 같습니다.
//
//  숫자	영단어
//  0	zero
//  1	one
//  2	two
//  3	three
//  4	four
//  5	five
//  6	six
//  7	seven
//  8	eight
//  9	nine
//제한사항
//1 ≤ s의 길이 ≤ 50
//s가 "zero" 또는 "0"으로 시작하는 경우는 주어지지 않습니다.
//return 값이 1 이상 2,000,000,000 이하의 정수가 되는 올바른 입력만 s로 주어집니다.
//입출력 예
//s	result
//"one4seveneight"	1478
//"23four5six7"	234567
//"2three45sixseven"	234567
//"123"	123
//입출력 예 설명
//입출력 예 #1
//
//문제 예시와 같습니다.
//입출력 예 #2
//
//문제 예시와 같습니다.
//입출력 예 #3
//
//"three"는 3, "six"는 6, "seven"은 7에 대응되기 때문에 정답은 입출력 예 #2와 같은 234567이 됩니다.
//입출력 예 #2와 #3과 같이 같은 정답을 가리키는 문자열이 여러 가지가 나올 수 있습니다.
//입출력 예 #4
//
//s에는 영단어로 바뀐 부분이 없습니다.
//제한시간 안내
//정확성 테스트 : 10초

    //    숫자 문자열과 영단어
    public int solution12(String s) {
        int answer = 0;
//        해쉬맵 한번 써봐야지
        HashMap<Integer, String> numberToString = new HashMap<>();
//        귀찮은 녀석들 모아서 넣어주고
        String[] sNumber = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
//        해쉬맵에 순번대로 넣는다
        for (int i = 0; i < sNumber.length; i++) {
            numberToString.put(i, sNumber[i]);
        }
        for (int i = 0; i < numberToString.size(); i++) {
            s = s.replace(numberToString.get(i), Integer.toString(i));
        }
        answer = Integer.parseInt(s);
        return answer;
    }

//문제 설명
// 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
// 예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다.
// 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
//
//제한 조건
//공백은 아무리 밀어도 공백입니다.
//s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
//s의 길이는 8000이하입니다.
//n은 1 이상, 25이하인 자연수입니다.
//입출력 예
//      s	        n	    result
//      "AB"	    1	    "BC"
//      "z"	        1	    "a"
//      "a B z"	    4	    "e F d"

    //시저 암호
    public String solution13(String s, int n) {
        String answer = "";
//        아스키 코드 : 65 A ~ 90 Z, 97 a ~ 122 z  90->65  122->97  차 26개
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == ' ')
                continue;
            if (Character.isUpperCase(charArr[i]))
                charArr[i] = (char) ((charArr[i] - 'A' + n) % 26 + 'A');
            if (Character.isLowerCase(charArr[i]))
                charArr[i] = (char) ((charArr[i] - 'a' + n) % 26 + 'a');
        }
        for (char i : charArr) {
            answer += i;
        }
        return answer;
    }
//    Character.isUpperCase() 얘가 대문자 알려줌
//    Character.isLowerCase() 얘가 소문자 알려줌
//    toUpperCase()
//    toLowerCase()


//문제 설명
//카카오에 입사한 신입 개발자 네오는 "카카오계정개발팀"에 배치되어, 카카오 서비스에 가입하는 유저들의 아이디를 생성하는 업무를 담당하게 되었습니다. "네오"에게 주어진 첫 업무는 새로 가입하는 유저들이 카카오 아이디 규칙에 맞지 않는 아이디를 입력했을 때, 입력된 아이디와 유사하면서 규칙에 맞는 아이디를 추천해주는 프로그램을 개발하는 것입니다.
//다음은 카카오 아이디의 규칙입니다.
//
//아이디의 길이는 3자 이상 15자 이하여야 합니다.
//아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
//단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.
//"네오"는 다음과 같이 7단계의 순차적인 처리 과정을 통해 신규 유저가 입력한 아이디가 카카오 아이디 규칙에 맞는 지 검사하고 규칙에 맞지 않은 경우 규칙에 맞는 새로운 아이디를 추천해 주려고 합니다.
//신규 유저가 입력한 아이디가 new_id 라고 한다면,
//
//1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
//2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
//3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
//4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
//5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
//6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
//7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
//예를 들어, new_id 값이 "...!@BaT#*..y.abcdefghijklm" 라면, 위 7단계를 거치고 나면 new_id는 아래와 같이 변경됩니다.
//
//1단계 대문자 'B'와 'T'가 소문자 'b'와 't'로 바뀌었습니다.
//"...!@BaT#*..y.abcdefghijklm" → "...!@bat#*..y.abcdefghijklm"
//
//2단계 '!', '@', '#', '*' 문자가 제거되었습니다.
//"...!@bat#*..y.abcdefghijklm" → "...bat..y.abcdefghijklm"
//
//3단계 '...'와 '..' 가 '.'로 바뀌었습니다.
//"...bat..y.abcdefghijklm" → ".bat.y.abcdefghijklm"
//
//4단계 아이디의 처음에 위치한 '.'가 제거되었습니다.
//".bat.y.abcdefghijklm" → "bat.y.abcdefghijklm"
//
//5단계 아이디가 빈 문자열이 아니므로 변화가 없습니다.
//"bat.y.abcdefghijklm" → "bat.y.abcdefghijklm"
//
//6단계 아이디의 길이가 16자 이상이므로, 처음 15자를 제외한 나머지 문자들이 제거되었습니다.
//"bat.y.abcdefghijklm" → "bat.y.abcdefghi"
//
//7단계 아이디의 길이가 2자 이하가 아니므로 변화가 없습니다.
//"bat.y.abcdefghi" → "bat.y.abcdefghi"
//
//따라서 신규 유저가 입력한 new_id가 "...!@BaT#*..y.abcdefghijklm"일 때, 네오의 프로그램이 추천하는 새로운 아이디는 "bat.y.abcdefghi" 입니다.
//
//[문제]
//신규 유저가 입력한 아이디를 나타내는 new_id가 매개변수로 주어질 때, "네오"가 설계한 7단계의 처리 과정을 거친 후의 추천 아이디를 return 하도록 solution 함수를 완성해 주세요.
//
//[제한사항]
//new_id는 길이 1 이상 1,000 이하인 문자열입니다.
//new_id는 알파벳 대문자, 알파벳 소문자, 숫자, 특수문자로 구성되어 있습니다.
//new_id에 나타날 수 있는 특수문자는 -_.~!@#$%^&*()=+[{]}:?,<>/ 로 한정됩니다.
//
//[입출력 예]
//no	new_id	                        result
//예1	"...!@BaT#*..y.abcdefghijklm"	"bat.y.abcdefghi"
//예2	"z-+.^."	"z--"
//예3	"=.="	"aaa"
//예4	"123_.def"	"123_.def"
//예5	"abcdefghijklmn.p"	            "abcdefghijklmn"
//입출력 예에 대한 설명
//입출력 예 #1
//문제의 예시와 같습니다.
//
//입출력 예 #2
//7단계를 거치는 동안 new_id가 변화하는 과정은 아래와 같습니다.
//
//1단계 변화 없습니다.
//2단계 "z-+.^." → "z-.."
//3단계 "z-.." → "z-."
//4단계 "z-." → "z-"
//5단계 변화 없습니다.
//6단계 변화 없습니다.
//7단계 "z-" → "z--"
//
//입출력 예 #3
//7단계를 거치는 동안 new_id가 변화하는 과정은 아래와 같습니다.
//
//1단계 변화 없습니다.
//2단계 "=.=" → "."
//3단계 변화 없습니다.
//4단계 "." → "" (new_id가 빈 문자열이 되었습니다.)
//5단계 "" → "a"
//6단계 변화 없습니다.
//7단계 "a" → "aaa"
//
//입출력 예 #4
//1단계에서 7단계까지 거치는 동안 new_id("123_.def")는 변하지 않습니다. 즉, new_id가 처음부터 카카오의 아이디 규칙에 맞습니다.
//
//입출력 예 #5
//1단계 변화 없습니다.
//2단계 변화 없습니다.
//3단계 변화 없습니다.
//4단계 변화 없습니다.
//5단계 변화 없습니다.
//6단계 "abcdefghijklmn.p" → "abcdefghijklmn." → "abcdefghijklmn"
//7단계 변화 없습니다.

    //신규 아이디 추천

    public String solution14(String new_id) {
        StringBuilder answer;

//        1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        answer = new StringBuilder(new_id.toLowerCase());
        System.out.println(answer);

//        2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
//        answer = answer.replaceAll("[^a-z0-9-_.$]", "");
        for (int i = 0; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);
            if (Character.isAlphabetic(ch) ||
                    Character.isDigit(ch) ||
                    ch == '-' || ch == '_' || ch == '.')
                answer.append(ch);
        }
        System.out.println(answer);

//        3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
//        answer = answer.replaceAll("[.]{2,}", ".");
        while (answer.toString().contains(".."))
            answer = new StringBuilder(answer.toString().replace("..", "."));
        System.out.println(answer);

//        4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
//        if (answer.indexOf(".") == 0 ) answer = answer.substring(1, answer.length()-1);
//        if (answer.lastIndexOf(".") == answer.length()-1) answer = answer.substring(0, answer.length()-2);
        if ((answer.length() > 0) && answer.charAt(0) == '.')
            answer = new StringBuilder(answer.substring(1));
        if ((answer.length() > 0) && answer.charAt(answer.length() - 1) == '.')
            answer = new StringBuilder(answer.substring(0, answer.length() - 1));
        System.out.println(answer);
//        시작과 끝 (.)제거 replace("^[.]|[.]$")

//        5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if (answer.length() == 0)
            answer.append("a");
        System.out.println(answer);

//        6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//             만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
//        if (answer.length() >= 16)
//            answer = answer.substring(0, 15);
//        if (answer.lastIndexOf(".") == answer.length()-1) answer = answer.substring(0, answer.length()-2);
//        System.out.println(answer);
        if (answer.length() > 15) {
            answer = new StringBuilder(answer.substring(0, 15));
            if (answer.charAt(answer.length() - 1) == '.')
                answer = new StringBuilder(answer.substring(0, answer.length() - 1));
        }
        System.out.println(answer);

//        7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        while (answer.length() < 3)
            answer.append(answer.charAt(answer.length() - 1));

        return answer.toString();
    }

//    문제 설명
//두 정수 left와 right가 매개변수로 주어집니다. left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//1 ≤ left ≤ right ≤ 1,000
//입출력 예
//      left	right	result
//      13	    17	    43
//      24	    27	    52
//입출력 예 설명
//입출력 예 #1
//
//다음 표는 13부터 17까지의 수들의 약수를 모두 나타낸 것입니다.
//          수	        약수	            약수의 개수
//          13	        1, 13	            2
//          14	        1, 2, 7, 14	        4
//          15	        1, 3, 5, 15	        4
//          16	        1, 2, 4, 8, 16	    5
//          17	        1, 17	            2
//따라서, 13 + 14 + 15 - 16 + 17 = 43을 return 해야 합니다.
//입출력 예 #2
//
//다음 표는 24부터 27까지의 수들의 약수를 모두 나타낸 것입니다.
//수	약수	약수의 개수
//24	1, 2, 3, 4, 6, 8, 12, 24	8
//25	1, 5, 25	3
//26	1, 2, 13, 26	4
//27	1, 3, 9, 27	4
//따라서, 24 - 25 + 26 + 27 = 52를 return 해야 합니다.


//    약수의 개수와 덧셈
    public int solution15(int left, int right) {
        int answer = 0;
        
//        일단 left~right까지 연속되는 수를 배열로 만들어야 연산하기가 편하다
//        리턴값으로 원하는건 int 하나 뿐이므로 홀짝인지 확인할 값이 들어갈 변수 한개만 있으면 되겠다
        
        //        준비물 준비
        int NumberCount = (right-left) + 1;
        int[] iArr = new int[NumberCount];

        for (int i = 0; i < NumberCount; i++) {
            iArr[i] = left + i;
        }
//        배열 만들기 끝
//        배열 속의 수를 i=1 i로 나눈 나머지가 0이 되는 숫자를 카운트에 += 한 다음에 이 카운트가 짝수면 int 변수에 += 해주고 홀수면 -= 해준다

        for (int i = 0; i < iArr.length; i++) {
//            j 반복문이 끝나면 배열 원소 하나의 짝수 홀수 갯수 카운트가 끝난 것이므로 초기화 시켜준다
            int count = 0;
            for (int j = 1; j <= iArr[i]; j++) {
                if(iArr[i] % j == 0) {
                    count ++;
                }
            }
//            초기화 전 j의 반복으로 얻어낸 값을 최종 리턴값에 연산시켜줘야 한다
            if (count % 2 == 0)
                answer += iArr[i];
            else
                answer -= iArr[i];
        }

        return answer;
    }
    
//    다른 분의 풀이
//        public int solution(int left, int right) {
//        int answer = 0;
//
//        for (int i=left;i<=right;i++) {
//            //제곱수인 경우 약수의 개수가 홀수
//            if (i % Math.sqrt(i) == 0) {
//                answer -= i;
//            }
//            //제곱수가 아닌 경우 약수의 개수가 짝수
//            else {
//                answer += i;
//            }
//        }
//
//        return answer;
//    }
//    천잰가?


//문제 설명
//정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
//
//제한 사항
//n은 0 이상 3000이하인 정수입니다.
//입출력 예
//n	    return
//12	28
//5	    6
//입출력 예 설명
//입출력 예 #1
//12의 약수는 1, 2, 3, 4, 6, 12입니다. 이를 모두 더하면 28입니다.
//
//입출력 예 #2
//5의 약수는 1, 5입니다. 이를 모두 더하면 6입니다.

    //    약수의 합
    public int solution16(int n) {
        int answer = 0;
        ArrayList<Integer> yaksuList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(n % i == 0)
                yaksuList.add(i);
        }
        for(int num:yaksuList) answer+=num;
        return answer;
    }
    
//    다른 분의 풀이
//    class SumDivisor {
//    public int sumDivisor(int num) {
//        int answer = 0;
//            for(int i = 1; i <= num/2; i++){
//        if(num%i == 0) answer += i;
//      }
//        return answer+num;
//    }
//
//    // 아래는 테스트로 출력해 보기 위한 코드입니다.
//    public static void main(String[] args) {
//        SumDivisor c = new SumDivisor();
//        System.out.println(c.sumDivisor(12));
//    }
//}


//    예산
//문제 설명
//S사에서는 각 부서에 필요한 물품을 지원해 주기 위해 부서별로 물품을 구매하는데 필요한 금액을 조사했습니다. 그러나, 전체 예산이 정해져 있기 때문에 모든 부서의 물품을 구매해 줄 수는 없습니다. 그래서 최대한 많은 부서의 물품을 구매해 줄 수 있도록 하려고 합니다.
//
//물품을 구매해 줄 때는 각 부서가 신청한 금액만큼을 모두 지원해 줘야 합니다. 예를 들어 1,000원을 신청한 부서에는 정확히 1,000원을 지원해야 하며, 1,000원보다 적은 금액을 지원해 줄 수는 없습니다.
//
//부서별로 신청한 금액이 들어있는 배열 d와 예산 budget이 매개변수로 주어질 때, 최대 몇 개의 부서에 물품을 지원할 수 있는지 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//d는 부서별로 신청한 금액이 들어있는 배열이며, 길이(전체 부서의 개수)는 1 이상 100 이하입니다.
//d의 각 원소는 부서별로 신청한 금액을 나타내며, 부서별 신청 금액은 1 이상 100,000 이하의 자연수입니다.
//budget은 예산을 나타내며, 1 이상 10,000,000 이하의 자연수입니다.
//입출력 예
//d	budget	result
//[1,3,2,5,4]	9	3
//[2,2,3,3]	10	4
//입출력 예 설명
//입출력 예 #1
//각 부서에서 [1원, 3원, 2원, 5원, 4원]만큼의 금액을 신청했습니다. 만약에, 1원, 2원, 4원을 신청한 부서의 물품을 구매해주면 예산 9원에서 7원이 소비되어 2원이 남습니다. 항상 정확히 신청한 금액만큼 지원해 줘야 하므로 남은 2원으로 나머지 부서를 지원해 주지 않습니다. 위 방법 외에 3개 부서를 지원해 줄 방법들은 다음과 같습니다.
//
//1원, 2원, 3원을 신청한 부서의 물품을 구매해주려면 6원이 필요합니다.
//1원, 2원, 5원을 신청한 부서의 물품을 구매해주려면 8원이 필요합니다.
//1원, 3원, 4원을 신청한 부서의 물품을 구매해주려면 8원이 필요합니다.
//1원, 3원, 5원을 신청한 부서의 물품을 구매해주려면 9원이 필요합니다.
//3개 부서보다 더 많은 부서의 물품을 구매해 줄 수는 없으므로 최대 3개 부서의 물품을 구매해 줄 수 있습니다.
//
//입출력 예 #2
//모든 부서의 물품을 구매해주면 10원이 됩니다. 따라서 최대 4개 부서의 물품을 구매해 줄 수 있습니다.

    public int solution17(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int count = 0;
        for (int i = 0; i < d.length; i++) {
            if (answer + d[i] > budget) break;
            answer += d[i];
            count++;
        }
        return count;
    }

//    다른 분이 푼 방법
//      public int solution(int[] d, int budget) {
//      int answer = 0;
//
//        Arrays.sort(d);
//
//        for (int i = 0; i < d.length; i++) {
//            budget -= d[i];
//
//            if (budget < 0) break;
//
//            answer++;
//        }
//
//        return answer;
//  }
//    빼주는 방법도 있네


//    최대공약수와 최소공배수
//문제 설명
//두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요. 배열의 맨 앞에 최대공약수,
// 그다음 최소공배수를 넣어 반환하면 됩니다. 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.
//
//제한 사항
//두 수는 1이상 1000000이하의 자연수입니다.
//입출력 예
//      n	        m	        return
//      3	        12	        [3, 12]
//      2	        5	        [1, 10]
//입출력 예 설명
//입출력 예 #1
//위의 설명과 같습니다.
//
//입출력 예 #2
//자연수 2와 5의 최대공약수는 1, 최소공배수는 10이므로 [1, 10]을 리턴해야 합니다.

    public int[] solution18(int n, int m) {
        int gCD = 1, lCM = 0, nMinDivisor = n, mMinDivisor = m, maxNumber = Math.max(n, m);
        int index = 2;
        while(maxNumber != index) {
            if(nMinDivisor % index == 0 && mMinDivisor % index == 0) {
                gCD *= index;
                nMinDivisor /= index;
                mMinDivisor /= index;
            }
            else
                index++;
        }
        lCM = gCD * nMinDivisor * mMinDivisor;
        return new int[]{gCD, lCM};
    }

//    다른 사람의 풀이
//    public int[] gcdlcm(int a, int b) {
//        int[] answer = new int[2];
//
//        answer[0] = gcd(a,b);
//        answer[1] = (a*b)/answer[0];
//        return answer;
//    }
//
//    public static int gcd(int p, int q)
//    {
//        if (q == 0) return p;
//        return gcd(q, p%q);
//    }
//
//    // 아래는 테스트로 출력해 보기 위한 코드입니다.
//    public static void main(String[] args) {
//        TryHelloWorld c = new TryHelloWorld();
//        System.out.println(Arrays.toString(c.gcdlcm(3, 12)));
//    }
//    유클리드 호제법 사용해서 풀기


//문제 설명
//배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
//
//예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
//
//array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
//1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
//2에서 나온 배열의 3번째 숫자는 5입니다.
//배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때,
// commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
//
//제한사항
//array의 길이는 1 이상 100 이하입니다.
//array의 각 원소는 1 이상 100 이하입니다.
//commands의 길이는 1 이상 50 이하입니다.
//commands의 각 원소는 길이가 3입니다.
//          입출력 예
//          array	                        commands	                            return
//          [1, 5, 2, 6, 3, 7, 4]	        [[2, 5, 3], [4, 4, 1], [1, 7, 3]]	    [5, 6, 3]
//입출력 예 설명
//[1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.
//[1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.
//[1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.

    //    K번째수
    public int[] solution19(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

//        쉽게 낼 수 있는 문제를 정말 복잡하게 해놓음
//        i = slice index start, j = slice index end, k = sorting after search index number
//        두번째 2차원 배열은 그냥 도구처럼 쓰라는 의도의 문제인 것 같다
        for (int i = 0; i < commands.length; i++) {
            int[] copyArr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(copyArr);
            answer[i] = copyArr[commands[i][2]-1];
        }
        return answer;
    }
    
//    다른 분이 한 거
//    public int[] solution(int[] array, int[][] commands) {
//        int n = 0;
//        int[] ret = new int[commands.length];
//
//        while(n < commands.length){
//            int m = commands[n][1] - commands[n][0] + 1;
//
//            if(m == 1){
//                ret[n] = array[commands[n++][0]-1];
//                continue;
//            }
//
//            int[] a = new int[m];
//            int j = 0;
//            for(int i = commands[n][0]-1; i < commands[n][1]; i++)
//                a[j++] = array[i];
//
//            sort(a, 0, m-1);
//
//            ret[n] = a[commands[n++][2]-1];
//        }
//
//        return ret;
//    }
//
//    void sort(int[] a, int left, int right){
//        int pl = left;
//        int pr = right;
//        int x = a[(pl+pr)/2];
//
//        do{
//            while(a[pl] < x) pl++;
//            while(a[pr] > x) pr--;
//            if(pl <= pr){
//                int temp = a[pl];
//                a[pl] = a[pr];
//                a[pr] = temp;
//                pl++;
//                pr--;
//            }
//        }while(pl <= pr);
//
//        if(left < pr) sort(a, left, pr);
//        if(right > pl) sort(a, pl, right);
//    }
//    퀵 정렬로 구현하심 속도가 아주 빠름


//문제 설명
//자연수 n이 매개변수로 주어집니다. n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return 하도록 solution 함수를 완성해주세요. 답이 항상 존재함은 증명될 수 있습니다.
//
//제한사항
//3 ≤ n ≤ 1,000,000
//입출력 예
//n	result
//10	3
//12	11
//입출력 예 설명
//입출력 예 #1
//
//10을 3으로 나눈 나머지가 1이고, 3보다 작은 자연수 중에서 문제의 조건을 만족하는 수가 없으므로, 3을 return 해야 합니다.
//입출력 예 #2
//
//12를 11로 나눈 나머지가 1이고, 11보다 작은 자연수 중에서 문제의 조건을 만족하는 수가 없으므로, 11을 return 해야 합니다.

    //    나머지가 1이 되는 수 찾기
    public int solution20(int n) {
        int answer = 0;

        int x = 2;
        int result = 0;
        while(n > x) {
            result = n % x;
            if (result == 1) {
                answer = x;
                break;
            }
            x++;
        }
        return answer;
    }

//문제 설명
//1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
//
//소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
//(1은 소수가 아닙니다.)
//
//제한 조건
//n은 2이상 1000000이하의 자연수입니다.
//입출력 예
//          n	result
//          10	4
//          5	3
//입출력 예 설명
//입출력 예 #1
//1부터 10 사이의 소수는 [2,3,5,7] 4개가 존재하므로 4를 반환
//
//입출력 예 #2
//1부터 5 사이의 소수는 [2,3,5] 3개가 존재하므로 3를 반환
    //    소수 찾기
    public int solution21(int n) {
        int answer = 0;
//    소수 문제가 왜 이렇게 많은지 모르겠네 소수성애자들인가
        int index = 2;
//    자기 자신이 소수일 수도 있으므로 index <= n
        while(index <= n) {
            if(isPrimeNumber(index)){
                answer++;
            }
            index++;
        }
        return answer;
    }

// 소수 판별식을 만든다
    public boolean isPrimeNumber (int n) {
        if (0 == n || n == 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
//    다른 사람 풀이
//        int numberOfPrime(int n) {
//        int result = 0;
//        for(int i=2; i<=n; i++){
//        for(int j=2; j<=i; j++){
//        if(j == i){
//            ++result;
//        } else if(i%j == 0){
//            break;
//        }
//      }
//    }
//
//        return result;
//    }
//
//    public static void main(String[] args) {
//        NumOfPrime prime = new NumOfPrime();
//        System.out.println( prime.numberOfPrime(10) );
//    }
//    허허
    
    
    
//    슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌다. 그녀가 만든 프랜즈 오천성이 대성공을 거뒀지만, 요즘 신규 사용자의 수가 급감한 것이다.
//    원인은 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것이 문제였다.
//
//이 문제를 어떻게 할까 고민 한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했다.
// 역시 슈퍼 개발자라 대부분의 로직은 쉽게 구현했지만, 실패율을 구하는 부분에서 위기에 빠지고 말았다.
// 오렐리를 위해 실패율을 구하는 코드를 완성하라.
//
//실패율은 다음과 같이 정의한다.
//스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
//전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때, 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.
//
//제한사항
//스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
//stages의 길이는 1 이상 200,000 이하이다.
//stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.
//각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
//단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
//만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
//스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.
//입출력 예
//          N	            stages	                        result
//          5	            [2, 1, 2, 6, 2, 4, 3, 3]	    [3,4,2,1,5]
//          4	            [4,4,4,4,4]	                    [4,1,2,3]
//입출력 예 설명
//입출력 예 #1
//1번 스테이지에는 총 8명의 사용자가 도전했으며, 이 중 1명의 사용자가 아직 클리어하지 못했다. 따라서 1번 스테이지의 실패율은 다음과 같다.
//
//1 번 스테이지 실패율 : 1/8
//2번 스테이지에는 총 7명의 사용자가 도전했으며, 이 중 3명의 사용자가 아직 클리어하지 못했다. 따라서 2번 스테이지의 실패율은 다음과 같다.
//
//2 번 스테이지 실패율 : 3/7
//마찬가지로 나머지 스테이지의 실패율은 다음과 같다.
//
//3 번 스테이지 실패율 : 2/4
//4번 스테이지 실패율 : 1/2
//5번 스테이지 실패율 : 0/1
//각 스테이지의 번호를 실패율의 내림차순으로 정렬하면 다음과 같다.
//
//[3,4,2,1,5]
//입출력 예 #2
//
//모든 사용자가 마지막 스테이지에 있으므로 4번 스테이지의 실패율은 1이며 나머지 스테이지의 실패율은 0이다.
//
//[4,1,2,3]

//    실패율
    public int[] solution22(int N, int[] stages) {
        int[] answer = new int[N];
        HashMap<Integer, Float> failMap = new HashMap<>();
        ArrayList<Integer> player = new ArrayList<>();
        for (int stage : stages) {
            player.add(stage);
        }
        for (int i :
                player) {
            System.out.printf("[%d]",i);
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            int successer = 0;
            int failure = 0;
            for (Integer integer : player) {
                if (integer > i + 1) {
                    successer += 1;
                }
                if (integer == i + 1) {
                    failure += 1;
                }
            }
            if (successer == 0 && failure == 0)
                failMap.put(i+1, (float) 0);
            else
                failMap.put(i+1, (float) failure/(successer+failure));
            System.out.printf("%dstage failure:%d\n",i+1, failure);
            System.out.printf("%dstage successer:%d\n",i+1, successer);
        }
        for(Integer key:failMap.keySet()){
            System.out.println("key : " + key + "   float value : " + failMap.get(key));
        }
//        예쁘게 잘 정리해줌
//        이제 내림차순 정렬해서 보내주기만 하면 되는데 HashMap에 넣을 줄만 알지 쓸 줄 모른다 shit


//        키로만 이루어진 list를 하나 만들어서 HashMap Object의 키를 가져와 담아준다
        List<Integer> failMapkeyTable = new ArrayList<>(failMap.keySet());
//        람다식으로 list의 sort 기능을 사용할건데 HashMap failMap의 value값을 기준으로 List의 failMapkeyTable 정렬해야한다
//        익명함수로 failMap의 key에 해당하는 list failMapkeyTable의 value를 인자값으로 보내 해쉬맵 오브젝트의 o2키값으로 value값과 o1키값으로
//        value값을 compareTo 해서 내림차순으로 비교해서 sort
        failMapkeyTable.sort((o1, o2) -> failMap.get(o2).compareTo(failMap.get(o1)));

//        잘 뒤집어졌는지 확인
        for (Integer key : failMapkeyTable) {
            System.out.print("Key : " + key);
            System.out.println(", Val : " + failMap.get(key));
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = failMapkeyTable.get(i);
        }

        return answer;
    }

//    다른 분이 만든 것    Comparable이 가지고 있는 compareTo 메소드를 내림차순용으로 오버라이드 하여 사용하기 위해 구현
//    class Solution {
//    public int[] solution(int N, int[] lastStages) {
//        int nPlayers = lastStages.length;
//        int[] nStagePlayers = new int[N + 2];
//        for (int stage : lastStages) {
//            nStagePlayers[stage] += 1;
//        }
//
//        int remainingPlayers = nPlayers;
//        List<Stage> stages = new ArrayList<>();
//        for (int id = 1 ; id <= N; id++) {
//            double failure = (double) nStagePlayers[id] / remainingPlayers;
//            remainingPlayers -= nStagePlayers[id];
//
//            Stage s = new Stage(id, failure);
//            stages.add(s);
//        }
//        Collections.sort(stages, Collections.reverseOrder());
//
//        int[] answer = new int[N];
//        for (int i = 0; i < N; i++) {
//            answer[i] = stages.get(i).id;
//        }
//        return answer;
//    }
//
//    class Stage implements Comparable<Stage> {
//        public int id;
//        public double failure;
//
//        public Stage(int id_, double failure_) {
//            id = id_;
//            failure = failure_;
//        }
//
//        @Override
//        public int compareTo(Stage o) {
//            if (failure < o.failure ) {
//                return -1;
//            }
//            if (failure > o.failure ) {
//                return 1;
//            }
//            return 0;
//        }
//    }
//}
//    오오...


//문제 설명
//점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다.
// 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
// 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다.
// 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
//
//전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때,
// 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
//
//제한사항
//전체 학생의 수는 2명 이상 30명 이하입니다.
//체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
//여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
//여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
//여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며,
// 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
//입출력 예
//      n	                lost	                reserve	            return
//      5	                [2, 4]	                [1, 3, 5]	        5
//      5	                [2, 4]	                [3]	                4
//      3	                [3]	                    [1]	                2
//입출력 예 설명
//예제 #1
//1번 학생이 2번 학생에게 체육복을 빌려주고, 3번 학생이나 5번 학생이 4번 학생에게 체육복을 빌려주면 학생 5명이 체육수업을 들을 수 있습니다.
//
//예제 #2
//3번 학생이 2번 학생이나 4번 학생에게 체육복을 빌려주면 학생 4명이 체육수업을 들을 수 있습니다.

//    체육복을 빌려줄 수 있는 조건1 index -1 || index + 1
//    체육복을 빌려줄 수 있는 조건2 && have training wearable > 1
//    제공되는 데이터 : 전체 학생 n, 도난당한 학생 lost 배열, 체육복 2벌이상 학생 reserve 배열
//    최종 리턴값은 n - ((index -1 || index + 1) && have training wearable > 1) 이다
//    여벌 체육복이 있는 사람이 도난 당했을 경우를 생각해 reserve 에 lost가 있을 경우 빼줘야 한다
    
    //    체육복
    public int solution23(int n, int[] lost, int[] reserve) {
        int answer = 0;
        HashMap<Integer, Integer> lostPerson = new HashMap<>();
        HashMap<Integer, Integer> havePerson = new HashMap<>();

//        해쉬 맵에 넣어주기
        for (int i = 0; i < lost.length; i++) {
            lostPerson.put(i+1, lost[i]);
        }
        for (int i = 0; i < reserve.length; i++) {
            havePerson.put(i+1, reserve[i]);
        }
        
//        잘 들어갔나 확인
        for (Integer values: lostPerson.values()) {
            System.out.printf("[%d]", values);
        }
        System.out.println();
        for (Integer values: havePerson.values()) {
            System.out.printf("{%d}", values);
        }

//        체육복을 도둑맞은 사람 중에 여벌옷을 가지고 있던 사람이 있을 경우 맵에서 지운다
        for (int i = 0; i < lostPerson.size(); i++) {
            if(lostPerson.containsValue(havePerson.get(i+1)))
                havePerson.remove(i+1);
        }
        
//        잘 지워졌나 확인
        System.out.println();
        for (Integer values: havePerson.values()) {
            System.out.printf("{%d}", values);
        }
        
//        준비물은 갖추어졌으니 이제부터 풀면 된다
        for (int i = 1; i < n+1; i++) {
            // 여벌옷을 가진 사람 중 옷을 도둑맞은 사람의 앞 번호가 있을 경우
            if (havePerson.containsKey(lostPerson.get(i)-1)) {
                lostPerson.remove(i);
            }
            // 여벌옷을 가진 사람 중 옷을 도둑맞은 사람의 뒷 번호가 있을 경우
            if (havePerson.containsKey(lostPerson.get(i)+1))
                lostPerson.remove(i);
        }

//        여벌옷을 잘 빌렸을 경우 잃은 사람이 지워졌을테니 확인
        System.out.println();
        for (Integer values: havePerson.values()) {
            System.out.printf("{%d}", values);
        }

//        총 학생 수에 lost.size와 reserve.size를 더한 값을 빼면 원하는 리턴값이 된다
        answer = n - (lostPerson.size() + havePerson.size());

        System.out.println();
        return answer;
    }

    public static void main(String[] args) {
        algo method = new algo();
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.printf("result : [%d]", method.solution23(n, lost, reserve));

    }
}


