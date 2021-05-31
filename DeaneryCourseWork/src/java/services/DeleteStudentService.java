package services;

import com.mainpackage.dao.GroupDAOimpl;
import java.util.concurrent.atomic.AtomicReference;

public class DeleteStudentService {
            public void service(String groupName,int ind, AtomicReference<GroupDAOimpl> groupDAO){
        groupDAO.get().deleteStudent(groupName, ind);
    }
}
