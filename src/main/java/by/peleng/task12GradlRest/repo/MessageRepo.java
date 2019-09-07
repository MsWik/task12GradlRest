package by.peleng.task12GradlRest.repo;

import by.peleng.task12GradlRest.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
