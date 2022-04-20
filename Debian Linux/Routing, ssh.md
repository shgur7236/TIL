# 12/19 routing, ssh
---
## Dynamic routing(rip)설정

apt install quagga
cp /usr/share/quagga-core/examples/zebra.conf.sample /etc/quaaga/zebra.conf
cp /usr/share/quagga-core/examples/ripd.conf.sample /etc/quagga/ripd.conf
chown quagga:quagga /etc/quagga/ -R
systemctl restart zebra ripd
telnet localhost 2602
password: zebra
en
conf t
route rip
network 네트워크 주소
end
wr
exit
systemctl restart zebra ripd
끝

---
## Dynamic routing(ospf) 설정

apt install quagga
cp /usr/share/quagga-core/examples/zebra.conf.sample /etc/quaaga/zebra.conf
cp /usr/share/quagga-core/examples/ospfd.conf.sample /etc/quagga/ospfd.conf
chown quagga:quagga /etc/quagga/ -R
systemctl restart zebra ospfd
telnet localhost 2604
password: zebra
en
conf t
route ospf
network 네트워크 주소 ar 0
end
wr
exit
systemctl restart zebra ripd
끝

---
## static routing

vim /etc/network/interfaces

모든 네트워크주소를 다 추가해줘야됨

up ip route add 네트워크주소(2.2.2.0/24) via

up ip route add 네트워크주소~

 넥스트 홉 주소

systemctl restart networking

---
## ssh 설정

apt install openssh-server
root 사용자로 할꺼면
vim /etc/ssh/sshd_config에서 32번째줄PermitRootLogin yes로 변경

ssh 접속방법
ssh [ip 주소]
ssh [user명]@[ip 주소]