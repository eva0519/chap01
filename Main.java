import java.util.*;

public class Main {

//    1번. 없는 정수 사이의 합 (하)
//  0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다. numbers에서 찾을 수 없는 숫자는 두개입니다.
//  두 정수를 a,b라고 했을 때, a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요. 예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.
//  입출력 예
//  [1,2,4,6,7,8,9,0]
//  12
//  [7,8,3,5,6,1,2,4]
//  45
//  지정 입력값
//  [1,3,5,9,2,4,8,0]
//  13

    public int solution1(int[] arr1) {
        int answer = 0;

//        준비물 준비   인자로 받아온 배열 담을 값 + 없는 수 가변 배열 담을 값
        ArrayList<Integer> iArr = new ArrayList<>();
        ArrayList<Integer> rArr = new ArrayList<>();

//        받아온 원시 배열을 담아줍니다
        for (int i = 0; i < arr1.length; i++) {
            iArr.add(arr1[i]);
        }
        
//        iArr에 0~9 중 없는 숫자를 rArr에 담아줍니다
        for (int i = 0; i <= 9; i++) {
            if (!iArr.contains(i))
                rArr.add(i);
        }

//        가진 수 반복하면서 더하기
        int left = rArr.get(0);
        int right = rArr.get(1);
        while (left <= right) {
            answer += right;
            right--;
        }

        return answer;
    }



//    2번. 이상한 문자 만들기2 (중)
//  문제 설명
//  문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다.
//  각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
//  제한 조건
//  공백을 포함하지 않고, 문자열 전체의 짝/홀수 인덱스를 판단해야합니다.
//  첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
//  입출력 예
//  "try hello world"
//  "TrY hElLo WoRlD"
//  “yoon ji yong”
//  “YoOn Ji YoNg”
//  지정 입력값
//  “hang hae ninety nine”
//  “HaNg HaE nInEtY nInE”

    public String solution2(String s) {
        String answer = "";
        int idx = 0;
//        하나하나 쪼개서 배열로 넣기 공백도 배열에다 넣기
        String[] strArr = s.split("");
//        빈 문자열도 배열로 들어갔기 때문에 이제 돌림
        for (int i = 0; i < strArr.length; i++) {
            if ((" ").equals(strArr[i]));
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



//    3번. 같은 단어는 싫어 (상)
//      배열 arr와 정수 n이 주어집니다. 배열 arr의 각 원소는 문자열로 이루어져 있습니다. 이때, 배열 arr에서 중복되는 단어는 전부 제거하려고 합니다.
//      단, 제거된 후 남은 단어들을 반환할 때는 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
//      예를 들어 strings가 ["brush", "sun", "brush", "bed", "car"]이고 n이 1이면 중복을 제거한 배열인 ["sun", "bed", "car"]에서
//      각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.
//      제한 조건
//      strings는 길이 1 이상, 50이하인 배열입니다.
//      strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
//      strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
//      모든 strings의 원소의 길이는 n보다 큽니다.
//      인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
//      입출력 예
//      ["brush", "sun", "brush", "bed", "car"]
//      1
//      ["car", "bed", "sun"]
//      ["banana", "cat", "car", "apple", "banana", "banana"]
//      0
//      ["apple","car","cat"]
//      지정 입력값
//      ["coke", "water", "glass", "dog", "dog", "yogurt", "vitamin"]
//      2
//      ["glass", "yogurt", "coke", "vitamin", "water"]

    public String[] solution3(String[] arr, int n) {
        String[] answer = {};

        ArrayList<String> distinct = new ArrayList<>(Arrays.asList(arr));
        ArrayList<String> removeWant = new ArrayList<>();

        // 중복 제거로 전부 없애고 싶어하므로 set은 쓸 수 없다. 손수 for문 돌려서 지워준다.
        // list는 가변 배열이라 지우기 편하다
        for (int i = 0; i < distinct.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (Objects.equals(distinct.get(i), distinct.get(j))) {
                    removeWant.add(distinct.get(i));
                }
            }
        }
        
        // removeWant의 값을 참조해 중복되는 모든 값을 제거
        distinct.removeAll(removeWant);


        // charAt을 써주고 싶은데 list에는 없거나 잘 모르기 때문에 어쩔 수 없이 다시 형변환
        String[] sStr = new String[distinct.size()];
        for (int i = 0; i < distinct.size(); i++) {
            sStr[i] = distinct.get(i);
        }

        // sort 기능을 사용하기 위해 다시 list로 만들어주는 김에 n번째 캐릭터를 앞에 붙여준다
        ArrayList<String> cStr = new ArrayList<>();
        for (String s : sStr) {
            cStr.add(s.charAt(n) + s);
        }
        // coke에 받은 인덱스값이 2라면 kcoke 식으로 앞에 붙었을 거다

        // 이제 정렬한다
        Collections.sort(cStr);

        // 앞에 거 떼어 주고 리턴
        answer = new String[cStr.size()];
        for (int i = 0; i < cStr.size(); i++) {
            answer[i] = cStr.get(i).substring(1);
        }

        return answer;
    }


    public static void main(String[] args) {
        Main method = new Main();

//        1번 문제
//        int[] arr1 = {1,3,5,9,2,4,8,0};
//        System.out.println(method.solution1(arr1));

//        2번 문제
        String s = "hang hae ninety nine";
        System.out.println(method.solution2(s));

//        3번 문제
//        String[] arr = {"banana", "cat", "car", "apple", "banana", "banana"};
//        int n = 0;
//        System.out.println(Arrays.toString(method.solution3(arr, n)));

    }
}