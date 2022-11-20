# 백준 Java 풀이 시 tips/guide

## 1. public class 이름은 Main이어야 함
- Main 이외의 클래스를 써야 하는 경우, public이 아닌 클래스나 inner 클래스로 만들어서 사용

## 2. import 부분도 함께 제출해야 함

## 3. public static void main() 함수를 포함하는 프로그램 클래스를 제출하는 것임
cf. 예시 코드 DfsSample.java 참고

## 4. 입력 받는 것부터 출력하는 부분까지 작성해야 함
- 템플릿 만들어서 '프로그래머스'에서와 비슷하게 문제를 풀 수 있도록 하기

### ✅ 효율적인 입력 = BufferedReader 및 StringTokenizer로 빠르게 입력받기
1. Scanner는 느림 → **BufferReader 사용하기**

> [**백준 입력 속도 비교**](https://www.acmicpc.net/blog/view/56)<br> 
> Java BufferedReader, Integer.parseInt 평균 0.6585초 vs Scanner 평균 4.8448초
> - Scanner가 느린 이유 = 내부적으로 nextFloat() 등 호출 시 다음 입력을 찾기 위해 정규식을 사용해서(✏️ 더 공부 필요)

2. **StringTokenizer()(o)** String에 대한 split()(x)로 **문자열 자르기**

3. 입력을 위한, System.in이 들어간, 클래스는 하나만 쓰기 
- 백준 입력 = 파일 → 일정량을 읽어들인 후 사용자의 요청(readLine() 등)에 따라 해당 버퍼에서 꺼내옴 → 여러 개 선언해두면 이미 다른 클래스에서 버퍼에 쌓인 부분 때문에 제대로 읽을 수 없게 됨

cf. 예시 코드 InputCodes.java 참고

### ✅ 효율적인 출력

## References
- [자바로 백준 풀 때의 팁 및 주의점 (boj java)](https://nahwasa.com/m/172)
- [<취준> 코딩테스트 준비하기 (with. 백준 & 프로그래머스)](https://haesoo9410.tistory.com/351)