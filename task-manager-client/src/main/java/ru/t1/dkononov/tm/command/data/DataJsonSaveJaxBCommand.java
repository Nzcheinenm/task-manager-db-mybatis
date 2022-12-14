package ru.t1.dkononov.tm.command.data;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.t1.dkononov.tm.dto.request.DataJsonSaveJaxBRequest;
import ru.t1.dkononov.tm.enumerated.Role;

public final class DataJsonSaveJaxBCommand extends AbstractDataCommand {

    @NotNull
    public static final String DESCRIPTION = "Сохранить данные в json jaxB файл.";

    @NotNull
    public static final String NAME = "data-save-json-jaxb";

    @Override
    public @Nullable String getARGUMENT() {
        return null;
    }

    @Override
    public @NotNull String getDESCRIPTION() {
        return DESCRIPTION;
    }

    @Override
    public @NotNull String getNAME() {
        return NAME;
    }

    @Override
    public void execute() throws Exception {
        System.out.println("[DATA SAVE JSON]");
        @NotNull final DataJsonSaveJaxBRequest request = new DataJsonSaveJaxBRequest(getToken());
        getDomainEndpoint().saveDataJsonJaxB(request);
    }

    @Override
    public @Nullable Role[] getRoles() {
        return new Role[]{Role.ADMIN};
    }

}
