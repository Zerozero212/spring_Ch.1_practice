# 🌱 Spring Boot 학습 및 Mustache 레이아웃 정리

오늘 학습한 스프링 부트의 기초 설정 방법, 주요 개념, 그리고 Mustache를 활용한 레이아웃 구조화 방법을 정리한 문서입니다.

---

## 1. 프로젝트 환경 및 빌드 도구
### 🛠️ 빌드 관리 도구 비교
* **Maven**: XML 기반(`pom.xml`). 설정이 정형화되어 있으나 코드가 길고 빌드 속도가 상대적으로 느림.
* **Gradle - Groovy**: 자바 문법과 유사한 스크립트 기반(`build.gradle`). 빌드 속도가 매우 빠르고 유연하여 현재 가장 많이 사용됨.
* **Gradle - Kotlin**: 코틀린 언어로 작성(`build.gradle.kts`). 정적 타입 체크와 자동 완성이 강력하여 안정적인 설정 가능.

---

## 2. 주요 의존성(Dependencies) 및 기술 개념

### 📦 핵심 라이브러리
| 라이브러리 명칭 | 역할 |
| :--- | :--- |
| **Spring Web** | RESTful API 및 웹 애플리케이션 개발의 핵심. 내장 **Tomcat** 포함. |
| **H2 Database** | 가벼운 **인메모리 DB**. 설치 없이 초기 개발 및 테스트용으로 최적. |
| **Mustache** | 서버에서 HTML을 생성하는 **템플릿 엔진**. 로직이 단순하여 가독성이 좋음. |
| **Spring Data JPA** | SQL 쿼리 대신 자바 객체로 DB를 조작하는 **ORM** 기술. |

### 💡 주요 용어 정리
* **SSR (Server Side Rendering)**: 서버에서 HTML 요리를 다 해서 브라우저에 배달하는 방식 (예: Mustache). SEO에 유리함.
* **CSR (Client Side Rendering)**: 서버는 재료(데이터)만 주고 브라우저가 직접 요리하는 방식 (예: Vue, React). 화면 전환이 부드러움.
* **엔진 (Engine)**: 복잡한 핵심 로직(화면 렌더링, DB 처리 등)을 대신 수행해 주는 거대한 기계 장치.
* **Tomcat (WAS)**: 자바 코드가 웹에서 돌아갈 수 있게 해주는 일꾼. Spring Boot는 이를 내장하고 있음.

---

## 3. Mustache 레이아웃 시스템 (Base Template)

반복되는 헤더와 푸터를 분리하여 관리하는 방법입니다.

### 📂 파일 구조
```text
src/main/resources/templates
├── layouts/
│   ├── header.mustache   <-- 상단 내비게이션, CSS 선언
│   └── footer.mustache   <-- 하단 정보, JS 선언
└── articles/
    └── index.mustache    <-- 메인 본문 페이지