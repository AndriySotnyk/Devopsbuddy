package studio.crayfish.devopsbuddy.test.integration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import studio.crayfish.devopsbuddy.DevopsbuddyApplication;
import studio.crayfish.devopsbuddy.backend.persistence.domain.backend.Plan;
import studio.crayfish.devopsbuddy.backend.persistence.domain.repositories.PlanRepository;
import studio.crayfish.devopsbuddy.backend.persistence.domain.repositories.RoleRepository;
import studio.crayfish.devopsbuddy.backend.persistence.domain.repositories.UserRepository;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DevopsbuddyApplication.class)
public class RepositoriesIntegrationTest {
    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    private static final int BASIC_PLAN_ID = 1;

    @Before
    public void init(){
        Assert.assertNotNull(planRepository);
        Assert.assertNotNull(roleRepository);
        Assert.assertNotNull(userRepository);
    }

    @Test
    public void testCreateNewPlan() throws Exception{
        Plan basicPlan = createBasicPlan();
        planRepository.save(basicPlan);
        Optional<Plan> retrivedPlan = planRepository.findById(BASIC_PLAN_ID);
        Assert.assertNotNull(retrivedPlan);
    }

    private Plan createBasicPlan(){
        Plan plan = new Plan();
        plan.setId(BASIC_PLAN_ID);
        plan.setName("Basic");
        return plan;
    }
}
