package com.example.app;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import lombok.SneakyThrows;

public class HelloWorld {
  private static final int PREPARE_COUNT = 100;
  private static final int WORKER_COUNT = PREPARE_COUNT - 1;
  private final ReentrantLock reentrantLock = new ReentrantLock(true);
  private final CountDownLatch START_SIGNAL = new CountDownLatch(PREPARE_COUNT);
  private int testMultipleTreadValue = 1;

  @SneakyThrows // todo_lh know annotation
  public static void main(String[] args) {
    //重入锁数量限制校验
      HelloWorld helloWorld = new HelloWorld();
      for(;;){
          helloWorld.reentrantLock.lock();
      }

  }
}
