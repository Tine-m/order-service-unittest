# Unit test af OrderService 

Vi vil unit teste metoden `calculateFinalPrice` i `OrderService` klassen.
Indirekte input fra `DiscountPolicy` mockes med Mockito

Metodens parametre `customer` og `orderAmount` er direkte input til `calculateFinalPrice`.

Rabatten er indirekte input, fordi `OrderService` får den fra `DiscountPolicy`.
I testen mockes `DiscountPolicy`; den rigtige `OrderService` testes.

Kør `OrderServiceTest` i IntelliJ eller `mvn test`.
