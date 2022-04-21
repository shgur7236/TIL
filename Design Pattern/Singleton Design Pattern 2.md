**싱글톤 패턴의 공통 구현 특성**
private 생성자와 static method를 사용한다는 것

### eager initialization(이른 초기화)
---
싱글톤 클래스의 인스턴스는 **클래스 로딩 시에 생성되며**, 이것은 싱글톤 클래스를 만들 수 있는 가장 쉬운 방법이지만 **클라이언트 애플리케이션이 이 클래스를 사용하지 않더라도 인스턴스가 생성되는 단점**이 있다.


```java
package com.pattern.singleton;

public class EagerInitializedSingleton {
    
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
    
    //클라이언트 응용 프로그램이 생성자를 사용하지 않도록 하는 개인 생성자
    private EagerInitializedSingleton(){}

    public static EagerInitializedSingleton getInstance(){
        return instance;
    }
}
```

### Static block initialization(정적 블록 초기화)
---
정적 블록 초기화 구현은 **예외 처리를 위한 옵션을 제공하는 정적 블록에 클래스의 인스턴스가 생성**된다는 점을 제외하고는 이른초기화 방법과 유사하다.


```java
package com.pattern.singleton;

public class StaticBlockSingleton {

    private static StaticBlockSingleton instance;
    
    private StaticBlockSingleton(){}
    
    //예외 처리를 위한 정적 블록 초기화
    static{
        try{
            instance = new StaticBlockSingleton();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }
    
    public static StaticBlockSingleton getInstance(){
        return instance;
    }
}
```

### lazy initialization(게으른 초기화)
---
```java
package com.pattern.singleton;

public class LazyInitializedSingleton {

    private static LazyInitializedSingleton instance;
    
    private LazyInitializedSingleton(){}
    
    public static LazyInitializedSingleton getInstance(){
        if(instance == null){
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}
```
- 다중 스레드의 경우 여러 스레드가 동시에 조건 내에 있으면 문제가 발생할 수 있다.
 
### Thread Safe Singleton(안전한 스레드 처리 방식)
---
메서드 동기화를 이용하여 한 번에 하나의 스레드만 이 방법을 실행할 수 있도록 하는 것이다.
```java
package com.pattern.singleton;

public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;
    
    private ThreadSafeSingleton(){}
    
    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
    
}
```
- **스레드 안전성을 제공**하지만, 별도의 인스턴스를 생성할 수 있는 **처음 몇 개의 스레드에만 필요**하다. **동기화된 방법과 관련된 비용 때문에 성능이 저하**된다. 매번 이러한 추가 오버헤드를 방지하기 위해 **이중 체크 잠금 원리를 사용**한다.
```java
public static ThreadSafeSingleton getInstanceUsingDoubleLocking(){
    if(instance == null){
        synchronized (ThreadSafeSingleton.class) {
            if(instance == null){
                instance = new ThreadSafeSingleton();
            }
        }
    }
    return instance;
}
```