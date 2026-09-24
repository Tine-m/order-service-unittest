package dk.ek.service;
import dk.ek.model.Customer;
public class OrderService {
 private final DiscountPolicy discountPolicy;
 public OrderService(DiscountPolicy discountPolicy) { this.discountPolicy = discountPolicy; }
 public double calculateFinalPrice(Customer customer, double orderAmount) {
  double discount = discountPolicy.getDiscountPercentage(customer);
  return orderAmount * (1 - discount);
 }
}