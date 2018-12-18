package UIDAOcom;

import Entity.domain.Education;
import UI.UI;
import java.util.Scanner;

class UICommunicationDAOEducation {

    Scanner sc = new Scanner(System.in);

    public void switchEducation(UI ui, DAO.DAOEducationImpl dbe, DAO.DAOCourseImpl dbc) {
        switch (ui.educationMenu()) {
            case 1:
                Education e = dbe.createEducation(ui.enterName(" education "), ui.enterPoints());
                System.out.println("Do you want to add a course to the education? \nEnter 'yes' to add education, otherwise press any key to continue.");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("yes")) {
                    ui.printList(dbc.getAllCourses());
                    System.out.println("Enter the id for the course:");
                    dbe.addCourse(e.getEducationId(), ui.enterId("course"));
                } else {
                    break;
                }
                break;
            case 2:
                dbe.addCourse(ui.enterId("education"), ui.enterId("course"));
                break;
            case 3:
                System.out.println(dbe.getEducation(ui.enterId("education")));
                break;
            case 4:
                ui.printList(dbe.getEducationByName(ui.enterName(" education ")));
                break;
            case 5:
                ui.printList(dbe.getAllEducations());
                break;
            case 6:
                dbe.removeEducation(ui.enterId("education"));
                break;
            default:
                System.out.println("Wrong choice, try again. ");

        }
    }

}
