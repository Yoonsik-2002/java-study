## 배열(Array)
배열이란 같은 타입의 여러 변수들을 하나의 묶음으로 다루는 것을 말한다.<br><br>
### 배열의 선언과 생성
- #### 배열의 선언
  Java 에서 **배열을 선언하는 방법**은 다음과 같다. 먼저, 원하는 자료형의 변수를 생성하고, 해당 변수 또는 자료형에 배열임을 의미하는 <br>
  대괄호`[]` 를 붙여주면 된다.<br>
  이렇게 배열을 선언하면 생성된 배열을 다루기 위한 참조변수를위한 공간이 만들어지게 된다. <br>
  (배열의 선언과 배열을 다루기 위한 참조변수 선언은 같은 의미)
  - #### 배열의 선언 예시
    |선언방법|선언 예|
    |---|---|
    |`타입[] 변수이름;`|`int[] student_score;`|
    |`타입 변수이름[];`|`int student_score[];`|
  
    위 예시에서 알 수 있듯이, 배열임을 의미하는 대괄호`[]` 는 변수의 자료형 뒤에 붙여도 되고, 변수이름 뒤에 붙여도 된다.<br>
    선언 예를 보면, 두 방법에 따라, 선언된 배열의 참조변수가 `student_score`, `student_score[]` 두 가지 형태로 만들어지는 것을 알 수 있다.<br>
  
    참고로 내가 공부하고 있는 책의 저자는 대괄호는 변수이름보다는 자료형의 일부라 생각하기 때문에 자료형 뒤에 붙이는 것을 선호한다고 한다. (~나도 그렇게 생각 하지만 이것이 정답은 아님!~)<br><br>
- #### 배열의 생성  
  배열을 선언하는 방법에 대해 알아 보았으니, **배열을 생성하는 방법**에 대해 알아보도록 하겠다. <br>
  배열의 선언이 배열을 다루기 위한 참조변수를 선언하는 것이였다면, 배열의 생성은 실질적으로 같은 타입의 여러 변수들을 저장할 공간을 생성하는 것 이라고 할 수 있다.<br>
  Java 에서는 배열을 생성하기 위해,  먼저 `new` 연산자를 사용하며 배열의 타입과 길이를 지정해 주어야 한다. 
  
  - #### 배열의 생성 예시
    |생성방법|생성 예|
    |---|---|
    |`타입[] 변수이름;`<br> `변수이름 = new 자료형[배열의 길이];`|`int[] student_score; // 배열을 선언(배열을 다루는 참조변수 선언)` <br> `student_score = new int[27]; // 배열을 생성(실제 저장공간을 생성)`|
    
    
    
    
  
  

  