
## Logo
![image](https://github.com/First-Team-STARTUP/Diabetes-management/assets/150316684/41834124-3099-4580-8003-b14ea9a86ce8)


<br>

# 📖 스타트업 혈당 관리 프로그램 '당당히' README

![readme_mockup2](https://github.com/First-Team-STARTUP/Diabetes-management/assets/159866078/6c93a0bb-7924-434d-a262-9e39ed7f4f38)


<br>

## 프로젝트 소개 : 루아

혈당 관리 웹 애플리케이션 '당당히'는 사용자가 일일 혈당 수치를 기록하고 추적하여 건강 상태를 관리할 수 있도록 돕습니다. <br/>
사용자는 간편한 UI를 통해 혈당 수치를 입력하고, 식사나 운동과 같은 활동과 관련된 정보를 함께 기록할 수 있습니다.<br/>
이 프로젝트는 사용자가 일일 혈당 수치를 입력하고 이를 기반으로 개선된 건강 상태를 확인할 수 있는 다양한 기능을 제공합니다.<br/> 
또한 사용자는 그래프나 통계를 통해 혈당 수치의 추이를 시각적으로 확인할 수 있습니다.<br/>

<br>

## 팀원 구성

<div align="center">

| **김루아** | **김이랑** | **이재형** |
| :------: |  :------: | :------: |
| [<img src="https://avatars.githubusercontent.com/u/106502312?v=4" height=150 width=150> <br/> @ruah0807](https://github.com/yeon1615) | [<img src="https://avatars.githubusercontent.com/u/112460466?v=4" height=150 width=150> <br/> @Cheorizzang](https://github.com/Cheorizzang) | [<img src="https://avatars.githubusercontent.com/u/112460506?v=4" height=150 width=150> <br/> @heejiyang](https://github.com/heejiyang) |

</div>

<br>

## 1. 개발 환경    : 루아

![개발환경](https://github.com/First-Team-STARTUP/Diabetes-management/assets/159866078/7bebd3a8-222c-47e2-8ab5-2a1c6128733f)

- Front : HTML, CSS, javaScript, Bootstrap, Chart.js
- Back-end : Thymeleaf, Java(Jdk 17), SpringBoots
- 버전 및 이슈관리 : Github, Github Issues, Github Project
- 협업 툴 : Notion, KakaoTalk
- UX/UI : [피그마](https://www.figma.com/file/Z78TTVni1hRUd3cZFUWlEt/startup?type=design&node-id=0%3A1&mode=dev&t=IoGgtOolww1rHbRh-1)


<br>


### 

## 2. 채택한 개발 기술과 브랜치 전략 : 루아

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

## 3. 프로젝트 구조  // 김루아

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

### 🍊이재형

- **UI**
    - 페이지 :
    - 공통 컴포넌트 : 
- **기능**
    - 작성중..

<br>
    
### 👩🏼‍💻김루아

- **UI**
    - 페이지 : 로그인, 회원가입, 회원가입확인, 회원정보 및 수정, 비밀번호 변경, 식후 혈당
    - 공통 컴포넌트 : 모달, 비밀번호 유효성 확인
- **기능**
    - Member 테이블설계, 테이블 간 외래키 맵핑, 회원가입 및 로그인, 보안기능, 비밀번호 암호화, 식후 혈당 기록, 데이터 조회 및 시각화

<br>

### 😎김이랑

- **UI**
    - 페이지 : 
    - 공통 컴포넌트 :
- **기능**
    - 작성중 ..
<br>


## 5. 개발 기간 및 작업 관리

### 개발 기간    //루아

- 개발 기간 : 2023-02-19 ~ 2023-03-12
- 사전 회의, ERD 작성 및 Figma작업 기간: 2023-02-19 ~ 2023-02-23
- 기능 개발 기간 : 2023-02-26 ~ 2023-03-12


<br>

### 작업 관리    //루아

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

### [로그아웃]
- 상단 고정바의 로그아웃 버튼을 클릭하면 로그아웃이 완료됩니다.
- 로그아웃시 로컬 저장소의 토큰 값과 사용자 정보를 삭제하고 초기화면으로 이동합니다.

| 로그아웃 |
|----------|
|![logout](https://github.com/First-Team-STARTUP/Diabetes-management/assets/159866078/61c0a8d8-6668-4582-95d7-2b045f680f62)|


<br>

### [내 정보 확인 및 수정]
- 내 정보를 확인하고 즉시 수정이 가능합니다.
- 문자열은 문자만 숫자열은 숫자만 수정이 가능합니다.
- 수정된 정보는 즉각 반영되어 데이터베이스에 저장됩니다.

| 내 정보 확인 및 수정 |
|----------|
|![upgradeProfile](https://github.com/First-Team-STARTUP/Diabetes-management/assets/159866078/633410df-d774-428f-8d03-946e1bfbefe1)|

<br>

### [홈 피드]
- 자신이 팔로우 한 유저의 게시글이 최신순으로 보여집니다.
- 팔로우 한 유저가 없거나, 팔로워의 게시글이 없을 경우 검색 버튼이 표시됩니다.
- 게시글의 상단 유저 배너 클릭 시 게시글을 작성한 유저의 프로필 페이지로, 본문 클릭 시 게시글 상세 페이지로 이동합니다.

| 팔로우하는 유저가 없을 때 | 팔로우하는 유저가 있을 때 |
|----------|----------|
|![home0](https://user-images.githubusercontent.com/112460466/210379059-48900aac-3735-45c6-a249-bc9c41b49414.gif)|![home1](https://user-images.githubusercontent.com/112460466/210379110-49153d27-0405-48e6-adfb-62c7818d2f43.gif)|

<br>

### [검색]
- 사용자 이름 혹은 계정 ID로 유저를 검색할 수 있습니다.
- 검색어와 일치하는 단어는 파란색 글씨로 표시됩니다.
- 클릭 시 해당 유저의 프로필 페이지로 진입합니다.

| 검색 |
|----------|
|![search](https://user-images.githubusercontent.com/112460466/210379805-6c8a42c0-0de8-48d3-8f75-cdf0ae5f4fb6.gif)|

<br>

### [프로필]

#### 1. 내 프로필
- 상단 프로필란에 프로필 수정과 상품 등록 버튼이 나타납니다.
- 판매중인 상품란에는 사용자가 판매하는 상품이 등록되며, 판매중인 상품이 없을 경우에는 영역 자체가 나타나지 않습니다.
- 게시글란은 상단의 리스트형과 앨범형 두 개의 버튼을 통해서 나누어 볼 수 있습니다.
    - 리스트형의 경우, 사용자가 작성한 글 내용과 이미지, 좋아요와 댓글의 수를 보여줍니다.
    - 앨범형의 경우, 사용자 게시글 중 이미지가 있는 글만 필터링해 바둑판 배열로 보여줍니다.
- 게시글을 클릭하면 각 게시글의 상세페이지로 이동합니다.

| 리스트형 & 앨범형 게시글 | 팔로잉 & 팔로워 리스트 |
|----------|----------|
|![myProfile](https://user-images.githubusercontent.com/112460466/210380492-40560e0b-c306-4e69-8939-cc3e7dc3d8fe.gif)|![followList](https://user-images.githubusercontent.com/112460466/210380539-d09b0bd7-0b61-4b22-85fa-f75e6bcecb68.gif)|

<br>

#### 2. 타 유저의 프로필
- 버튼을 클릭해 해당 사용자를 팔로우 또는 언팔로우할지 결정할 수 있으며 팔로워 수의 변화가 페이지에 즉시 반영됩니다.

| 팔로우 & 언팔로우 |
|----------|
|![yourProfile](https://user-images.githubusercontent.com/112460466/210380853-04f2d2bd-adab-4786-a8e8-c275ce765071.gif)|

<br>

#### 3. 프로필 수정
- 사용자 프로필 이미지, 이름, 아이디, 소개 중 한 가지를 수정하면 저장 버튼이 활성화됩니다.
- 계정 ID의 유효한 형식 및 중복 검사를 통과하지 못하면 하단에 경고 문구가 나타나며 저장 버튼이 비활성화됩니다.
- 사용자 이름과 소개는 공백으로 시작할 수 없습니다.
- 프로필 수정이 완료되면 내 프로필 페이지로 이동합니다.

| 초기화면 |
|----------|
|![editProfile](https://user-images.githubusercontent.com/112460466/210381212-d67fdf87-b90c-4501-a331-f2a384534941.gif)|

<br>

### [게시글]

#### 1. 게시글 작성
- 글이 입력되거나 사진이 첨부되면 업로드 버튼이 활성화됩니다.
- 최대 세 장까지 이미지 첨부가 가능하며 첨부한 파일을 취소할 수 있습니다.
- 게시글 하단에 업로드 날짜가 표시됩니다.

| 게시글 작성 |
|----------|
|![uploadPost](https://user-images.githubusercontent.com/112460466/210381758-1de5a889-f587-41d2-b200-22c20a970519.gif)|

<br>

#### 2. 게시글 수정 및 삭제
- 자신의 게시글일 경우 모달 버튼을 통해 수정, 삭제가 가능합니다.
- 게시글 삭제 버튼 클릭 시, 게시글을 삭제하고 페이지를 리렌더링하여 삭제된 내용을 페이지에 반영합니다.
- 타 유저의 게시글일 경우 모달 버튼을 통해 신고할 수 있습니다.

| 게시글 수정 & 삭제 |
|----------|
|![editDeletePost](https://user-images.githubusercontent.com/112460466/210382021-da057943-dc21-411e-a1f8-552be0e973bf.gif)|

<br>

#### 3. 좋아요와 댓글
- 좋아요와 댓글 수는 실시간으로 상세 페이지에 반영됩니다.
- 댓글이 몇 분 전에 작성되었는지 표시됩니다.
- 자신의 댓글일 경우 모달 버튼을 통해 삭제가 가능합니다.
- 타 유저의 댓글일 경우 모달 버튼을 통해 신고할 수 있습니다.

| 좋아요 & 댓글 |
|----------|
|![likeComment](https://user-images.githubusercontent.com/112460466/210382217-01d70181-91c3-43db-a1b8-409a612afb1c.gif)|

<br>

### [상품]

#### 1. 상품 등록
- 상품 이미지, 상품명, 가격, 판매 링크를 필수로 입력해야 저장 버튼이 활성화됩니다.
- 상품 가격은 숫자만 입력할 수 있으며, 숫자를 입력하면 자동으로 원 단위로 변환됩니다.
- 상품 가격이 0원일 경우 버튼이 비활성화되며 하단에 경고 문구가 나타납니다.
- 상품명과 판매 링크는 공백으로 시작할 수 없습니다.
- 상품 등록이 완료되면 내 프로필 페이지로 이동합니다.

| 상품 등록 |
|----------|
|![addProduct](https://user-images.githubusercontent.com/112460466/210386068-c6ff2e05-eb64-4abc-b6dc-93bf52b88d3f.gif)|

<br>

#### 2. 상품 수정 및 삭제
- 상품 이미지, 상품명, 가격, 판매 링크 중 한 가지를 수정하면 저장 버튼이 활성화됩니다.
- 상품 수정이 완료되면 내 프로필 페이지로 이동합니다.
- 상품 삭제 버튼 클릭 시, 상품을 삭제하고 페이지를 리렌더링하여 삭제된 내용을 페이지에 반영합니다.

| 상품 수정 & 삭제 |
|----------|
|![editDeleteProduct](https://user-images.githubusercontent.com/112460466/210386311-5fae87a7-745f-47c0-b8e3-fc41c65cb3cb.gif)|

<br>

### [채팅]
- 채팅 목록에서 아직 읽지 않은 채팅에는 좌측 상단의 파란색 알림을 띄워줍니다.
- 채팅방에서 메시지를 입력하거나 파일을 업로드하면 전송 버튼이 활성화됩니다.
- 채팅방에서 우측 상단의 채팅방 나가기 모달 버튼을 통해 채팅 목록 페이지로 이동할 수 있습니다.
- 채팅 메시지 전송 및 수신 기능은 개발 예정입니다.

| 채팅 |
|----------|
|![chat](https://user-images.githubusercontent.com/112460466/210386478-ea4877c5-1728-4872-ab50-a8408ddf6dcd.gif)|

<br>

## 8. 트러블 슈팅

- [탭메뉴 프로필 버튼 이슈](https://github.com/likelion-project-README/README/wiki/README-8.%ED%8A%B8%EB%9F%AC%EB%B8%94-%EC%8A%88%ED%8C%85_%ED%83%AD%EB%A9%94%EB%89%B4-%ED%94%84%EB%A1%9C%ED%95%84-%EB%B2%84%ED%8A%BC-%EC%9D%B4%EC%8A%88)

- [프로필 수정 이슈](https://github.com/likelion-project-README/README/wiki/README-8.%ED%8A%B8%EB%9F%AC%EB%B8%94-%EC%8A%88%ED%8C%85_%ED%94%84%EB%A1%9C%ED%95%84-%EC%88%98%EC%A0%95-%EC%9D%B4%EC%8A%88)

<br>

## 9. 개선 목표

- API 모듈화 : API를 불러오는 코드의 반복이 많아 모듈화할 예정
- lighthouse Performance 증진
    - 모든 페이지에서 특히 Best Practices & SEO 점수는 90~100으로 우수
    - Performance 점수가 대체적으로 미흡한 문제
    
    ![KakaoTalk_Photo_2023-01-04-16-55-30](https://user-images.githubusercontent.com/112460466/210591134-09bf8efd-3c34-4b99-a3d7-895ca99e1457.png)
    
- **23-01-17 성능 개선 내용**
    
    ![성능개선 후](https://user-images.githubusercontent.com/106502312/212872369-7ceeb2cf-d551-41d2-bfb0-01e35e9903fe.png)
    
    - 이미지 최적화
        - `<img>` 요소에 `width` , `height` 속성값을 명시해 불필요한 Reflow를 방지했습니다.
        - browser-image-compression 라이브러리를 사용해 유저가 업로드하는 이미지를 압축했습니다.
        - Intersection Observer API를 사용해 Lazy Loading 기법을 적용하여 홈 피드의 게시글 이미지가 viewport 내에 들어오는 순간 로딩되도록 변경했습니다.
    - 웹폰트 최적화
        - WOFF2 포맷을 추가하고 가장 우선적으로 적용되도록 선언했습니다.
        - 서브셋 폰트로 교체해 용량을 줄였습니다.
    
<br>

## 10. 프로젝트 후기

### 🍊 이재형

작성중..
<br>

### 👻 김루아

 작성중..
<br>

### 😎 김이랑

 작성중..



