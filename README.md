# demo-swagger-java
springboot结合swagger的例子
# 注意
* config为自定义的通过解析配置文件来配置swagger,默认解析`application-dev`配置文件,也就是`dev`环境的.如果需要修改,修改config/swagger中的`@Profile("dev")`
* swagger的apiinfo所用到的title和description使用的是`spring.application.name`和`spring.application.description`两个配置,没有的话会报错
