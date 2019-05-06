package lt.vu.usecases.cdi.security;

import lombok.Getter;
import javax.enterprise.inject.Model;

@Model
public class SecureBean {

    @Getter
    private String result = "Press the button!!!";

}
