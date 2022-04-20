### NAT(Network Access Translation)
- Routing 정보가 서로 공유되지 않는 다른 두 네트워크 사이의 통신을 가능하게 한다. 주로 사설망과 공인망 사이의 통신을 위해 사용된다.
- Port Forwarding: 특정 Port를 특정 Port로 전송하는 방법

### NAT 종류
1. Static NAT 
사설 IP와 공인 IP의 1대1

2. Dynamic NAT
다수의 사설 IP와 다수의 공인 IP의 1대1 (1:1로 매칭 되기 때문에 다른 한쪽이 많으면 낭비가 된다)

3. PAT
다수의 사설 IP 대 1개의 공인 IP

### 복습
ip access-list extended NAT
permit ip ~ ~ any
exit
각 포트에 inside랑 outside 지정
ip nat inside source list NAT int [outside port] overload