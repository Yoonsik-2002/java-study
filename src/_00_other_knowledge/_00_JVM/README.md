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
![스크린샷(4)](https://github.com/Yoonsik-2002/java-study/assets/83572199/8dc6ec32-179d-4b89-8c6b-42e34e7fedc6)<br>

- #### 일반 애플리케이션
  그림에서 볼 수 있듯이, 일반 애플리케이션은 OS와 맞붙어 있기 때문에, **OS종속적이다.** <br>








