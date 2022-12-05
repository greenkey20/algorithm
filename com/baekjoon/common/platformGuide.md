# 백준 Java 풀이 시 tips/guide

## 1. public class 이름은 Main이어야 함
- 백준.Bronze.q11654.백준.Bronze.q1152.Main 이외의 클래스를 써야 하는 경우, public이 아닌 클래스나 inner 클래스로 만들어서 사용

## 2. import 부분도 함께 제출해야 함

## 3. public static void main() 함수를 포함하는 프로그램 클래스를 제출하는 것임
cf. 예시 코드 DfsSample.java 참고

## 4. 입력 받는 것부터 출력하는 부분까지 작성해야 함
- 템플릿 만들어서 '프로그래머스'에서와 비슷하게 문제를 풀 수 있도록 하기

### ✅ 효율적인 입력 = BufferedReader 및 StringTokenizer로 빠르게 입력받기
1. Scanner는 느림 → **BufferReader 사용하기**

> [**백준 입력 속도 비교**](https://www.acmicpc.net/blog/view/56)<br> 
> Java BufferedReader, Integer.parseInt 평균 0.6585초<br>
> vs Scanner 평균 4.8448초
> 
> ❕ **Scanner가 느린 이유** (✏️ 더 공부 필요)
> 1. 내부적으로 nextFloat() 등 호출 시 다음 입력을 찾기 위해 정규식을 사용해서
> 2. Scanner에서 쓰는 버퍼 사이즈가 BufferedReader에서 사용하는 버퍼 사이즈보다 작음

2. **StringTokenizer 클래스(o)** String에 대한 split()(x)로 **문자열 자르기**
- StringTokenizer 클래스는 긴 문자열을 지정된 구분자(delimiter)를 기준으로 여러 개의 token/문자열로 잘라내는 데 사용됨
  - 단, 구분자로 1개의 문자만 사용 가능 → 보다 복잡한 형태의 구분자로 문자열을 나눠야 할 때는 정규식 사용하는 메서드(e.g. String의 split(String regex), Scanner의 useDelimiter(String pattern) 등) 사용해야 함

3. 입력을 위한, System.in이 들어간, 클래스는 하나만 쓰기 
- 백준 입력 = 파일 → 일정량을 읽어들인 후 사용자의 요청(readLine() 등)에 따라 해당 버퍼에서 꺼내옴 → 여러 개 선언해두면 이미 다른 클래스에서 버퍼에 쌓인 부분 때문에 제대로 읽을 수 없게 됨

cf1. 예시 코드 InputCodes.java 참고 <br>
cf2. 문자열 "1 2"와 같은 입력을 정수 2개로 변환해서 받고자 할 때 NumberFormat 런타임 에러 발생하지 않도록 입력 받는 법 = https://help.acmicpc.net/judge/rte/NumberFormat

### ✅ 효율적인 출력
1. 하나의 문자열로 이어 한 번에(o) 반복문 활용한(x) 출력
e.g. StringBuilder 사용

2. BufferedWriter 사용

> [**백준 출력 속도 비교**](https://www.acmicpc.net/blog/view/57) : 총 N개의 줄에 1부터 10,000,000까지의 자연수를 한 줄에 하나씩 출력하는 시간을 10번 측정해서 평균 값을 낸 것<br>
> Java BufferedWriter bf.write(i + "\n") 평균 0.9581초<br>
> vs StringBuilder를 이용해 문자열 하나로 만든 다음 System.out.println(sb) 평균 1.1881초<br>
> vs System.out.println(i) 평균 30.013초 

> **BufferedWriter 사용 출력 시 주의할 점**
> int형 자료는 String으로 변환(String.valueOf(int), Integer.toString(int) 등)해서 출력해야 함

## References
- [자바로 백준 풀 때의 팁 및 주의점 (boj java)](https://nahwasa.com/m/172)
- [백준 문제 자바로 풀 때 유의사항](https://blog.naver.com/chltmddus23/221696297647)
- [<취준> 코딩테스트 준비하기 (with. 백준 & 프로그래머스)](https://haesoo9410.tistory.com/351)
- [BufferedWriter int형 출력](https://dev-note-97.tistory.com/58)