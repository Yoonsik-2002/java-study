## JVM(Java virtual machine)
**Java Virtual Mathine**을 직역하면, '자바를 실행하기 위한 가상 기계' 라고 할 수 있다.<br>
영어권에서는 컴퓨터를 머신(Machine)이라고도 부르기 때문에, **'자바를 실행가기 위한 가상 컴퓨터'** 라고 이해하면, 더욱 자연스러운<br>
이해가 가능하다.<br>
<br>

### 가상 기계(virtual Machine)
소프트웨어로 구현된 하드웨어를 뜻하는 넓은 의미의 용어이다.<br>

'소프트웨어로 구현된 하드웨어'라는 개념이 낮설게 느껴질 수 있다. 이에 대해 설명하면,<br>
컴퓨터의 성능이 향상됨에 따라, 점점 더 많은 하드웨어들이 소프트웨어화 되어, 컴퓨터 속으로 들어오고 있다.<br>

이러한 가상 기계(virtual Machine)의 예로는, 다음 것들이 있다.<br>
- TV와 비디오를 소프트웨어화한 윈도우 미디어 플레이어
- 오디오 시스템을 소프트웨어화한 윈앰프(winamp) 등
<br>

이와 마찬가지로, 가상 컴퓨터(virtual computer)는 실제 컴퓨터(하드웨어)가 아닌 소프트웨어로 구현된 컴퓨터라는 뜻으로, 컴퓨터 속의<br>
컴퓨터라고 생각하면 된다.<br>

> **자바로 작성된 애플리케이션(application program, 응용 프로그램)은 모두 이 가상 컴퓨터(JVM)에서만 실행되기 때문에,<br>
> 자바 애플리케이션이 실행되기 위해서는 반드시 이 JVM이 필요하다!**

<br>

## Write once, run anywhere
**'한번 작성하면, 어디서든 실행된다'** 자바의 중요한 장점 중 하나이다.<br>
자바가 이러한 장점을 지니게 된 이유는 [JVM](https://github.com/Yoonsik-2002/java-study/edit/main/src/_00_other_knowledge/_00_JVM/README.md#jvmjava-virtual-machine)에 있다.<br>
<br>

##### 자바 애플리케이션과 일반 애플리케이션의 비교
<br>

![스크린샷(4)](https://github.com/Yoonsik-2002/java-study/assets/83572199/8dc6ec32-179d-4b89-8c6b-42e34e7fedc6)<br>
<br>

- #### 일반 애플리케이션
  그림에서 볼 수 있듯이, 일반 애플리케이션은 OS와 맞붙어 있기 때문에, **OS 종속적이다.** <br>
  때문에 다른 OS에서 실행시키기 위해서는, 애플리케이션을 해당 OS에 맞게 변경해 주어야 한다는 번거로움이 존재한다.<br>
<br>

- #### Java 애플리케이션
  반면에, Java 애플리케이션은 JVM하고만 상호작용을 하기 때문에, **OS와 하드웨어에 독립적이다.** <br>
  때문에, 다른 OS에서도 프로그램의 변경없이 실행이 가능하다.<br>
  
  단, OS와 맞붙어 있는 JVM은 OS에 종속적이기 때문에, 해당 OS에서 실행 가능한 JVM이 필요하다.<br>
  <br>
  
  ##### 다양한 OS용 JVM
  ![스크린샷(6)](https://github.com/Yoonsik-2002/java-study/assets/83572199/599bb196-d6e8-4562-84df-123316b1bfae)<br>
  
  그래서 썬(Sun Microsystems)에서는 위와 같이, 일반적으로 많이 사용되는 주요 OS용 JVM을 제공하고 있고, 이를 통해<br>
  **"Write once, run anywhere"** 이 가능하게 되는 것이다.<br>
<br><br>

## JVM 메모리 구조
응용프로그램이 실행되면, JVM은 시스템으로 부터 프로그램을 수행하는데 필요한 메모리를 할당 받는다.<br>
그리고, JVM은 이 메모리를 용도에 따라 여러 영역으로 나누어 관리한다.<br>

그 중, 3가지 주요 영역(method area, call stack, heap)에 대해 정리해 보도록 하겠다.<br>
<br>

##### JVM의 메모리 구조
![스크린샷(2)](https://github.com/Yoonsik-2002/java-study/assets/83572199/5c43e90e-6f1e-431a-8810-5ae3d2115ba3)<br>

- #### 메서드 영역(method area)
  프로그램 실행 중, 어떤 클래스가 사용되면, JVM은 해당 클래스의 클래스 파일(`*.class`)을 읽고, 분석하여 클래스에 대한 정보<br>
  (클래스 데이터)를 이곳에 저장한다.<br>

  이때, 해당 클래스의 클래스 변수(class variable)도 이 영역에 함께 생성된다.<br>
  
  **`클래스 데이터`** **`클래스 변수`**<br>
<br>

- #### 호출스택(call stack 또는 execution stack)
  




  
  
  







