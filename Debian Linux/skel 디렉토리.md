# skel 디렉토리

/etc/skel 디렉토리는 새로운 사용자를 생성하였을 경우, 새 사용자를 위한 기본 폴더를 참고하는 디렉토리입니당

즉, user01이라는 새로운 사용자를 만들고,

mkdir /etc/skel/asdasd 을 만들면

su - user01 로 들어가서 ls -l 을 해보면 asdasd라는 디렉토리를 볼 수 있다.