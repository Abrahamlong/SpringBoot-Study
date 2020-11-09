# Spring Boot

官方参考文档：https://docs.spring.io/spring-boot/docs/2.1.6.RELEASE/reference/htmlsingle/

官网查看自动装配的配置属性：https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html#core-properties



## 1. SpringBoot：初识

### 1.1  Spring是如何简化Java开发的

**为了降低Java开发的复杂性，Spring采用了以下4种关键策略：**

- 基于POJO的轻量级和最小侵入性编程，所有东西都是bean；
- 通过IOC，依赖注入（DI）和面向接口实现松耦合；
- 基于切面（AOP）和惯例进行声明式编程；
- 通过切面和模版减少样式代码，RedisTemplate，xxxTemplate；



### 1.2 什么是SpringBoot

学过javaweb的同学就知道，开发一个web应用，从最初开始接触Servlet结合Tomcat, 跑出一个Hello Wolrld程序，是要经历特别多的步骤；后来就用了框架Struts，再后来是SpringMVC，到了现在的SpringBoot，过一两年又会有其他web框架出现；你们有经历过框架不断的演进，然后自己开发项目所有的技术也在不断的变化、改造吗？建议都可以去经历一遍；

言归正传，什么是SpringBoot呢，就是一个javaweb的开发框架，和SpringMVC类似，对比其他javaweb框架的好处，官方说是简化开发，**约定大于配置**，  you can "just run"，能迅速的开发web应用，几行代码开发一个http接口。

所有的技术框架的发展似乎都遵循了一条主线规律：从一个复杂应用场景 衍生 一种规范框架，人们只需要进行各种配置而不需要自己去实现它，这时候强大的配置功能成了优点；发展到一定程度之后，人们根据实际生产应用情况，选取其中实用功能和设计精华，重构出一些轻量级的框架；之后为了提高开发效率，嫌弃原先的各类配置过于麻烦，于是开始提倡“约定大于配置”，进而衍生出一些一站式的解决方案。

是的这就是Java企业级应用->J2EE->spring->springboot的过程。

随着 Spring 不断的发展，涉及的领域越来越多，项目整合开发需要配合各种各样的文件，慢慢变得不那么易用简单，违背了最初的理念，甚至人称配置地狱。Spring Boot 正是在这样的一个背景下被抽象出来的开发框架，目的为了让大家更容易的使用 Spring 、更容易的集成各种常用的中间件、开源软件；

Spring Boot 基于 Spring 开发，Spirng Boot 本身并不提供 Spring 框架的核心特性以及扩展功能，只是用于快速、敏捷地开发新一代基于 Spring 框架的应用程序。也就是说，它并不是用来替代 Spring 的解决方案，而是和 Spring 框架紧密结合用于提升 Spring 开发者体验的工具。Spring Boot 以**约定大于配置的核心思想**，默认帮我们进行了很多设置，多数 Spring Boot 应用只需要很少的 Spring 配置。同时它集成了大量常用的第三方库配置（例如 Redis、MongoDB、Jpa、RabbitMQ、Quartz 等等），Spring Boot 应用中这些第三方库几乎可以零配置的开箱即用。

简单来说就是SpringBoot其实不是什么新的框架，它默认配置了很多框架的使用方式，就像maven整合了所有的jar包，spring boot整合了所有的框架 。

Spring Boot 出生名门，从一开始就站在一个比较高的起点，又经过这几年的发展，生态足够完善，Spring Boot 已经当之无愧成为 Java 领域最热门的技术。

**Spring Boot的主要优点：**

- 为所有Spring开发者更快的入门
- **开箱即用**，提供各种默认配置来简化项目配置
- 内嵌式容器简化Web项目
- 没有冗余代码生成和XML配置的要求



### 1.3 第一个SpringBoot程序

- #### pom.xml文件夹

```xml
<!-- 父依赖 -->
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.3.3.RELEASE</version>
    <relativePath/>
</parent>

<dependencies>
    <!-- web场景启动器 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <!-- springboot单元测试 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
        <!-- 剔除依赖 -->
        <exclusions>
            <exclusion>
                <groupId>org.junit.vintage</groupId>
                <artifactId>junit-vintage-engine</artifactId>
            </exclusion>
        </exclusions>
    </dependency>
</dependencies>

<build>
    <plugins>
        <!-- 打包插件 -->
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```

- #### 第一个http接口

```java
@RestController
//@RequestMapping("/hello")
public class HelloController {

    //接口；http://localhost:8080/hello
    @RequestMapping("/hello")
    public String hello(){

        // 调用业务，接收前端参数
        return "hello world";
    }
}
```

- #### 父依赖

其中它主要是依赖一个父项目，主要是管理项目的资源过滤及插件！

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.2.5.RELEASE</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
```

点进去，发现还有一个父依赖

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-dependencies</artifactId>
    <version>2.2.5.RELEASE</version>
    <relativePath>../../spring-boot-dependencies</relativePath>
</parent>
```

`spring-boot-dependencies`  才是真正管理SpringBoot应用里面所有依赖版本的地方，SpringBoot的版本控制中心；

**以后我们导入依赖默认是不需要写版本；但是如果导入的包没有在依赖中管理着就需要手动配置版本了；**



----

## 2. SpringBoot：运行原理初探

### 2.1 启动器 spring-boot-starter

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

**springboot-boot-starter-xxx**：就是spring-boot的场景启动器

**spring-boot-starter-web**：帮我们导入了web模块正常运行所依赖的组件；

SpringBoot将所有的功能场景都抽取出来，做成一个个的starter （启动器），只需要在项目中引入这些starter即可，所有相关的依赖都会导入进来 ， 我们要用什么功能就导入什么样的场景启动器即可 ；我们未来也可以自己自定义 starter；



### 2.2 默认的主启动类

```java
//@SpringBootApplication 来标注一个主程序类，说明这是一个SpringBoot应用，
@SpringBootApplication
public class SpringbootApplication {

   public static void main(String[] args) {
     //以为是启动了一个方法，没想到启动了一个服务
      SpringApplication.run(SpringbootApplication.class, args);
   }

}
```

**SpringApplication.run分析**

​	分析该方法主要分两部分，一部分是SpringApplication的实例化，二是run方法的执行；

但是**一个简单的启动类并不简单！**我们来分析一下这些注解都干了什么



### 2.3 @SpringBootApplication

作用：标注在某个类上说明这个类是SpringBoot的主配置类 ， SpringBoot就应该运行这个类的main方法来启动SpringBoot应用；

进入这个注解：可以看到上面还有很多其他注解！

```java
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
    excludeFilters = {@Filter(
    type = FilterType.CUSTOM,
    classes = {TypeExcludeFilter.class}
), @Filter(
    type = FilterType.CUSTOM,
    classes = {AutoConfigurationExcludeFilter.class}
)}
)
public @interface SpringBootApplication {
    // ......
}
```

#### 2.3.1 @ComponentScan

<u>这个注解在Spring中很重要 ,它对应XML配置中的元素，**作用：自动扫描并加载符合条件的组件或者bean，将这个bean定义加载到IOC容器中；**</u>

#### 2.3.2 @SpringBootConfiguration

作用：SpringBoot的配置类 ，标注在某个类上 ， 表示这是一个SpringBoot的配置类；

```java
// @SpringBootConfiguration点进去可以看到@Configuration
@Configuration
public @interface SpringBootConfiguration {}

// @Configuration点进去可以看到@Component
@Component
public @interface Configuration {}
```

> 这里的 @Configuration，说明这是一个配置类 ，配置类就是对应Spring的xml 配置文件；
>
> @Configuration里面的 @Component 这就说明，启动类本身也是Spring中的一个组件而已，负责启动应用;

#### 2.3.3 @EnableAutoConfiguration

- **@EnableAutoConfiguration ：开启自动配置功能**

  以前我们需要自己配置的东西，而现在SpringBoot可以自动帮我们配置 ；@EnableAutoConfiguration告诉SpringBoot开启自动配置功能，这样自动配置才能生效；

  点进@EnableAutoConfiguration注解接续查看：

- **@AutoConfigurationPackage ：自动配置包**

```java
@Import(AutoConfigurationPackages.Registrar.class)
public @interface AutoConfigurationPackage {
}
```

​		**@import** ：Spring底层注解@import，给容器中导入一个组件	

​		**AutoConfigurationPackages.Registrar.class作用**：将主启动类的所在包及包下面所有子包里面的所有组件扫描到Spring容器 ；

- **@Import(AutoConfigurationImportSelector.class) ：给容器导入组件 ；**

  **AutoConfigurationImportSelector ：**自动配置导入选择器，那么它会导入哪些组件的选择器呢？我们点击去这个类看源码：

  1. 这个类中有一个这样的方法

  ```java
  // 获得候选的配置
  protected List<String> getCandidateConfigurations(AnnotationMetadata metadata, AnnotationAttributes attributes) {
      //这里的getSpringFactoriesLoaderFactoryClass（）方法
      //返回的就是我们最开始看的启动自动导入配置文件的注解类；EnableAutoConfiguration
      List<String> configurations = SpringFactoriesLoader.loadFactoryNames(this.getSpringFactoriesLoaderFactoryClass(), this.getBeanClassLoader());
      Assert.notEmpty(configurations, "No auto configuration classes found in META-INF/spring.factories. If you are using a custom packaging, make sure that file is correct.");
      return configurations;
  }
  ```

  2. 这个方法又调用了 SpringFactoriesLoader 类的静态方法！我们进入SpringFactoriesLoader类loadFactoryNames() 方法

  ```java
  public static List<String> loadFactoryNames(Class<?> factoryClass, @Nullable ClassLoader classLoader) {
      String factoryClassName = factoryClass.getName();
      //这里它又调用了 loadSpringFactories 方法
      return (List)loadSpringFactories(classLoader).getOrDefault(factoryClassName, Collections.emptyList());
  }
  ```

  3. 我们继续点击查看 loadSpringFactories 方法

  ```java
  private static Map<String, List<String>> loadSpringFactories(@Nullable ClassLoader classLoader) {
      //获得classLoader ， 我们返回可以看到这里得到的就是EnableAutoConfiguration标注的类本身
      MultiValueMap<String, String> result = (MultiValueMap)cache.get(classLoader);
      if (result != null) {
          return result;
      } else {
          try {
              //去获取一个资源 "META-INF/spring.factories"
              Enumeration<URL> urls = classLoader != null ? classLoader.getResources("META-INF/spring.factories") : ClassLoader.getSystemResources("META-INF/spring.factories");
              LinkedMultiValueMap result = new LinkedMultiValueMap();
  
              //将读取到的资源遍历，封装成为一个Properties
              while(urls.hasMoreElements()) {
                  URL url = (URL)urls.nextElement();
                  UrlResource resource = new UrlResource(url);
                  Properties properties = PropertiesLoaderUtils.loadProperties(resource);
                  Iterator var6 = properties.entrySet().iterator();
  
                  while(var6.hasNext()) {
                      Entry<?, ?> entry = (Entry)var6.next();
                      String factoryClassName = ((String)entry.getKey()).trim();
                      String[] var9 = StringUtils.commaDelimitedListToStringArray((String)entry.getValue());
                      int var10 = var9.length;
  
                      for(int var11 = 0; var11 < var10; ++var11) {
                          String factoryName = var9[var11];
                          result.add(factoryClassName, factoryName.trim());
                      }
                  }
              }
  
              cache.put(classLoader, result);
              return result;
          } catch (IOException var13) {
              throw new IllegalArgumentException("Unable to load factories from location [META-INF/spring.factories]", var13);
          }
      }
  }
  ```

  4. 发现一个多次出现的文件：spring.factories，全局搜索它

### 2.4 spring.factories

![image-20201106164933881](C:\Users\A80024\AppData\Roaming\Typora\typora-user-images\image-20201106164933881.png)

我们根据源头打开**spring.factories**文件，看到了很多自动配置的文件；这就是自动配置根源所在！

![image-20201106165055250](C:\Users\A80024\AppData\Roaming\Typora\typora-user-images\image-20201106165055250.png)

**WebMvcAutoConfiguration**

我们在上面的自动配置类随便找一个打开看看，比如 ：WebMvcAutoConfiguration

![image-20201106165321319](C:\Users\A80024\AppData\Roaming\Typora\typora-user-images\image-20201106165321319.png)

可以看到这些一个个的都是JavaConfig配置类，而且都注入了一些Bean，可以找一些自己认识的类，看着熟悉一下！

所以，自动配置真正实现是从classpath中搜寻所有的META-INF/spring.factories配置文件 ，并将其中对应的 org.springframework.boot.autoconfigure. 包下的配置项，通过反射实例化为对应标注了 @Configuration的JavaConfig形式的IOC容器配置类 ， 然后将这些都汇总成为一个实例并加载到IOC容器中。

**结论：**

1. SpringBoot在启动的时候从类路径下的META-INF/spring.factories中获取EnableAutoConfiguration指定的值
2. 将这些值作为自动配置类导入容器 ， 自动配置类就生效 ， 帮我们进行自动配置工作；
3. 整个J2EE的整体解决方案和自动配置都在springboot-autoconfigure的jar包中；
4. 它会给容器中导入非常多的自动配置类 （xxxAutoConfiguration）, 就是给容器中导入这个场景需要的所有组件 ， 并配置好这些组件 ；
5. 只要导入了对应的start，就有了对应的启动器，有了启动器，我们的自动装配就可以生效；
6. 有了自动配置类 ， 免去了我们手动编写配置注入功能组件等的工作；

**现在大家应该大概的了解了下，SpringBoot的运行原理，后面我们还会深化一次！**



### 2.5 run方法流程分析

- #### SpringApplication类（包含run方法）主要做了以下四件事情：
  - 推断应用的类型是普通的项目还是Web项目；
  - 查找并加载所有可用初始化器 ， 设置到initializers属性中；
  - 找出所有的应用程序监听器，设置到listeners属性中；
  - 推断并设置main方法的定义类，找到运行的主类；

<img src="https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWcyMDIwLmNuYmxvZ3MuY29tL2Jsb2cvMTkwNTA1My8yMDIwMDQvMTkwNTA1My0yMDIwMDQxMjIyMTEzNTExOS0xODQzMzIyMzUxLnBuZw?x-oss-process=image/format,png" alt="img" style="zoom:150%;" />

----

## 3. SpringBoot：yaml配置注入

SpringBoot的yml文件所有配置官网参考：https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html#core-properties

### 3.1 配置文件

SpringBoot使用一个全局的配置文件 ， 配置文件名称是固定的

- application.properties
  - 语法结构 ：key=value
- application.yml
  - 语法结构 ：key：空格 value

**配置文件的作用 ：**修改SpringBoot自动配置的默认值，因为SpringBoot在底层都给我们自动配置好了；

比如我们可以在配置文件中修改Tomcat 默认启动的端口号！测试一下！

```
server.port=8081
```



### 3.2 yaml概述

以前的配置文件，大多数都是使用xml来配置；比如一个简单的端口配置，我们来对比下yaml和xml

传统xml配置：

```xml
<server>
    <port>8081<port>
</server>
```

yaml配置：

```yml
server：
  prot: 8080
```



### 3.3 yaml基础语法

**说明：语法要求严格！**

1. 空格不能省略

2. 以缩进来控制层级关系，只要是左边对齐的一列数据都是同一个层级的。

3. 属性和值的大小写都是十分敏感的。

- **字面量：普通的值 [ 数字，布尔值，字符串 ]**

字面量直接写在后面就可以 ， 字符串默认不用加上双引号或者单引号；

```yml
k: v
```

- **对象、Map（键值对）**

```yml
#对象、Map格式
k: 
    v1:
    v2:
```

在下一行来写对象的属性和值得关系，注意缩进；比如：

```yml
student:
    name: long
    age: 3
```

行内写法

```yml
student: {name: long,age: 3}
```

- **数组（ List、set ）**

用 - 值表示数组中的一个元素,比如：

```yml
pets:
 - cat
 - dog
 - pig
```

行内写法

```yml
pets: [cat,dog,pig]
```

- **修改SpringBoot的默认端口号**

配置文件中添加，端口号的参数，就可以切换端口；

```yml
server:  
  port: 8082
```



### 3.4 yaml注入配置文件

1. 在springboot项目中的resources目录下新建一个文件 application.yml

2. 编写一个实体类 Dog；

```java
package com.kuang.springboot.pojo;

@Component  //注册bean到容器中
public class Dog {
    private String name;
    private Integer age;
    
    //有参无参构造、get、set方法、toString()方法  
}
```

3. 思考，我们原来是如何给bean注入属性值的！@Value，给狗狗类测试一下：

```java
@Component //注册bean
public class Dog {
    @Value("小黄")
    private String name;
    @Value("18")
    private Integer age;
}
```

4. 在SpringBoot的测试类下注入狗狗输出一下；

```java
@SpringBootTest
class DemoApplicationTests {

    @Autowired //将狗狗自动注入进来
    Dog dog;

    @Test
    public void contextLoads() {
        System.out.println(dog); //打印看下狗狗对象
    }
}
```

结果成功输出，@Value注入成功，这是我们原来的办法对吧。

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWcyMDIwLmNuYmxvZ3MuY29tL2Jsb2cvMTkwNTA1My8yMDIwMDQvMTkwNTA1My0yMDIwMDQxMjIyMTI0MjQzNC04NzcwMjU0NTUucG5n?x-oss-process=image/format,png)

5. 我们在编写一个复杂一点的实体类：Person 类

```java
@Component //注册bean到容器中
public class Person {
    private String name;
    private Integer age;
    private Boolean happy;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;
    
    //有参无参构造、get、set方法、toString()方法  
}
```

6、我们来使用yaml配置的方式进行注入，大家写的时候注意区别和优势，我们编写一个yaml配置！

```yml
person:
  name: long
  age: 3
  happy: false
  birth: 2000/01/01
  maps: {k1: v1,k2: v2}
  lists:
   - code
   - girl
   - music
  dog:
    name: 旺财
    age: 1
```

7、我们刚才已经把person这个对象的所有值都写好了，我们现在来注入到我们的类中！

```java
/*
@ConfigurationProperties作用：
    将配置文件中配置的每一个属性的值，映射到这个组件中；
    告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定
  	参数 prefix = “person” : 将配置文件中的person下面的所有属性一一对应
*/
@Component //注册bean
@ConfigurationProperties(prefix = "person")
public class Person {
    private String name;
    private Integer age;
    private Boolean happy;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;
}
```

8. IDEA 提示，springboot配置注解处理器没有找到，让我们看文档，我们可以查看文档，找到一个依赖！

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWcyMDIwLmNuYmxvZ3MuY29tL2Jsb2cvMTkwNTA1My8yMDIwMDQvMTkwNTA1My0yMDIwMDQxMjIyMTMxNzg2NC03OTYzMjY1NC5wbmc?x-oss-process=image/format,png)

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWcyMDIwLmNuYmxvZ3MuY29tL2Jsb2cvMTkwNTA1My8yMDIwMDQvMTkwNTA1My0yMDIwMDQxMjIyMTMzNzE4OS0xMTM5NDE4NzkucG5n?x-oss-process=image/format,png)

```xml
<!-- 导入配置文件处理器，配置文件进行绑定就会有提示，需要重启 -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-configuration-processor</artifactId>
  <optional>true</optional>
</dependency>
```

9. 确认以上配置都OK之后，我们去测试类中测试一下：

```java
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    Person person; //将person自动注入进来

    @Test
    public void contextLoads() {
        System.out.println(person); //打印person信息
    }

}
```

**yaml配置注入到实体类完全OK！**



### 3.5 加载指定的配置文件

**@PropertySource ：**加载指定的配置文件；

**@configurationProperties**：默认从全局配置文件中获取值；

1. 我们去在resources目录下新建一个**person.properties**文件

```properties
name=long
```

2. 然后在我们的代码中指定加载person.properties文件

```java
@PropertySource(value = "classpath:person.properties")
@Component //注册bean
public class Person {

    @Value("${name}")
    private String name;

    ......  
}
```

3. 再次输出测试一下：指定配置文件绑定成功！



### 3.6 配置文件占位符

配置文件还可以编写占位符生成随机数

```yml
person:
    name: long${random.uuid} # 随机uuid
    age: ${random.int}  # 随机int
    happy: false
    birth: 2000/01/01
    maps: {k1: v1,k2: v2}
    lists:
      - code
      - girl
      - music
    dog:
      name: ${person.hello:other}_旺财
      age: 1
```



### 3.7 对比小结

@Value这个使用起来并不友好！我们需要为每个属性单独注解赋值，比较麻烦；我们来看个功能对比图

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWcyMDIwLmNuYmxvZ3MuY29tL2Jsb2cvMTkwNTA1My8yMDIwMDQvMTkwNTA1My0yMDIwMDQxMjIyMTUyODExNC0xMjU4MjM4OTY0LnBuZw?x-oss-process=image/format,png)

1. @ConfigurationProperties只需要写一次即可 ， @Value则需要每个字段都添加；

2. **松散绑定：**比如在yml中写的`last-name`，这个和`lastName`是一样的，**` - `**  后面跟着的字母默认是大写的，这就是松散绑定；

3. **JSR303数据校验 ：** 这个就是我们可以在字段是增加一层过滤器验证 ， 可以保证数据的合法性；

4. **复杂类型封装：**yml中可以封装对象 ， 使用value就不支持；

- #### **结论：**
  - 配置yml和配置properties都可以获取到值 ， 强烈推荐 yml；
  - 如果我们在某个业务中，只需要获取配置文件中的某个值，可以使用一下 @value；



----

## 4. SpringBoot：JSR303数据校验及多环境切换

### 4.1 概述

Springboot中可以用注解 `@validated` 来进行校验数据，如果数据异常则会统一抛出异常，方便异常中心统一处理；我们这里来写个注解让我们的name只能支持Email格式；

```java
@Component //注册bean
@ConfigurationProperties(prefix = "person")
@Validated  //数据校验
public class Person {

    @Email(message="邮箱格式错误") //name必须是邮箱格式
    private String name;
}
```

运行结果 ：default message [不是一个合法的电子邮件地址];

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWcyMDIwLmNuYmxvZ3MuY29tL2Jsb2cvMTkwNTA1My8yMDIwMDQvMTkwNTA1My0yMDIwMDQxMjIyMTU1NjIzNy0zOTE2NzA5NzUucG5n?x-oss-process=image/format,png)

**使用数据校验，可以保证数据的正确性；**



### 4.2 常见参数

```markdown
@NotNull(message="名字不能为空")
private String userName;
@Max(value=120,message="年龄最大不能查过120")
private int age;
@Email(message="邮箱格式错误")
private String email;

# 空检查
@Null       验证对象是否为null
@NotNull    验证对象是否不为null, 无法查检长度为0的字符串
@NotBlank   检查约束字符串是不是Null还有被Trim的长度是否大于0,只对字符串,且会去掉前后空格.
@NotEmpty   检查约束元素是否为NULL或者是EMPTY.
    
# Booelan检查
@AssertTrue     验证 Boolean 对象是否为 true  
@AssertFalse    验证 Boolean 对象是否为 false  
    
# 长度检查
@Size(min=, max=) 验证对象（Array,Collection,Map,String）长度是否在给定的范围之内  
@Length(min=, max=) string is between min and max included.

# 日期检查
@Past       验证 Date 和 Calendar 对象是否在当前时间之前  
@Future     验证 Date 和 Calendar 对象是否在当前时间之后  
@Pattern    验证 String 对象是否符合正则表达式的规则

# 数字检查
@Max(value)       	验证元素必须为一个数字，其值必须大等于指定的最大值
@Min(value)			验证元素必须为一个数字，其值必须大等于指定的最小值
Digits(integer,fraction)	验证元素必须为一个数字，其值必须在可接受的范围
```



### 4.3 多配置文件

我们在主配置文件编写的时候，文件名可以是 application-{profile}.properties/yml , 用来指定多个环境版本；

**例如：**

​	application-test.yml代表测试环境配置

​	application-dev.yml代表开发环境配置

但是SpringBoot并不会直接启动这些配置文件，它**默认使用application.yml主配置文件**；

我们需要通过一个配置来选择需要激活的环境：

```properties
#比如在配置文件中指定使用dev环境，我们可以通过设置不同的端口号进行测试；
#我们启动SpringBoot，就可以看到已经切换到dev下的配置了；
spring:
  profiles:
    active: dev
```

![image-20201107134329150](C:\Users\abraham\AppData\Roaming\Typora\typora-user-images\image-20201107134329150.png)



### 4.4 yaml的多文档块

和properties配置文件中一样，但是使用yml去实现不需要创建多个配置文件，更加方便了 !

```yml
server:
  port: 8081
#选择要激活那个环境块
spring:
  profiles:
    active: prod


---
server:
  port: 8082
spring:
  profiles: dev #配置环境的名称

---
server:
  port: 8083
spring:
  profiles: prod  #配置环境的名称
```

**注意：如果yml和properties同时都配置了端口，并且没有激活其他环境 ， 默认会使用properties配置文件的！**



### 4.5 配置文件加载位置

**外部加载配置文件的方式十分多，我们选择最常用的即可，在开发的资源文件中进行配置！**

官方外部配置文件说明参考文档：

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWcyMDIwLmNuYmxvZ3MuY29tL2Jsb2cvMTkwNTA1My8yMDIwMDQvMTkwNTA1My0yMDIwMDQxMjIyMTYyNzg2NC0yODEyODk3MzkucG5n?x-oss-process=image/format,png)

SpringBoot启动会扫描以下位置的application.properties或者application.yml文件作为SpringBoot的默认配置文件：

```
优先级1：项目路径下的config文件夹配置文件
优先级2：项目路径下配置文件
优先级3：资源路径下的config文件夹配置文件
优先级4：资源路径下配置文件
```

优先级由高到底，高优先级的配置会覆盖低优先级的配置；

**SpringBoot会从这四个位置全部加载主配置文件；互补配置；**

我们在最低级的配置文件中设置一个项目访问路径的配置来测试互补问题；

```properties
#配置项目的访问路径
server.servlet.context-path=/long
```



----

## 5. SpringBoot：自动配置原理

配置文件到底能写什么？怎么写？SpringBoot官方文档中有大量的配置，我们无法全部记住

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWcyMDIwLmNuYmxvZ3MuY29tL2Jsb2cvMTkwNTA1My8yMDIwMDQvMTkwNTA1My0yMDIwMDQxMjIyMTY0NjE1OS0zNDM0MjA1MzEucG5n?x-oss-process=image/format,png)

### 5.1 分析自动配置原理

我们以**HttpEncodingAutoConfiguration（Http编码自动配置）**为例解释自动配置原理；

```java
//表示这是一个配置类，和以前编写的配置文件一样，也可以给容器中添加组件；
@Configuration 

//自动配置属性：启动指定类的ConfigurationProperties功能；
  //进入这个HttpProperties查看，将配置文件中对应的值和HttpProperties绑定起来；
  //并把HttpProperties加入到ioc容器中
@EnableConfigurationProperties({HttpProperties.class}) 

//Spring底层@Conditional注解
  //根据不同的条件判断，如果满足指定的条件，整个配置类里面的配置就会生效；
  //这里的意思就是判断当前应用是否是web应用，如果是，当前配置类生效
@ConditionalOnWebApplication(
    type = Type.SERVLET
)

//判断当前项目有没有这个类CharacterEncodingFilter；SpringMVC中进行乱码解决的过滤器；
@ConditionalOnClass({CharacterEncodingFilter.class})

//判断配置文件中是否存在某个配置：spring.http.encoding.enabled；
  //如果不存在，判断也是成立的
  //即使我们配置文件中不配置pring.http.encoding.enabled=true，也是默认生效的；
@ConditionalOnProperty(
    prefix = "spring.http.encoding",
    value = {"enabled"},
    matchIfMissing = true
)

public class HttpEncodingAutoConfiguration {
    //他已经和SpringBoot的配置文件映射了
    private final Encoding properties;
    //只有一个有参构造器的情况下，参数的值就会从容器中拿
    public HttpEncodingAutoConfiguration(HttpProperties properties) {
        this.properties = properties.getEncoding();
    }
    
    //给容器中添加一个组件，这个组件的某些值需要从properties中获取
    @Bean
    @ConditionalOnMissingBean //判断容器没有这个组件？
    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new OrderedCharacterEncodingFilter();
        filter.setEncoding(this.properties.getCharset().name());
        filter.setForceRequestEncoding(this.properties.shouldForce(org.springframework.boot.autoconfigure.http.HttpProperties.Encoding.Type.REQUEST));
        filter.setForceResponseEncoding(this.properties.shouldForce(org.springframework.boot.autoconfigure.http.HttpProperties.Encoding.Type.RESPONSE));
        return filter;
    }
    //。。。。。。。
}
```

**一句话总结 ：根据当前不同的条件判断，决定这个配置类是否生效！**

- 一但这个配置类生效；这个配置类就会给容器中添加各种组件；
- 这些组件的属性是从对应的properties类中获取的，这些类里面的每一个属性又是和配置文件绑定的；
- 所有在配置文件中能配置的属性都是在xxxxProperties类中封装着；
- 配置文件能配置什么就可以参照某个功能对应的这个属性类

```java
//从配置文件中获取指定的值和bean的属性进行绑定
@ConfigurationProperties(prefix = "spring.http") 
public class HttpProperties {
    // .....
}
```

我们去配置文件里面试试前缀，看提示！

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWcyMDIwLmNuYmxvZ3MuY29tL2Jsb2cvMTkwNTA1My8yMDIwMDQvMTkwNTA1My0yMDIwMDQxMjIyMTcwOTQ2OS0xOTI3Njc4MzMyLnBuZw?x-oss-process=image/format,png)

- ####  精髓
  - SpringBoot启动会加载大量的自动配置类；
  - 我们看我们需要的功能有没有在SpringBoot默认写好的自动配置类当中；
  - 我们再来看这个自动配置类中到底配置了哪些组件；
  - 给容器中自动配置类添加组件的时候，会从properties类中获取某些属性；我们只需要在配置文件中指定这些属性的值即可；

  **xxxxAutoConfigurartion：自动配置类；**向容器中自动添加组件

  **xxxxProperties:封装配置文件中相关属性；**



### 5.2 @Conditional

了解完自动装配的原理后，我们来关注一个细节问题，**自动配置类必须在一定的条件下才能生效；**

**@Conditional派生注解（Spring注解版原生的@Conditional作用）**

作用：必须是@Conditional指定的条件成立，才给容器中添加组件，配置配里面的所有内容才生效；

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWcyMDIwLmNuYmxvZ3MuY29tL2Jsb2cvMTkwNTA1My8yMDIwMDQvMTkwNTA1My0yMDIwMDQxMjIyMTc0Nzk1NC01OTEyODI2NjEucG5n?x-oss-process=image/format,png)



**那么多的自动配置类，必须在一定的条件下才能生效；也就是说，我们加载了这么多的配置类，但不是所有的都生效了。**

我们怎么知道哪些自动配置类生效？

**我们可以通过启用 debug=true属性；来让控制台打印自动配置报告，这样我们就可以很方便的知道哪些自动配置类生效；**

```properties
#开启springboot的调试类
debug=true
```

**Positive matches:（自动配置类启用的：正匹配）**

**Negative matches:（没有启动，没有匹配成功的自动配置类：负匹配）**

**Unconditional classes: （没有条件的类）**

【演示：查看输出的日志】



----

## 6. SpringBoot：Web开发探究

### 6.1 静态资源处理

- #### 打开WebMvcAutoConfiguration配置类，找到addResourceHandlers方法

```java
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    // 如果我们有在配置文件中配置自定义的具体资源存放路径，则该方法失效，直接结束；
    if (!this.resourceProperties.isAddMappings()) {
        logger.debug("Default resource handling disabled");
        return;
    }
    Duration cachePeriod = this.resourceProperties.getCache().getPeriod();
    CacheControl cacheControl = this.resourceProperties.getCache().getCachecontrol().toHttpCacheControl();
    /**
     * 方式一：在webjars包下找对应的静态资源
     * addResourceHandle("/webjars/**")：为请求的静态资源处理器，即请求路径
     * ddResourceLocations("classpath:/META-INF/resources/webjars/")：为静态资源的具体存放位置
     * ("/webjars/**")即等价("classpath:/META-INF/resources/webjars/")："/webjars/**"请求会对应找"classpath:/META-INF/resources/webjars/"路径下的静态资源
     */
    if (!registry.hasMappingForPattern("/webjars/**")) {
        customizeResourceHandlerRegistration(registry.addResourceHandler("/webjars/**")
                                             .addResourceLocations("classpath:/META-INF/resources/webjars/")
                                             .setCachePeriod(getSeconds(cachePeriod)).setCacheControl(cacheControl));
    }
    /**
     * 方式二：当前目录下的所有资源
	 * 即“/**”下的所有请求都会在"classpath:/META-INF/resources/","classpath:/resources/", "classpath:/static/", "classpath:/public/"这四个路径下找，优先级即为此顺序
     */
    String staticPathPattern = this.mvcProperties.getStaticPathPattern();
    if (!registry.hasMappingForPattern(staticPathPattern)) {
        customizeResourceHandlerRegistration(registry.addResourceHandler(staticPathPattern)
                                             .addResourceLocations(getResourceLocations(this.resourceProperties.getStaticLocations()))
                                             .setCachePeriod(getSeconds(cachePeriod)).setCacheControl(cacheControl));
    }
}
```

- #### 方式一：访问webjars包下的静态资源

**WebJars是将web前端资源（js，css等）打成jar包文件**，然后借助Maven工具，以jar包形式对web前端资源进行统一依赖管理，保证这些Web资源版本唯一性；

![image-20201107195252063](C:\Users\abraham\AppData\Roaming\Typora\typora-user-images\image-20201107195252063.png)

![image-20201107195619730](C:\Users\abraham\AppData\Roaming\Typora\typora-user-images\image-20201107195619730.png)

**访问：http://localhost:8088/webjars/jquery/3.5.1/jquery.js**即找到"classpath:/META-INF/resources/webjars/"下的“jquery/3.5.1/jquery.js”并返回得到结果；

![image-20201107200015167](C:\Users\abraham\AppData\Roaming\Typora\typora-user-images\image-20201107200015167.png)

- #### 方式二：当前目录下的所有静态资源

![image-20201107201246152](C:\Users\abraham\AppData\Roaming\Typora\typora-user-images\image-20201107201246152.png)

![image-20201107201224540](C:\Users\abraham\AppData\Roaming\Typora\typora-user-images\image-20201107201224540.png)

**优先级：**"classpath:/META-INF/resources/" > "classpath:/resources/" >  "classpath:/static/" > "classpath:/public/"

- #### 方式三：自定义静态资源的存放路径

在application.yml文件中增加如下配置：

```xml
spring:
  resources:
    static-locations: classpath:/long/
```



### 6.2 首页处理

- #### 打开WebMvcAutoConfiguration配置类，找到welcomePageHandlerMapping方法

```java
@Bean
public WelcomePageHandlerMapping welcomePageHandlerMapping(ApplicationContext applicationContext,FormattingConversionService mvcConversionService, ResourceUrlProvider mvcResourceUrlProvider) {
    WelcomePageHandlerMapping welcomePageHandlerMapping = new WelcomePageHandlerMapping(
        new TemplateAvailabilityProviders(applicationContext), applicationContext, getWelcomePage(),
        this.mvcProperties.getStaticPathPattern());
    welcomePageHandlerMapping.setInterceptors(getInterceptors(mvcConversionService, mvcResourceUrlProvider));
    welcomePageHandlerMapping.setCorsConfigurations(getCorsConfigurations());
    return welcomePageHandlerMapping;
}

private Optional<Resource> getWelcomePage() {
    String[] locations = getResourceLocations(this.resourceProperties.getStaticLocations());
    return Arrays.stream(locations).map(this::getIndexHtml).filter(this::isReadable).findFirst();
}
// 默认的首页路径
private Resource getIndexHtml(String location) {
    return this.resourceLoader.getResource(location + "index.html");
}
```

- #### 默认html静态资源放在templates目录下，该目录下的所有界面只能通过controller来跳转，并需要thymeleaf模板引擎的支持

```java
//在templates目录下的所有界面只能通过controller来跳转
//这个需要模板引擎的支持：thymeleaf
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
```



### 6.3 模板引擎Thymeleaf

**==官网文档：==**https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html

- #### 什么是Thymeleaf？
  - Thymeleaf是一个现代服务器端Java模板引擎，适用于Web和独立环境，能够处理HTML，XML，JavaScript，CSS甚至纯文本；

  - Thymeleaf的主要目标是提供一种优雅且高度可维护的模板创建方式；为实现这一目标，它以*自然模板*的概念为基础，将其逻辑注入模板文件，其方式不会影响模板被用作设计原型；这改善了设计沟通，缩小了设计和开发团队之间的差距；
  - Thymeleaf也从一开始就设计了Web标准 - 特别是**HTML5** - 允许您创建完全验证的模板，如果您需要的话；

- #### 导入依赖

```xml
<!--Thymeleaf-->
<dependency>
    <groupId>org.thymeleaf</groupId>
    <artifactId>thymeleaf-spring5</artifactId>
</dependency>
<dependency>
    <groupId>org.thymeleaf.extras</groupId>
    <artifactId>thymeleaf-extras-java8time</artifactId>
</dependency>

<!--Thymeleaf，该依赖为SpringBoot集成，自动引入上述两个包-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

- #### ThymeleafProperties 文件

```java
@ConfigurationProperties(prefix = "spring.thymeleaf")
public class ThymeleafProperties {

	private static final Charset DEFAULT_ENCODING = StandardCharsets.UTF_8;

	public static final String DEFAULT_PREFIX = "classpath:/templates/";

	public static final String DEFAULT_SUFFIX = ".html";
    
    ......
}
```

- #### Thymeleaf的基础语法

| Order |             Feature             |                         Attributes                          |
| :---: | :-----------------------------: | :---------------------------------------------------------: |
|   1   |       Fragment inclusion        |               `th:insert` <br />`th:replace`                |
|   2   |       Fragment iteration        |                          `th:each`                          |
|   3   |     Conditional evaluation      | `th:if` <br />`th:unless` <br />`th:switch`<br /> `th:case` |
|   4   |    Local variable definition    |                 `th:object`<br /> `th:with`                 |
|   5   | General attribute modification  |   `th:attr` <br />`th:attrprepend` <br />`th:attrappend`    |
|   6   | Specific attribute modification |    `th:value` <br />`th:href` <br />`th:src` <br />`...`    |
|   7   |  Text (tag body modification)   |                 `th:text`<br /> `th:utext`                  |
|   8   |     Fragment specification      |                        `th:fragment`                        |
|   9   |        Fragment removal         |                         `th:remove`                         |

- **Simple expressions:**
  - Variable Expressions: `${...}`
  - Selection Variable Expressions: `*{...}`
  - Message Expressions: `#{...}`
  - Link URL Expressions: `@{...}`
  - Fragment Expressions: `~{...}`
- **Literals：**
  - Text literals: `'one text'`, `'Another one!'`,…
  - Number literals: `0`, `34`, `3.0`, `12.3`,…
  - Boolean literals: `true`, `false`
  - Null literal: `null`
  - Literal tokens: `one`, `sometext`, `main`,…
- **Text operations:**
  - String concatenation: `+`
  - Literal substitutions: `|The name is ${name}|`
- **Arithmetic operations:**
  - Binary operators: `+`, `-`, `*`, `/`, `%`
  - Minus sign (unary operator): `-`
- **Boolean operations:**
  - Binary operators: `and`, `or`
  - Boolean negation (unary operator): `!`, `not`
- **Comparisons and equality:**
  - Comparators: `>`, `<`, `>=`, `<=` (`gt`, `lt`, `ge`, `le`)
  - Equality operators: `==`, `!=` (`eq`, `ne`)
- **Conditional operators:**
  - If-then: `(if) ? (then)`
  - If-then-else: `(if) ? (then) : (else)`
  - Default: `(value) ?: (defaultvalue)`
- **Special tokens:**
  - No-Operation: `_`

### 6.4 扩展SpringMVC配置

- #### 官网阅读

我们需要知道SpringBoot对我们的SpringMVC还做了哪些配置，包括如何扩展，如何定制；

```java
Spring MVC Auto-configuration
// Spring Boot为Spring MVC提供了自动配置，它可以很好地与大多数应用程序一起工作。
Spring Boot provides auto-configuration for Spring MVC that works well with most applications.
// 自动配置在Spring默认设置的基础上添加了以下功能：
The auto-configuration adds the following features on top of Spring’s defaults:
// 1.包含视图解析器
Inclusion of ContentNegotiatingViewResolver and BeanNameViewResolver beans.
// 2.支持静态资源文件夹的路径，以及webjars
Support for serving static resources, including support for WebJars 
// 3.自动注册了Converter：
// 转换器，这就是我们网页提交数据到后台自动封装成为对象的东西，比如把"1"字符串自动转换为int类型
// Formatter：【格式化器，比如页面给我们了一个2019-8-10，它会给我们自动格式化为Date对象】
Automatic registration of Converter, GenericConverter, and Formatter beans.
// 4.HttpMessageConverters
// SpringMVC用来转换Http请求和响应的的，比如我们要把一个User对象转换为JSON字符串，可以去看官网文档解释；
Support for HttpMessageConverters (covered later in this document).
// 5.定义错误代码生成规则的
Automatic registration of MessageCodesResolver (covered later in this document).
// 6.首页定制
Static index.html support.
// 7.图标定制
Custom Favicon support (covered later in this document).
// 8.初始化数据绑定器：帮我们把请求数据绑定到JavaBean中！
Automatic use of a ConfigurableWebBindingInitializer bean (covered later in this document).

/*
如果您希望保留Spring Boot MVC功能，并且希望添加其他MVC配置（拦截器、格式化程序、视图控制器和其他功能），则可以添加自己的@configuration类，类型为webmvcconfiguer，但不添加@EnableWebMvc。如果希望提供RequestMappingHandlerMapping、RequestMappingHandlerAdapter或ExceptionHandlerExceptionResolver的自定义实例，则可以声明WebMVCregistrationAdapter实例来提供此类组件。
*/
If you want to keep Spring Boot MVC features and you want to add additional MVC configuration 
(interceptors, formatters, view controllers, and other features), you can add your own 
@Configuration class of type WebMvcConfigurer but without @EnableWebMvc. If you wish to provide 
custom instances of RequestMappingHandlerMapping, RequestMappingHandlerAdapter, or 
ExceptionHandlerExceptionResolver, you can declare a WebMvcRegistrationsAdapter instance to provide such components.

// 如果您想完全控制Spring MVC，可以添加自己的@Configuration，并用@EnableWebMvc进行注释。
If you want to take complete control of Spring MVC, you can add your own @Configuration annotated with @EnableWebMvc.
```

我们来仔细对照，看一下它怎么实现的，它告诉我们SpringBoot已经帮我们自动配置好了SpringMVC，然后自动配置了哪些东西呢？

- #### 自定义视图解析器

1. 写一个自定义的视图解析器；

```java
// 扩展SpringMVC
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    
    @Bean //放到bean中
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }

    // 只要是实现了视图解析器接口（ViewResolver）的类都可以将其看成视图解析器
    // 我们写一个静态内部类，自定义实现自己的视图解析器，实现ViewResolver接口
    private static class MyViewResolver implements ViewResolver{
        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }
}
```

2. 查看我们自己写的视图解析器是否起作用：

我们给 **DispatcherServlet** 中的 **doDispatch方法** 加个断点进行调试一下，因为所有的请求都会走到这个方法中

![image-20201108114042173](C:\Users\abraham\AppData\Roaming\Typora\typora-user-images\image-20201108114042173.png)

3. 我们启动我们的项目，然后随便访问一个页面，看一下Debug信息：

![image-20201108114137619](C:\Users\abraham\AppData\Roaming\Typora\typora-user-images\image-20201108114137619.png)

找到我们自定义的视图解析器

![image-20201108114207055](C:\Users\abraham\AppData\Roaming\Typora\typora-user-images\image-20201108114207055.png)

- #### 修改SpringBoot的默认配置

这么多的自动配置，原理都是一样的，通过这个WebMVC的自动配置原理分析，我们要学会一种学习方式，通过源码探究，得出结论；这个结论一定是属于自己的，而且一通百通。

SpringBoot的底层，大量用到了这些设计细节思想，所以，没事需要多阅读源码！得出结论；

SpringBoot在自动配置很多组件的时候，先看容器中有没有用户自己配置的（如果用户自己配置@bean），如果有就用用户配置的，如果没有就用自动配置的；

如果有些组件可以存在多个，比如我们的视图解析器，就将用户配置的和自己默认的组合起来！

我们要做的就是编写一个@Configuration注解类，并且类型要为WebMvcConfigurer，还不能标注@EnableWebMvc注解；我们去自己写一个；我们新建一个包叫config，写一个类MyMvcConfig；

```java
// 应为类型要求为WebMvcConfigurer，所以我们实现其接口
// 可以使用自定义类扩展MVC的功能
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 浏览器发送/long ， 就会跳转到long页面；
        registry.addViewController("/long").setViewName("long");
    }
}
```

在浏览器访问http://localhost:8088/long：

![image-20201108114552006](C:\Users\abraham\AppData\Roaming\Typora\typora-user-images\image-20201108114552006.png)

**跳转成功；所以说，我们要扩展SpringMVC，官方就推荐我们这么去使用，既保SpringBoot留所有的自动配置，也能用我们扩展的配置！**

==【实践：https://blog.csdn.net/qq_45173404/article/details/108934414】==



## 7. SpringBoot：页面国际化

有的时候，我们的网站会去涉及中英文甚至多语言的切换，这时候我们就需要学习国际化了！

## 7.1 配置文件编写

1. 我们在resources资源文件下新建一个i18n目录，存放国际化配置文件;

2. 建立一个login.properties文件，还有一个login_zh_CN.properties；发现IDEA自动识别了我们要做国际化操作；文件夹变了！

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWcyMDIwLmNuYmxvZ3MuY29tL2Jsb2cvMTkwNTA1My8yMDIwMDQvMTkwNTA1My0yMDIwMDQxMjIyNTE0MTg3Ni0xMzA3NjA4MTM3LnBuZw?x-oss-process=image/format,png)

3. 我们可以在这上面去新建一个文件；

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWcyMDIwLmNuYmxvZ3MuY29tL2Jsb2cvMTkwNTA1My8yMDIwMDQvMTkwNTA1My0yMDIwMDQxMjIyNTE1NDg4OS0xNTI0NjUzNDQ5LnBuZw?x-oss-process=image/format,png)

弹出如下页面：我们再添加一个英文的；

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWcyMDIwLmNuYmxvZ3MuY29tL2Jsb2cvMTkwNTA1My8yMDIwMDQvMTkwNTA1My0yMDIwMDQxMjIyNTIwNzYwNC0xMjM4NDUxNTY4LnBuZw?x-oss-process=image/format,png)

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWcyMDIwLmNuYmxvZ3MuY29tL2Jsb2cvMTkwNTA1My8yMDIwMDQvMTkwNTA1My0yMDIwMDQxMjIyNTIyMTA2NS04ODczOTg2NTUucG5n?x-oss-process=image/format,png)

**4. 接下来，我们就来编写配置，我们可以看到idea下面有另外一个视图；**

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWcyMDIwLmNuYmxvZ3MuY29tL2Jsb2cvMTkwNTA1My8yMDIwMDQvMTkwNTA1My0yMDIwMDQxMjIyNTIzNDQ0MS0yNTg1OTA5NTIucG5n?x-oss-process=image/format,png)

这个视图我们点击 + 号就可以直接添加属性了；配置文件编写如下：

login.properties ：默认

```properties
login.btn=登录
login.password=密码
login.remember=记住我
login.tip=请登录
login.username=用户名
```

英文：

```properties
login.btn=Sign in
login.password=Password
login.remember=Remember me
login.tip=Please sign in
login.username=Username
```

中文：

```properties
login.btn=登录
login.password=密码
login.remember=记住我
login.tip=请登录
login.username=用户名
```



### 13.2 配置页面国际化值

- #### 首先要在SpringBoot配置文件中配置我们刚写的配置文件路径

```yml
spring:
# 国际化配置文件的位置
  messages:
    basename: i18n.login
```

- #### 去页面获取国际化的值：#{…}

![image-20201109150149785](C:\Users\A80024\AppData\Roaming\Typora\typora-user-images\image-20201109150149785.png)

- #### 访问验证

![image-20201109150207721](C:\Users\A80024\AppData\Roaming\Typora\typora-user-images\image-20201109150207721.png)

### 13.5 配置国际化解析

- #### 修改一下前端页面的跳转链接

```html
<!-- 这里传入参数不需要使用？ 直接使用（key=value）-->
<a class="btn btn-sm" th:href="@{/index.html(lang='zh_CN')}">中文</a>
<a class="btn btn-sm" th:href="@{/index.html(lang='en_US')}">English</a>
```

- #### 编写自定义的处理国际化的配置类

```java
public class MyLocaleResolver implements LocaleResolver {

    // 解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {

        // 去获取请求中的语言参数
        String language = request.getParameter("lang");
        Locale locale = Locale.getDefault(); // 如果没有获取到就使用系统默认的
        // 如果请求的链接参数“lang”不为空
        if (!StringUtils.isEmpty(language)){
            // 分割请求参数 zh_CN  en_US
            String[] split = language.split("_");
            // 国家，地区
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }
    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
```

- #### 在我们自定义的MyMvcConofig下添加bean；

```java
// 将自定义的国际化配置放到bean中，自动装配
@Bean
public LocaleResolver localeResolver(){
    return new MyLocaleResolver();
}
```

- #### 重启访问即可



----

## 7. SpringBoot整合JDBC

### 7.1 SpringData简介

对于数据访问层，无论是 SQL(关系型数据库) 还是 NOSQL(非关系型数据库)，Spring Boot 底层都是采用 Spring Data 的方式进行统一处理。

Spring Boot 底层都是采用 Spring Data 的方式进行统一处理各种数据库，Spring Data 也是 Spring 中与 Spring Boot、Spring Cloud 等齐名的知名项目。

Sping Data 官网：https://spring.io/projects/spring-data

数据库相关的启动器 ：可以参考官方文档：

https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/htmlsingle/#using-boot-starter

整合JDBC

### 7.2 创建测试项目测试数据源

1、我去新建一个项目测试：springboot-data-jdbc ; 引入相应的模块！基础模块

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWcyMDIwLmNuYmxvZ3MuY29tL2Jsb2cvMTkwNTA1My8yMDIwMDQvMTkwNTA1My0yMDIwMDQxMjIyMzYwMDg1MS04NzQzNDkwMTQucG5n?x-oss-process=image/format,png)

2、项目建好之后，发现自动帮我们导入了如下的启动器

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
123456789
```

3、编写yaml配置文件连接数据库；

```yml
spring:
  datasource:
    username: root
    password: 123456
    #?serverTimezone=UTC解决时区的报错
    url: jdbc:mysql://localhost:3306/springboot?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8
    driver-class-name: com.mysql.cj.jdbc.Driver
1234567
```

4、配置完这一些东西后，我们就可以直接去使用了，因为SpringBoot已经默认帮我们进行了自动配置；去测试类测试一下

```java
@SpringBootTest
class SpringbootDataJdbcApplicationTests {

    //DI注入数据源
    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() throws SQLException {
        //看一下默认数据源
        System.out.println(dataSource.getClass());
        //获得连接
        Connection connection =   dataSource.getConnection();
        System.out.println(connection);
        //关闭连接
        connection.close();
    }
}
123456789101112131415161718
```

结果：我们可以看到他默认给我们配置的数据源为 : class com.zaxxer.hikari.HikariDataSource ， 我们并没有手动配置

我们来全局搜索一下，找到数据源的所有自动配置都在 ：DataSourceAutoConfiguration文件：

```java
@Import(
    {Hikari.class, Tomcat.class, Dbcp2.class, Generic.class, DataSourceJmxConfiguration.class}
)
protected static class PooledDataSourceConfiguration {
    protected PooledDataSourceConfiguration() {
    }
}
1234567
```

这里导入的类都在 DataSourceConfiguration 配置类下，可以看出 Spring Boot 2.2.5 默认使用HikariDataSource 数据源，而以前版本，如 Spring Boot 1.5 默认使用 org.apache.tomcat.jdbc.pool.DataSource 作为数据源；

**HikariDataSource 号称 Java WEB 当前速度最快的数据源，相比于传统的 C3P0 、DBCP、Tomcat jdbc 等连接池更加优秀；**

**可以使用 spring.datasource.type 指定自定义的数据源类型，值为 要使用的连接池实现的完全限定名。**

关于数据源我们并不做介绍，有了数据库连接，显然就可以 CRUD 操作数据库了。但是我们需要先了解一个对象 JdbcTemplate

### 7.3 JDBCTemplate

1、有了数据源(com.zaxxer.hikari.HikariDataSource)，然后可以拿到数据库连接(java.sql.Connection)，有了连接，就可以使用原生的 JDBC 语句来操作数据库；

2、即使不使用第三方第数据库操作框架，如 MyBatis等，Spring 本身也对原生的JDBC 做了轻量级的封装，即JdbcTemplate。

3、数据库操作的所有 CRUD 方法都在 JdbcTemplate 中。

4、Spring Boot 不仅提供了默认的数据源，同时默认已经配置好了 JdbcTemplate 放在了容器中，程序员只需自己注入即可使用

5、JdbcTemplate 的自动配置是依赖 org.springframework.boot.autoconfigure.jdbc 包下的 JdbcTemplateConfiguration 类

**JdbcTemplate主要提供以下几类方法：**

- execute方法：可以用于执行任何SQL语句，一般用于执行DDL语句；
- update方法及batchUpdate方法：update方法用于执行新增、修改、删除等语句；batchUpdate方法用于执行批处理相关语句；
- query方法及queryForXXX方法：用于执行查询相关语句；
- call方法：用于执行存储过程、函数相关语句。

### 7.4 测试

编写一个Controller，注入 jdbcTemplate，编写测试方法进行访问测试；

```java
package com.kuang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jdbc")
public class JdbcController {

    /**
     * Spring Boot 默认提供了数据源，默认提供了 org.springframework.jdbc.core.JdbcTemplate
     * JdbcTemplate 中会自己注入数据源，用于简化 JDBC操作
     * 还能避免一些常见的错误,使用起来也不用再自己来关闭数据库连接
     */
    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询employee表中所有数据
    //List 中的1个 Map 对应数据库的 1行数据
    //Map 中的 key 对应数据库的字段名，value 对应数据库的字段值
    @GetMapping("/list")
    public List<Map<String, Object>> userList(){
        String sql = "select * from employee";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }
    
    //新增一个用户
    @GetMapping("/add")
    public String addUser(){
        //插入语句，注意时间问题
        String sql = "insert into employee(last_name, email,gender,department,birth)" +
                " values ('狂神说','24736743@qq.com',1,101,'"+ new Date().toLocaleString() +"')";
        jdbcTemplate.update(sql);
        //查询
        return "addOk";
    }

    //修改用户信息
    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id){
        //插入语句
        String sql = "update employee set last_name=?,email=? where id="+id;
        //数据
        Object[] objects = new Object[2];
        objects[0] = "秦疆";
        objects[1] = "24736743@sina.com";
        jdbcTemplate.update(sql,objects);
        //查询
        return "updateOk";
    }

    //删除用户
    @GetMapping("/delete/{id}")
    public String delUser(@PathVariable("id") int id){
        //插入语句
        String sql = "delete from employee where id=?";
        jdbcTemplate.update(sql,id);
        //查询
        return "deleteOk";
    }
    
}
1234567891011121314151617181920212223242526272829303132333435363738394041424344454647484950515253545556575859606162636465666768697071
```

测试请求，结果正常；

到此，CURD的基本操作，使用 JDBC 就搞定了。https://docs.spring.io/spring-boot/docs/2.0.4.RELEASE/reference/htmlsingle/#using-boot-starter)

## 

### 7.5 原理探究 ：

org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration 数据源配置类作用 ：根据逻辑判断之后，添加数据源；

**SpringBoot默认支持以下数据源：**

**com.zaxxer.hikari.HikariDataSource （Spring Boot 2.0 以上，默认使用此数据源）**

org.apache.tomcat.jdbc.pool.DataSource

org.apache.commons.dbcp2.BasicDataSource

**可以使用 spring.datasource.type 指定自定义的数据源类型，值为 要使用的连接池实现的完全限定名。默认情况下，它是从类路径自动检测的。**

```java
    @Configuration
    @ConditionalOnMissingBean({DataSource.class})
    @ConditionalOnProperty(
        name = {"spring.datasource.type"}
    )
    static class Generic {
        Generic() {
        }

        @Bean
        public DataSource dataSource(DataSourceProperties properties) {
            return properties.initializeDataSourceBuilder().build();
        }
    }
1234567891011121314
```

# 8、SpringBoot整合Druid

## 8.1、Druid简介

Java程序很大一部分要操作数据库，为了提高性能操作数据库的时候，又不得不使用数据库连接池。

Druid 是阿里巴巴开源平台上一个数据库连接池实现，结合了 C3P0、DBCP 等 DB 池的优点，同时加入了日志监控。

Druid 可以很好的监控 DB 池连接和 SQL 的执行情况，天生就是针对监控而生的 DB 连接池。

Druid已经在阿里巴巴部署了超过600个应用，经过一年多生产环境大规模部署的严苛考验。

Spring Boot 2.0 以上默认使用 Hikari 数据源，可以说 Hikari 与 Driud 都是当前 Java Web 上最优秀的数据源，我们来重点介绍 Spring Boot 如何集成 Druid 数据源，如何实现数据库监控。

Github地址：https://github.com/alibaba/druid/

**com.alibaba.druid.pool.DruidDataSource 基本配置参数如下：**

| 配置                          | 缺省值             | 说明                                                         |
| ----------------------------- | ------------------ | ------------------------------------------------------------ |
| name                          |                    | 配置这个属性的意义在于，如果存在多个数据源，监控的时候可以通过名字来区分开来。 如果没有配置，将会生成一个名字，格式是：“DataSource-” + System.identityHashCode(this). 另外配置此属性至少在1.0.5版本中是不起作用的，强行设置name会出错 [详情-点此处](http://blog.csdn.net/lanmo555/article/details/41248763)。 |
| url                           |                    | 连接数据库的url，不同数据库不一样。例如： mysql : jdbc:mysql://10.20.153.104:3306/druid2 oracle : jdbc:oracle:thin:@10.20.149.85:1521:ocnauto |
| username                      |                    | 连接数据库的用户名                                           |
| password                      |                    | 连接数据库的密码。如果你不希望密码直接写在配置文件中，可以使用ConfigFilter。详细看这里：https://github.com/alibaba/druid/wiki/使用ConfigFilter |
| driverClassName               | 根据url自动识别    | 这一项可配可不配，如果不配置druid会根据url自动识别dbType，然后选择相应的driverClassName |
| initialSize                   | 0                  | 初始化时建立物理连接的个数。初始化发生在显示调用init方法，或者第一次getConnection时 |
| maxActive                     | 8                  | 最大连接池数量                                               |
| maxIdle                       | 8                  | 已经不再使用，配置了也没效果                                 |
| minIdle                       |                    | 最小连接池数量                                               |
| maxWait                       |                    | 获取连接时最大等待时间，单位毫秒。配置了maxWait之后，缺省启用公平锁，并发效率会有所下降，如果需要可以通过配置useUnfairLock属性为true使用非公平锁。 |
| poolPreparedStatements        | false              | 是否缓存preparedStatement，也就是PSCache。PSCache对支持游标的数据库性能提升巨大，比如说oracle。在mysql下建议关闭。 |
| maxOpenPreparedStatements     | -1                 | 要启用PSCache，必须配置大于0，当大于0时，poolPreparedStatements自动触发修改为true。在Druid中，不会存在Oracle下PSCache占用内存过多的问题，可以把这个数值配置大一些，比如说100 |
| validationQuery               |                    | 用来检测连接是否有效的sql，要求是一个查询语句。如果validationQuery为null，testOnBorrow、testOnReturn、testWhileIdle都不会其作用。 |
| validationQueryTimeout        |                    | 单位：秒，检测连接是否有效的超时时间。底层调用jdbc Statement对象的void setQueryTimeout(int seconds)方法 |
| testOnBorrow                  | true               | 申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。 |
| testOnReturn                  | false              | 归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能 |
| testWhileIdle                 | false              | 建议配置为true，不影响性能，并且保证安全性。申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。 |
| timeBetweenEvictionRunsMillis | 1分钟（1.0.14）    | 有两个含义： 1) Destroy线程会检测连接的间隔时间，如果连接空闲时间大于等于minEvictableIdleTimeMillis则关闭物理连接 2) testWhileIdle的判断依据，详细看testWhileIdle属性的说明 |
| numTestsPerEvictionRun        |                    | 不再使用，一个DruidDataSource只支持一个EvictionRun           |
| minEvictableIdleTimeMillis    | 30分钟（1.0.14）   | 连接保持空闲而不被驱逐的最长时间                             |
| connectionInitSqls            |                    | 物理连接初始化的时候执行的sql                                |
| exceptionSorter               | 根据dbType自动识别 | 当数据库抛出一些不可恢复的异常时，抛弃连接                   |
| filters                       |                    | 属性类型是字符串，通过别名的方式配置扩展插件，常用的插件有： 监控统计用的filter:stat 日志用的filter:log4j 防御sql注入的filter:wall |
| proxyFilters                  |                    | 类型是List<com.alibaba.druid.filter.Filter>，如果同时配置了filters和proxyFilters，是组合关系，并非替换关系 |

## 8.2、配置数据源

1、添加上 Druid 数据源依赖。

```xml
<!-- https://mvnrepository.com/artifact/com.alibaba/druid -->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.1.12</version>
</dependency>
123456
```

2、切换数据源；之前已经说过 Spring Boot 2.0 以上默认使用 com.zaxxer.hikari.HikariDataSource 数据源，但可以 通过 spring.datasource.type 指定数据源。

```yml
spring:
  datasource:
    username: root
    password: 123456
    url: jdbc:mysql://localhost:3306/springboot?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource # 自定义数据源
1234567
```

3、数据源切换之后，在测试类中注入 DataSource，然后获取到它，输出一看便知是否成功切换；

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWcyMDIwLmNuYmxvZ3MuY29tL2Jsb2cvMTkwNTA1My8yMDIwMDQvMTkwNTA1My0yMDIwMDQxMjIyMzk0MjA5MS01OTg4OTI1NDYucG5n?x-oss-process=image/format,png)

4、切换成功！既然切换成功，就可以设置数据源连接初始化大小、最大连接数、等待时间、最小连接数 等设置项；可以查看源码

```yml
spring:
  datasource:
    username: root
    password: 123456
    #?serverTimezone=UTC解决时区的报错
    url: jdbc:mysql://localhost:3306/springboot?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8
    driver-class-name: com.mysql.cj.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource

    #Spring Boot 默认是不注入这些属性值的，需要自己绑定
    #druid 数据源专有配置
    initialSize: 5
    minIdle: 5
    maxActive: 20
    maxWait: 60000
    timeBetweenEvictionRunsMillis: 60000
    minEvictableIdleTimeMillis: 300000
    validationQuery: SELECT 1 FROM DUAL
    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    poolPreparedStatements: true

    #配置监控统计拦截的filters，stat:监控统计、log4j：日志记录、wall：防御sql注入
    #如果允许时报错  java.lang.ClassNotFoundException: org.apache.log4j.Priority
    #则导入 log4j 依赖即可，Maven 地址：https://mvnrepository.com/artifact/log4j/log4j
    filters: stat,wall,log4j
    maxPoolPreparedStatementPerConnectionSize: 20
    useGlobalDataSourceStat: true
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500
123456789101112131415161718192021222324252627282930
```

5、导入Log4j 的依赖

```xml
        <!-- https://mvnrepository.com/artifact/log4j/log4j -->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
123456
```

6、现在需要程序员自己为 DruidDataSource 绑定全局配置文件中的参数，再添加到容器中，而不再使用 Spring Boot 的自动生成了；我们需要 自己添加 DruidDataSource 组件到容器中，并绑定属性；

```java
package com.kuang.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DruidConfig {

    /*
       将自定义的 Druid数据源添加到容器中，不再让 Spring Boot 自动创建
       绑定全局配置文件中的 druid 数据源属性到 com.alibaba.druid.pool.DruidDataSource从而让它们生效
       @ConfigurationProperties(prefix = "spring.datasource")：作用就是将 全局配置文件中
       前缀为 spring.datasource的属性值注入到 com.alibaba.druid.pool.DruidDataSource 的同名参数中
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

}
12345678910111213141516171819202122232425
```

7、去测试类中测试一下；看是否成功！

```java
@SpringBootTest
class SpringbootDataJdbcApplicationTests {

    //DI注入数据源
    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() throws SQLException {
        //看一下默认数据源
        System.out.println(dataSource.getClass());
        //获得连接
        Connection connection =   dataSource.getConnection();
        System.out.println(connection);

        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
        System.out.println("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());

        //关闭连接
        connection.close();
    }
}
1234567891011121314151617181920212223
```

输出结果 ：可见配置参数已经生效！

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWcyMDIwLmNuYmxvZ3MuY29tL2Jsb2cvMTkwNTA1My8yMDIwMDQvMTkwNTA1My0yMDIwMDQxMjIyNDAzNTcwNi0xMjgwOTI3NTU3LnBuZw?x-oss-process=image/format,png)

## 8.3、配置Druid数据源监控

Druid 数据源具有监控的功能，并提供了一个 web 界面方便用户查看，类似安装 路由器 时，人家也提供了一个默认的 web 页面。

所以第一步需要设置 Druid 的后台管理页面，比如 登录账号、密码 等；配置后台管理；

```java
//配置 Druid 监控管理后台的Servlet；
//内置 Servlet 容器时没有web.xml文件，所以使用 Spring Boot 的注册 Servlet 方式
@Bean
public ServletRegistrationBean statViewServlet() {
    ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

    // 这些参数可以在 com.alibaba.druid.support.http.StatViewServlet 
    // 的父类 com.alibaba.druid.support.http.ResourceServlet 中找到
    Map<String, String> initParams = new HashMap<>();
    initParams.put("loginUsername", "admin"); //后台管理界面的登录账号
    initParams.put("loginPassword", "123456"); //后台管理界面的登录密码

    //后台允许谁可以访问
    //initParams.put("allow", "localhost")：表示只有本机可以访问
    //initParams.put("allow", "")：为空或者为null时，表示允许所有访问
    initParams.put("allow", "");
    //deny：Druid 后台拒绝谁访问
    //initParams.put("kuangshen", "192.168.1.20");表示禁止此ip访问

    //设置初始化参数
    bean.setInitParameters(initParams);
    return bean;
}
1234567891011121314151617181920212223
```

配置完毕后，我们可以选择访问 ：http://localhost:8080/druid/login.html

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWcyMDIwLmNuYmxvZ3MuY29tL2Jsb2cvMTkwNTA1My8yMDIwMDQvMTkwNTA1My0yMDIwMDQxMjIyNDExMjQ3MS02NDY4MjkwNDEucG5n?x-oss-process=image/format,png)

进入之后

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWcyMDIwLmNuYmxvZ3MuY29tL2Jsb2cvMTkwNTA1My8yMDIwMDQvMTkwNTA1My0yMDIwMDQxMjIyNDEzMTAxMC0xMjk2MzYzMS5wbmc?x-oss-process=image/format,png)

**配置 Druid web 监控 filter 过滤器**

```java
//配置 Druid 监控 之  web 监控的 filter
//WebStatFilter：用于配置Web和Druid数据源之间的管理关联监控统计
@Bean
public FilterRegistrationBean webStatFilter() {
    FilterRegistrationBean bean = new FilterRegistrationBean();
    bean.setFilter(new WebStatFilter());

    //exclusions：设置哪些请求进行过滤排除掉，从而不进行统计
    Map<String, String> initParams = new HashMap<>();
    initParams.put("exclusions", "*.js,*.css,/druid/*,/jdbc/*");
    bean.setInitParameters(initParams);

    //"/*" 表示过滤所有请求
    bean.setUrlPatterns(Arrays.asList("/*"));
    return bean;
}
12345678910111213141516
```

平时在工作中，按需求进行配置即可，主要用作监















































