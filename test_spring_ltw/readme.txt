
* Tomcat 6.0.x或者更高版本

 1、复制org.springframework.instrument.tomcat.jar到$CATALINA_HOME/lib目录下（$CATALINA_HOME 是tomcat安装的根目录）          http://maven.outofmemory.cn/org.springframework/spring-instrument-tomcat/
 2、修改tomcat的默认类加载器为自定义类加载器需要配置应用的context文件
     <Context path="/myWebApp" docBase="/my/webApp/location">
        <Loader
            loaderClass="org.springframework.instrument.classloading.tomcat.TomcatInstrumentableClassLoader"/>
     </Context>
     Apache Tomcat 6.0.x（类似于5.0.x/5.5.x）系列支持多种context配置路径：
         服务器的配置文件 $CATALINA_HOME/conf/server.xml
         默认的context配置文件 $CATALINA_HOME/conf/context.xml （这个配置文件会影响所有的应用）
         每个应用独立的配置文件，可以是在服务端 $CATALINA_HOME/conf/[enginename]/[hostname]/[webapp]-context.xml ； 可以是在web应用的工程目录下 META-INF/context.xml

     推荐使用第三种方式中把配置文件放在web应该的工程目录下，这样配置文件只会被使用它的应用打包，不需要修改服务端的配置
