package by.company.hotel.command;

public class DefaultCommand implements Command {

    @Override
    public CommandResult execute(RequestContent requestContent) {
        return new CommandResult() ;
    }
}
