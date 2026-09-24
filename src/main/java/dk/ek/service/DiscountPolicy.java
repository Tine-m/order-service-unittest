package dk.ek.service;
import dk.ek.model.Customer;
public interface DiscountPolicy {
 double getDiscountPercentage(Customer customer);
}