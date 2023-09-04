import java.util.*;

class SingularLinkedLists{

    static Scanner sc = new Scanner(System.in);
    static class StudentLists{
        static class Student{
            int rollno;
            String name;
            String Coursename;
            String Section;
            String Contacts;
            
            Student next;

            Student(){
                System.out.println("Enter the student's data : ===>");
                System.out.print("Name  :  ");
                this.name = sc.next();
                System.out.print("Roll no.  :  ");
                this.rollno = sc.nextInt();
                System.out.print("E-mail  :  ");
                this.Contacts = sc.next();
                System.out.print("Section  :  ");
                this.Section = sc.next();

                next = null;
            }
        }

        static Student head = null;
        static Student tail =  null;
        static int TotalStudents = 0;

        static void CreateLinkedList(){
            Student tempStudent = new Student();
            head = tempStudent;
            head.next = tempStudent;
            tail = tempStudent;
            TotalStudents++;
            System.out.println("List created successfully.");
        }

        
            void atBeginning(){
                if(head == null){
                    CreateLinkedList();
                }else{
                    Student tempStudent = new Student();
                    tempStudent.next = head.next;
                    head.next = tempStudent;
                    TotalStudents++;
                }
            }

            static void atEnd(){
                if (head ==  null){
                    CreateLinkedList();
                }else{
                    Student tempStudent = new Student();
                    tail = tempStudent;
                    tail.next = null;
                    TotalStudents++;
                }
            }

        void traverser(){
            Student temp = head;
            int i = 1;
            System.out.println("S.no    Roll No.    Name                Section     Course          Contacts");
            while(temp.next != null){
                System.out.println(   i+"    "+temp.rollno+"    "+temp.name+"               "+temp.Section+"    "+temp.Coursename+"         "+temp.Contacts);
                i++;
                temp = temp.next;
            }
        }

            void delete(){
                traverser();
                System.out.print("Enter the serial no. of a studet to delete : ");
                int choose = sc.nextInt();
                Student temp = head;
                for (int i=1; i<=choose-1; i++){
                    temp = temp.next;
                }
                if (choose == 1){
                    head = tail = null;
                    TotalStudents --;
                }else if(choose == TotalStudents){
                    tail = null;
                    TotalStudents--;
                }else{
                    Student temp2 = temp.next;
                    temp.next = temp2.next;
                    TotalStudents--;
                }
            }
    }


    public static void main(String[] args) {

        StudentLists ComputerScience = new StudentLists();
        System.out.println("Choose one of the following : ");
        System.out.println("1.  Add Student in the list.");
        System.out.println("2.  Delete a student from the list.");
        System.out.println("3.  Show the student's list");
        int c = sc.nextInt();
        switch(c){
            case 1:
                ComputerScience.atBeginning();
            case 2: 
                ComputerScience.delete();
            case 3:
                ComputerScience.traverser();
            case 4:
                return;
        }   
    }
}
