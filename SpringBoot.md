# Spring Boot配置

### 主启动类注解

```Java
@SpringBootConfiguration： Springboot的配置
 		@Documented： 说明这是一个spring组件		
		@Configuration： spring配置类
		
@EnableAutoConfiguration： 自动导入配置
		@AutoConfigurationPackage： 自动配置包
		@Import({AutoConfigurationImportSelector.class})： 自动配置导入选择
		
//获取所有的配置
List<String> configurations = this.getCandidateConfigurations(annotationMetadata, attributes);

```

### 配置文件注解

```java
@PropertySource ：加载指定的配置文件
	例：@PropertySource(value = "classpath:application.yml")
    
@configurationProperties：默认从全局配置文件中获取值
    例：@ConfigurationProperties(prefix = "person") 
    
@Autowired: 自动化装配
```

### 自动配置注解

```java
//表示这是一个配置类
@Configuration(
    proxyBeanMethods = false
)

//自动配置属性
@EnableConfigurationProperties({ServerProperties.class})

//以下三个均是spring的底层注解：根据不同的条件来判断当前配置或者类是否生效
@ConditionalOnWebApplication(
    type = Type.SERVLET
)
@ConditionalOnClass({CharacterEncodingFilter.class})
@ConditionalOnProperty(
    prefix = "server.servlet.encoding",
    value = {"enabled"},
    matchIfMissing = true
)

xxxxAutoConfigurartion：自动配置类；给容器中添加组件

xxxxProperties:封装配置文件中相关属性；
    
```

**<u>==通过配置debug=true来查看哪些自动配置类生效哪些是未生效的==</u>**

​		==**Positive matches:（自动配置类启用的：正匹配）**==

​		==**Negative matches:（没有启动，没有匹配成功的自动配置类：负匹配）**==

​		==**Unconditional classes: （没有条件的类）**==



# Spring Boot Web开发

<u>要解决的问题：导入静态资源、首页的问题、jsp-模板引擎Tyhmeleaf、装配扩展SpringMVC、增删改查、拦截器</u>

### 静态资源

```java
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    if (!this.resourceProperties.isAddMappings()) {
        logger.debug("Default resource handling disabled");
    } else {
        Duration cachePeriod = this.resourceProperties.getCache().getPeriod();
        CacheControl cacheControl = this.resourceProperties.getCache().getCachecontrol().toHttpCacheControl();
        if (!registry.hasMappingForPattern("/webjars/**")) {
            this.customizeResourceHandlerRegistration(registry.addResourceHandler(new String[]{"/webjars/**"}).addResourceLocations(new String[]{"classpath:/META-INF/resources/webjars/"}).setCachePeriod(this.getSeconds(cachePeriod)).setCacheControl(cacheControl));
        }

        String staticPathPattern = this.mvcProperties.getStaticPathPattern();
        if (!registry.hasMappingForPattern(staticPathPattern)) {
            this.customizeResourceHandlerRegistration(registry.addResourceHandler(new String[]{staticPathPattern}).addResourceLocations(WebMvcAutoConfiguration.getResourceLocations(this.resourceProperties.getStaticLocations())).setCachePeriod(this.getSeconds(cachePeriod)).setCacheControl(cacheControl));
        }

    }
}
```



