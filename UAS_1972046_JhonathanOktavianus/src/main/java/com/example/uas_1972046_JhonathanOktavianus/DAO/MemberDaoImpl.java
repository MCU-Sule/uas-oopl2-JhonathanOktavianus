package com.example.uas_1972046_JhonathanOktavianus.DAO;

import com.example.uas_1972046_JhonathanOktavianus.Entity.FeMember;
import com.example.uas_1972046_JhonathanOktavianus.Utility.HibernateUtil;
import javafx.collections.FXCollections;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * 1972046 - Jhonathan Oktavianus
 */
public class MemberDaoImpl implements DAOInterface<FeMember>{
    @Override
    public int addData(FeMember data) {
        Session s = HibernateUtil.getSession();

        Transaction t = s.beginTransaction();
        s.save(data);

        t.commit();
        s.close();
        return 0;
    }

    @Override
    public int updateData(FeMember data) {
        Session s = HibernateUtil.getSession();

        Transaction t = s.beginTransaction();
        s.update(data);

        t.commit();
        s.close();
        return 0;
    }

    @Override
    public List<FeMember> showData() {
        Session s = HibernateUtil.getSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(FeMember.class);
        query.from(FeMember.class);
        List<FeMember> mList = s.createQuery(query).getResultList();
        s.close();

        return FXCollections.observableArrayList(mList);
    }
}
