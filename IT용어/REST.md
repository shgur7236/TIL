## ‼️ REST란?

- “Representational State Transfer”의 약자
- 자원을 이름으로 구분하여 해당 자원의 상태를 주고받는 모든 것을 의미합니다.
- 월드 와이드 웹(www)과 같은 분산 하이퍼미디어 시스템을 위한 소프트웨어 개발 아키텍처의 한 형식
    - 웹의 장점을 최대한 활용할 수 있는 아키텍처의 스타일이다.
    - Client와 Server 사이의 통신 방식 중 하나이다.

## 🤟 REST의 구체적인 개념

HTTP URI(Uniform Resource Identifier)를 통해 자원(Resource)을 명시하고, HTTP Method(POST, GET, PUT, DELETE)를 통해 해당 자원에 대한 CRUD Operation을 적용하는 것을 의미한다.

즉, REST는 자원 기반의 구조(ROA, Resource Oriented Architecture) **설계의 중심에 Resource가 있고 HTTP Method를 통해 Resource를 처리하도록 설계된 아키텍쳐를 의미한다.**

### CRUD Operation

- Create : 생성(POST)
- Read : 조회(GET)
- Update : 수정(PUT)
- Delete : 삭제(DELETE)

## 👉 REST의 장단점

### 장점

- HTTP 프로토콜의 인프라를 그대로 사용하므로 REST API 사용을 위한 별도의 인프라를 구출할 필요가 없다.
- REST API 메시지가 의도하는 바를 명확하게 나타내므로 의도하는 바를 쉽게 파악할 수 있다.
- REST API 메시지가 의도하는 바를 명확하게 나타내므로 의도하는 바를 쉽게 파악할 수 있다.

### 단점

- 표준이 존재하지 않는다.
- 사용할 수 있는 메소드가 4가지 밖에 없다.

## REST가 필요한 이유

- 최근의 서버 프로그램은 다양한 브라우저와 안드로이폰, 아이폰과 같은 모바일 디바이스에서도 통신을 할 수 있어야 한다.
- 이러한 멀티 플랫폼에 대한 지원을 위해 서비스 자원에 대한 아키텍처를 세우고 이용하는 방법을 모색한 결과, REST에 관심을 가지게 되었다.

## REST 구성 요소

1. **자원(Resource) : HTTP URI** 
2. **자원에 대한 행휘(Verb) : HTTP Method**
3. **자원에 대한 행위의 내용 (Representations) : HTTP Message Pay Load**
