package tim.tu.edu.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tim.tu.edu.library.domain.Role;
import tim.tu.edu.library.domain.User;
import tim.tu.edu.library.dto.UserDto;
import tim.tu.edu.library.service.RoleService;
import tim.tu.edu.library.service.UserService;

import javax.validation.Valid;


@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    RoleService roleService;


    @GetMapping(value = "/login")
    public String login(){
        return "pages/user/login";
    }


    /**
     * Display registration pge
     * @param modelMap
     * @return
     */
    @GetMapping(value = "/register")
    public String register(ModelMap modelMap){

        /**
         * Add empty user object to model map
         */
        UserDto userDto = new UserDto();
        modelMap.addAttribute("user", userDto);

        /**
         * Show page
         */
        return "pages/user/register";
    }

    /**
     * Register new user
     * @param modelMap
     * @param userDto
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/register")
    public String registerUser(ModelMap modelMap,
//                               @RequestParam("terms") String terms,
                               @ModelAttribute("user") @Valid UserDto userDto,
                               BindingResult bindingResult){


        if(bindingResult.hasErrors()){

        }

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setActive(true);
        Role role = roleService.findByRole("ROLE_ADMIN");
        user.setRole(role);

        userService.saveUser(user);

        return "pages/user/login";
    }
}
