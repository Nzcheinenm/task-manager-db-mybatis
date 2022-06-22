package ru.t1.dkononov.tm.service;


import ru.t1.dkononov.tm.api.ITaskRepository;
import ru.t1.dkononov.tm.api.ITaskService;
import ru.t1.dkononov.tm.model.Task;
import ru.t1.dkononov.tm.repository.TaskRepository;

import java.util.List;

public class TaskService implements ITaskService {

    private ITaskRepository taskRepository;

    public TaskService(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task create(String name, String description) {
        if(name == null) return null;
        if(description == null) return null;
        Task task = new Task();
        task.setName(name);
        task.setDescription(description);
        add(task);
        return task;
    }

    @Override
    public Task add(final Task project) {
        if(project == null) return null;
        return taskRepository.add(project);
    }

    @Override
    public void clear() {
        taskRepository.clear();
    }

}