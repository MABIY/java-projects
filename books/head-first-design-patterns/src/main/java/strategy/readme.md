# thingking-策略模式
## [chatgpt](https://chatgpt.com/share/68e2803d-8440-8006-9682-5902a0b97f65) 
---
```code
策略模式
public interface FlyBehavior {
    void fly();
}
public interface QuackBehavior {
    void quack();
}
public abstract class Duck {
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    public abstract void display();

    public void performFly(){
        flyBehavior.fly();
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void performQuack(){
        quackBehavior.quack();
    }
    public void swim(){
        System.out.println("All duck float, even decoys!");
    }

}
这个一个版本，通过把flyBehavior 和quackBehavior 行为封装成算法族，在 duck中通过组合属性，通过performFly() 和performQuack()来出发。

下面是第一种方式:
public interface FlyBehavior {
    void fly();
}
public interface QuackBehavior {
    void quack();
}
public interface ProxyFlyBehavior extends FlyBehavior {}
public interface ProxyQuackBehavior extends QuackBehavior {}
public abstract class Duck implements ProxyFlyBehavior, ProxyQuackBehavior {
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    //todo_lh 如果很多参数，需要在创建对象的时候初始化，该如何结果
    public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    public abstract void display();


    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    @Override
    public void fly() {
        flyBehavior.fly();
    }

    @Override
    public void quack() {
        quackBehavior.quack();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void swim(){
        System.out.println("All duck float, even decoys!");
    }
}
通过让鸭子实现ProxyFlybehavior 和ProxyQuackBehavior这个两个接口继承FlyBehavior和QuackBehavior，这样就可以判断某个类是否实现FlyBehavior。不过head first 里用的是版本1
```
非常好 👍，你抓到了**策略模式（Strategy Pattern）**的精髓——
**通过组合行为对象而非继承，让行为在运行时可变。**
你现在对比的是两种实现方式：

---

## 🦆 一、Head First 版本（组合 + 委托调用）

```java
public abstract class Duck {
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }
}
```

### ✅ 特点

* **Duck不实现FlyBehavior接口**，而是**委托**（delegate）给flyBehavior对象执行；
* **解耦彻底**：Duck不关心flyBehavior的实现，只知道它能fly()；
* **行为可以在运行时动态切换**；
* **Duck类层次结构清晰**（行为变化与Duck类型变化分离）；
* **完全遵守“面向接口编程，而非实现编程”**。

---

## 🧩 二、你的 Proxy 接口版本（Duck 实现行为接口）

```java
public abstract class Duck implements ProxyFlyBehavior, ProxyQuackBehavior {
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    @Override
    public void fly() {
        flyBehavior.fly();
    }

    @Override
    public void quack() {
        quackBehavior.quack();
    }
}
```

### ✅ 优点

1. **Duck对象本身就是FlyBehavior、QuackBehavior的实例**：
   外部代码可以直接调用 `duck.fly()` 而不需要 `duck.performFly()`；
2. **可用于类型判断**：
   例如 `if (duck instanceof FlyBehavior)`；
3. **语义上更直接**：鸭子确实“能飞”、“能叫”。

---

### ⚠️ 缺点

1. **混淆“行为的持有者”和“行为的提供者”**

    * Duck 本身不是行为的实现者，而是行为的“使用者”；
    * 它实现了行为接口，但实际工作仍由内部委托完成。
      这在大型系统中容易误导别人，以为 Duck 自身实现了 fly() 的逻辑。

2. **违背单一职责原则（SRP）**
   Duck 既是领域对象，又是行为接口的实现者，职责边界模糊。

3. **可维护性下降**
   若未来需要对行为接口扩展（例如FlyBehavior新增 `stopFly()`），
   所有Duck子类都必须重新实现（或继承）该接口的方法签名。

---

## 🧠 结论：为什么《Head First》选择版本 1

因为策略模式的设计意图是：

> “将算法的实现与使用算法的对象分离，使算法可独立于使用它的对象而变化。”

版本 1 完全符合：

* “行为”在Duck之外独立变化；
* Duck只负责组合和委托；
* 行为接口是纯粹的策略接口。

版本 2 虽然可用（特别在某些接口判断场景下），
但**让Duck实现FlyBehavior/QuackBehavior会让行为和策略耦合**，
失去了“独立变化”的初衷。

---

## 💡如果你想兼顾“类型判断”与“低耦合”

可以采用第三种折中写法 👇：

```java
public interface CanFly {}
public interface CanQuack {}

public abstract class Duck implements CanFly, CanQuack {
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    public void performFly() { flyBehavior.fly(); }
    public void performQuack() { quackBehavior.quack(); }
}
```

这样：

* Duck 不直接耦合行为逻辑；
* 又能通过 `instanceof CanFly` 判断是否具备飞行能力；
* 行为仍可自由切换。

---

是否希望我画一张 UML 图，直观展示这三种设计的类关系和依赖方向？

但**让Duck实现FlyBehavior/QuackBehavior会让行为和策略耦合**
这里应该不是行为和策略的耦合，应该是行为和duck的耦合吧


你说得对，表述上更准确的应该是：

> “让 Duck 实现 FlyBehavior/QuackBehavior，会让**行为和 Duck 对象耦合**”，而不是行为和策略耦合。

原因如下：

---

### 1️⃣ 策略和行为的关系

* **策略（Strategy）**就是 `FlyBehavior`/`QuackBehavior` 接口及其具体实现（如 `FlyWithWings`、`Quack`）。
* **行为（Behavior）**本质上就是策略提供的能力。
* 策略模式的核心就是**将行为和使用行为的对象（Duck）分离**，通过组合和委托调用来实现。

---

### 2️⃣ 版本2的问题

* Duck 实现了 FlyBehavior/QuackBehavior：

```java
public abstract class Duck implements FlyBehavior, QuackBehavior
```

* 虽然内部仍然委托给 `flyBehavior` / `quackBehavior` 执行实际逻辑
* 但是**类型上 Duck 直接与行为接口绑定**：

    * 外部看到 Duck 就能被当作 FlyBehavior 或 QuackBehavior 使用
    * 这实际上把**Duck 对象与行为接口耦合**了
* 行为接口增加方法 → Duck 类必须修改代理方法 → Duck 与行为接口耦合度增加

---

### 3️⃣ 为什么不是“行为和策略耦合”

* 策略模式本意就是：

    * **策略独立** → FlyBehavior 与 QuackBehavior 本身是独立接口
    * Duck 仅通过组合使用策略
* 版本2的问题不是策略本身和行为耦合，而是 **行为接口的实现被 Duck 绑定了**
* 换句话说，是 Duck 对象与行为接口耦合，而不是策略与行为耦合

---

💡 **总结一句话**：

> 版本2的维护复杂度增加，是因为 Duck 类型和行为接口耦合了，而策略依然独立。

---

如果你愿意，我可以画一张**版本1 vs 版本2的依赖图**，直观展示 Duck、行为接口、策略实现之间的耦合关系，让这个区别一目了然。

你希望我画吗？


FlyBehavior 实现CanFly吗

严格来说，在你提到的“折中写法”里，**`FlyBehavior` 不需要实现 `CanFly`**。

原因如下：

---

### 1️⃣ `CanFly` 的作用

* 它只是一个**标记接口（Marker Interface）**，用于类型判断，比如：

```java
if (duck instanceof CanFly) {
    duck.performFly();
}
```

* 它并不提供方法实现，也不依赖具体的行为逻辑。

---

### 2️⃣ FlyBehavior 是策略接口

```java
public interface FlyBehavior {
    void fly();
}
```

* 它定义的是**行为算法族**；
* 每个具体的飞行方式（比如 `FlyWithWings`、`FlyNoWay`）实现 `FlyBehavior`；
* **Duck 内部持有 FlyBehavior 的引用并委托调用**。

---

### 3️⃣ 为什么不需要 FlyBehavior 实现 CanFly

* `CanFly` 是给 **Duck** 判断能力的，而不是行为策略判断的；
* Duck 内部组合了 FlyBehavior，因此：

```java
public class MallardDuck extends Duck implements CanFly, CanQuack {
    public MallardDuck() {
        super(new FlyWithWings(), new Quack());
    }
}
```

* 这样，MallardDuck 被认为“能飞”，外部可以类型检查；
* 内部实际飞行由 `FlyWithWings` 完成。

---

💡 **总结**：

* `FlyBehavior` 是“策略接口”，不负责标记能力；
* `CanFly` 是“能力标记接口”，只给 Duck 做类型判断；
* **Duck 实现 CanFly，而 FlyBehavior 不必实现 CanFly**。

---

如果你愿意，我可以画一张图，把 **Duck、FlyBehavior、CanFly** 的关系直观展示出来，让这个折中方案更容易理解。

你希望我画吗？


版本2里即用类的实现也用了组合，有什么好和不好的吗

完全可以，我们来仔细分析一下你说的版本2：**Duck 类实现了 `ProxyFlyBehavior`/`ProxyQuackBehavior` 接口，同时内部仍通过组合持有 `FlyBehavior`/`QuackBehavior` 并委托调用**。

---

## 1️⃣ 优点

### ✅ 1. 可以直接当行为对象使用

```java
Duck duck = new MallardDuck();
duck.fly();    // 直接调用 Duck.fly() 而不是 performFly()
duck.quack();
```

* 外部代码不需要知道 `performFly()` 这一层委托；
* 在类型判断时可以写：

```java
if (duck instanceof FlyBehavior) {
    duck.fly();
}
```

* 对一些框架或泛型编程场景更友好（要求对象实现接口）。

---

### ✅ 2. 兼容现有接口

* 如果系统中有其他依赖 `FlyBehavior` 或 `QuackBehavior` 的 API，Duck 可以直接作为行为接口的实现传入，而不需要额外包装。

---

### ✅ 3. 保留了行为组合的灵活性

* 内部依然使用组合：

```java
flyBehavior.fly();
```

* 行为依然可以运行时动态切换：

```java
duck.setFlyBehavior(new FlyRocketPowered());
```

* 仍然可以做到策略模式的“行为可独立变化”。

---

## 2️⃣ 缺点

### ❌ 1. 语义上混淆

* Duck 并没有真正实现行为逻辑，而是**委托**给内部对象；
* 但类型上却实现了 `FlyBehavior`，容易让人误以为 Duck 自己会飞、自己会叫。

### ❌ 2. 单一职责被削弱

* Duck 既是“领域对象”（鸭子），又是“行为接口实现者”，职责边界模糊；
* 维护成本增加：如果 FlyBehavior/QuackBehavior 增加方法，Duck 也必须同步修改接口方法（哪怕只是委托）。

### ❌ 3. 类型判断的耦合

* 你必须通过 `instanceof FlyBehavior` 判断能力，而行为可以随时变化；
* 可能出现类型说“能飞”，但内部 `flyBehavior` 实际是 `FlyNoWay`，语义不一致。

---

## 3️⃣ 总结

| 方面         | 优点                                   | 缺点                          |
| ---------- | ------------------------------------ | --------------------------- |
| **外部调用**   | 可以直接调用 `duck.fly()` / `duck.quack()` | 语义混淆，容易误以为 Duck 自己实现了行为     |
| **行为动态变化** | 内部仍通过组合，可动态切换                        | 无明显缺点，组合仍然保留                |
| **类型判断**   | 可以用 `instanceof` 判断                  | 类型和实际行为可能不一致                |
| **职责划分**   | 兼容接口                                 | 违背单一职责，Duck同时扮演“鸭子”和“行为实现者” |

---

💡 **核心理解**：

* 版本2本质还是策略模式（组合 + 委托），只是**加了接口实现的外壳**；
* 好处是方便类型判断和调用接口方法；
* 坏处是 **职责模糊 + 语义可能误导**，如果团队较大或代码复杂，容易造成维护问题。

---

如果你愿意，我可以画一张**版本1 vs 版本2 的类图对比**，直观看出组合、接口实现、委托的关系和区别。

你希望我画吗？

为什么说 **Duck类层次结构清晰**（行为变化与Duck类型变化分离）?


明白，我来详细解释这个“行为变化和 Duck 类型变化分离”的含义。

---

## 1️⃣ Duck 类型 vs Duck 行为

在面向对象设计中，通常会区分两类变化：

1. **Duck 类型的变化**

    * 指的是鸭子本身的种类不同，例如：`MallardDuck`、`RedHeadDuck`、`RubberDuck`。
    * 这些类型的区别通常体现在外观 (`display()`) 或特定领域逻辑上。

2. **Duck 行为的变化**

    * 指的是鸭子的飞行和叫声方式不同，例如：能飞、不能飞、会叫、不会叫。
    * 行为可能随时需要改变：比如橡皮鸭（RubberDuck）不会飞，但突然给它装上喷气背包，它就能飞了。

---

## 2️⃣ 传统继承的局限

如果用继承来实现行为：

```java
class MallardDuck extends Duck {
    void fly() { ... }    // 特定飞行实现
    void quack() { ... }  // 特定叫声
}
class RubberDuck extends Duck {
    void fly() { ... }    // 不会飞
    void quack() { ... }  // 不会叫
}
```

问题：

* 行为固定在类型里，如果要改变行为：

    * 要修改父类方法，或者
    * 再创建子类组合，例如 `MallardDuckWithRocket`、`RubberDuckSilent`。
* **类爆炸（class explosion）**：行为变化和类型变化绑在一起，维护成本高。

---

## 3️⃣ 策略模式的解耦（组合 + 委托）

通过组合行为接口：

```java
public abstract class Duck {
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public void performFly() { flyBehavior.fly(); }
    public void performQuack() { quackBehavior.quack(); }
}
```

* **Duck 类型变化**：由子类 `MallardDuck`、`RubberDuck` 决定。
* **行为变化**：由组合的 `FlyBehavior`、`QuackBehavior` 决定。
* **关键**：类型和行为是完全独立的两个维度：

    * 创建一个鸭子对象时，可以自由选择不同的行为组合；
    * 运行时还可以通过 `setFlyBehavior()`、`setQuackBehavior()` 动态改变行为。

---

### 🔹 举例说明

```java
Duck mallard = new MallardDuck();        // Mallard 类型
mallard.performFly();                     // 使用 FlyWithWings
mallard.setFlyBehavior(new FlyRocketPowered()); // 行为变化，不影响类型
mallard.performFly();                     // 现在飞行方式变了
```

* **类型（MallardDuck）没变**
* **行为（飞行方式）改变了**
* **两者解耦** ✅

---

💡 **总结一句话**：

> 策略模式把“Duck 的种类”与“Duck 的行为”拆开：类型变化决定“是什么鸭子”，行为变化决定“它怎么飞、怎么叫”，两者互不干扰。

---

如果你需要，我可以画一张**二维坐标图**，横轴是 Duck 类型，纵轴是行为组合，这样一眼就能看出“解耦”的效果。

你希望我画吗？


版本2里即用类的实现也用了组合，有什么好和不好的吗


完全可以，我们来仔细分析一下你说的版本2：**Duck 类实现了 `ProxyFlyBehavior`/`ProxyQuackBehavior` 接口，同时内部仍通过组合持有 `FlyBehavior`/`QuackBehavior` 并委托调用**。

---

## 1️⃣ 优点

### ✅ 1. 可以直接当行为对象使用

```java
Duck duck = new MallardDuck();
duck.fly();    // 直接调用 Duck.fly() 而不是 performFly()
duck.quack();
```

* 外部代码不需要知道 `performFly()` 这一层委托；
* 在类型判断时可以写：

```java
if (duck instanceof FlyBehavior) {
    duck.fly();
}
```

* 对一些框架或泛型编程场景更友好（要求对象实现接口）。

---

### ✅ 2. 兼容现有接口

* 如果系统中有其他依赖 `FlyBehavior` 或 `QuackBehavior` 的 API，Duck 可以直接作为行为接口的实现传入，而不需要额外包装。

---

### ✅ 3. 保留了行为组合的灵活性

* 内部依然使用组合：

```java
flyBehavior.fly();
```

* 行为依然可以运行时动态切换：

```java
duck.setFlyBehavior(new FlyRocketPowered());
```

* 仍然可以做到策略模式的“行为可独立变化”。

---

## 2️⃣ 缺点

### ❌ 1. 语义上混淆

* Duck 并没有真正实现行为逻辑，而是**委托**给内部对象；
* 但类型上却实现了 `FlyBehavior`，容易让人误以为 Duck 自己会飞、自己会叫。

### ❌ 2. 单一职责被削弱

* Duck 既是“领域对象”（鸭子），又是“行为接口实现者”，职责边界模糊；
* 维护成本增加：如果 FlyBehavior/QuackBehavior 增加方法，Duck 也必须同步修改接口方法（哪怕只是委托）。

### ❌ 3. 类型判断的耦合

* 你必须通过 `instanceof FlyBehavior` 判断能力，而行为可以随时变化；
* 可能出现类型说“能飞”，但内部 `flyBehavior` 实际是 `FlyNoWay`，语义不一致。

---

## 3️⃣ 总结

| 方面         | 优点                                   | 缺点                          |
| ---------- | ------------------------------------ | --------------------------- |
| **外部调用**   | 可以直接调用 `duck.fly()` / `duck.quack()` | 语义混淆，容易误以为 Duck 自己实现了行为     |
| **行为动态变化** | 内部仍通过组合，可动态切换                        | 无明显缺点，组合仍然保留                |
| **类型判断**   | 可以用 `instanceof` 判断                  | 类型和实际行为可能不一致                |
| **职责划分**   | 兼容接口                                 | 违背单一职责，Duck同时扮演“鸭子”和“行为实现者” |

---

💡 **核心理解**：

* 版本2本质还是策略模式（组合 + 委托），只是**加了接口实现的外壳**；
* 好处是方便类型判断和调用接口方法；
* 坏处是 **职责模糊 + 语义可能误导**，如果团队较大或代码复杂，容易造成维护问题。

---

如果你愿意，我可以画一张**版本1 vs 版本2 的类图对比**，直观看出组合、接口实现、委托的关系和区别。

你希望我画吗？


代码复杂，容易造成维护问题
麻烦说下，这个代码复杂情况下维护的问题

明白，你问的是在**版本2**（Duck 实现行为接口 + 内部组合委托）的情况下，为什么会增加**维护复杂度**，具体问题如下：

---

## 1️⃣ 语义混淆导致理解成本高

* Duck 类 **既是领域对象，又是行为接口的实现者**
* 外部看到：

```java
Duck duck = new MallardDuck();
duck.fly();
```

可能会以为 **Duck 自己实现了飞行逻辑**，其实是委托给内部 `flyBehavior`。

* 对新人或维护者来说，阅读代码时需要额外理解“接口实现只是代理，实际行为由内部对象完成”。
* 当行为接口增加新方法时，需要 Duck 也去实现代理逻辑，增加认知负担。

---

## 2️⃣ 单一职责被削弱

* Duck 类同时承担两个职责：

    1. 表示鸭子类型（MallardDuck、RubberDuck…）
    2. 实现 FlyBehavior / QuackBehavior 接口
* 单一职责原则（SRP）被破坏：

    * 任何行为接口的变更都可能影响 Duck 类；
    * 任何 Duck 类型的变更都可能涉及行为接口的实现。

---

## 3️⃣ 行为变化和类型可能不一致

* 版本2允许运行时切换行为：

```java
duck.setFlyBehavior(new FlyNoWay());
```

* 但是 `duck instanceof FlyBehavior` 仍然为 true
* 语义上不一致：类型表示“能飞”，实际行为可能不会飞
* 这种不一致增加了维护成本，需要额外注意状态和行为的同步。

---

## 4️⃣ 继承和接口耦合

* Duck 必须实现接口的方法（即便只是委托），如果行为接口改动：

    * 比如 FlyBehavior 新增 `land()` 方法
    * 所有 Duck 子类必须同步增加代理实现
* 增加修改成本，尤其是团队协作或大系统中，容易引入遗漏和 bug。

---

## 5️⃣ 类膨胀和复杂度提升

* 当行为接口数量增加或行为复杂化时：

    * Duck 类可能需要实现多个行为接口
    * 并为每个接口方法写代理代码
* Duck 类变得越来越大，阅读和维护成本上升。

---

### ✅ 总结

版本2的维护问题主要来自三点：

1. **职责模糊**：Duck既是对象，又是行为接口实现者。
2. **语义不一致**：类型标识与实际行为可能不匹配。
3. **接口耦合**：行为接口改动需要修改所有Duck子类代理方法。

---

💡 **经验教训**：

* **策略模式本质**是把“行为”和“使用者对象”分离
* 版本2虽然方便接口调用，但牺牲了清晰的职责边界
* 在大型系统中，更容易造成维护负担

---

如果你愿意，我可以给出一个**具体维护场景示例**，展示版本2在团队修改行为接口时可能出错的情况，让你直观理解风险。

你希望我画这个示例吗？

好的麻烦给出来

好的，我来举一个**版本2在实际维护中可能出错的示例**，用一个团队协作修改行为接口的场景直观说明维护风险。

---

## 1️⃣ 初始代码（版本2）

```java
// 行为接口
public interface FlyBehavior {
    void fly();
}

// Duck 类实现接口，同时组合委托
public abstract class Duck implements FlyBehavior {
    protected FlyBehavior flyBehavior;

    public Duck(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    @Override
    public void fly() {
        flyBehavior.fly(); // 委托
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
}

// 具体鸭子
public class MallardDuck extends Duck {
    public MallardDuck(FlyBehavior flyBehavior) {
        super(flyBehavior);
    }
}
```

假设初始 `FlyBehavior` 只有一个方法 `fly()`，一切正常。

---

## 2️⃣ 团队需求变更

团队决定**增加降落行为**，让飞行不仅能飞，还能着陆：

```java
public interface FlyBehavior {
    void fly();
    void land(); // 新增方法
}
```

---

## 3️⃣ 维护问题

### a. Duck 类必须同步修改

* 版本2中 Duck 实现了 `FlyBehavior`：

```java
@Override
public void land() {
    flyBehavior.land(); // 必须委托
}
```

* 如果漏掉了 `land()` 方法，代码就**无法编译**。
* 所有 Duck 子类（MallardDuck、RubberDuck…）也必须检查是否继承正确，否则编译报错或行为异常。

### b. 行为和类型语义可能不一致

* 假设某个鸭子本来是 `FlyNoWay`：

```java
duck.setFlyBehavior(new FlyNoWay());
```

* `FlyNoWay` 没有实现 `land()` 或只是空实现
* 虽然 `duck instanceof FlyBehavior` 为 true，但 `duck.land()` 不会产生任何效果
* 外部调用者可能以为这个鸭子能飞、能降落，但实际上不能 → **语义不一致**

### c. 代理代码膨胀

* 如果行为接口继续增加方法，比如 `takeOff()`、`hover()`
* Duck 类必须为每个方法写一遍代理：

```java
@Override
public void takeOff() { flyBehavior.takeOff(); }
@Override
public void hover() { flyBehavior.hover(); }
```

* Duck 类越来越臃肿 → 阅读和维护成本上升

---

## 4️⃣ 总结风险点

| 风险类别         | 具体表现                                                   |
| ------------ | ------------------------------------------------------ |
| **职责模糊**     | Duck 同时是对象，又是行为接口实现者                                   |
| **类型与行为不一致** | `instanceof FlyBehavior` 为 true，但内部 flyBehavior 实际行为不同 |
| **接口改动成本高**  | 行为接口新增方法 → Duck 类和子类必须同步修改代理方法                         |
| **代码膨胀**     | 每新增一个行为方法，Duck 类增加一行代理代码 → 难维护                         |

---

💡 **对比版本1（Head First）**：

* Duck **不实现 FlyBehavior**
* 仅内部组合委托：

```java
public void performFly() { flyBehavior.fly(); }
```

* 行为接口增加方法时，只需要修改行为实现类
* Duck 类不受影响 → **更符合单一职责原则**

---

如果你需要，我可以画一张**版本1 vs 版本2维护成本对比图**，用箭头表示依赖关系，让你一眼看到为什么版本2维护复杂度更高。

你希望我画吗？
