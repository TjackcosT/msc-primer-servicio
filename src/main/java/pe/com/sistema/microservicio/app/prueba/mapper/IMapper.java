package pe.com.sistema.microservicio.app.prueba.mapper;

public interface IMapper<I, O>{
    public O map(I in);
}
