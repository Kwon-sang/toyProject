# Toy Project : 숫자 야구게임 개발 
    우아한 테크코스 프리코스 미션 중 하나인, 숫자야구게임을 이용한 프로젝트를 실시한다.
    해당 게임을 우선, 콘솔기반 게임으로 구성하며, 콘솔기반 게임으로 구현함에 있어,
    적절한 리팩토링과 테스트 검증을 수행하기로 한다.
    
    이후, 웹기반 어플리케이션으로 적용하고, 기능을 추가하여, 온전한 웹어플리케이션 을 만들어보기로 한다.


---


# 1. 기능 요구 사항
    1~9까지 서로 다른 수로 이루어진 3자리 수를 맞추는 게임.
    컴퓨터는 랜덤한 서로다른 세자리 숫자를 생성하며, 이를 게임의 유저(클라이언트)가 맞추면 승리하며 게임은 종료된다.
    유저는 컴퓨터의 숫자를 추론한 3자리 서로다른 수를 제시하며, 컴퓨터는 유저가 입력한 숫자에 대한 힌트를 제공한다.
    
    힌트는 다음과 같다.
     - 같은 자리 숫자가 일치할 경우 : n스트라이크
     - 같은 자리는 아니나, 일치하는 숫자가 존재할 경우 : n볼
     - 어떤 숫자도 포함되지 않을 경우 : 낫싱
    
    컴퓨터의 숫자를 유저가 맞춘 후, 게임이 종료될 시, 유저는 게임을 다시 시작하거나 혹은 완전히 종료할 수 있다.
    사용자가 잘못된 값을 입력할 경우, IllegarArgumentException을 발생시킨 후, 애플리케이션은 종료되어야 한다.

 - ## 1.1 게임 실행 예시
```
 숫자 야구 게임을 시작합니다.
 (For Example, a Computer number is 264)
 숫자를 입력해 주세요 : 321
 1볼
 숫자를 입력해 주세요 : 213
 1스트라이크
 숫자를 입력해 주세요 : 246
 1스트라이크 2볼
 숫자를 입력해 주세요 : 264
 3스트라이크
 3개의 숫자를 모두 맞히셨습니다! 게임 종료
 게임을 재시작 하시겠습니까? (Y/N)
 Y
 (For Example, a Computer number is 649)
 숫자를 입력해 주세요 : 649
 3스트라이크
 3개의 숫자를 모두 맞히셨습니다! 게임 종료
 게임을 재시작 하시겠습니까? (Y/N)
 N
```
---

# 2. 콘솔기반 게임 구현
## 2.1 : God class (version 1) 
Code Link : (https://github.com/Kwon-sang/toyProject/blob/master/src/main/java/v1/Application_v1.java)
> - version1 에서는 우선 하나의 클래스에 모든 기능을 구현하는, 'God class anti-pattern' 방식으로 구현한다.<br/>
> - 이러한 하나의 클래스에 모든 기능을 구현하는 것은 객체지향적 프로그래밍 보다는 오히려 절차지향적 프로그래밍에 가깝다.<br/>
> - 로직을 구성하는 코드 전반에 대한 이해가 필요하게 되어, 이는 유지보수가 힘들어지며 또한 확장에 있어서 에러를 발생시킬 가능성이 높다.<br/>
> - 기능이 추가됨에 따라 class 크기가 커질 경우, 문제는 더욱 복잡해진다.
> 
> 피해야 할 Anti-Pattern 이지만, 이를 기반으로 코드의 리팩토링 과정과 관점을 적용 및 개선해 볼 수 있을 것이다. 