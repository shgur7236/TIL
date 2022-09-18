# JPA 영속성 컨텍스트

**Entity를 영구 저장하는 환경이라는** 뜻으로, **가상의 데이터베이스** 같은 역할을 한다.

아래의 코드는 Entity를 영속성 컨텍스트에 저장하는 코드이며, 해당 코드는 DB에 저장이 안된 상태이다.(트랜잭션이 끝나야 DB에 반영을 한다)

```java
entityManager.persist(member); 
```

## 영속성 컨텍스트를 사용하는 이유

1. 1차 캐시
2. 동일성 보장
3. 트랜잭션을 지원하는 쓰기 지연
4. 변경 감지

### 1차 캐시


영속성 컨텍스트 내부에는 1차 캐시라는 공간이 있다.캐시는 Map의 형태로 만들어지며 key는 id값, value는 해당 entity값이 들어 있다.

![images_cham_post_0ca8eb9e-cfa6-445c-8e15-974b66b6dfed_image](https://user-images.githubusercontent.com/81364498/180405373-076cd311-4bc5-45a6-afc0-549234d08fdb.png)

```java
 Member member = em.find(Member.class, "Nohhyuk");
```

- 1차 캐시에서 엔티티를 첫 번째로 찾는다. 해당 엔티티가 있을 경우 바로 반환한다.
- 1차 캐시에 없을 경우 데이터베이스에서 조회합니다. 조회한 데이터로 엔티티를 생성해 1차 캐시에 저장한다. 이후 엔티티를 반환한다.

![images_cham_post_5b0ef062-c160-4f54-abf6-0009e98e7249_image](https://user-images.githubusercontent.com/81364498/180405380-1ef8e320-89c6-4adc-b5e8-6c0869929ef4.png)

### 동일성 보장


엔티티의 동일성을 보장한다.

```java
Member a = em.find(Member.class, "member1");
Member b = em.find(Member.class, "member2");
System.out.print(a==b) // true
```

### 쓰기 지연


Entity들을 1차 캐시에 저장할 때, 저장할 뿐만 아니라 쓰기 지연 SQL 저장소라는 곳에 해당 SQL문도 함께 저장한다.

- 트랜잭션 커밋을 실행할 때, 미리 저장해두었던 SQL문들을 한번에 실행한다.

### 변경 감지

- jpa에서 update를 할 때, 따로 update()나 modify()가 없다.

```java
Member member = em.find(Memeber.class, "member1");
member.setName("updateName");
```

- find()로 member를 조회한 다음 data를 변경하기만 하면 이를 감지해, commit()할 때 update문이 알아서 생성되어 날아간다.
- 이는 아래와 같은 흐름덕분에 가능하다.

- 1차 캐시에는 스냅샷이라는 공간이 있다.
    - snapshot: 1차(최초)로 객체가 들어왔을 시점을 저장
    - Entity: 실제 저장된 Entity
- flush()가 실행될 때, 먼저 Entity와 스냅샷을 비교한다.
- 위의 코드에서는 Name을 변경했기에, Entity의 Name과 스냅샷의 Name이 다른것음 감지해 자동으로 Update문을 생성하는 것이다.

![images_cham_post_8f780bd7-1c2e-4695-a2a1-5d52689fe6fc_image](https://user-images.githubusercontent.com/81364498/180405404-b2ec4ec8-21c4-44f3-b625-3ad23fc65b78.png)

## 엔티티의 생명주기

<img width="481" alt="JPA_3_2" src="https://user-images.githubusercontent.com/81364498/180405463-6e4416a3-947e-4b5d-b6c8-2ec7bd31a3f8.png">

### 1) 비영속 (new/transient)

- 영속성 컨텍스트와 전혀 관계가 없는 새로운 상태

엔티티 객체를 생성했다. 지금은 순수한 객체 상태이며 아직 저장하지 않았다.

```java
Member member = new Member();
member.setName("aa"); // new/transient
```

### 2) 영속 (managed)

- 영속성 컨텍스트에 관리되는 상태

엔티티 매니저를 통해서 엔티티를 영속성 컨텍스트에 저장했다. 이렇게 영속성 컨텍스트가 관리하는 엔티티를 영속 상태라 한다.

```java
em.persist(member); // 영속성 상태
```

객체가 영속 상태가 된다고 해서, 해당 시점에 DB 쿼리가 수행되지 않는다. 트랜잭션이 commit()되는 시점에 쿼리가 수행된다.

### 3) 준영속 (detached)

- 영속성 컨텍스트에 저장되었다가 분리된 상태

영속성 컨텍스트가 관리하던 영속 상태의 엔티티를 영속성 컨텍스트가 관리하지 않으면 준영속 상태가 된다.

```java
em.detach(member); // 영속성을 지운다.
em.close(); // 영속성 컨텍스트를 닫는다.
em.clear(); // 영속성 컨텍스트를 초기화한다.
```

### 4) 삭제 (removed)

- 영속성 컨텍스트에서 삭제된 상태

엔티티를 영속성 컨텍스트와 데이터베이스에서 삭제한다.

```java
em.remove(member); // 객체를 삭제한 상태
```

## ‼️플러시

플러시는 영속성 컨텍스트의 변경 내용을 데이터베이스에 반영한다.

### flush() 호출 시 일어나는 일

- 변경 감지가 동작해서 영속성 컨텍스트에 있는 모든 엔티티를 스냅샷과 비교해서 수정된 엔티티를 찾는다. 수정된 엔티티는 수정 쿼리를 만들어서 쓰기 지연 SQL 저장소에 등록된다.
- 저장된 쿼리를 데이터베이스에 전송한다.

## ‼️병합: merge()

준영속 상태의 엔티티를 다시 영속 상태로 변경하려면 병합을 사용하면 된다.

```java
Member mergeMember = em.merge(member);
```

merge()는 파라미터로 넘어온 준영속 상태의 엔티티를 사용해서 새롭게 병합된 영속 상태의 엔티티를 반환한다.

식별자 값으로 엔티티를 조회할 수 있으면 불러서 병합하고 조회할 수 없으면 새로 생성해서 병합한다. 따라서 병합은 save or update 기능을 수행한다.
