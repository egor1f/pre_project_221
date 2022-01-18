package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }
   @Override
   public User getCarInfo(String model, int series) {
      TypedQuery<User> query = sessionFactory.getCurrentSession()
              .createQuery("from User user where user.userCar.model = :param1 and user.userCar.series = :param2", User.class);
      query.setParameter("param1", model);
      query.setParameter("param2", series);
      List<User> results = query.getResultList();
      if (results.isEmpty()) {
         System.out.println("User not found");
      } else if (results.size() > 1) {
         System.out.println("There are more than one users");
      }
      return results.get(0);
   }
}
