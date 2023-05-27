## 패키지 (Package)
패키지란 비슷한 성격의 자바 클래스들을 하나로 모아둘 수 있는 자바의 디렉토리이다.<br>

이렇게 패키지를 이용하여 비슷한 성격의 자바 클래스들을 모아두는 이유는 다음과 같다.<br><br>

- 비슷한 성격의 자바 클래스들을 패키지 단위로 모아두기 때문에 클래스 분류가 용이하다.

- 자바 코드 작성 시, 다른사람이 작성한 라이브러리나 클래스를 사용하게 되는 경우가 많이 있는데, 이때 가져오려는 클래스 명이<br>
  같은 경우, 클래스의 패키지 이름으로 각 클래스를 구분할 수 있다.<br>
  결론적으로 클래스 명이 동일하더라도 패키지 이름이 다르면 충돌없이 해당 클래스를 가져와 사용이 가능하다.<br>
  따라서, 배포용으로 작성하는 자바 클래스는 반드시 패키지 명을 포함해야 한다.<br>
<br>

### `import`문
위에서 설명했듯이, 패키지란 서로 비슷한 성격의 클래스들을 모아둔 하나의 단위(디렉토리)이다.<br>
이렇게 패키지 안에 속한 클래스를 다른 파일에서 사용하기 위해서는 클래스 이름 앞에 패키지의 경로까지 포함한 full name까지<br>
명시해 주어야만 사용이 가능하다.<br>

이렇게 다른 파일에서 클래스를 가져와 사용할 때마다 해당 클래스의 패키지 경로까지 포함한 긴 이름을 사용하는 것은 비효율적이다.<br>
그래서 Java 에서는 `import`라는 키워드를 제공하고 있다.<br>

`import`문은 자바 컴파일러에게 코드에서 사용할 클래스의 패키지에 대한 정보를 미리 제공해주는 역할을 한다.<br>
따라서, `import`문을 사용하면 다른 패키지에 속해있는 클래스를 가져와 사용할 때, 패키지 경로를 제외한 클래스 이름만으로 가져와<br>
사용할 수 있게 된다.<br>
<br>

### `java.util`패키지
`java.util`패키지(package)는 말 그대로 Java 프로그래밍에 있어, 유용한 클래스들을 모아둔 것으로,<br>
대표적인 클래스들은 날짜와 관련된 `Date`, `Calender`등이 있으며, 자료구조와 알고리즘 관련 클래스들의 집합인<br>
컬렉션 프레임워크(Collection Framework)도 포함되어 있다.<br>

> 컬렉션 프레임워크(Collection Framework)란?
  다수의 데이터들을 쉽고 효과적으로 처리(데이터 저장, 데이터 처리) 할 수 있는 표준화된 방법을 <br>
  제공하는 클래스들의 집합이다.<br><br>
  즉, 데이터를 저장하는 자료구조와 저장된 데이터를 처리하는 알고리즘을 클래스로 구현해 놓은 것이다.<br>
  이러한 컬렉션 프레임워크는 Java의 인터페이스(Interface)를 사용하여 구현한다.<br>
<br>

- #### `java.util`패키지에 속한 클래스들
  `java.util` 패키지에 속한 클래스들을 정리해보면 다음과 같다.<br>

  ```
  AbstractCollection, 
  AbstractList, AbstractSequentialList, LinkedList, ArrayList, Vector, Stack, 
  AbstractSet, HashSet, LinkedHashSet, TreeSet, 
  AbstractMap, HashMap, LinkedHashMap, TreeMap, 
  Arrays, BitSet, Calendar, GregorianCalendar, 
  Collection, Date, Dictionary, Hashtable, Properties, 
  EventObject, Locale, Observable, Random, Scanner, StringTokenizer
  ```