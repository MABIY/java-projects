package org.example.app;

import java.time.Duration;
import java.util.function.Supplier;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/**
 * Learn how to transform values.
 *
 * @author Sebastien Deleuze
 */
public class Part04Transform {

  public static void main(String[] args) {
    Flux<User> flux =
        Flux.just(
            User.builder()
                .username("username")
                .firstname("firstname")
                .lastname("lastname")
                .build());
    Supplier<Flux<User>> supplier = () -> new Part04Transform().asyncCapitalizeMany(flux);
    StepVerifier.withVirtualTime(supplier)
        .expectSubscription()
        .expectNoEvent(Duration.ofMinutes(2))
        .expectNext(
            User.builder().username("USERNAME").firstname("FIRSTNAME").lastname("LASTNAME").build())
        .verifyComplete();
  }

  Flux<User> asyncCapitalizeMany(Flux<User> flux) {
    return flux.flatMap(this::asyncCapitalizeUser);
  }

  Flux<User> capitalizeMany(Flux<User> flux) {
    return flux.map(
        t ->
            User.builder()
                .username(t.getUsername().toUpperCase())
                .firstname(t.getFirstname().toUpperCase())
                .lastname(t.getLastname().toUpperCase())
                .build());
  }

  Mono<User> capitalizeOne(Mono<User> mono) {
    return mono.map(
        t ->
            User.builder()
                .username(t.getUsername().toUpperCase())
                .firstname(t.getFirstname().toUpperCase())
                .lastname(t.getLastname().toUpperCase())
                .build());
  }

  private Mono<User> asyncCapitalizeUser(User user) {
    // 模拟异步情况
    return Mono.delay(Duration.ofMinutes(2))
        .then(
            Mono.just(
                User.builder()
                    .firstname(user.getFirstname().toUpperCase())
                    .username(user.getUsername().toUpperCase())
                    .lastname(user.getLastname().toUpperCase())
                    .build()));
  }

  @Getter
  @Builder
  @EqualsAndHashCode
  private static class User {
    private String username;
    private String firstname;
    private String lastname;
  }
}
