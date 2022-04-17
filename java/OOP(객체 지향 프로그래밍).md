## OOP란 무엇인가?
- 객체의 관점에서 프로그래밍 하는 것을 의미한다.
- 절차지향에 비해서 사람의 사고방식과 더 가깝다.
- 객체들의 유기적인 관계를 통해서 프로세스가 진행된다.
- 애플리케이션을 구성하는 요소들을 객체로 바라보고, 객체들을 유기적으로 연결하여 프로그래밍 하는 것을 말한다.

## OOP의 특징
### 캡슐화 (Encapsulation)
- 필요한 변수나 메소드를 하나로 묶는 것
- 정보은닉
  
### 추상화 (Abstraction)
- 목적과 관련이 없는 부분을 제거하여 필요한 부분만을 표현

### 다형성 (Polymorphism)
- 형태가 같은데 다른 기능을 하는 것을 의미한다(같은 동작이지만 다른 결과물이 나올때 다형이라고 생각하면 된다.)
- 코드의 재사용, 코드 길이 감소 -> 유지보수 good

> ### Overriding & Overloading
OOP에서 다형성의 개념을 녹여내는 방법은 두가지인데, 바로 Overriding과 Overloading이다.

오버라이딩
- 부모 클래스에서 만들어진 메서드를 자식 클래스에서 자신의 입맛대로 다시 재정의해서 사용하는 것을 말한다

오버로딩
- 같은 이름의 메서드를 사용하지만 메서드마다 다른 용도로 사용되며 그 결과물도 다르게 구현할 수 있다.
    - 오버로딩이 가능하려면 메서드끼리 이름은 같지만 매개변수의 갯수나 데이터 타입이 다르면 오버로드이 적용된다
    - 메서드 이름이 같아도 에러가 나지 않는다

>### 오버라이딩 오버로딩 예
```java
// Overriding

public class Employee{
  
  public String name;
  public int age;
  
  public void print(){
    System.out.println("사원의 이름 = "+this.name+", 나이 = "+this.age);
  }
}

//Employee 상속
public class Manager extends Employee{
  
  String jobOfManage;
  
  //overriding  Employee의 pirnt() 메소드 오버라이딩
  public void print(){
    System.out.println("사원의 이름 = "+this.name+", 나이 = "+this.age);
    System.out.println("관리자 "+this.name+"은 "+this.jobOfManage+" 담당입니다.");
  }
}

//Overloading
public class OverloadingTest{
  
  public void test(){
    System.out.println("사용자 없음");
  }
  
  public void test(String name){
    System.out.println("사용자 이름 = " +name);
  }
  
  public void test(String name, int money){
    System.out.println("사용자 이름 = "+name+" , 사용료 = "+money);
  }
}
```
다시 정리하면 같은 행위를 하지만 용도와 목적에 부함하여 다양한 기능 수행과 처리, 결과를 낳을 수 있다.

### 상속성, 재사용(Inheritance)
---
상속은 객체지향의 꽃이라고 할 수 있다.
- 상속이란 객체상속이란 기존 상위클래스에 근거하여 새롭게 클래스와 행위를 정의할 수 있게 도와주는 개념이다.
- 기존 클래스에 기능을 가져와 재사용할 수 있으면서도 동시에 새롭게 만든 클래스에 새로운 기능을 추가할 수 있게 만들어 준다.

