package studio.crayfish.devopsbuddy.backend.persistence.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import studio.crayfish.devopsbuddy.backend.persistence.domain.backend.Plan;

@Repository
public interface PlanRepository extends CrudRepository<Plan, Integer> {
}
