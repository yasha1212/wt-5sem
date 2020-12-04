package by.company.hotel.command;

import by.company.hotel.constant.PageConstant;

public class ToRegistrationCommand implements Command {
    @Override
    public CommandResult execute(RequestContent requestContent) {
        return new CommandResult(CommandResult.ResponseType.FORWARD, PageConstant.REGISTRATION_PAGE);
    }
}
