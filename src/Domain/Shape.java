package Domain;
import java.io.Serializable;


public interface Shape extends Serializable {
    String getNameOfShape();

    String getProperties();

    double getRadius();
    double getLength();
    double getWidth();
    double getHeight();


    void serialization(String filename);

    void deSerialization(String filename);

//    String getUniqueId();
    }


