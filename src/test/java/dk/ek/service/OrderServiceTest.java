package dk.ek.service;

import dk.ek.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {
    @Mock
    private DiscountPolicy discountPolicy;
    private OrderService subject;

    @BeforeEach
    void setUp() {
        subject = new OrderService(discountPolicy);
    }

    @Test
    void shouldApplyCustomerDiscount() {
        Customer customer = new Customer("Peter");
        // Indirekte input: rabatten kommer fra den mockede dependency.
        given(discountPolicy.getDiscountPercentage(customer)).willReturn(0.20);
        // Direkte input: customer og 1000 gives direkte til metoden.
        double finalPrice = subject.calculateFinalPrice(customer, 1000);
        assertEquals(800.0, finalPrice, 0.001);
    }

    @Test
    void shouldKeepFullPriceWhenCustomerHasNoDiscount() {
        Customer customer = new Customer("Wendy");
        given(discountPolicy.getDiscountPercentage(customer)).willReturn(0.0);
        double finalPrice = subject.calculateFinalPrice(customer, 1000);
        assertEquals(1000.0, finalPrice, 0.001);
    }
}