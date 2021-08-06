## Spring Cloud Gateway介绍

[Spring Cloud Gateway](https://docs.spring.io/spring-cloud-gateway/docs/current/reference/html/)是Spring Cloud官网推出的第二代网关框架，定位于取代Netfilix Zuul。旨在为微服务架构提供一种简单且有效的API路由的管理方式，并基于Filter的方式提供网关的基本功能，如路由转发、权限校验、限流等。

>  Spring Cloud Gateway是由WebFlux + Netty + Reactor实现的响应式API网关。它**不能在传统的servlet容器中工作，也不能构建成war包**。

### 核心概念

* 路由(route)：是网关中最基本的部分，路由信息包括一个ID、一个目录的URI、一组断言工厂、一组Filter组成。如果断言为真，则说明请求的URL和配置的路由匹配；
* 断言(predicates)：Java8中的断言函数，SpringCloudGateway中断言函数类型是Spring 5.0 框架中的ServerWebExchange。断言函数允许开发者去定义匹配Http reqest中的任何信息，比如请求头和参数等；
* 过滤器(Filter)：分为`Gateway Filter`和`Global Filter`。Filter可以对请求和响应进行处理。

## Start Demo

#### 导入依赖

在`pom.xml`文件中添加依赖项：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0">

    <dependencies>
        <!--   gateway 网关     -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-gateway</artifactId>
        </dependency>

        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
    </dependencies>
    
</project>
```

#### 添加配置文件

在资源文件下新建`application.yml`配置文件：

```yml
server:
  port: 8080

spring:
  application:
    name: demo-spring-cloud-gateway
  cloud:
    # 配置nacos注册中心地址
    nacos:
      discovery:
        server-addr: 127.0.0.1:8848

    # 配置网关信息
    gateway:
      discovery:
        locator:
          # 默认为False，设置为True开启通过微服务创建路由的功能，即可以通过微服务名称访问服务
          enabled: true
```

#### 启动类

```java
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
```