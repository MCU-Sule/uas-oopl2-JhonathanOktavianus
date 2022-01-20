package com.example.uas_1972046_JhonathanOktavianus.DAO;

import com.example.uas_1972046_JhonathanOktavianus.Entity.FePoint;
import com.example.uas_1972046_JhonathanOktavianus.Entity.FeTransaction;
import com.example.uas_1972046_JhonathanOktavianus.Utility.HibernateUtil;
import javafx.collections.FXCollections;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * 1972046 - Jhonathan Oktavianus
 */
public class PointDaoImpl implements DAOInterface<FePoint>{
    @Override
    public int addData(FePoint data) {
        return 0;
    }

    @Override
    public int updateData(FePoint data) {
        return 0;
    }

    @Override
    public List<FePoint> showData() {
        Session s = HibernateUtil.getSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(FePoint.class);
        query.from(FePoint.class);
        List<FePoint> pList = s.createQuery(query).getResultList();
        s.close();

        return FXCollections.observableArrayList(pList);
    }
}
