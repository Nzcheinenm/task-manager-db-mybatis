package ru.t1.dkononov.tm.command.project;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.t1.dkononov.tm.exception.field.AbstractFieldException;
import ru.t1.dkononov.tm.model.Project;
import ru.t1.dkononov.tm.util.TerminalUtil;

public final class ProjectShowByIdCommand extends AbstractProjectCommand {

    @Getter
    @NotNull
    public final String NAME = "project-show-by-id";

    @Getter
    @NotNull
    public final String DESCRIPTION = "Показать проект по Id.";


    @Override
    public void execute() throws AbstractFieldException {
        final String userId = getUserId();
        System.out.println("[SHOW PROJECT]");
        System.out.println("[ENTER ID]");
        final String scanner = TerminalUtil.inLine();
        final Project project = getProjectService().findById(userId, scanner);
        System.out.println(show(project));
    }

    public String show(final Project project) {
        return "[ID: " + project.getId() + "]\n" +
                "[NAME: " + project.getName() + "]\n" +
                "[DESC: " + project.getDescription() + "]\n" +
                "[STATUS: " + project.getStatus() + "]";
    }

}
