package io.pivotal.literx;

import java.time.Duration;
import reactor.core.publisher.Mono;

/**
 * Learn how to create Mono instances.
 *
 * @author Sebastien Deleuze
 * @see <a
 *     href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html">Mono
 *     Javadoc</a>
 */
public class Part02Mono {

  // ========================================================================================

      public static void main(String[] args) {
          Mono.firstWithValue(
                          Mono.just(1).map(integer -> "foo" + integer),
                          Mono.delay(Duration.ofMillis(100)).thenReturn("bar")
                  )
                  .subscribe(System.out::println);
      }

  // ========================================================================================

  // TODO Return an empty Mono
  Mono<String> emptyMono() {
    return Mono.empty();
  }

  // ========================================================================================

  // TODO Create a Mono that emits an IllegalStateException
  Mono<String> errorMono() {
    return Mono.error(new IllegalStateException());
  }

  // ========================================================================================

  // TODO Return a Mono that contains a "foo" value
  Mono<String> fooMono() {
    return Mono.just("foo");
  }

  // TODO Return a Mono that never emits any signal
  Mono<String> monoWithNoSignal() {
    return Mono.never();
  }

}
