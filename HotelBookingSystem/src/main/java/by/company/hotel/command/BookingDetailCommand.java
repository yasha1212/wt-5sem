package by.company.hotel.command;

import by.company.hotel.entity.Booking;
import by.company.hotel.exception.ServiceException;
import by.company.hotel.message.MessageHandler;
import by.company.hotel.service.CommonService;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.company.hotel.constant.PageConstant.*;
import static by.company.hotel.constant.RequestConstant.*;
import static by.company.hotel.constant.RequestConstant.BOOKINGS;

public class BookingDetailCommand implements Command {

    private static Logger log = LogManager.getLogger("booking detail");

    private CommonService commonService;

    public BookingDetailCommand(CommonService commonService) {
        this.commonService = commonService;
    }

    @Override
    public CommandResult execute(RequestContent requestContent) {
        CommandResult commandResult;
        int bookingId = Integer.parseInt(requestContent.getRequestParameter(BOOKING_ID)[0]);
        Map<String, Object> requestAttributes = new HashMap<>();
        try {
            List<Booking> bookingList = commonService.findBookingById(bookingId);
            if (bookingList.isEmpty()) {
                requestAttributes.put(ERROR_FINDING_BOOKINGS, MessageHandler.getMessage("message.no_bookings", (String) requestContent.getSessionAttribute(LOCALE)));
                commandResult = new CommandResult(CommandResult.ResponseType.FORWARD, BOOKINGS_PAGE, requestAttributes);
            } else {
                Booking booking = bookingList.get(0);
                requestAttributes.put(BOOKING, booking);
                commandResult = new CommandResult(CommandResult.ResponseType.FORWARD, BOOKING_DETAIL_PAGE, requestAttributes);
            }
            return commandResult;
        } catch (ServiceException e) {
            log.error("Error in receiving bookings");
            return new DefaultCommand().execute(requestContent);
        }
    }
}
