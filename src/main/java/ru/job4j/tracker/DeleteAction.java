package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        int id = input.askInt("Enter id: ");
        boolean run = tracker.delete(id);
        if(!run) {
            System.out.println("Ошибка удаления заявки.");
        } else {
            System.out.println("Заявка удалена успешно.");
        }
        return run;
    }
}
