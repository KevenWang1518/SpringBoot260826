SpringBoot07程序是相对比较完整的，有Service和Mapper，以及mapper.xml映射的项目。

SpringBoot09程序是更加完整的，有Controller、Service和Mapper，以及mapper.xml映射的项目。还加上了Web网页映射和mybatis逆向生成，以及切面操作日志。
            实现了SSM整合：Spring + SpringMVC + MyBatis
            Spring Boot项目本身就是基于Spring框架实现的。因此SSM整合时，只需要在整合MyBatis框架之后，引入web启动器即可完成SSM整合。
SpringBoot01
手动配置 web 包括两种方式：
● 第一种：配置文件方式（实际开发中，经常通过这种方式改变默认配置）
  ○ 通过修改application.properties或application.yml，添加spring.mvc和spring.web相关的配置。
● 第二种：编写代码方式（实际开发中，经常通过这种方式扩展新配置）
  ○ 编写一个类实现WebMvcConfigurer接口，并对应重写接口中的方法即可扩展新的配置。
    编写代码方式又包括两种方式：
  ● 第一种：编写类实现WebMvcConfigurer接口+@Configuration，重写对应的方法。
  ● 第二种：编写一个方法，用@Bean注解标注。

  SpringBoot13 线程池 异步方法

  SpringBoot14 swagger openAPI文档