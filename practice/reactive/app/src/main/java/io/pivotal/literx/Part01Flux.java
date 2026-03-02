package io.pivotal.literx;

import java.time.Duration;
import java.util.List;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

/**
 * Learn how to create Flux instances.
 *
 * @author Sebastien Deleuze
 * @see <a
 *     href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html">Flux
 *     Javadoc</a>
 */
public class Part01Flux {

  // ========================================================================================

  public static void main(String[] args) {
    Flux<String> stringFlux = new Part01Flux().errorFlux();
    StepVerifier.create(stringFlux).expectSubscription().expectError(IllegalStateException.class);
  }

  // ========================================================================================

  // TODO Create a Flux that emits increasing values from 0 to 9 each 100ms
  Flux<Long> counter() {
    return Flux.interval(Duration.ofMillis(100)).take(10);
  }

  // ========================================================================================

  // TODO Return an empty Flux
  Flux<String> emptyFlux() {
    return Flux.empty();
  }

  // ========================================================================================

  // TODO Create a Flux that emits an IllegalStateException
  Flux<String> errorFlux() {
    return Flux.error(new IllegalStateException());
  }

  // TODO Create a Flux from a List that contains 2 values "foo" and "bar"
  Flux<String> fooBarFluxFromList() {
    List<String> values = List.of("foo", "bar");
    return Flux.fromIterable(values);
  }

  // ========================================================================================

  // TODO Return a Flux that contains 2 values "foo" and "bar" without using an array or a
  // collection
  Flux<String> fooBarFluxFromValues() {
    return Flux.just("foo", "bar");
  }
}
