# chap01

다음 코드를 실행하면 출력 결과로 5를 기대했는데 4가 출력되었습니다. 어디에서 잘못 작성된 것일까요?

```
        int var1=5;
        int var2=2;
        double var3=var1/var2;
        int var4=(int)(var3*var2);
        System.out.println(var4);
```

기본 데이터 타입은 이미 내부적으로 할당되는 메모리 공간 비트를 어떤 식으로 사용할지를 정의하고 있다
연산자가 var1 / var2 의 연산이 먼저 행해진 뒤 해당 값을 임시로 저장해놓았다가, 이후에 double 자료형 변수에 대입시키기 때문에
연산을 하는 과정에서 연산값을 가진 변수의 데이터 타입을 참조해 임시값을 저장할 때 데이터 손실이 발생해서 소수점 아래가 사라진다
연산이 행해지기 전 형변환을 통해 원하는 타입의 메모리 공간을 확보해 주어야 데이터 손실 없이 원하는 값을 얻을 수 있다





다음 코드를 실행했을 때 출력 결과는 무엇입니까? (증감연산자에 대해 알아보세요!)

```
        int x=10;
        int y=20;
        int z = (++x) + (y--);
        System.out.println(z);
```

>> 31

int z = ((++x) x가 증가하는 위치 + (y--)) y가 감소하는 위치;





while문과 Math.random() 메소드를 이용해서 2개의 주사위를 던졌을 때 나오는 눈을 (눈1, 눈2) 형태로 출력하고,
눈의 합이 5가 아니면 계속 주사위를 던지고, 눈의 합이 5이면 실행을 멈추는 코드를 작성해보세요.
눈의 합이 5가 되는 조합은 (1,4), (4,1), (2,3), (3,2)입니다.

```
        int result = 0;
        System.out.println("시작!");
        while (result != 5) {
            int dice1 = (int) (Math.random() * 6) + 1;
            int dice2 = (int) (Math.random() * 6) + 1;
            System.out.printf("(%d,%d)\n", dice1, dice2);
            result = dice1 + dice2;
        }
        System.out.println("끝!");
```

시작!
(3,6)
(2,6)
(1,4)
끝!
