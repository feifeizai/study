#Springboot缓存的使用

##1.添加依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-cache</artifactId>
</dependency>
```

##2.缓存注解

### 2.1 @EnableCaching

**@EnableCaching: 注解要添加到主方法上, 代表开启基于注解的缓存**

```java
@EnableCaching//开启基于注解的缓存
@MapperScan("com.xhf.springboot.mapper")
@SpringBootApplication
public class SpringbootCache01Application {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootCache01Application.class, args);
	}
}
```

###2.2 @Cacheable 

```
@Cacheable: 注解代表将运行结果缓存, 后边要相同的数据, 直接总缓存中取出, 不用调用方法
包含的几个属性:
	- chacheNames/value: 指缓存组件的名字;两者等效;参数时数组形式;
		cacheNames = {"emp","temp"}
	- key: 缓存数据使用的key;
		默认是使用参数的值作为key值;
		数据结构是key-value形式;
		也可以使用spel表达式, #id
	- keyGenerater: key的生成器; 也可以自己制定key的生成器的组件id
		注意key和keyGenerater只能二选一
	- cacheManager:指定缓存管理器;或者cacheResolver指定获取解析器;两者也是二选一;
	- condition: 指定复合条件的情况下才缓存;
		condition="#id>0",只有id大于0时才缓存
	- unless: true时方法的返回值就不会被缓存;false时缓存;可以获得结果进行判断
		例如: condition="#id>0", unless="#result==null" 当id>0并且返回的结果不为null时才缓存
	- sync: 是否使用异步模式
```



```java
@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Cacheable(cacheNames = {"emp"})
    public Employee getEmp(Integer id){
        System.out.println("查询id为:"+id+"的员工");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }
}
```

**自定义key的生成策略**

```java
@Configuration
public class MyConfig {
    //定义自己的缓存主键生成策略
    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator(){
        return new KeyGenerator(){
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                return method.getName()+"["+ Arrays.asList(objects).toString()+"]";
            }
        };
    }
}
	//设置key生成策略
	@Cacheable(cacheNames = {"emp"},keyGenerator = "myKeyGenerator")
    public Employee getEmp(Integer id){
        System.out.println("查询id为:"+id+"的员工");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }
```

### 2.3 @CachePut

```
@CachePut: 即调用方法修改数据, 又更新缓存数据;
	运行实际:
		1. 先调用方法;
		2. 将方法的结果缓存起来
		3. 参数和@Cacheable相同
```

```java
	//默认使用参数值作为key值	
	@Cacheable(cacheNames = {"emp"})
    public Employee getEmp(Integer id){
        System.out.println("查询id为:"+id+"的员工");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }
	//使用返回结果的id值作为key值
    @CachePut(value = "emp",key = "#result.id")
    public Employee updateEmp(Employee employee){
        System.out.println("更新员工:"+employee.toString());
        employeeMapper.updateEmp(employee);
        return employee;
    }
```

### 2.4 @CacheEvict

```
@CacheEvict: 清除缓存;
** 参数
	- allEntries: true删除所有的emp下的缓存, 默认false;
	- beforeInvocation: true: 是否在方法之前之前, 缓存的删除实在方法前还是方法后, 默认false;(区别如果这个方法报错了,那么就有区别了)
	
	
	@CacheEvict(value = "emp",key = "#id")
    public void delEmp(Integer id){
        System.out.println("清除员工:"+id);
        //employeeMapper.deleteEmpById(id);
        //return employee;
    }
```

### 2.5 @Caching

```java
// @Caching的源码如下, 包含了三个注解的功能
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Caching {
    Cacheable[] cacheable() default {};

    CachePut[] put() default {};

    CacheEvict[] evict() default {};
}
```

```java
@Caching(
            cacheable = {
                    @Cacheable(value = "emp",key = "#lastName")
            },
            put = {
                    @CachePut(value = "emp",key = "#result.id"),
                    @CachePut(value = "emp",key = "#result.email")
            }
    )
    public Employee getEmpByLastName(String lastName){
        Employee emp = employeeMapper.getEmpByLastName(lastName);
        return emp;
    }
// 根据name查询到的数据可以将数据根据id和email缓存到缓存中, 下次查询就不用到数据库了, 由于有put注解所以这个方法一定要执行
```

### 2.6 @CacheConfig

```
这个注解主要时给所有的缓存注解提供公共属性
@CacheConfig(cacheNames="emp")
@Service
public class EmployeeService {}
```

## 3. 切换缓存redis

```
springboot默认的缓存时concurrenthashmap, 现在要切换到redis
步骤:
	1. 引入依赖;
	<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-redis</artifactId>
    </dependency>
    2. 配置application.properties文件;
    	spring.redis.host=192.168.93.132
		spring.redis.port=6379
	3.引入类
	@Autowired
	StringRedisTemplate stringRedisTemplate;//操作key-value都是字符串的
	@Autowired
	RedisTemplate redisTemplate;//操作key-value都是对象的
	
	@Test//操作字符串
	public void test(){
		//stringRedisTemplate.opsForValue().append("name","xiehongfei");
		stringRedisTemplate.opsForValue().set("pwd","bniwfen",100);
		String pwd = stringRedisTemplate.opsForValue().get("pwd");
		System.out.println("----->"+pwd);
	}
	@Test//操作对象
	public void test2(){
		Employee emp = employeeMapper.getEmpById(1);
		//默认使用jdk序列化方式保存数据
		redisTemplate.opsForValue().set("emp_01",emp);
		Object employee = redisTemplate.opsForValue().get("emp_01");
		System.out.println(employee.toString());
	}
	为了便于观察数据,我们采用json的序列化方式
	 //修改序列化规则
    @Bean
    public RedisTemplate<Object,Object> myRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Object> redisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        template.setDefaultSerializer(redisSerializer);
        return template;
    }
    
@Test
public void test2(){
    Employee emp = employeeMapper.getEmpById(1);
    //默认使用jdk序列化方式保存数据, 我们使用json格式所以自定义了myRedisTemplate
    myRedisTemplate.opsForValue().set("emp_02",emp,100);
    Object emp_01 = myRedisTemplate.opsForValue().get("emp_02");
    System.out.println(emp_01.toString());
}

```

