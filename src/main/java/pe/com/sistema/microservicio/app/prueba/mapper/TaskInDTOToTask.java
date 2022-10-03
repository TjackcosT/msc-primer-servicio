package pe.com.sistema.microservicio.app.prueba.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import pe.com.sistema.microservicio.app.prueba.persistence.entity.Task;
import pe.com.sistema.microservicio.app.prueba.persistence.entity.TaskStatus;
import pe.com.sistema.microservicio.app.prueba.service.dto.TaskInDTO;

@Component
public class TaskInDTOToTask implements IMapper<TaskInDTO, Task>{

	@Override
    public Task map(TaskInDTO in) {
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
        return task;
    }
	
}
