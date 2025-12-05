# SPRING ADVANCED

## Lv 0. 프로젝트 세팅 - 에러 분석

프로젝트를 실행했으나, 특정 에러로 인해 애플리케이션 실행에 실패했습니다! 발생한 에러의 원인을 정확히 분석하고 실행 가능하게 만들어주세요! (에러는 여러 개일 수 있습니다)


## Lv 1. ArgumentResolver

패키지 org.example.expert.config;에 위치한 AuthUserArgumentResolver 의 로직이 현재 동작하지 않고 있습니다. AuthUserArgumentResolver 가 정상적으로 기능할 수 있도록 해주세요.


## Lv 2. 코드 개선

### 2-1. 코드 개선 퀴즈 - Early Return

조건에 맞지 않는 경우 즉시 리턴하여, 불필요한 로직의 실행을 방지하고 성능을 향상시킵니다.

패키지 `org.example.expert.domain.auth.service;` 의 `AuthService` 클래스에 있는 `signup()` 중 아래의 코드 부분의 위치를 리팩토링해서

```java
if (userRepository.existsByEmail(signupRequest.getEmail())) {
    throw new InvalidRequestException("이미 존재하는 이메일입니다.");
}
```

해당 에러가 발생하는 상황일 때, `passwordEncoder`의 `encode()` 동작이 불필요하게 일어나지 않게 코드를 개선해주세요.

주의사항! : 이미지의 `signup()` 메서드 안에서만 리팩토링을 진행해주세요!


### 2-2. 리팩토링 퀴즈 - 불필요한 if-else 피하기

복잡한 if-else 구조는 코드의 가독성을 떨어뜨리고 유지보수를 어렵게 만듭니다. 불필요한 else 블록을 없애 코드를 간결하게 합니다.

패키지 `org.example.expert.client;` 의 `WeatherClient` 클래스에 있는 `getTodayWeather()` 중 아래의 코드 부분을 리팩토링해주세요.

```java
WeatherDto[] weatherArray = responseEntity.getBody();
if (!HttpStatus.OK.equals(responseEntity.getStatusCode())) {
    throw new ServerException("날씨 데이터를 가져오는데 실패했습니다. 상태 코드: " + responseEntity.getStatusCode());
} else {
    if (weatherArray == null || weatherArray.length == 0) {
        throw new ServerException("날씨 데이터가 없습니다.");
    }
}
```

### 2-3. 코드 개선 퀴즈 - Validation

패키지 `org.example.expert.domain.user.service;` 의 `UserService` 클래스에 있는 `changePassword()` 중 아래 코드 부분을 해당 API의 요청 DTO에서 처리할 수 있게 개선해주세요.

```java
if (userChangePasswordRequest.getNewPassword().length() < 8 ||
        !userChangePasswordRequest.getNewPassword().matches("ㅅ") ||
        !userChangePasswordRequest.getNewPassword().matches(".*[A-Z].*")) {
    throw new InvalidRequestException("새 비밀번호는 8자 이상이어야 하고, 숫자와 대문자를 포함해야 합니다.");
}
```

Tip!
'org.springframework.boot:spring-boot-starter-validation' 라이브러리를 활용해주세요!


## Lv 3. N+1 문제

- `TodoController`와 `TodoService`를 통해 `Todo` 관련 데이터를 처리합니다.
- 여기서 N+1 문제가 발생할 수 있는 시나리오는 `getTodos` 메서드에서 모든 Todo를 조회할 때, 각 Todo와 연관된 데이터를 개별적으로 가져오는 경우입니다.
- 요구사항:
    - JPQL `fetch join`을 사용하여 N+1 문제를 해결하고 있는 `TodoRepository`가 있습니다. 이를 동일한 동작을 하는 `@EntityGraph` 기반의 구현으로 수정해주세요.



## Lv 4. 테스트코드 연습

### 1. 테스트 코드 연습 - 1 (예상대로 성공하는지에 대한 케이스입니다.)

테스트 패키지 org.example.expert.config; 의 PasswordEncoderTest 클래스에 있는 matches_메서드가_정상적으로_동작한다() 테스트가 의도대로 성공할 수 있게 수정해 주세요.


### 2. 테스트 코드 연습 - 2 (예상대로 예외처리 하는지에 대한 케이스입니다.)

- 1번 케이스
    
    테스트 패키지 `org.example.expert.domain.manager.service;` 의 `ManagerServiceTest` 의 클래스에 있는 `manager_목록_조회_시_Todo가_없다면_NPE_에러를_던진다()` 테스트가 성공하고 컨텍스트와 일치하도록 **테스트 코드**와 **테스트 코드 메서드명**을 수정해 주세요.
 
    Hint! 
    던지는 에러가 `NullPointerException`이 아니므로 메서드명 또한 수정되어야 해요!

- 2번 케이스
  
    테스트 패키지 `org.example.expert.domain.comment.service;` 의 `CommentServiceTest` 의 클래스에 있는 `comment_등록_중_할일을_찾지_못해_에러가_발생한다()` 테스트가 성공할 수 있도록 **테스트 코드**를 수정해 주세요.
    
- 3번 케이스
    
    테스트 패키지 `org.example.expert.domain.manager.service`의 `ManagerServiceTest` 클래스에 있는 `todo의_user가_null인_경우_예외가_발생한다()` 테스트가 성공할 수 있도록 **서비스 로직**을 수정해 주세요.






