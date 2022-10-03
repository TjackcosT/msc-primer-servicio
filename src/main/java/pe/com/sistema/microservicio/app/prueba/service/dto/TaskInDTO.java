package pe.com.sistema.microservicio.app.prueba.service.dto;

import java.time.LocalDateTime;

public class TaskInDTO {

	private String title;
    private String description;
    private LocalDateTime eta;
    
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getEta() {
		return eta;
	}
	public void setEta(LocalDateTime eta) {
		this.eta = eta;
	}
	@Override
	public String toString() {
		return "TaskInDTO [title=" + title + ", description=" + description + ", eta=" + eta + "]";
	}    
}
