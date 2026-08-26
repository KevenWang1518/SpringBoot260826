手动开发第一个SpringBoot应用。
1.创建一个空的工程。
2.设置JDK
3.设置maven
4.新建一个全新的maven模块

5.在pom.xml文件中添加:
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.16</version>
    </parent>
它是一个启动器。这个启动器的名字是:parent
称为 springboot parent starter
凭什么继承它，为什么?
使用父项目中规定的依赖版本。比较方便。

6.在pom.xml文件中添加web开发所需要的启动器:
   <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
   </dependency>

7.编写Controller
    @RestController
    public class HelloController {
        @GetMapping("/hello")
        public String hello() {
            return "Hello SpringBoot";
        }
    }
8.编写SpringBoot的核心入口程序(main方法)