package exception;

import com.sun.xml.bind.api.Bridge;
import com.sun.xml.ws.api.model.CheckedException;
import com.sun.xml.ws.api.model.ExceptionType;
import com.sun.xml.ws.api.model.JavaMethod;
import com.sun.xml.ws.api.model.SEIModel;

public class SalaInexistente extends Throwable implements CheckedException {


    @Override
    public SEIModel getOwner() {
        return null;
    }

    @Override
    public JavaMethod getParent() {
        return null;
    }

    @Override
    public Class getExceptionClass() {
        return null;
    }

    @Override
    public Class getDetailBean() {
        return null;
    }

    @Override
    public Bridge getBridge() {
        return null;
    }

    @Override
    public ExceptionType getExceptionType() {
        return ExceptionType.valueOf("NullPointerException");
    }

    @Override
    public String getMessageName() {
        return "Sala Inexistente";
    }
}
