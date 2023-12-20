package anudip.EstatesGo;

import estatesGo.Entity.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;



public class App {
    public static void main(String[] args) {
        Configuration conf = new Configuration().configure()
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Admin.class)
                .addAnnotatedClass(Agent.class)
                .addAnnotatedClass(Appointment.class)
                .addAnnotatedClass(Property.class);

        SessionFactory ss = conf.buildSessionFactory();
        Session s = ss.openSession();
        Transaction t = s.beginTransaction();

        try {
            // Create instances of Customer, Admin, Agent, Appointment, Property,
            Customer customer = new Customer();
            customer.setCname("kunal");
            customer.setContact("99998888");
            customer.setCemail("kunal@gmail.com");
            customer.setUsername("kkk");
            customer.setPassword("bhuklgi");

            Admin admin = new Admin();
            admin.setName("Admin");
            admin.setContact("9876543210");
            admin.setAddress("Admin Address");
            admin.setEmail("admin@gmail.com");
            admin.setUsername("adminser");
            admin.setPassword("admord");

            Agent agent = new Agent();
            agent.setName("Pratik");
            agent.setContact(987664531);
            agent.setAddress("Agent Address");
            agent.setEmail("pratik@email.com");
            agent.setUsername("Pratikser");
            agent.setPassword("pratikord");

            Property property = new Property();
            property.setName("Gorewada");
            property.setDescription("god and nice");
            property.setPrice(100000);
            property.setStatus("Available");

            Appointment appointment = new Appointment();
            appointment.setDescription("Meeting for Sample Property");
            appointment.setDate("2023-01-01");
            appointment.setCustomer(customer);
            appointment.setAgent(agent);
            appointment.setAdmin(admin);
            appointment.setStatus("Scheduled");

            // Save entities
            s.save(customer);
            s.save(admin);
            s.save(agent);
            s.save(property);
            s.save(appointment);

            t.commit();
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
            e.printStackTrace();
        } finally {
            s.close();
            ss.close();
        }
    }
}
