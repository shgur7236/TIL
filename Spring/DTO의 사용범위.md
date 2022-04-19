### 먼저 DTO란?
- DTO(Data Transfer Object)란 계층간 데이터 교환을 위해 사용하는 객체이다. 
    - DTO를 설명하기 위해선 먼저 MVC 패턴에 대해 알아야 한다.

### MVC 패턴
![image](https://velog.velcdn.com/images%2Fminide%2Fpost%2F29966859-4aca-4b35-b238-f9aabf5dfe68%2F300px-Router-MVC-DB.svg.png)
- 애플리케이션 개발 시 구성요소를 Model과 View, Controller 세 가지 역할로 구분하는 디자인 패턴이다.          
- 비즈니스 처리 로직(Model)과 UI 영역(View)의 중간에서 Controller가 연결해주는 역할을 한다.

Controller는 View로부터 들어온 사용자 요청을 해석해 Model을 업데이트하거나 Model로부터 데이터를 받아 View로 전달하는 작업 등을 수행한다.
Model과 View를 분리함으로써 서로의 의존성을 낮추고 독립적인 개발을 가능하게 한다.

--------------------------------------------------------
### DTO를 사용하지 않는 경우
> User.java
```
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    ...
}
```
> UserController.java
```
@GetMapping("/page/{id}")
@ResponseStatus(Httpstatus.OK)
public User viewMyPage(@PathVariable("id") Long id) {
    return userService.viewMyPage(id);
}
```
이렇게 Controller가 클라이언트의 요청에 대한 응답으로 도메인 Model인 User를 넘겨주면 다음와 같은 문제점이 있다.
1. 도메인 Model의 모든 속성이 외부에 노출된다.
    - 위 예시의 경우 사용자가 마이페이지 조회에 대한 요청을 하는데 그에 대한 응답으로 외부에 노출되면 안되는 'password' 데이터까지 응답해준다. 이처럼 도메인 Model자체를 응답해주면 중요한 정보가 외부에 노출되는 보안 문제가 발생한다.
    - View에서 보낸 요청에 대한 데이터 외의 불필요한 데이터를 모두 가지고 있다.
2. UI 계층에서 Model의 메소드를 호출하거나 상태를 변경시킬 위험이 존재한다.
3. Model과 View가 강하게 결합되어, View의 요구사항 변화가 Model에 영향을 끼치지 쉬워진다.
    - User Entity의 속성이 변경되면, View가 전달받을 JSON 등 클라이언트의 코드에도 변경을 유발하기 때문에 상호간 강하게 결합된다.
----
### DTO를 사용하는 경우
> UserResponseDto.java
```
public class UserResponseDto {
    private String name;
    private String email;
}
```
> UserController.java
```
@GetMapping("/page/{id}")
@ResponseStatus(Httpstatus.OK)
public UserResponseDto viewMyPage(@PathVariable("id") Long id) {
    return userService.viewMyPage(id);
}
```
DTO를 사용하면 앞에서 언급했던 문제들을 해결할 수 있다. 도메인 Model을 캡슐화하고, UI화면에서 사용하는 데이터만 선택적으로 보낼 수 있다.
### 정리하면
> DTO는 클라이언트 요청에 포함된 데이터를 담아 서버 측에 전달하고, 서버 측의 응답 데이터를 담아 클라이언트에 전달하는 계층간 전달자 역할이다.


