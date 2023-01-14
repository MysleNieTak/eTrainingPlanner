package hibernate.eTrainingPlanner;

import hibernate.eTrainingPlanner.model.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        HibernateUtil.INSTANCE.getSessionFactory().openSession();

    }
}