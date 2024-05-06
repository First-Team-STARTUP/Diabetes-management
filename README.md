
## Logo
![image](https://github.com/First-Team-STARTUP/Diabetes-management/assets/150316684/41834124-3099-4580-8003-b14ea9a86ce8)


<br>

# 📖 스타트업 혈당 관리 프로그램 '당당히' README

![readme_mockup2](https://github.com/First-Team-STARTUP/Diabetes-management/assets/159866078/6c93a0bb-7924-434d-a262-9e39ed7f4f38)


<br>

## 프로젝트 소개

혈당 관리 웹 애플리케이션 '당당히'는 사용자가 일일 혈당 수치를 기록하고 추적하여 건강 상태를 관리할 수 있도록 돕습니다. <br/>
사용자는 간편한 UI를 통해 혈당 수치를 입력하고, 식사나 운동과 같은 활동과 관련된 정보를 함께 기록할 수 있습니다.<br/>
이 프로젝트는 사용자가 일일 혈당 수치를 입력하고 이를 기반으로 개선된 건강 상태를 확인할 수 있는 다양한 기능을 제공합니다.<br/> 
또한 사용자는 그래프나 통계를 통해 혈당 수치의 추이를 시각적으로 확인할 수 있습니다.<br/>

<br>

## 팀원 구성

<div align="center">

| **김루아** | **김이랑** | **이재형** |
| :------: |  :------: | :------: |
| [<img src="https://avatars.githubusercontent.com/u/106502312?v=4" height=150 width=150> <br/> @ruah0807](https://github.com/yeon1615) | [<img src="https://github.com/First-Team-STARTUP/Diabetes-management/assets/113574030/517a3a6c-7926-4ca3-9d23-8ff172e32727" height=150 width=150> <br/> @yirang26](https://github.com/YirangKim) | [<img src="https://avatars.githubusercontent.com/u/112460506?v=4" height=150 width=150> <br/> @heejiyang](https://github.com/heejiyang) |

</div>

<br>

## 1. 개발 환경

![개발환경](https://github.com/First-Team-STARTUP/Diabetes-management/assets/159866078/7bebd3a8-222c-47e2-8ab5-2a1c6128733f)

- Front : HTML, CSS, javaScript, Bootstrap, Chart.js
- Back-end : Thymeleaf, Java(Jdk 17), SpringBoots
- 버전 및 이슈관리 : Github, Github Issues, Github Project
- 협업 툴 : Notion, KakaoTalk
- UX/UI : [피그마](https://www.figma.com/file/Z78TTVni1hRUd3cZFUWlEt/startup?type=design&node-id=0%3A1&mode=dev&t=IoGgtOolww1rHbRh-1)


<br>


### 

## 2. 채택한 개발 기술과 브랜치 전략 

### Java, Springboots

클래스를 분류함으로써 각 클래스가 특정한 역할을 수행하도록 설계하고 코드를 구조화하여 가독성을 높였습니다.

- 사용자 요청을 받아들이고 해당 요청에 대한 처리를 담당하는 컨트롤러를 사용하여 웹 애플리케이션에서 클라이언트의 요청을 처리하고 응답을 생성하는 역할을 담당했습니다.
- 비즈니스 로직을 구현하고 데이터베이스와의 상호작용을 처리하는 서비스클래스는 주로 컨트롤러에서 호출되며, 비즈니스 로직의 분리와 코드 재사용성을 높이는 데 중점을 두었습니다.
- 데이터베이스와의 상호작용을 담당하는 레파지토리클래스는, 데이터 액세스 계층을 추상화하여 데이터베이스와의 직접적인 상호작용을 캡슐화하고, 데이터베이스에 대한 CRUD 작업을 수행합니다.

### 코드 컨벤션

- 팀 내의 협업을 원할 하게 하기 위해 이와 같이 코드컨벤션을 준수하였습니다.
  변수, 함수 클래스의 이름은 명확하고 의미 있는 이름으로 작성하고, 카멜 케이스는 변수와 함수의 이름으로 작성, 클래스는 파스칼 케이스로 이름을 작성합니다.
  코드의 이해를 돕기 위해 주석을 적극적으로 활용했습니다. 코드의 각부분에 간단한 설명을 추가하고, 주요 기능이나 복잡한 알고리즘에 대한 주석을 작성했습니다.
  함수와 메서드는 한가지 기능만 수행하도록 작성하고, 재사용성과 유지보수성을 높이기 위해 각 함수나 메서드의 크기를 작게 유지하도록 했습니다.
  또한, 예외 처리를 적절하게 사용하여 코드의 안정성을 확보하고자 했습니다. 

### 브랜치 전략

- 저희 '당당히'는 브랜치로부터 분기된 피처 브랜치에서 작업하는 것을 중심으로 했습니다.
  코드 변경의 범위를 제한하여 작업의 추적성을 높이고, 멤버들과의 충돌을 최소화하기 위해 각 기능이나 작업은 별도의 feature브랜치에서 개발하였습니다.
  그리고 피쳐브랜치에서 개발한 기능이 완료되면 주기적인 메인 브랜치와의 merge를 통해 오류를 최소화 하고, 코드 변경을 빠르게 메인 브랜치로 반영,
  지속적인 통합을 실현하고 에러의 재빠른 대처가 가능했습니다.
  이러한 방식으로 저희 팀은 개별기능을 독립적으로 개발하고, 메인 브랜치와의 빈번한 병합을 통해 소스 코드를 안정적으로 유지하였습니다. 

<br>

## 3. 프로젝트 구조

```
├── README.md
├── build
│   ├── classes
│   │   └── java
│   │       ├── main
│   │       │   └── org
│   │       │       └── startup
│   │       │           └── diabetes
│   │       │               ├── DiabetesApplication.class
│   │       │               ├── config
│   │       │               │   ├── RootConfig.class
│   │       │               │   ├── SwaggerConfig.class
│   │       │               │   └── WebSecurityConfig.class
│   │       │               ├── controller
│   │       │               │   ├── BoardController.class
│   │       │               │   ├── FastingController.class
│   │       │               │   ├── HighlightController.class
│   │       │               │   ├── LayoutController.class
│   │       │               │   ├── MainController.class
│   │       │               │   ├── MemberController.class
│   │       │               │   ├── NutritionController.class
│   │       │               │   └── SafeFoodController.class
│   │       │               ├── domain
│   │       │               │   ├── BaseEntity.class
│   │       │               │   ├── Board$BoardBuilder.class
│   │       │               │   ├── Board.class
│   │       │               │   ├── Fasting$FastingBuilder.class
│   │       │               │   ├── Fasting.class
│   │       │               │   ├── Food$FoodBuilder.class
│   │       │               │   ├── Food.class
│   │       │               │   └── Member.class
│   │       │               ├── dto
│   │       │               │   ├── BoardDTO$BoardDTOBuilder.class
│   │       │               │   ├── BoardDTO.class
│   │       │               │   ├── FastingDTO$FastingDTOBuilder.class
│   │       │               │   ├── FastingDTO.class
│   │       │               │   ├── FoodDTO$FoodDTOBuilder.class
│   │       │               │   ├── FoodDTO.class
│   │       │               │   ├── MemberDTO$MemberDTOBuilder.class
│   │       │               │   ├── MemberDTO.class
│   │       │               │   ├── MemberPwUpdateDTO.class
│   │       │               │   ├── PageRequestDTO$PageRequestDTOBuilder.class
│   │       │               │   ├── PageRequestDTO.class
│   │       │               │   ├── PageResponseDTO$PageResponseDTOBuilder.class
│   │       │               │   └── PageResponseDTO.class
│   │       │               ├── repository
│   │       │               │   ├── BoardRepository.class
│   │       │               │   ├── FastingRepository.class
│   │       │               │   ├── FoodRepository.class
│   │       │               │   └── MemberRepository.class
│   │       │               ├── security
│   │       │               │   ├── MemberSecurityDTO.class
│   │       │               │   ├── UserDetail$1.class
│   │       │               │   ├── UserDetail.class
│   │       │               │   └── UserDetailService.class
│   │       │               └── service
│   │       │                   ├── BoardService.class
│   │       │                   ├── FastingService.class
│   │       │                   ├── FastingServiceImpl.class
│   │       │                   ├── FoodService.class
│   │       │                   ├── FoodServiceImple.class
│   │       │                   ├── MemberService$MidExistException.class
│   │       │                   ├── MemberService.class
│   │       │                   ├── MemberServiceImpl$MemberServiceImplBuilder.class
│   │       │                   └── MemberServiceImpl.class
│   │       └── test
│   │           └── org
│   │               └── startup
│   │                   └── diabetes
│   │                       ├── B01ApplicationTests.class
│   │                       └── service
│   │                           └── FastingServiceTests.class
│   ├── generated
│   │   └── sources
│   │       ├── annotationProcessor
│   │       │   └── java
│   │       │       ├── main
│   │       │       └── test
│   │       └── headers
│   │           └── java
│   │               ├── main
│   │               └── test
│   ├── libs
│   │   ├── Diabetes-0.0.1-SNAPSHOT-plain.jar
│   │   └── Diabetes-0.0.1-SNAPSHOT.jar
│   ├── reports
│   │   └── tests
│   │       └── test
│   │           ├── classes
│   │           │   ├── org.startup.diabetes.B01ApplicationTests.html
│   │           │   └── org.startup.diabetes.service.FastingServiceTests.html
│   │           ├── css
│   │           │   ├── base-style.css
│   │           │   └── style.css
│   │           ├── index.html
│   │           ├── js
│   │           │   └── report.js
│   │           └── packages
│   │               ├── org.startup.diabetes.html
│   │               └── org.startup.diabetes.service.html
│   ├── resolvedMainClassName
│   ├── resources
│   │   └── main
│   │       ├── application.yml
│   │       ├── static
│   │       │   ├── assets
│   │       │   │   ├── background.png
│   │       │   │   ├── favicon.ico
│   │       │   │   ├── logo.png
│   │       │   │   └── profile.jpg
│   │       │   ├── css
│   │       │   │   ├── addStyle.css
│   │       │   │   ├── common.css
│   │       │   │   └── styles.css
│   │       │   ├── images
│   │       │   │   └── chicken.jpg
│   │       │   ├── index.html
│   │       │   ├── js
│   │       │   │   └── scripts.js
│   │       │   └── lib
│   │       │       └── jquery-3.7.1.min.js
│   │       └── templates
│   │           ├── board
│   │           │   ├── index.html
│   │           │   ├── info.html
│   │           │   ├── list.html
│   │           │   └── save.html
│   │           ├── fasting
│   │           │   ├── highlight.html
│   │           │   ├── intro.html
│   │           │   ├── list.html
│   │           │   ├── register.html
│   │           │   ├── report.html
│   │           │   ├── safeFood.html
│   │           │   ├── save.html
│   │           │   └── service.html
│   │           ├── fragments
│   │           │   ├── footer.html
│   │           │   └── header.html
│   │           ├── layouts
│   │           │   ├── basic.html
│   │           │   └── defaultLayout.html
│   │           ├── main.html
│   │           ├── member
│   │           │   ├── change-password.html
│   │           │   ├── delete-member.html
│   │           │   ├── join.html
│   │           │   ├── login.html
│   │           │   ├── mypage.html
│   │           │   └── successSignUp.html
│   │           └── page
│   │               └── home.html
```

<br>

## 4. 역할 분담

### 👩🏼‍💻김루아

- **UI**
    - 페이지 : 로그인, 회원가입, 회원가입확인, 회원정보 및 수정, 비밀번호 변경, 식후 혈당
    - 공통 컴포넌트 : 모달, 비밀번호 유효성 확인
- **기능**
    - Spring Security, Member 테이블설계, 테이블 간 외래키 맵핑, 회원가입 및 로그인, 보안기능, 비밀번호 암호화, 식후 혈당 기록, 데이터 조회 및 시각화

<br>

### 😎김이랑

- **UI**
    - 페이지 : 
    - 공통 컴포넌트 :
- **기능**
    - 작성중 ..
<br>

### 🍊이재형

- **UI**
    - 페이지 :
    - 공통 컴포넌트 : 
- **기능**
    - 작성중..

<br>
    
## 5. 개발 기간 및 작업 관리

### 개발 기간

- 개발 기간 : 2023-02-19 ~ 2023-03-12
- 사전 회의, ERD 작성 및 Figma작업 기간: 2023-02-19 ~ 2023-02-23
- 기능 개발 기간 : 2023-02-26 ~ 2023-03-12

<br>

### 작업 관리

- GitHub Projects와 Issues를 사용하여 진행 상황을 공유했습니다.
- 주3~4회 회의를 진행하며 작업 순서와 방향성에 대한 지속적인 소통과 Notion에 기록 공유했습니다.

<br>

## 6. 신경 쓴 부분

- [접근제한 설정](https://github.com/likelion-project-README/README/wiki/README-6.%EC%8B%A0%EA%B2%BD-%EC%93%B4-%EB%B6%80%EB%B6%84_%EC%A0%91%EA%B7%BC%EC%A0%9C%ED%95%9C-%EC%84%A4%EC%A0%95)

- [Recoil을 통한 상태관리 및 유지](https://github.com/likelion-project-README/README/wiki/README-6.%EC%8B%A0%EA%B2%BD-%EC%93%B4-%EB%B6%80%EB%B6%84_Recoil%EC%9D%84-%ED%86%B5%ED%95%9C-%EC%83%81%ED%83%9C%EA%B4%80%EB%A6%AC-%EB%B0%8F-%EC%9C%A0%EC%A7%80)

<br>

## 7. 페이지별 기능


### [회원가입]
- 모든 인풋을 작성해야 회원가입이 가능합니다.
- 비밀번호 재확인 유효성 검사를 통과해야만 가입이 가능합니다.
- 각각에 맞는 문자열이나 숫자를 입력해야만 가입이 가능합니다.

| 회원가입 |
|----------|
|![join](https://github.com/First-Team-STARTUP/Diabetes-management/assets/159866078/33b2a79d-05ca-4a99-a0c6-fcf0b5502f07)|

<br>

### [로그인]
- 회원 가입한 사용자만 로그인 가능합니다.

| 로그인 |
|----------|
![login](https://github.com/First-Team-STARTUP/Diabetes-management/assets/159866078/56b0765d-030a-415a-b386-0186c008c2d7)|

### [비밀번호 변경]
- 비밀번호 재확인 유효성 검사를 통과해야 변경이 가능합니다.
- 변경된 비밀번호는 암호화 되어 저장됩니다.

| 비밀번호 변경 |
|----------|
|![upgradePassword](https://github.com/First-Team-STARTUP/Diabetes-management/assets/159866078/fa4be004-9bb3-4dc3-b16b-fbe139d48998)|


<br>

### [내 정보 확인 및 수정]
- 내 정보를 확인하고 즉시 수정이 가능합니다.
- 문자열은 문자만 숫자열은 숫자만 수정이 가능합니다.
- 수정된 정보는 즉각 반영되어 데이터베이스에 저장됩니다.

| 내 정보 확인 및 수정 |
|----------|
|![upgradeProfile](https://github.com/First-Team-STARTUP/Diabetes-management/assets/159866078/633410df-d774-428f-8d03-946e1bfbefe1)|

<br>

### [로그아웃]
- 상단 고정바의 로그아웃 버튼을 클릭하면 로그아웃이 완료됩니다.
- 로그아웃시 로컬 저장소의 토큰 값과 사용자 정보를 삭제하고 초기화면으로 이동합니다.

| 로그아웃 |
|----------|
|![logout](https://github.com/First-Team-STARTUP/Diabetes-management/assets/159866078/61c0a8d8-6668-4582-95d7-2b045f680f62)|


<br>

### [식후혈당 기록 및 기록 확인]
- 맨 첫 페이지는 로그인 당일로 넘어갑니다.
- 식후 먹은 음식과 혈당을 기록 후 비동기 방식으로 당일의 혈당이 즉각 출력과 동시에 데이터베이스에 저장됩니다.
- 날짜를 선택하면 변경한 날짜와 그날 저장했던 식후 혈당 정보를 함께 볼 수 있습니다.

| 식후 혈당 기록 하기 |
|----------|
|![home0](https://github.com/First-Team-STARTUP/Diabetes-management/assets/159866078/a28f1545-ec8f-40fb-bc2b-91b8b0867802)|
| 기록 확인 |
|![ezgif com-video-to-gif-converter](https://github.com/First-Team-STARTUP/Diabetes-management/assets/159866078/5d9db598-7fe3-4d0b-9ea8-5537f160eadd)|


<br>
## 9. 개선 목표

- 음식 정보확장
- 자동 로그인 기능 및 jwt토큰 활용, social로그인 추가
- 멤버페이지 내에 더 많은 이벤트나 알림창 생성
- 평균 과 위험수치 혈당등을 알 수 있는 혈당에 관한 더 많은 정보 페이지 추가
    
<br>

## 10. 프로젝트 후기

### 👻 김루아

**경험 및 성장**
<br>
첫 스프링부트 프로젝트에서 보안 부분을 맡게 되면서 많은 부담감과 도전을 경험했습니다. 프로젝트 진행 과정 중 발생한 문제를 해결해 나가면서, 개발자로서의 성장을 실감할 수 있었습니다. 특히 각 개발 부분이 합쳐질 때 느껴지는 성취감은 이루 말할 수 없이 크게 다가왔습니다.

**아쉬운 점**
<br>
시큐리티 개발에 많은 시간을 할애하면서, 계획했던 JWT 인증 및 소셜 로그인 기능을 완성하지 못했습니다. 프로젝트 초기 목표였던 '식후 혈당 페이지' 개발로 방향을 전환해야 했던 점이 아쉽습니다.

**추가 개발**
<br>
프로젝트가 끝난 후에도 배운 점을 살려 '식후 혈당 페이지'에 개별 날짜 출력 기능을 추가하는 작업을 진행했습니다. 이를 통해 추가적인 기술 스킬을 확보하고, 프로젝트 완성도를 높일 수 있었습니다.

**결론**
<br>
이번 프로젝트는 저에게 첫 진지한 개발 도전이었고, 많은 학습과 성장의 기회를 제공했습니다. 아직 배울 것이 많지만, 이번 경험이 앞으로의 개발 여정에 큰 동기부여가 되었습니다.
<br>

### 😎 김이랑

 작성중..

### 🍊 이재형

작성중..
<br>





