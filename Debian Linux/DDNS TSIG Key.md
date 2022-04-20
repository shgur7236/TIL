# DDNS TSIG key

### 설명

BIND DNS 서버의 GSS-TSIG (Generic Security Service Algorithm for Secret Key Transaction) 기능은 DDNS 인증에 사용되는 기능입니다. 주로 AD 도메인 컨트롤러와 BIND 서비스간의 인증에 사용됩니다. 이 GSS-TSIG 기능에 버퍼 오버 플로우를 유발할 수 있는 취약점이 존재합니다. 이 취약점을 공격하면 BIND DNS 서버의 기능이 중단되어 서비스에 장애를 일으킬 수 있습니다.

## 사용법

### 1. rndc-key 생성

rndc-confgen -a

### 2. /etc/bind/named.conf 수정

vim /etc/bind/named.conf

include “/etc/bind/rndc.key”;  **추가**

### 3. /etc/bind/named.conf 수정

allow-update { key rncd.key; };

systemctl restart bind9

### 4. /etc/dhcp/dhcpd.conf 수정

vim /etc/dhcp/dhcpd.conf

include “/etc/bind/rndc.key”;

systemctl restart isc-dhcp-server