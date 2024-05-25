package vn.edu.hust.project.appledeviceservice.repository.mysql;

import org.springframework.stereotype.Repository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.IBaseRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.UserModel;
@Repository
public interface IUserRepository extends IBaseRepository<UserModel> {
}
