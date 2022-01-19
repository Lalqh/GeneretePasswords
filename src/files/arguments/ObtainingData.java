package files.arguments;

import java.io.Serializable;

public class ObtainingData implements Serializable {

    private String passwordName;
    private String password;

    public ObtainingData(String passwordName, String password) {
        this.passwordName = passwordName;
        this.password = password;
    }

    public String getPasswordName() {
        return passwordName;
    }

    public void setPasswordName(String passwordName) {
        this.passwordName = passwordName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}