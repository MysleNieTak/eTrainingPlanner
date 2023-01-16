package hibernate.eTrainingPlanner;

import hibernate.eTrainingPlanner.model.Trainee;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ServiceAddTrainee implements CommandService {

    @Override
    public String getCommand() {
        return "add new trainee";
    }

    public void commandService() {
        System.out.println("Please provide trainee's first name:");
        String name = Main.scanner.nextLine();

        System.out.println("Please provide trainee's surname:");
        String surname = Main.scanner.nextLine();

        System.out.println("Please provide trainee's email address:");
        String email = Main.scanner.nextLine();

        Trainee trainee = Trainee.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .build();

        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(trainee);
            System.out.println("New trainee added successfully!");

            transaction.commit();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }
}
