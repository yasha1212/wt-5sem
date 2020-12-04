package by.company.hotel.command;

import by.company.hotel.entity.User;
import by.company.hotel.exception.ServiceException;
import by.company.hotel.message.MessageHandler;
import by.company.hotel.service.UserService;
import by.company.hotel.validator.LoginValidator;
import by.company.hotel.validator.PasswordValidator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static by.company.hotel.constant.PageConstant.*;
import static by.company.hotel.constant.RequestConstant.*;

public class LoginCommand implements Command {

    private static Logger log = LogManager.getLogger("login");

    private UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CommandResult execute(RequestContent requestContent) {
        User user;
        CommandResult commandResult;
        String login = requestContent.getRequestParameter(LOGIN)[0];
        String password = requestContent.getRequestParameter(PASSWORD)[0];
        Map<String, Object> requestAttributes = new HashMap<>();
        Map<String, Object> users = new HashMap<>();
        LoginValidator loginValidator = new LoginValidator();
        PasswordValidator passwordValidator = new PasswordValidator();
        if (loginValidator.isValidated(login) && passwordValidator.isValidated(password)) {
            try {
                if (userService.login(login, password).isEmpty()) {
                    users.put(ERROR_LOGIN_PASS, MessageHandler.getMessage("warning.login_password", (String) requestContent.getSessionAttribute(LOCALE)));
                    commandResult = new CommandResult(CommandResult.ResponseType.FORWARD, LOGIN_PAGE, requestAttributes, users);
                    log.debug("Login error: can't find user");
                } else {
                    user = userService.login(login, password).get(0);
                    if (!user.isAdmin()) {
                        users.put(USER, user);
                        commandResult = new CommandResult(CommandResult.ResponseType.FORWARD, USER_MAIN_PAGE, requestAttributes, users);
                        log.debug(user + " logged in as user");
                    } else {
                        user = userService.login(login, password).get(0);
                        users.put(USER, user);
                        commandResult = new CommandResult(CommandResult.ResponseType.FORWARD, ADMIN_MAIN_PAGE, requestAttributes, users);
                        log.debug(user + " logged in as admin");
                    }
                }
            } catch (ServiceException e) {
                log.debug("Unable to log in", e);
                return new DefaultCommand().execute(requestContent);
            }
        } else {
            commandResult = new CommandResult(CommandResult.ResponseType.FORWARD, LOGIN_PAGE);
        }
        return commandResult;
    }
}
