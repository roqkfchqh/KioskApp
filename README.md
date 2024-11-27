# 🍲 키오스크

# with Java

## 📜프로젝트 파일 구조
```java
📁src
├── 📁Exception
│   └── BadInputException.java
├── 📁Main
│   └── Main.java
├── 📁Menu
│   ├── 📁Main
│   │   ├── MainMenuItem.java
│   │   └── MainMenuType.java
│   ├──📁Side
│   │   ├── SideMenuItem.java
│   │   └── SideMenuType.java
│   └── MenuFactory.java
├── 📁Order
│   ├── Coupon.java
│   ├── Order.java
│   └── OrderBuilder.java
└── 📁State
    ├── CartState.java
    ├── MainMenuState.java
    ├── OrderState.java
    ├── PaymentState.java
    ├── SideMenuState.java
    └── StateHandler.java


```
- 사용 언어 : JAVA 
- 구현된 기능 : 장바구니, 쿠폰 추가/삭제, 메뉴 추가/삭제, 메인메뉴와 사이드메뉴 함께 주문,  사이드메뉴 수량 제한



## ⭐ 유지 보수가 편리한 키오스크를 만들었습니다!
#### 전체적으로 새로운 기능을 추가하거나 기존 기능을 수정할 때 관련된 코드만 쉽게 찾을 수 있습니다.
1. 메인메뉴, 사이드메뉴, 쿠폰 전부 enum 열거형으로 두었습니다.

2. 상태 패턴을 통해 각 상태를 분리해 명확히 하고 유지보수성을 높였습니다.

3. 팩토리, 빌더 패턴을 통해 주문 과정을 체계화하고 확장성을 높였습니다.

4. 예외 처리를 확실하게 했습니다.


## 🗨️최대한 많이 배우려고 노력했습니다!
1. 싱글턴, 팩토리, 빌더, 상태 패턴 등 고려될 수 있는 디자인 패턴을 모두 적용해봤습니다.

2. 최대한 메서드들을 중앙에 집중시켜서 이후 새 기능을 추가할 때 편리하도록 구성했습니다. 



## 🛠 앞으로 개선하고 싶은 점도 많습니다.

1. 코드의 길이가 꽤 긴데, 리팩토링을 어떻게 할지 고민입니다.

2. ui를 제대로 신경쓰지 못했습니다.



## ⌨️ 내가 고민했던 것들

- [
kiosk 구조 짜기 <1>](https://roqkfchqh.tistory.com/68)   

- [ 	
State pattern <2>](https://roqkfchqh.tistory.com/69)

- [	
Builder pattern<3>](https://roqkfchqh.tistory.com/70)

- [
Trouble shooting <4>](https://roqkfchqh.tistory.com/72)

- [	
기존 코드에 Stream 반영하기 <5>](https://roqkfchqh.tistory.com/73)
