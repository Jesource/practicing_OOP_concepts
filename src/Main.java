public class Main {
    public static void main(String[] args) {

        var labourCodeLT = new LabourCode(40, 3.93, 60, 1.5);
        var labourCode_task1 = new LabourCode(40, 4, 60, 1.5);


        var emp1 = new Employee(41, 4, labourCode_task1);
        var emp2 = new Employee(19, 33, labourCode_task1);

        System.out.println(emp1.getSalary());
        System.out.println(emp2.getSalary());

    }
}
