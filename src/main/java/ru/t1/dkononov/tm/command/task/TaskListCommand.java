package ru.t1.dkononov.tm.command.task;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.t1.dkononov.tm.enumerated.Sort;
import ru.t1.dkononov.tm.exception.AbstractException;
import ru.t1.dkononov.tm.model.Task;
import ru.t1.dkononov.tm.util.TerminalUtil;

import java.util.Arrays;
import java.util.List;

public final class TaskListCommand extends AbstractTaskCommand {

    @Getter
    @NotNull
    public final String NAME = "task-list";

    @Getter
    @NotNull
    public final String DESCRIPTION = "Вывести список задач.";

    @Override
    public void execute() throws AbstractException {
        @Nullable final String userId = getUserId();
        System.out.println("[SHOW TASKS]");
        System.out.println("[ENTER SORT: ]");
        System.out.println(Arrays.toString(Sort.values()));
        @NotNull final String sortType = TerminalUtil.inLine();
        @Nullable final Sort sort = Sort.toSort(sortType);
        @NotNull final List<Task> tasks = getTaskService().findAll(userId, sort);
        showTasks(tasks);
    }

    public void showTasks(@NotNull final List<Task> tasks) {
        int index = 1;
        for (@Nullable final Task task : tasks) {
            if (task == null) continue;
            System.out.println(index + ". " + show(task));
            index++;
        }
    }

    public String show(@NotNull final Task task) {
        return "[ID: " + task.getId() + "]\n" +
                "[NAME: " + task.getName() + "]\n" +
                "[DESC: " + task.getDescription() + "]\n" +
                "[STATUS: " + task.getStatus() + "]";
    }

}
