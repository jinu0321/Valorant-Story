# Valorant Story

<p align="center">
  <img src="app/src/main/ic_launcher-playstore.png" width="120" alt="Valorant Story 앱 아이콘" />
</p>

VALORANT의 요원, 무기, 맵 정보를 한곳에서 빠르게 찾아볼 수 있도록 만든 **Kotlin 기반 Android 정보 앱**입니다. 게임을 실행하지 않은 상황에서도 역할·스킬, 무기별 사거리/부위별 피해량, 맵 구조를 모바일 화면에 맞게 탐색할 수 있도록 구성했습니다.

> 이 저장소는 2020년 당시의 정적 리소스를 포함한 프로젝트입니다. 최신 게임 데이터와 차이가 있을 수 있습니다.

## 해결하려는 문제

게임을 익히는 과정에서는 요원 스킬, 무기 성능, 맵 구조처럼 성격이 다른 정보를 번갈아 확인해야 합니다. Valorant Story는 이 정보를 세 개의 탭으로 분리하고, 목록에서 상세 정보까지 이어지는 단순한 탐색 흐름으로 정리합니다.

- **요원:** 역할, 소개, 스킬 키·비용·충전 수·설명 확인
- **무기:** 종류, 가격, 탄창, 벽 관통력, 연사 방식과 사거리별 머리/몸통/다리 피해량 확인
- **맵:** 카드 목록과 한국어/영어 표기가 반영된 전체 맵 이미지 확인
- **다국어:** Android 리소스 로캘을 이용한 영어 기본값과 한국어(`ko-rKR`) 제공
- **화면 대응:** 기기 화면 크기를 기준으로 카드와 상세 이미지 크기를 조정

현재 코드에 포함된 콘텐츠는 **요원 11명(추가 예정 카드 1개 별도), 무기 18개, 맵 4개**입니다.

## 기술 스택

| 영역 | 기술 |
| --- | --- |
| 언어 / 플랫폼 | Kotlin 1.3.72, Android (minSdk 21 / targetSdk 29) |
| UI | AndroidX AppCompat, ConstraintLayout, Fragment, RecyclerView, Data Binding, Kotlin Android Extensions |
| 화면 이동 | Activity, Fragment transaction, Intent extra, Anko |
| 데이터 | Android string/drawable 리소스, 로캘별 리소스 오버라이드 |
| 광고 / 관측 | Google Mobile Ads, Firebase Analytics, Firebase Crashlytics |
| 빌드 / 테스트 | Gradle 6.1.1, Android Gradle Plugin 4.0.0, JUnit 4, AndroidX Test / Espresso |

## 화면 및 데이터 흐름

```text
MainActivity
  ├─ 요원 탭 ─ AgentContentsFragment ─ AgentCardAdapter ─ AgentDetailActivity
  │                                                    └─ AgentFullImageActivity
  ├─ 무기 탭 ─ ArsenalContentsFragment ─ ArsenalCardAdapter ─ ArsenalDetailActivity
  └─ 맵 탭 ─ MapContentsFragment ─ MapCardAdapter ─ MapDetailActivity

Fragment가 모델 배열 생성
  → RecyclerView Adapter가 카드 렌더링
  → 선택한 항목의 identifier를 Intent로 전달
  → 상세 Activity가 모델과 로컬 리소스를 조합해 화면 구성
```

별도의 서버 상태나 전역 UI 상태 관리 프레임워크는 사용하지 않습니다. 탭 상태는 `MainActivity`가 Fragment 교체와 배경/강조 색상 변경으로 처리하고, 상세 화면에 필요한 최소 값인 `identifier`만 전달해 목적지에서 데이터를 다시 구성합니다.

## 핵심 구현

### 1. 정적 게임 데이터를 Android 리소스로 관리

앱의 게임 정보와 이미지는 `res/values`, `res/values-ko-rKR`, `res/drawable`에 포함되어 있습니다. 따라서 콘텐츠 조회 자체에는 네트워크가 필요하지 않고, Android의 리소스 선택 규칙으로 기기 언어에 맞는 문자열을 제공합니다.

- `Agent`는 identifier별 문자열·역할 아이콘·스킬 이미지를 명시적으로 연결합니다.
- `Arsenal`은 `ResourceGetterWithIdentifier`를 통해 `arsenal_{identifier}_{field}` 규칙으로 문자열과 이미지를 조회하여 반복 매핑을 줄입니다.
- `Map`은 로캘의 `language` 리소스에 따라 한국어/영어 라벨이 포함된 전체 맵 이미지를 선택합니다.

정적 리소스 방식은 빠르고 예측 가능한 조회가 장점인 반면, 데이터 변경 시 앱 업데이트가 필요합니다.

### 2. 목록과 상세 화면의 역할 분리

각 도메인은 Fragment와 전용 RecyclerView Adapter로 목록을 구성하고, 상세 Activity는 전달받은 identifier에 해당하는 모델을 생성합니다. 요원 상세 화면은 Data Binding으로 모델을 연결하며, 스킬 목록은 별도의 세로 RecyclerView로 표현합니다. 무기 상세 화면은 존재하지 않는 보조 공격/사거리 구간을 숨기고, 피해량이 150 이상인 값을 강조합니다.

### 3. 광고 노출과 생명주기 처리 집중화

`AdManager`가 배너 광고의 로드 및 `pause`/`resume`/`destroy` 호출을 모읍니다. 목록 어댑터는 상세 페이지 열람 횟수를 기준으로 전면 광고를 시도하고, 광고가 닫힌 뒤 원래 선택한 상세 화면으로 이동합니다. Firebase Analytics와 Crashlytics 의존성도 앱 모듈에 연결되어 있습니다.

> 게임 콘텐츠는 로컬 리소스에서 읽습니다. 인터넷 권한은 Google Mobile Ads 및 Firebase SDK 연동을 위해 선언되어 있으며, 코드에는 Riot API 호출, 별도 백엔드, 로그인, 데이터베이스 또는 로컬 영속 저장소가 없습니다.

## 프로젝트 구조

```text
app/src/main/
├── java/com/jincal/valorantstory/
│   ├── MainActivity.kt                 # 탭과 최상위 화면 전환
│   ├── *DetailActivity.kt              # 요원·무기·맵 상세 화면
│   ├── agent/, arsenal/, map/          # 도메인 모델과 RecyclerView Adapter
│   ├── fragment/                       # 세 가지 콘텐츠 목록
│   └── object/                         # 광고, 리소스, 화면 크기, View/Fragment 유틸리티
├── res/
│   ├── layout/                         # Activity, Fragment, 카드 레이아웃
│   ├── drawable/                       # 요원·스킬·무기·맵 이미지와 배경
│   ├── values/                         # 영어 기본 문자열, 색상, 스타일
│   └── values-ko-rKR/                  # 한국어 문자열 오버라이드
└── AndroidManifest.xml
```

## 실행 방법

이 프로젝트는 Android Studio와 Android SDK 29를 기준으로 구성되어 있습니다.

1. 저장소를 클론하고 Android Studio에서 루트 디렉터리를 엽니다.
2. Gradle 동기화를 실행합니다.
3. Android 5.0(API 21) 이상의 에뮬레이터 또는 기기를 선택합니다.
4. `app` 구성을 실행합니다.

명령줄에서 디버그 빌드와 단위 테스트를 실행할 수도 있습니다.

```bash
./gradlew assembleDebug
./gradlew testDebugUnitTest
```

프로젝트가 사용하는 Gradle/Android 플러그인 및 일부 라이브러리는 현재 기준으로 오래된 버전입니다. 최신 JDK나 Android Studio에서 동기화 문제가 발생한다면 프로젝트 당시 환경에 맞는 JDK 8과 Android SDK 29 조합을 먼저 확인해야 합니다. Firebase 및 광고 연동을 변경해 사용하는 경우에는 자신의 프로젝트 설정과 광고 단위 ID로 교체해야 합니다.

## 비공식 프로젝트 안내

Valorant Story는 **비공식 팬 프로젝트**이며 Riot Games의 공식 앱이나 제휴 제품이 아닙니다. VALORANT, Riot Games 및 관련 이름·이미지·상표의 권리는 각 권리자에게 있습니다. 저장소의 소프트웨어 코드는 [Apache License 2.0](LICENSE)을 따르며, 이 라이선스가 제3자 게임 자산에 대한 권리를 부여하는 것은 아닙니다.
