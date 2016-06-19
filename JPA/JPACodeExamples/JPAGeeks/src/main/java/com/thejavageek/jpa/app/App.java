/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thejavageek.jpa.app;

import com.jpa.my.entities.Company;
import com.thejavageek.jpa.entities.Department;
import com.thejavageek.jpa.entities.Department_;
import com.thejavageek.jpa.entities.Desk;
import com.thejavageek.jpa.entities.Desk_;
import com.thejavageek.jpa.entities.Employee;
import com.thejavageek.jpa.entities.Employee_;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

/**
 *
 * @author SanghviR
 */
public class App {

    private EntityManager entityManager;

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPAGeeks");
        EntityManager entityManager = factory.createEntityManager();
        App app = new App();
        app.entityManager = entityManager;
        
        
        //Executing using Method References
        app.transactionManager(app::cpnyDepEmpInserts);
        app.transactionManager(app::cpnyDepEmpSelect);
        entityManager.close();
        factory.close();
        
        //Below steps are regular 
        //Regular Start ********************************************************
//        EntityTransaction transaction = entityManager.getTransaction();
//        try {

//            transaction.begin();
//            //associations
//            //app.associations(entityManager);
//
//            //inserts
//            //app.inserts();
//            //app.criteria();
//            //app.JPQL();
//            app.cpnyDepEmpInserts();
//            app.cpnyDepEmpSelect();
//            transaction.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            transaction.rollback();
//        } finally {
//
//            entityManager.close();
//            factory.close();
//        }
        
        //Regular End ********************************************************

    }

    private void associations(EntityManager em) {

        Employee e = em.find(Employee.class, 1);

        System.out.println("The first name is " + e.getFirstname());
        e.setFirstname("Apeksha");
        em.remove(e);
//        Employee e = new Employee();
//        e.setFirstname("Rahul");
//
//        Project p = new Project();
//        p.setName("Electrical");
////        p.setIdproject(1);
////        em.merge(p);
//        List<Project> ls = new ArrayList<>();
//        ls.add(p);
//
//        e.setProjects(ls);
//        em.persist(e);

    }

    private void criteria() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Employee> cr = builder.createQuery(Employee.class);
        Root<Employee> employeeFrom = cr.from(Employee.class);

        cr.where(builder.equal(employeeFrom.get(Employee_.firstname), "Rahul"));

        TypedQuery<Employee> type = entityManager.createQuery(cr);
        Employee e = type.getSingleResult();
        System.err.println("The name is " + e.getFirstname());

        //using joins
        CriteriaQuery<Object[]> cq = builder.createQuery(Object[].class);
        Root<Employee> E = cq.from(Employee.class);
        Join<Employee, Department> D = E.join(Employee_.department);
        Join<Employee, Desk> desk = E.join(Employee_.desk);

        cq.multiselect(E.get(Employee_.firstname), D.get(Department_.name), desk.get(Desk_.number)).
                where(builder.like(E.get(Employee_.firstname), "%Rahul%"));
        Object[] results = entityManager.createQuery(cq).getSingleResult();
        Arrays.asList(results).forEach((obj) -> System.err.println("The result is " + obj));

    }

    private void JPQL() {
        Query q = entityManager.createQuery("SELECT E.firstname , ED.name , EDE.number FROM Employee AS INNER JOIN E.department AS ED INNER JOIN E.desk AS EDE WHERE E.firstname = 'Rahul' ");
        Object[] results = (Object[]) q.getSingleResult();
        System.out.println("The first name is " + results[0]);
    }

    private void inserts() {
        Department maths = new Department();
        maths.setName("Mathematics");

        Department science = new Department();
        science.setName("Science");

        Employee e1 = new Employee();
        e1.setFirstname("Rahul");
        e1.setDepartment(maths);

        Employee e2 = new Employee();
        e2.setFirstname("Apeksha");
        e2.setDepartment(science);

        Desk desk = new Desk();
        desk.setLocation("Hyderabad");
        desk.setNumber(143);
        e1.setDesk(desk);
        entityManager.persist(desk);
        entityManager.persist(e1);
        entityManager.persist(e2);
    }

    private void cpnyDepEmpInserts() {

        Company tcs = new Company();
        tcs.setCpnyName("Tata Consultany Company");

        Company infy = new Company();
        infy.setCpnyName("Infosys");

        Department java = new Department();
        java.setCompany(infy);
        java.setName("JAVA");

        Department net = new Department();
        net.setCompany(infy);
        net.setName("Net");

        Department mainframe = new Department();
        mainframe.setCompany(tcs);
        mainframe.setName("Mainframe");

        Employee java1 = new Employee();
        java1.setFirstname("JAVA1");
        java1.setDepartment(java);

        Employee java2 = new Employee();
        java2.setFirstname("JAVA2");
        java2.setDepartment(java);

        Employee net1 = new Employee();
        net1.setFirstname("Net1");
        net1.setDepartment(net);

        entityManager.persist(java1);
        entityManager.persist(java2);
        entityManager.persist(net1);
        //entityManager.persist(mainframe);

        entityManager.persist(tcs);
        
        throw new RuntimeException("Testing transaction rollback");

    }

    private void cpnyDepEmpSelect() {
        
        //sql -- select c.cpnyname , d.name , e.firstname from employee e inner join department d on e.iddepartment = d.iddepartment 
        //right join company c on d.company_companyid = c.companyid
        //where c.cpnyname = 'Infosys'
        //joins are executed in the order in which they are specified. The resultset from previous join goes as input for next join. Where clause works on the entire join
        //***************JPQL Start ***********//
        //Query select = entityManager.createQuery("SELECT C.cpnyName , D.name ,E.firstname FROM Employee E INNER JOIN E.department D RIGHT JOIN D.company C");
        //select.getResultList().forEach(MethodRef::methRef);
        //***************JPQL End ***********//
        //************Criteria Start ***************//
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        //Specifies the expected resut datatype
        CriteriaQuery<Object[]> criteria = cb.createQuery(Object[].class);

        //from clause of query
        Root<Employee> E = criteria.from(Employee.class);

        //first join 
        Join<Employee, Department> D = E.join(Employee_.department, JoinType.INNER);
        //Issue http://docs.oracle.com/javaee/6/api/javax/persistence/criteria/JoinType.html
        //Join<Department, Company> C = D.join(Department_.company, JoinType.RIGHT);

        //select clause
        //criteria.multiselect(C.get(Company_.cpnyName), D.get(Department_.name), E.get("firstname"));
        //List<Object[]> ls = entityManager.createQuery(criteria).getResultList();
        //************Criteria End ***************//
        //Native Query
        Query select = entityManager.createNativeQuery("select c.cpnyname ,d.name , e.firstname from Company c left join (department d join employee e on d.iddepartment = e.iddepartment) on c.companyid = d.company_companyid");

        List<Object[]> ls = select.getResultList();
        String space = "  ";
        StringBuilder sb = new StringBuilder();

        ls.forEach((action) -> {
            //action is an object[] obtained from list.

            //This doesn't work out because local variables referenced in lambda expressions are effectively final.
            //space = "Apeksha";
            for (Object object : action) {
                sb.append(object).append(space);
            }
            sb.append("\n");
        });
        System.out.println("The outcome is ");
        System.out.println("-----------------");
        System.out.println(sb.toString());
        
    }

    private void transactionManager(VoidNoArgsFunction func) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            func.execute();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();

        }
    }

}

class MethodRef {

    static <T> void methRef(T t) {
        Object[] o = (Object[]) t;
        Arrays.asList(o).forEach((action) -> System.out.println("The value returned " + action));
    }
}

@FunctionalInterface
interface VoidNoArgsFunction {

    void execute();
}

//Relationships finish with “One” will be EAGERly fetched: @OneToOne and @ManyToOne.
//Relationships finish with “Many” will be LAZYly fetched: @OneToMany and @ManyToMany
