package funciones;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectOutputStreamAPS extends ObjectOutputStream {
    
	public ObjectOutputStreamAPS () throws IOException {
		super();
	}
	
    public ObjectOutputStreamAPS(OutputStream out) throws IOException {
        super(out);
    }
    
    @Override
    protected void writeStreamHeader() throws IOException {
        // No se escribe la cabecera con metadatos
    }
    
}
