package by.peleng.task12GradlRest.repo;

import by.peleng.task12GradlRest.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<User,String> {
}
