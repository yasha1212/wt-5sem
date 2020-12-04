package by.company.hotel.command;

import by.company.hotel.entity.Booking;
import by.company.hotel.entity.User;
import by.company.hotel.exception.ServiceException;
import by.company.hotel.message.MessageHandler;
import by.company.hotel.service.CommonService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.company.hotel.constant.PageConstant.BOOKINGS_PAGE;
import static by.company.hotel.constant.PageConstant.USER_MAIN_PAGE;
import static by.company.hotel.constant.RequestConstant.*;

public class ShowBookingsCommand implements Command {

    private static Logger log = LogManager.getLogger("show bookings");

    private CommonService commonService;

    public ShowBookingsCommand(CommonService commonService) {
        this.commonService = commonService;
    }

    @Override
    public CommandResult execute(RequestContent requestContent) {
        CommandResult commandResult;
        User user = (User) requestContent.getSessionAttribute(USER);
        Map<String, Object> requestAttributes = new HashMap<>();
        try {
            List<Booking> bookingList = commonService.findBookings(user.getLogin());
            if (bookingList.isEmpty()) {
                requestAttributes.put(ERROR_FINDING_BOOKINGS, MessageHandler.getMessage("message.no_bookings", (String) requestContent.getSessionAttribute(LOCALE)));
                commandResult = new CommandResult(CommandResult.ResponseType.FORWARD, USER_MAIN_PAGE, requestAttributes);
            } else {
                requestAttributes.put(BOOKINGS, bookingList);
                commandResult = new CommandResult(CommandResult.ResponseType.FORWARD, BOOKINGS_PAGE, requestAttributes);
            }
            return commandResult;
        } catch (ServiceException e) {
            log.error("Error in receiving bookings");
            return new DefaultCommand().execute(requestContent);
        }
    }
}
