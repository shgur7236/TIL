### vim

command mode → edit mode
i  → insert
I
a →append
A
o → open a new line below and insert
O
x → 현재 커서 위치의 한 문자 삭제
D → 현재 커서 뒤의 모든 문자열을 삭제
dd → 현재 라인을 삭제
yy → 현재 라인을 버퍼에 복사
p→ 현재 커서 뒤(아래)에 붙여 넣기 
P → 현재 커서 앞(위)에 붙여 넣기

### Block 지정

- 라인 단위 Shift+v and 화살표 위 아래
- 컬럼 단위 ctr + v and ← → 위 아래
지정한 블록을 버퍼에 복사 y
붙여 넣기 P or p

## 다중 문서 편집
Ctrl + w(window) and n(new) → 새로운 창 open
Ctrl + w and c(close) → 현재 창 닫기 
Ctrl + w and j → 아래(다음) 창으로 이동
Ctrl + w and k → 위(이전) 창으로 이동


:w [abc.txt] abc.txt로저장
:R <abc.txt> abx.txt.읽기
:x 저장 후 종료
:q 종료
:x! 
:q!