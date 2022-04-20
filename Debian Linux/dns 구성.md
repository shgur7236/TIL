# dns

apt install bind9 dnsutils

cd /etc/bind 

vim named.conf.local

zone "itnsa.kr"{ 

type master;

file "itnsa.kr.zone";

};   추가 

cp db.empty /var/cache/bind/itnsa.kr.zone   → 카피 해준다 

vim /var/cache/bind/itnsa.kr.zone

:%s:localhost:[ns.itnsa.kr](http://ns.itnsa.kr):g     → localhost를 ns.itnsa.kr로 바꾼다

ns       IN      A    192.168.0.100   → 추가

www    IN     A    192.168.0.100     → 추가

vim /etc/bind named.conf.options

블라블라 no

allow-query { any; };

systemctl restart bind9

vim /etc/resolv.conf

nameserver ~

systemctl restart bind9

---

## 조건부 전달자

zone “~” {

type forward;

forwarder { 주소; };

};

---

# slave DNS구성

## 개념

사용하는 대에 있어서 깊은 이해를 필요하는 부분이 아니기 떄문에 단순히 Master와 Slave는 주.보조 관계이며 DNS 서버를 이중화 시킨다고만 알고 있으면 된다.

동기화 과정을 통해 zone 파일을 관리하게 된는데, zone 파일의 SOA 필드에 있는 serial을 확인하여 이 파일이 업데이트가 되었는지 판단한다. serial이 증가 했을 경우 파일이 업데이트 된 것으로 판단한다. 그래서 동기화 과정을 통해 Slave서버로 zone 파일이 전송 된다.

dns 서버에 들어가서

vim /etc/bind/named.conf 파일에

zone “dns 서버 주소” 안에

also-notify { “slave주소”; };

systemctl restart bind9

### NEXT

slave인 서버에 apt install bind9 설치 후 

vim /etc/bind/named.conf.options

dnssec-validation no;

allow-recursion { any; };

하고

vim /etc/bind/named.conf

zone 생성

일반 zone과 달리 

type slave;

masters로 마스터 지정

allow-notify로 master가 알 수있게