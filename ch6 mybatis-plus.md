
1、pom.xml中添加mysql、mp、lombom依赖
2、application.yaml文件中配置数据源
3、新建User.class
4、新建UserMapper接口  extends BaseMapper<User>
5、启动类添加@MapperScan注解，指定Mapper路径
6、写测试用列，loadUser(1)