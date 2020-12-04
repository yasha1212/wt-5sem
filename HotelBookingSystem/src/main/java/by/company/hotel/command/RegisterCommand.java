package by.company.hotel.command;

import by.company.hotel.entity.User;
import by.company.hotel.exception.ServiceException;
import by.company.hotel.service.UserService;
import by.company.hotel.validator.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static by.company.hotel.constant.PageConstant.*;
import static by.company.hotel.constant.RequestConstant.*;


public class RegisterCommand implements Command {

    private static Logger log = LogManager.getLogger("register");

    private UserService userService;

    public RegisterCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CommandResult execute(RequestContent requestContent) {
        CommandResult commandResult;
        String login = requestContent.getRequestParameter(LOGIN)[0];
        String password = requestContent.getRequestParameter(PASSWORD)[0];
        String email = requestContent.getRequestParameter(EMAIL)[0];
        String firstName = requestContent.getRequestParameter(FIRST_NAME)[0];
        String lastName = requestContent.getRequestParameter(LAST_NAME)[0];
        String phoneNumber = requestContent.getRequestParameter(PHONE_NUMBER)[0];
        String country = requestContent.getRequestParameter(COUNTRY)[0];
        String birthday = requestContent.getRequestParameter(BIRTHDAY)[0];
        User user;

        LoginValidator loginValidator = new LoginValidator();
        PasswordValidator passwordValidator = new PasswordValidator();
        EmailValidator emailValidator = new EmailValidator();
        BirthdayValidator birthdayValidator = new BirthdayValidator();

        if (loginValidator.isValidated(login) && passwordValidator.isValidated(password) && emailValidator.isValidated(email)
                && birthdayValidator.isValidated(birthday)) {
            try {
                user = userService.register(login, password, email, firstName, lastName, phoneNumber, country, birthday, false);
            } catch (ServiceException e) {
                log.error("Unable to register user");
                return new DefaultCommand().execute(requestContent);
            }
            Map<String, Object> users = new HashMap<>();
            users.put(USER, user);
            commandResult = new CommandResult(CommandResult.ResponseType.FORWARD, LOGIN_PAGE, users);
            log.debug(user + "was successfully registered");
        } else {
            commandResult = new CommandResult(CommandResult.ResponseType.FORWARD, LOGIN_PAGE);
        }
        return commandResult;
    }
}
