<<<<<<< HEAD
### 예시를 통해 알아보자
---
일반적으로 의존성에 대한 제어권은 객체 자기 자신이 갖는다. 아래의 코드는 Sample이라는 클래스에서 Apple 객체를 불러오는 예제이다. 의존관계는 간단히 말해 new라는 키워드를 통해 생성된다.
```java
class Sample{
    private Apple apple = new Apple();
}
```

아래는 SampleTest라는 클래스에서 Apple 객체를 생성한 뒤 Sample 클래스의 생성자로 주입시켜 준다. 여기서는 Sample이 직접 Apple을 생성하는 것이 아니라 생성자로 주입받는다.
```java
class Sample{
    private Apple apple;

    public Sample(Apple apple) {
        this.apple = apple;
    }
}

class SampleTest{

    Apple apple = new Apple();
    Sample sample = new Sample(apple);
}
```

이처럼 첫 번째 예시에서는 Apple 객체의 제어권이 Sample에게 있었다면, 두 번째 예시에서는 Sample에게 있는 것이 아니라 SampleTest에게 있다. 
###이처럼 의존성을 역전시켜 제어권을 직접 갖지 않는 것을 IoC라고 하며
###의존성을 외부에서 주입시켜 주는 것을 DI라고 한다.


---
### 그렇다면 이게 대체 무슨 의미가 있는 걸까?

스프링에서는 Spring 컨테이너, IoC 컨테이너라는 개념을 사용한다. 컨테이너는 보통 인스턴스의 생명주기를 관리하며, 생성된 인스턴스들에게 추가적인 기능을 제공하도록 하는 것이라 할 수 있다.

다시 말해, 컨테이너란 당신이 작성한 코드의 처리과정을 위임받은 독립적인 존재라고 생각하면 된다. 컨테이너는 적절한 설정만 되어있다면 누구의 도움 없이도 프로그래머가 작성한 코드를 스스로 참조한 뒤 알아서 객체의 생성과 소멸을 컨트롤해준다.

스프링 컨테이너는 스프링 프레임워크의 핵심부에 위치하며, 종속객체 주입을 이용하여 애플리케이션을 구성하는 컴포넌트들을 관리한다. 이때 스프링 컨테이너에서 생성되는 객체를 Bean이라고 한다.

 
 ### Bean
 - Spring Bean Container에 존재하는 객체
 - Bean Container는 의존성 주입을 통해 Bean 객체를 사용할 수 있도록 해준다
 - 보통 싱글턴으로 존재
 - Beans는 우리가 컨테이너에 공급하는 설정 메타 데이터(XML 파일)에 의해 생성된다.


### 그럼 스프링 컨테이너에 Bean은 어떻게 생성될까?
### 1. Component scan
@ComponentScan은 @Commponent 어노테이션이나 stereotype(@Service, @Controller, @Repository 등) 어노테이션 부여된 class를 찾아 자동으로 Bean으로 등록해주는 역할을 한다.
추가적으로 Bean으로 등록하고 싶은 class가 있다면 @Component 어노테이션을 붙이면 된다.

### 2. @Configuration에서 @Bean으로 등록
@Configuration 어노테이션을 사용해서 직접 @Bean을 등록해주는 방법이다. @Bean 어노테이션을 사용하면 자동으로 빈으로 등록된다.
```java
@Configuration
public void HttpConfig {

    @Bean
    public RestTemplate createTemplate(){
        return new RestTemplate();
    }
}
```

---
### !! Service나 Controller 같은 한번만 호출해도 되는 객체들은 Bean으로 등록하여 관리한다면 결합도가 낮아져 유지보수에 용이할 것이다. 

=======
### 예시를 통해 알아보자
---
일반적으로 의존성에 대한 제어권은 객체 자기 자신이 갖는다. 아래의 코드는 Sample이라는 클래스에서 Apple 객체를 불러오는 예제이다. 의존관계는 간단히 말해 new라는 키워드를 통해 생성된다.
```java
class Sample{
    private Apple apple = new Apple();
}
```

아래는 SampleTest라는 클래스에서 Apple 객체를 생성한 뒤 Sample 클래스의 생성자로 주입시켜 준다. 여기서는 Sample이 직접 Apple을 생성하는 것이 아니라 생성자로 주입받는다.
```java
class Sample{
    private Apple apple;

    public Sample(Apple apple) {
        this.apple = apple;
    }
}

class SampleTest{

    Apple apple = new Apple();
    Sample sample = new Sample(apple);
}
```

이처럼 첫 번째 예시에서는 Apple 객체의 제어권이 Sample에게 있었다면, 두 번째 예시에서는 Sample에게 있는 것이 아니라 SampleTest에게 있다. 
###이처럼 의존성을 역전시켜 제어권을 직접 갖지 않는 것을 IoC라고 하며
###의존성을 외부에서 주입시켜 주는 것을 DI라고 한다.


---
### 그렇다면 이게 대체 무슨 의미가 있는 걸까?

스프링에서는 Spring 컨테이너, IoC 컨테이너라는 개념을 사용한다. 컨테이너는 보통 인스턴스의 생명주기를 관리하며, 생성된 인스턴스들에게 추가적인 기능을 제공하도록 하는 것이라 할 수 있다.

다시 말해, 컨테이너란 당신이 작성한 코드의 처리과정을 위임받은 독립적인 존재라고 생각하면 된다. 컨테이너는 적절한 설정만 되어있다면 누구의 도움 없이도 프로그래머가 작성한 코드를 스스로 참조한 뒤 알아서 객체의 생성과 소멸을 컨트롤해준다.

스프링 컨테이너는 스프링 프레임워크의 핵심부에 위치하며, 종속객체 주입을 이용하여 애플리케이션을 구성하는 컴포넌트들을 관리한다. 이때 스프링 컨테이너에서 생성되는 객체를 Bean이라고 한다.

 
 ### Bean
 - Spring Bean Container에 존재하는 객체
 - Bean Container는 의존성 주입을 통해 Bean 객체를 사용할 수 있도록 해준다
 - 보통 싱글턴으로 존재
 - Beans는 우리가 컨테이너에 공급하는 설정 메타 데이터(XML 파일)에 의해 생성된다.


### 그럼 스프링 컨테이너에 Bean은 어떻게 생성될까?
### 1. Component scan
@ComponentScan은 @Commponent 어노테이션이나 stereotype(@Service, @Controller, @Repository 등) 어노테이션 부여된 class를 찾아 자동으로 Bean으로 등록해주는 역할을 한다.
추가적으로 Bean으로 등록하고 싶은 class가 있다면 @Component 어노테이션을 붙이면 된다.

### 2. @Configuration에서 @Bean으로 등록
@Configuration 어노테이션을 사용해서 직접 @Bean을 등록해주는 방법이다. @Bean 어노테이션을 사용하면 자동으로 빈으로 등록된다.
```java
@Configuration
public void HttpConfig {

    @Bean
    public RestTemplate createTemplate(){
        return new RestTemplate();
    }
}
```

---
### !! Service나 Controller 같은 한번만 호출해도 되는 객체들은 Bean으로 등록하여 관리한다면 결합도가 낮아져 유지보수에 용이할 것이다. 

>>>>>>> 3504ce7ded91d5ff01fb951937f01ddd57447039
