package services;

import com.mainpackage.dao.AdminDAOimpl;
import java.util.concurrent.atomic.AtomicReference;

public class AdminService {
    public void service(String login,String password,String button,AtomicReference<AdminDAOimpl> adminDAO) {
    if (button.equals("Увійти як адміністратор")) 
            if(!adminDAO.get().isAdmin(login, password)) 
                throw new IllegalArgumentException("Неправильний логін чи пароль");
    }
}
