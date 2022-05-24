### HSRP 예제

>#### IOU5

int e0/0.10
standby 10 priority 105 
standby 10 preempt
standby 10 ip 5.5.5.254
standby 10 track 1 decrement 10

int e0/0.20
standby 20 preempt
standby 20 ip 6.6.6.254
standby 20 priority 105 
standby 20 track 1 decrement 10
track 1 int e0/1 line-protocol

>#### IOU8

int e0/0.10
standby 10 preempt
standby 10 ip 5.5.5.254

int e0/0.20
standby 20 preempt
standby 20 ip 6.6.6.254

### priority 값이 더 큰값이 active상태 105를 많이 씀 
preempt는 자신이 active가 된다는 뜻
