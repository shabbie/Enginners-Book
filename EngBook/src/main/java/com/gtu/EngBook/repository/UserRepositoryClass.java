/*
package com.gtu.EngBook.repository;

import com.gtu.EngBook.model.UserModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryClass{


    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public boolean checkLogin(String email,String password) {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();

        Criteria userCriteria = session.createCriteria(UserModel.class);
        Conjunction and = Restrictions.conjunction();
        and.add(Restrictions.eq("email",email));
        and.add(Restrictions.eq("password",password));

        userCriteria.add(Restrictions.and(and));
        List<UserModel> listLogin = new ArrayList<UserModel>();
        listLogin = userCriteria.list();

        tx.commit();
        session.close();

        if(listLogin.isEmpty())
        return false;
        else {

            return true;
        }
    }
}
*/
