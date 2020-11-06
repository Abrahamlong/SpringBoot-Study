# Spring Boot



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
5. 有了自动配置类 ， 免去了我们手动编写配置注入功能组件等的工作；

**现在大家应该大概的了解了下，SpringBoot的运行原理，后面我们还会深化一次！**



### 2.5 run方法流程分析

<img src="https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWcyMDIwLmNuYmxvZ3MuY29tL2Jsb2cvMTkwNTA1My8yMDIwMDQvMTkwNTA1My0yMDIwMDQxMjIyMTEzNTExOS0xODQzMzIyMzUxLnBuZw?x-oss-process=image/format,png" alt="img" style="zoom:150%;" />
跟着源码和这幅图就可以一探究竟了！

























































