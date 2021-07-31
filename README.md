
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

