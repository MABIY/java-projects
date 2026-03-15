package io.pivotal.literx;

import io.pivotal.literx.domain.User;
import io.pivotal.literx.repository.ReactiveRepository;
import io.pivotal.literx.repository.ReactiveUserRepository;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

/**
 * Learn how to control the demand.
 *
 * @author lh
 */
public class Part06Request {
  ReactiveRepository<User> repository = new ReactiveUserRepository();

  public static void main(String[] args) {
    Part06Request part06Request = new Part06Request();

    Flux<User> fourUserWithDelay = part06Request.repository.findAll();
    part06Request.requestAllExpectFour(fourUserWithDelay).verify();

    part06Request.requestOneExpectSkylerThenRequestOneExpectJesse(fourUserWithDelay).verify();

    part06Request.requestOneExpectSkylerThenRequestOneExpectJesse(fourUserWithDelay).verify();

    part06Request.fluxWithLog().subscribe(System.out::println);
  }

  // TODO Return a Flux with all users stored in the repository that prints automatically logs for
  // all reactive Streams signals
  Flux<User> fluxWithDoOnPrintln() {
    return repository
        .findAll()
        .doOnSubscribe(s -> System.out.println("Starring"))
        .doOnNext(u -> System.out.println(u.getFirstname() + " " + u.getLastname()))
        .doOnComplete(() -> System.out.println("The end!"));
  }

  // TODO Return a Flux with all users stored in the repository that prints automatically logs for
  // all Reactive Streams signals
  Flux<User> fluxWithLog() {
    return repository.findAll().log();
  }

  // TODO Create a StepVerifier that initially requests all values and expect 4 values to be
  // received
  StepVerifier requestAllExpectFour(Flux<User> flux) {
    return StepVerifier.create(flux)
        .expectSubscription()
        .thenRequest(Long.MAX_VALUE)
        .expectNextCount(4)
        .expectComplete();
  }

  // TODO Create a StepVerifier that initially request 1 value and expects User.SKYLER
  //    the requests another value and expects User.JESSE then stops verifying by cancelling the
  // source
  StepVerifier requestOneExpectSkylerThenRequestOneExpectJesse(Flux<User> flux) {
    return StepVerifier.create(flux)
        .thenRequest(1)
        .expectNext(User.SKYLER)
        .thenRequest(1)
        .expectNext(User.JESSE)
        .thenCancel();
  }
}
