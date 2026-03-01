package org.example.app;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

/**
 * Learn how to merge flux.
 *
 * @author Sebastien Deleuze
 */
public class Part05Merge {

  public static void log(String key,int i){
    System.out.println(key +"线程:" +Thread.currentThread().getName());
  }

  public static void main(String[] args){
      Flux<User> delayFlux =Flux.just(User.builder().lastname("delay_lastname").username("delay_username").firstname("delay_firstname").build(),User.builder().lastname("delay_1lastname").username("delay_username").firstname("delay_firstname").build()).delayElements(Duration.ofMillis(100));
      Flux<User> normalFlux =Flux.just(User.builder().lastname("normal_lastname").username("normal_username").firstname("normal_firstname").build(),User.builder().lastname("normal_1lastname").username("normal_username").firstname("normal_firstname").build()).delayElements(Duration.ofMillis(51));

    StepVerifier.create(new Part05Merge().mergeFluxWithInterleave(delayFlux, normalFlux))
        .expectSubscription()
        .expectNext(
            User.builder()
                .lastname("normal_lastname")
                .username("normal_username")
                .firstname("normal_firstname")
                .build(),
                User.builder()
                        .lastname("delay_lastname")
                        .username("delay_username")
                        .firstname("delay_firstname")
                        .build(),
            User.builder()
                .lastname("normal_1lastname")
                .username("normal_username")
                .firstname("normal_firstname")
                .build(),
            User.builder()
                .lastname("delay_1lastname")
                .username("delay_username")
                .firstname("delay_firstname")
                .build()).verifyComplete();

      StepVerifier.create(new Part05Merge().mergeFluxWithNoInterleave(delayFlux, normalFlux))
              .expectSubscription()
              .expectNext(
                      User.builder()
                              .lastname("delay_lastname")
                              .username("delay_username")
                              .firstname("delay_firstname")
                              .build(),
                      User.builder()
                              .lastname("delay_1lastname")
                              .username("delay_username")
                              .firstname("delay_firstname")
                              .build(),
                      User.builder()
                              .lastname("normal_lastname")
                              .username("normal_username")
                              .firstname("normal_firstname")
                              .build(),
                      User.builder()
                              .lastname("normal_1lastname")
                              .username("normal_username")
                              .firstname("normal_firstname")
                              .build()
              ).verifyComplete();

    Mono<User> mono1 =
        Mono.just(
            User.builder()
                .lastname("mono1_lastname")
                .username("mono1_username")
                .firstname("mono1_firstname")
                .build()
        );

      Mono<User> mono2 =
              Mono.just(
                      User.builder()
                              .lastname("mono2_lastname")
                              .username("mono2_username")
                              .firstname("mono2_firstname")
                              .build());
    StepVerifier.create(new Part05Merge().createFluxFromMultipleMono(mono1, mono2))
        .expectSubscription()
        .expectNext(
            User.builder()
                .lastname("mono1_lastname")
                .username("mono1_username")
                .firstname("mono1_firstname")
                .build(),
            User.builder()
                .lastname("mono2_lastname")
                .username("mono2_username")
                .firstname("mono2_firstname")
                .build());
  }

  // ========================================================================================

  // TODO Create a Flux containing the value of mono1 then the value of mono2
  Flux<User> createFluxFromMultipleMono(Mono<User> mono1, Mono<User> mono2) {
    return Flux.concat(mono1, mono2);
  }

  // TODO Merge flux1 and flux2 values with interleave
  Flux<User> mergeFluxWithInterleave(Flux<User> flux1, Flux<User> flux2) {
    return flux1.mergeWith(flux2);
  }

  // ========================================================================================

  // TODO Merge flux1 and flux2 values with no interleave (flux1 values and then flux2 values)
  Flux<User> mergeFluxWithNoInterleave(Flux<User> flux1, Flux<User> flux2) {
    return flux1.concatWith(flux2);
  }

  // ========================================================================================

  @Getter
  @Builder
  @EqualsAndHashCode
  private static class User {
    private String username;
    private String firstname;
    private String lastname;
  }
}
