package ru.t1.dkononov.tm.command.user;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.t1.dkononov.tm.enumerated.Role;
import ru.t1.dkononov.tm.exception.AbstractException;
import ru.t1.dkononov.tm.util.TerminalUtil;

public final class UserUnlockCommand extends AbstractUserCommand{

    @Getter
    @NotNull
    private final String DESCRIPTION = "user unlock";

    @Getter
    @NotNull
    private final String NAME = "user-unlock";

    @Override
    public void execute() throws AbstractException {
        System.out.println("[USER UNLOCK]");
        System.out.println("ENTER LOGIN:");
        @NotNull final String login = TerminalUtil.inLine();
        serviceLocator.getUserService().unlockUserByLogin(login);
    }

    @Nullable
    @Override
    public Role[] getRoles() {
        return new Role[] { Role.ADMIN };
    }

}
