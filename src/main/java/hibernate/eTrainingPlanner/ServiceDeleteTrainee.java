package hibernate.eTrainingPlanner;

import hibernate.eTrainingPlanner.model.Trainee;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ServiceDeleteTrainee implements CommandService {

    @Override
    public String getCommand() {
        return "delete trainee";
    }

    public void commandService() {
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            System.out.println("Provide ID of the trainee you want to remove:");
            String idString = Main.scanner.nextLine();
            Long traineeId = Long.parseLong(idString);

            Trainee trainee = session.get(Trainee.class, traineeId);
            if (trainee == null) {
                throw new EntityNotFoundException("Trainee with ID: " + traineeId + " not found. Please try again.");
            }

            session.remove(trainee);
            System.out.println("Trainee successfully deleted!");
            transaction.commit();

        }
        catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }
}
