package by.company.hotel.command;

import by.company.hotel.constant.PageConstant;

public class LogoutCommand implements Command {

    @Override
    public CommandResult execute(RequestContent requestContent) {
        return new CommandResult(CommandResult.ResponseType.FORWARD, PageConstant.INDEX_PAGE);
    }
}
