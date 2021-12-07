public class Main {
    public static void main(String[] args) {

        var emp1 = new Employee(41, 4);

        System.out.println("emp1 work hours: \t" + emp1.getWorkHours());
        System.out.println("emp1 salary: \t\t" + emp1.getSalary());

        emp1.setWorkHours(42);
        System.out.println("emp1 work hours: \t" + emp1.getWorkHours());
        System.out.println("emp1 salary: \t\t" + emp1.getSalary());

        emp1.setWorkHours(62);
//        System.out.println("emp1 work hours: \t" + emp1.getWorkHours());
//        System.out.println("emp1 salary: \t\t" + emp1.getSalary());
    }
}
