package ru.t1.dkononov.tm.command.task;

import ru.t1.dkononov.tm.exception.field.AbstractFieldException;
import ru.t1.dkononov.tm.util.TerminalUtil;

public final class TaskRemoveByIdCommand extends AbstractTaskCommand {

    public static final String NAME = "task-remove-by-id";

    public static final String DESCRIPTION = "Удалить задачу по Id.";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void execute() throws AbstractFieldException {
        System.out.println("[ENTER ID]");
        final String value = TerminalUtil.inLine();
        getTaskService().removeById(value);
    }

}