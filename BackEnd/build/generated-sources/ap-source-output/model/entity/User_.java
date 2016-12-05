package model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.entity.Log;
import model.entity.Meddelandet;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-29T14:12:52")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile ListAttribute<User, Meddelandet> meddelandetList;
    public static volatile SingularAttribute<User, String> password;
    public static volatile ListAttribute<User, Meddelandet> meddelandetList1;
    public static volatile SingularAttribute<User, String> name;
    public static volatile ListAttribute<User, Log> logList;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> confirmpassword;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;

}