package multimedia_2;
public class Multimedia {
    public String autor,titulo;
    public FORMATO formato;
    public int duracion;

    public Multimedia(String autor, String titulo, FORMATO formato, int duracion) {
        this.autor = autor;
        this.titulo = titulo;
        this.formato = formato;
        this.duracion = duracion;
    }
    
    public void Reproducir() throws InterruptedException{
        Thread.sleep(1000);
    }
}
