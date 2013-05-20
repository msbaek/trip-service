Testing and Refactoring Legacy Code
===================================

원문
--

-   http://www.infoq.com/presentations/Testing-Refactoring-Legacy-Code

-   youtube: http://www.youtube.com/watch?v=_NnElPO5BU0

-   github: https://github.com/sandromancuso/trip-service-kata

내용
--

이 예제는 singleton, static method call을 가지고 있어서 testing하기 어려운 코드를 테스트를 추가하면서 리팩토링하는
과정을 보여준다.

잇점
--

날마다 누군가 작성해 놓은 코드를 수정하거나 새로운 코드를 추가해야 하는 우리에게 도움이되는 예로 보인다.

Legacy Code Rules
-----------------

-   You cannot change production code if not covered by tests

-   Just automated refactorings(via IDE) are allowed, if needed to write the
    test

Working with Legacy Code Tips
-----------------------------

-   start refactoring from deepest to shortest branch

-   start testing from shortest to deepest branch

과정
--

이 예제에서는 제일 짧은 브랜치(1st shortes branch)에서 시작해서 가장 깊은 브랜치(most deepest branch)에 대해서
로직을 커버하는 테스트를 추가하고,

가장 깊은 브랜치(most deepest branch)에서 시작해서 제일 짧은 브랜치(1st shortest branch)에 대해서 리팩토링을
수행한다.

배울만한 점
------

-   최초에 테스트할 수 없는 코드에 테스트를 추가하려할 때는 seam을 생성하는 것으로 시작

    -   extract method / subclass and override 기법 활용

    -   이후 진정한 의존성 관리를 위해 DI 형식으로 전환해야 함

-   메소드 이름을 지을 때 파라미터와 함께 연결하여 읽을 수 있도록 명명하자.

    -   ex. **addTripsTo(user)**

-   Builder를 통해 다양한 파라미터를 갖는 객체 생성을 명시적으로 표현

-   guard clause(http://c2.com/cgi/wiki?GuardClause )를 메소드 처음 부분으로 이동


