package model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.entity.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-29T14:12:52")
@StaticMetamodel(Log.class)
public class Log_ { 

    public static volatile SingularAttribute<Log, User> fromuser;
    public static volatile SingularAttribute<Log, Integer> id;
    public static volatile SingularAttribute<Log, String> content;

}