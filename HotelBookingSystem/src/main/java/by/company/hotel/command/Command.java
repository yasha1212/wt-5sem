package by.company.hotel.command;

@FunctionalInterface
public interface Command {
    CommandResult execute(RequestContent requestContent);
}
