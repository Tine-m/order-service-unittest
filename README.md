# OrderService – Mockito og indirekte input

Java 21 Maven-projekt til IntelliJ med JUnit 5 og Mockito.

`customer` og `orderAmount` er direkte input til `calculateFinalPrice`.
Rabatten er indirekte input, fordi `OrderService` får den fra `DiscountPolicy`.
I testen mockes `DiscountPolicy`; den rigtige `OrderService` testes.

Kør `OrderServiceTest` i IntelliJ eller `mvn test`.
