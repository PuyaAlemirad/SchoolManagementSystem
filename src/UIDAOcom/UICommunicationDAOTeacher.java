package UIDAOcom;

import DAO.DAOCourseImpl;
import DAO.DAOTeacherImpl;
import Entity.domain.Teacher;
import UI.UI;
import java.util.Scanner;

public class UICommunicationDAOTeacher {

    Scanner sc = new Scanner(System.in);

    public boolean switchTeacher(UI ui, DAOTeacherImpl dbt, DAOCourseImpl dbc) {
        switch (ui.teacherMenu()) {
            case 1:
                Teacher t = dbt.createTeacher(ui.enterId("teacher"), ui.enterName(" teachers first "), ui.enterName(" teachers last "), ui.enterGender(), ui.enterSalary());
                System.out.println("Do you want to make the teacher a supervisor for a course? \nEnter 'yes' to add a course, otherwise press any key to continue.");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("yes")) {
                    ui.printList(dbc.getAllCourses());
                    System.out.println("Enter the id for the course:");
                    dbt.updateTeacherCourse(t.getPersonId(), ui.enterId("course"));

                }
                ui.enterToContinue();
                break;

            case 2:
                ui.printList(dbc.getAllCourses());
                dbt.updateTeacherCourse(ui.enterId("teacher"), ui.enterId("course"));
                ui.enterToContinue();
                break;

            case 3:
                System.out.println(dbt.getTeacher(ui.enterId("teacher")));
                ui.enterToContinue();
                break;

            case 4:
                ui.printList(dbt.getTeacherByName(ui.enterName(" teacher ")));
                ui.enterToContinue();
                break;

            case 5:
                ui.printList(dbt.getAllTeachers());
                ui.enterToContinue();
                break;

            case 6:
                dbt.updateTeacherSalary(ui.enterId("teacher"), ui.enterSalary());
                ui.enterToContinue();
                break;

            case 7:
                dbt.removeTeacher(ui.enterId("teacher"));
                ui.enterToContinue();
                break;

            case 0:
                return false;

            default:
                System.out.println("Wrong choice");
                break;
        }
        return true;
    }

}
