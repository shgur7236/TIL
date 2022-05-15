## Annotation이 뭘까?
Spring에서는 Annotation을 많이 사용합니다. **Annotation의 역할**은 아래와 같습니다.
> JAVA에서 Annotation 이라는 기능이 있습니다. 사전상으로는 주석의 의미이지만 Java에서는 주석 이상의 기능을 가지고 있습니다. Annotation은 자바 소스 코드에 추가하여 사용할 수 있는 메타데이터의 일종이고, 소스코드에 추가하면 단순 주석의 기능을 하는 것이 아니라 특별한 기능을 사용할 수 있습니다.

Annotation은 클래스와 메서드에 추가하여 다양한 기능을 부여하는 역할을 합니다. Annptation을 활용하여 Spring Framework는 해당 클래스가 어떤 역할인지 정하기도 하고, Bean을 주입하기도 하며, 자동으로 getter나 setter를 생성하기도 합니다. 특별한 의미를 부여하거나 기능을 부여하는 등 다양한 역할을 수행할 수 있습니다. 

## Spring의 주요 Annotation

### @Component
개발자가 생성한 Class를 Spring의 Bean으로 등록할 때 사용하는 Annotation입니다. Spring은 해당 Annotation을 보고 Spring의 Bean으로 등록합니다.

```java
@Component(value="myman") // Bean 등록
public class Man{
    public Man(){
        System.out.println("hi");
    }
}
```

### @ComponentScan
Spring Framework는 @Component, @Service, @Repository, @Controller, @Configuration 중 1개라도 등록된 클래스를 찾으면, Context에 bean으로 등록합니다. @ComponentScan Annotation이 있는 클래스의 하위 Bean을 등록 될 클래스들을 스캔하여 Bean으로 등록해줍니다.

### @Bean
@Bean Annotation은 개발자가 제어가 불가능한 외부 라이브러리와 같은 것들을 Bean으로 만들 때 사용합니다.

### @Controller
Spring에게 해당 Class가 Controller의 역할을 한다고 명시하기 위해 사용하는 Annotation입니다.
```java
@Controller                 // Controller 역할을 합니다.
@RequestMapping("/user")    // /user로 들어오는 요청을 모두 처리합니다.
public class UserController{
    @RequestMapping(method = RequestMethod.GET)
    public String getUser(Model model){
        // GET method, /user 요청을 처리
    } 
}
```

### @RequestHeader
Request의 header 값을 가져올 수 있으며, 해당 Annotation을 쓴 메소드의 파라미터에 사용합니다.
```java
@Controller                 // Controller 역할을 합니다.
@RequestMapping("/user")    // /user로 들어오는 요청을 모두 처리합니다.
public class UserController{
    @RequestMapping(method = RequestMethod.GET)
    public String getUser(@RequestHeader(value="Accept-Language")String acceptLanguage) { 
        // GET method, /user 요청을 처리
    } 
}
```

### @RequestMapping
@RequestMapping(value=" ")와 같은 형태로 작성하며, 요청 들어온 URI의 요청과 Annotation value 값이 일치하면 해당 클래스나 메소드가 실행됩니다. Controller 객체 안의 메서드와 클래스에 적용 가능합니다.
- Class 단위에 사용하면 하위 메소드에 모두 적용됩니다.
- 메소드에 적용되면 해당 메소드에 지정한 방식으로 URI를 처리합니다.
```java
@Controller                   //  Controller 역할을 합니다
@RequestMapping("/user")      // /user로 들어오는 요청을 모두 처리합니다.
public class UserController {
    @RequestMapping(method = RequestMethod.GET)
    public String getUser(Model model) {
        //  GET method, /user 요청을 처리
    }
    @RequestMapping(method = RequestMethod.POST)
    public String addUser(Model model) {
        //  POST method, /user 요청을 처리
    }
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String addUser(Model model) {
        //  GET method, /user/info 요청을 처리
    }
}
```
### @RequestParam
URL에 전달되는 파라미터를 메소드의 인자와 매칭시켜, 파라미터를 받아서 처리 할 수 있다. 
```java
@Controller                   // Controller 역할을 합니다
@RequestMapping("/user")      // /user로 들어오는 요청을 모두 처리합니다.
public class UserController {
    @RequestMapping(method = RequestMethod.GET)
    public String getUser(@RequestParam String nickname, @RequestParam(name="old") String age {
        // GET method, /user 요청을 처리
        // https://naver.com?nickname=dog&old=10
        String sub = nickname + "_" + age;
        ...
    }
}
```

### @RequestBody
Body에 전달되는 데이터를 메소드의 인자와 매칭시켜, 데이터를 받아서 처리 할 수 있다. 클라이언트가 보내는 HTTP 요청 본문(JSON 및 XML 등)을 java 오브젝트로 변환한다.
```java
@Controller                   // Controller 역할을 합니다
@RequestMapping("/user")      // /user로 들어오는 요청을 모두 처리합니다.
public class UserController {
    @RequestMapping(method = RequestMethod.POST)
    public String addUser(@RequestBody User user) {
        //  POST method, /user 요청을 처리
        String sub_name = user.name;
        String sub_old = user.old;
    }
}
```

### @ModelAttribute
클라이언트가 전송하는 HTTP parameter, Body 내용을 Setter 함수를 통해 1:1로 객체에 데이터를 연결(바인딩)합니다.
RequestBody와 다르게 HTTP Body 내용은 multipart/form-data 형태를 요구합니다.
@RequestBody가 json을 받는 것과 달리 @ModenAttribute 의 경우에는 json을 받아 처리할 수 없습니다.

### @ResponseBody
@ResponseBody은 메소드에서 리턴되는 값이 View 로 출력되지 않고 HTTP Response Body에 직접 쓰여지게 됩니다. return 시에 json, xml과 같은 데이터를 return 합니다.
```java
@Controller                   // Controller 역할을 합니다
@RequestMapping("/user")      // /user로 들어오는 요청을 모두 처리합니다.
public class UserController {
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getUser(@RequestParam String nickname, @RequestParam(name="old") String age {
        // GET method, /user 요청을 처리
        // https://naver.com?nickname=dog&old=10
        User user = new User();
        user.setName(nickname);
        user.setAge(age);
        return user;
    }
}
```

### @Autowired
Spring Framework에서 Bean 객체를 주입받기 위한 방법이 3가지가 있다. Spring Framework가 Class를 보고 Type에 맞게(Type을 먼저 확인 후,없으면 Name 확인) Bean을 주입한다.
- @Autowired
- 생성자(@AllArgsConstructor 사용)
- setter

### @GetMapping
RequestMapping(Method=RequestMapping.GET)과 똑같은 역할을 한다.
```java
@Controller                   // Controller 역할을 합니다
@RequestMapping("/user")      // /user로 들어오는 요청을 모두 처리합니다.
public class UserController {
    @GetMapping("/")
    public String getUser(Model model) {
        //  GET method, /user 요청을 처리
    }
    
    ////////////////////////////////////
    // 위와 아래 메소드는 동일하게 동작합니다.
    ////////////////////////////////////

    @RequestMapping(method = RequestMethod.GET)
    public String getUser(Model model) {
        //  GET method, /user 요청을 처리
    }
}
```

### @PostMapping
postMapping 또한 RequestMapping(Method=RequestMapping.POST)와 똑같은 역할을 한다.
```java
@Controller                   // Controller 역할을 합니다
@RequestMapping("/user")      // /user로 들어오는 요청을 모두 처리합니다.
public class UserController {
    @PostMapping('/')
    public String addUser(Model model) {
        //  POST method, /user 요청을 처리
    }

    ////////////////////////////////////
    // 위와 아래 메소드는 동일하게 동작합니다.
    ////////////////////////////////////

    @RequestMapping(method = RequestMethod.POST)
    public String addUser(Model model) {
        //  POST method, /user 요청을 처리
    }
}
```
