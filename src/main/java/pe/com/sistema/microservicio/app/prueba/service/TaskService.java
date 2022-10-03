package pe.com.sistema.microservicio.app.prueba.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import pe.com.sistema.microservicio.app.prueba.exceptions.ToDoExceptions;
import pe.com.sistema.microservicio.app.prueba.mapper.TaskInDTOToTask;
import pe.com.sistema.microservicio.app.prueba.persistence.entity.Task;
import pe.com.sistema.microservicio.app.prueba.persistence.entity.TaskStatus;
import pe.com.sistema.microservicio.app.prueba.persistence.repository.TaskRepository;
import pe.com.sistema.microservicio.app.prueba.service.dto.TaskInDTO;

@Service
public class TaskService {

	private final TaskRepository repository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDTO taskInDTO) {
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task);
    }

    public List<Task> findAll() {
        return this.repository.findAll();
    }

    public List<Task> findAllByTaskStatus(TaskStatus status) {
        return this.repository.findAllByTaskStatus(status);
    }

    @Transactional
    public void updateTaskAsFinished(Long id) {
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }

        this.repository.markTaskAsFinished(id);
    }

    public void deleteById(Long id) {
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }

        this.repository.deleteById(id);
    }
	
}
