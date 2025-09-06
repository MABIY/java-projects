package com.lh.javabase.function;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;
import java.util.function.Function;

/**
 * @author liu.hua
 */
@Setter
@Getter
@AllArgsConstructor
class User{
    private String name;
    private Address address;
}

@AllArgsConstructor
@Getter
class Address{
    private String city;

}
/**
 * @author liu.hua
 */
public class OptinalWithFunction {
    public static void main(String[] args) {
        User user = new User("Alice", new Address("Beijing"));

        Function<User, Address> getUserAddress = User::getAddress;
        Function<Address, String> getCity = Address::getCity;

        String city = Optional.of(user)
                .map(getUserAddress)
                .map(getCity)
                .orElse("Unknown");
        System.out.println(city);
    }
}
