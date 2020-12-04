package by.company.hotel.command;

import by.company.hotel.entity.Booking;
import by.company.hotel.exception.ServiceException;
import by.company.hotel.message.MessageHandler;
import by.company.hotel.service.CommonService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static by.company.hotel.constant.PageConstant.BOOKINGS_PAGE;
import static by.company.hotel.constant.PageConstant.USER_MAIN_PAGE;
import static by.company.hotel.constant.RequestConstant.*;

public class CancelBookingCommand implements Command {

    private static Logger log = LogManager.getLogger("cancel booking");

    private CommonService commonService;

    public CancelBookingCommand(CommonService commonService) {
        this.commonService = commonService;
    }

    @Override
    public CommandResult execute(RequestContent requestContent) {
        CommandResult commandResult;
        int bookingId = Integer.parseInt(requestContent.getRequestParameter(BOOKING_ID)[0]);
        System.out.println(bookingId);
        try {
            Booking booking = commonService.cancelBooking(bookingId);
        } catch (ServiceException e) {
            log.error("Error while canceling booking", e);
            return new DefaultCommand().execute(requestContent);
        }

        Map<String, Object> attributes = new HashMap<>();
        attributes.put(SUCCESSFUL_BOOKING, MessageHandler.getMessage("message.successful_canceling", (String) requestContent.getSessionAttribute(LOCALE)));
        commandResult = new CommandResult(CommandResult.ResponseType.FORWARD, BOOKINGS_PAGE, attributes);
        log.debug("Booking was successfully canceled");
        return commandResult;
    }
}
