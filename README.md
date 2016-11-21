# spring

AppConfig 配置了Mybatis数据源相关信息，支持事务。 在使用事务的时候在方法上加上 @Transactional 注解

例如
@
public class UserService{

  @Autowired
  private UserDao userDao; 
  
  @Transactional
  public void update(){
    
  }
}
