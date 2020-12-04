package by.company.hotel.service;

import by.company.hotel.entity.Booking;
import by.company.hotel.entity.Room;
import by.company.hotel.exception.RepositoryException;
import by.company.hotel.exception.ServiceException;
import by.company.hotel.repository.BookingRepository;
import by.company.hotel.repository.RoomRepository;
import by.company.hotel.specification.BookingByIdSpecification;
import by.company.hotel.specification.BookingByUserSpecification;
import by.company.hotel.specification.FindAvailableRoomsSpecification;
import by.company.hotel.specification.Specification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

public class CommonService {

    private static Logger log = LogManager.getLogger("common service");

    public List<Booking> findBookings(String login) throws ServiceException {
        List<Booking> bookings;
        Specification specification = new BookingByUserSpecification(login);
        BookingRepository repository = new BookingRepository();
        try {
            bookings = repository.query(specification);
        } catch (RepositoryException e) {
            log.error("RepositoryException while finding bookings");
            throw new ServiceException(e);
        }
        return bookings;
    }

    public List<Room> findAvailableRooms(String arrival, String departure) throws ServiceException {
        List<Room> rooms;
        Specification specification = new FindAvailableRoomsSpecification(arrival, departure);
        RoomRepository roomRepository = new RoomRepository();
        try {
            rooms = roomRepository.query(specification);
        } catch (RepositoryException e) {
            log.error("RepositoryException while finding available rooms");
            throw new ServiceException(e);
        }
        return rooms;
    }

    public Booking cancelBooking(int bookingId) throws ServiceException {
        BookingRepository bookingRepository = new BookingRepository();
        Booking booking = new Booking();
        booking.setBookingId(bookingId);
        try {
            bookingRepository.remove(booking);
        } catch (RepositoryException e) {
            log.error("RepositoryException while canceling booking", e);
            throw new ServiceException(e);
        }
        return booking;
    }

    public List<Booking> findBookingById(int bookingId) throws ServiceException {
        List<Booking> bookings;
        Specification specification = new BookingByIdSpecification(bookingId);
        BookingRepository repository = new BookingRepository();
        try {
            bookings = repository.query(specification);
        } catch (RepositoryException e) {
            log.error("RepositoryException while finding booking by Id");
            throw new ServiceException(e);
        }
        return bookings;
    }



}
