package Task_Management_System.Code;

public class TaskManagementSystem {
    static class Task {
        int taskId;
        String taskName;
        String status;
        Task next;

        public Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
            this.next = null;
        }

        @Override
        public String toString() {
            return String.format("Task{id=%d, name='%s', status='%s'}", taskId, taskName, status);
        }
    }

    private Task head;

    public void addTask(int taskId, String taskName, String status) {
        Task newTask = new Task(taskId, taskName, status);
        newTask.next = head;
        head = newTask;
    }

    public Task searchTask(int taskId) {
        Task current = head;
        while (current != null) {
            if (current.taskId == taskId) return current;
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        Task current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public boolean deleteTask(int taskId) {
        Task current = head, prev = null;
        while (current != null) {
            if (current.taskId == taskId) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Task\n2. Search Task\n3. Traverse Tasks\n4. Delete Task\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Task Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Status: ");
                    String status = scanner.nextLine();
                    tms.addTask(id, name, status);
                    System.out.println("Task added.");
                    break;
                case 2:
                    System.out.print("Enter Task ID to search: ");
                    int sid = scanner.nextInt();
                    Task found = tms.searchTask(sid);
                    if (found != null) System.out.println(found);
                    else System.out.println("Task not found.");
                    break;
                case 3:
                    tms.traverseTasks();
                    break;
                case 4:
                    System.out.print("Enter Task ID to delete: ");
                    int did = scanner.nextInt();
                    if (tms.deleteTask(did)) System.out.println("Task deleted.");
                    else System.out.println("Task not found.");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
