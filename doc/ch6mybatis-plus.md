
练习L11:配置数据库开发环境，使用MP完成User数据查询
1、pom.xml中添加mysql、mp、lombom依赖，lombok要安装插件；
2、application.yaml文件中配置数据源,注意application.yaml文件的位置；
3、新建User.class
4、新建UserMapper接口  extends BaseMapper<User>
5、启动类添加@MapperScan注解，指定Mapper路径
6、写测试用列，loadUser(1)