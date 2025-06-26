package repo;

import model.ExpenseShare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseShareRepo extends JpaRepository<ExpenseShare, Long> {
}
