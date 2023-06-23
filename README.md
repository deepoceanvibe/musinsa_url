# musinsa_url
무신사 Shorten Url 문제

🦎 bitly 같은 URL 단축 서비스 만들기 다음 요구사항을 만족하는 단축 URL 생성 API 개발

- 단축 URL 생성 기능
- 생성된 단축 URL로 요청시 원래 URL로 리다이렉트
- 데이터 저장은 DB가 아닌 ArrayList에 저장
- Optional) 단축된 URL에 대한 요청 횟수 저장 및 요청 횟수 조회 기능

신경써야할 내용

- 단축 URL로 어떤 값을 사용할 것 인가?
- 나중에 프론트엔드 페이지가 추가된다면 이 API 서버가 그대로 활용될 수 있는가?
