package model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.entity.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-29T14:12:52")
@StaticMetamodel(Meddelandet.class)
public class Meddelandet_ { 

    public static volatile SingularAttribute<Meddelandet, User> reciever;
    public static volatile SingularAttribute<Meddelandet, User> sender;
    public static volatile SingularAttribute<Meddelandet, String> subject;
    public static volatile SingularAttribute<Meddelandet, Integer> id;
    public static volatile SingularAttribute<Meddelandet, String> content;

}