package Domain;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public interface Shape extends Serializable {
    String getNameOfShape();

    String getProperties();

    void serialization(String filename);

    void deSerialization(String filename);
    }


