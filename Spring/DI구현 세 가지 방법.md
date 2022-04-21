### 강한 결합
---
**객체 내부에서 다른 객체를 생성하는 것은 강한 결합도를 가지는 구조**이다.
A 클래스 내부에서 B 라는 객체를 생성하고 있다면, B 객체를 C 객체로 바꾸고 싶은 경웨 A 클래스도 수정해야 하는 방식이기 떄문에 강한 결합이다.


### 느슨한 결합
---
**객체를 주입 받는다는 것은 외부에서 생성된 객체를 인터페이스를 통해서 넘겨받는 것**이다.
**이렇게 하면 결합도를 낮출 수 있고, 런타임시에 의존관계가 결정되기 떄문에 유연한 구조**를 가진다.

의존성 주입의 종류로는 `Field Injection`, `Setter Injection`, `Constructor injection`방법이 있다.

### Field Injection(필드 주입)
---
변수 선언부에 @Autowired Annotation을 붙인다.
```java
@Component
public class SampleController {
        @Autowired
        private SampleService sampleService;
}
```
### Field Injection을 사용하면 안되는 이유
- **단일 책임(SRP)의 원칙 위반**

**의존성을 주입하기가 쉽다.**
@Autowired 선언 아래에 개수 제한 업이 무한전 추가할 수 있어서

여기서 `Constructor Injection`을 사용하면 다른 Injection 타입에 비해 위기감을 느끼게 해준다.

**Constuctor의 parameter가 많아짐가 동시에 하나의 Class가 많은 책임을 떠아는다는 걸 알게된다.**

- **의존성이 숨는다.**
`DI Container`를 사용한다는 것은 Class가 자신의 의존성만 책임진다는게 아니라 제공된 의존성 또한 책임진다.

그래서 **Class가 어떤 의존성을 책임지지 않을 때, 메서드나 생성자를 통해(Setter나 Constructor) 확실히 커뮤니케이션이 되어야한다.**

하지만 Field Injection은 **숨은 의존성만 제공**해준다.

- **DI Container의 결합성과 테스트 용이성**
- **불변성**
`Constructor Injection`과 다르게 `Filed Injection`은 final을 선언할 수 없다.
그래서 객체가 변할 수 있다.

- **순환 의존성**

*순환 의존성?*
A Class가 B Class를 참조하는데 B Class가 다시 A Class를 참조할 경우,
A Class가 B Class를 참조하고, B Class가 C Class를 참조하고 C Class가 A Class를 참조하는 경우 이를 순환 의존성(Circular Dependency)이라고 부른다.

`Field Injection`은 스프링 컨테이너 말고는 외부에서 주입할 수 있는 방법이 없다.
`Field Injection`은 **읽기 쉽고, 사용하기 편하다는 것** 말고는 장점이 없다.

### Setter injection(수정자 주입)
---
`Setter Injectio`n은 **선택적인 의존성을 사용할 때 유용하다.**
**상황에 따라 의존성 주입이 가능**하다.

`Setter Injectio`n은 set Method를 정의해서 사용한다.

```java
@Component
public class SampleController {
    private SampleService sampleService;
 
    @Autowired
    public void setSampleService(SampleService sampleService) {
        this.sampleService = sampleService;
    }
}
```
`Setter Injection`으로 의존관계 주입은 런타임시에 할 수 있도록 **낮은 결합도**를 가지게 구현되었다.

하지만 **`Setter Injection`을 통해서 Service의 구현체를 주입해주지 않아도 Controller 객체는 생성이 가능**하다.

**Controller 객체가 생성가능하다는 것은 내부에 있는 Service의 method 호출이 가능하다는 것**인데,
set을 통해 **Service의 구현체를 주입해주지 않았으므로,NullPointerException 이 발생**한다.

**주입이 필요한 객체가 주입이 되지 않아도 얼마든지 객체를 생성할 수 있다는 것이 문제**다.

이 문제를 해결 할 수 있는 방법이 `Constructor Injection`이다.

### Constructor Inection을 사용해야 하는 이유
---
**Spring Framework Reference에서 권장하는 방법은 생성자를 통한 주입**이다.

생성자를 사용하는 방법이 좋은 이유는 **필수적으로 사용해야하는 의존성 없이는 Instance를 만들지 못하도록 강제**할 수 있기 때문이다.

또한 앞서 살펴본 **`Field Injection`의 단점들을 장점으로 가져갈 수** 있다.

- **null을 주입하지 않는 한 NullPointerException은 발생하지 않는다.**

**의존관계 주입을 하지 않은 경우에는 Controller 객체를 생성할 수 없다.**
즉, 의존관계에 대한 내용을 외부로 노출시킴으로써 컴파일 타임에 오류를 잡아낼 수 있다.

- **final을 사용할 수 있다.**

**final의 장점은 객체가 불변하도록 할 수 있는 점**으로, 누군가가 Controller 내부에서 Service객체를 바꿔치기 할 수 없다는 점이다.

- **순환 의존성을 알 수 있다.**
- **의존성을 주입하기가 번거로워 위기감을 느낄 수 있다.**

`Constructor Injection`의 경우 생성자의 인자가 많아지면 코드가 길어지면 **개발자로 하여금 위기감을 느끼게 해준다.**

이러한 장점들 때문에 **`Constructor injection`을 추천**한다.


