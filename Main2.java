import java.util.ArrayList;
import java.util.Collections;

public class Main2 {

    //    자연수 뒤집어 더하기
//    자연수의 n의 각 자리 숫자를 뒤집은 순서로 더해 출력하는 수식을 리턴해주세요.
//    예를들어 n이 1234이면 "5+4+3+2+1=15" 라는 문자열을 리턴합니다.

    public static void main(String[] args) {
        Main2 method = new Main2();

//        String s = "97 75 88 99 95 92 73";
        String s = "97 75 88 99 95 92 73";
        System.out.println(method.solution3(s));

//        int[] arr1 = {9,9,9,9,7,9,8};
//        int[] arr2 = {23,23,30,28,30,23,23};
//        102

//        System.out.println(method.solution2(arr1, arr2));
//        System.out.println((method.solution1(718253)));
    }


//    소수의 개수와 덧셈 (상)
//    문제 설명
//    문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. str 나타나는 숫자 중 소수의 최대값
//    과 소수가 아닌 수의 최소값을 찾아 이를 "(최소값)(최대값)" 형태의 문자열을 변환하는 함수
//    solution을 완성하세요.
//    예를들어 s가 "2,3,4,5"라면 "4,5"를 리턴하고, "15 3 10 9 7 8"라면 "8 7"을 리턴하면 됩니다.

//    제한 사항 s에는 둘 이상의 정수가 공백으로 구분되어 있습니다
//    문자열에는 소수가 한개 이상 섞여 있습니다.
//    문자열에는 소수가 아닌 수가 한개 이상 섞여 있습니다.
//    음수는 없습니다
//    97 75 88 99 95 92 73      75 97

    public String solution3(String s) {
//        공백 없애고 string 배열로 잘라버리기
        String[] strings = s.split(" ");
//        일일히 타입 캐스팅 해주기 귀찮으니까 인트 배열에 넣어줌
        int[] intArr = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            intArr[i] = Integer.parseInt(strings[i]);
        }
//        소수 중 가장 큰 수와 비소수 중 가장 작은 수 구할 변수값 마련
        int maxPrime = 0;
        int minPrime = Integer.MAX_VALUE;
        for (int j : intArr) {
            if (primeNumber(j))
                maxPrime = Math.max(maxPrime, j);
            else
                minPrime = Math.min(minPrime, j);
        }
//        공백 넣어서 돌려줌
        return minPrime + " " + maxPrime;
    }
// 소수 판별식
    public boolean primeNumber(int n) {
        if (n == 1 || n == 0) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }


    //        몇 시간 했더라?
//        지용이는 항해에서 한주동안 공부기록을 남길 알고리즘을 만들어보기로 했다
//        항해의 체크인 페이지에는 몇가지 조건이 있는데 이를 만족하는 알고리즘을 만들어보자
//        체크인과 체크아웃은 항상 정시에 진행한 것으로 가정한다
//        체크아웃을 할때 익일 시간은 24+a 로 계산한다. 즉 새벽 2시는 24+2인 26으로 표기한다
//        체크인 페이지는 체크아웃이 새벽 5시 정각이나 새벽 5시를 넘어가면 체크아웃을 깜빡한 것으로 간주한다.
//        따라서 새벽 5시가 넘어가 체크아웃을 하게 되면 자동으로 체크아웃을 오후 9시(21시)로 한 것으로 처리한다.

//    if(x >= 29 ? x = 21)

    public int solution2(int[] arr1, int[] arr2) {
        int answer = 0;
        int checkOver = 29;
        int checkOutDefault = 21;
//        쓸 변수들을 미리 만들어준다
//        다음부터는 오버로딩을 통해 위 두 변수값을 받아온다 치면 변수만 바꿔도 체크오버 체크아웃디폴트 시간을 정해줄 수 있다

//        for문 돌리면서 연산한다. 새벽5시면 24 + 5이므로 29이다. 29시를 포함해야 한다.
        for (int i = 0; i < arr1.length; i++) {
            if (arr2[i] >= checkOver)
                answer += (checkOutDefault - arr1[i]);
            else
                answer += arr2[i] - arr1[i];
        }

        return answer;
    }

    public String solution1(int n) {
        StringBuilder answer = new StringBuilder();
        ArrayList<Integer> tempArr = new ArrayList<>();

//        자릿수 나눠서 리스트에 담아주기
        while(n > 0){
            tempArr.add(n % 10);
            n = n / 10;
        }

//        정렬시킨뒤 반전시켜서 내림차순으로 만들어주기
        Collections.sort(tempArr);
        Collections.reverse(tempArr);

//        합계 구하기
        int total = 0;
        for (int temp :
                tempArr) {
            total += temp;
        }
        
//        list에 순서대로 담아주면서 + 같이 넣기
        for (Integer integer : tempArr) {
            answer.append(integer).append("+");
        }

//        귀찮아서 함께 넣은 마지막 +는 삭제되지 않았으므로 replace로 마지막 인덱스를 = 문자열로 바꿔주기 + 하는 김에 합계도 추가
        answer.replace(answer.length()-1, answer.length(), "=").append(total);

        return answer.toString();
    }

//    public static void main(String[] args) {
//        Main method = new Main();
//        System.out.println((method.solution(718253)));
//    }

}
