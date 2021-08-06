
### 一、服务治理：Spring Cloud Eureka/Nacos

#### 介绍

* 作用：实现各个**微服务实例的自动化注册与发现**；
* 解决了什么问题：多个微服实例之间相互调用时，每个调用方都需记录被调方的地址列表，当服务越多时维护成本也增加。服务治理则是把所有实例地址都放到一个地方，当需要调用对方时，只需要从维护的地址列表中找到被调方地址即可，大大简化了服务地址维护问题。

    * 服务注册中心：每个服务单元向注册中心登记自己提供的服务，将主机与端口号、版本号、通信协议等一些附加信息告知注册中心，注册中心按服务名分类组织服务清单。
    * 服务发现：调用方向注册中心咨询服务，并获取所有服务的实例清单，以实现对具体服务实例的访问。

### 二、客户端负载均衡：Spring Cloud Ribbon

### 三、服务容错保护：Spring Cloud Hystrix

### 四、声明式服务调用：Spring Cloud Feign/OpenFeign

### 五、API网关服务：Spring Cloud Zuul/Gateway

### 六、分布式配置中心：Spring Cloud Config

### 七、消息总线：Spring Cloud Bus

### 八、消息驱动的微服务：Spring Cloud Stream

### 九、分布式服务跟踪：Spring Cloud Sleuth


## Nacos

* [nacos官网](https://nacos.io/zh-cn/index.html)
* [spring-cloud-alibaba 版本说明](https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E)

> 节点注册都注册到服务中心后，是不能直接通过对方的`服务名`进行调用的。

LoadBalanced与RestTemplate整合方式：

```java
public class RestConfig {

    /**
     * 第一种方式：直接在 restTemplate() 方法上加 @LoadBalanced 注解
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    
    /**
     * 第二种方式：在restTemplate过滤器中添加LoadBalancer
     */
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        LoadBalancerInterceptor interceptor = new LoadBalancerInterceptor(loadBalancerClient);
        restTemplate.setInterceptors(Collections.singletonList(interceptor));
        return restTemplate;
    }


    /**
     * 第三种方式：在请求地址中直接通过LoadBalancer来获取地址 
     */
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/echo/app-name")
    public String echoAppName(){
        //使用 LoadBalanceClient 和 RestTemolate 结合的方式来访问
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider");
        String url = String.format("http://%s:%s/echo/%s",serviceInstance.getHost(),serviceInstance.getPort(),appName);
        System.out.println("request url:"+url);
        return restTemplate.getForObject(url,String.class);
    }
}
```

