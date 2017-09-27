package tim.tu.edu.library.bootstrap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import tim.tu.edu.library.domain.Role;
import tim.tu.edu.library.service.RoleService;


@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    RoleService roleService;


    /**
     * Pre-Load database
     * @param contextRefreshedEvent
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Role role = new Role();
        role.setRole("ROLE_ADMIN");
        role.setDescription("Administrator Role");

        roleService.saveRole(role);
    }
}
