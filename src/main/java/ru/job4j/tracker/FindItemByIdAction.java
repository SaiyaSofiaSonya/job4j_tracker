package ru.job4j.tracker;

public class FindItemByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find item by id ====");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        boolean run = item != null;
        if (run) {
                System.out.println(item);
        } else {
            System.out.println("Заявка с введенным id: " + id + " не найдена.");
        }
        return run;
    }
}