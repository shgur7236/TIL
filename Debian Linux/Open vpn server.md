# OpenVPN Server 설정 방법, 예제, 명령어

# EasyRSA로 CA 구축

첫 번째 단계는 다음을 포함하는 공개 키 인프라(PKI)를 구축하는 것입니다.

- 인증 기관 (CA) 인증서 및 개인 키.
- CA에서 발급한 서버에 대한 별도의 인증서 및 개인 키 쌍.
- CA에서 발급한 각 클라이언트에 대한 별도의 인증서 개인 키 쌍

> https://jjeongil.tistory.com/1531