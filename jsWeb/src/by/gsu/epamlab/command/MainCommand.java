package by.gsu.epamlab.command;

import by.gsu.epamlab.command.page.AbstractPage;
import by.gsu.epamlab.command.page.JsonPage;
import by.gsu.epamlab.exceptions.DaoException;
import by.gsu.epamlab.ifaces.TaskDao;
import by.gsu.epamlab.model.beans.Task;
import by.gsu.epamlab.model.factories.TaskFactory;
import by.gsu.epamlab.model.factories.TypeTableEnum;
import org.json.CDL;
import org.json.JSONArray;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

import static by.gsu.epamlab.controllers.ConstantsJsp.*;

public class MainCommand implements ActionCommand {
    public MainCommand() {
    }

    @Override
    public AbstractPage execute(HttpServletRequest request) throws DaoException {
        HttpSession session = request.getSession();
        int idUser = (int) session.getAttribute(ID_USER);
        TaskDao taskDao = TaskFactory.getInstanceFromFactory();
        TypeTableEnum typeTable = TypeTableEnum.getTypeTable(request.getParameter(TYPE_TABLE));

        JSONArray jsonNamesTable = new JSONArray();
        jsonNamesTable.put(FIELD_NAME);
        JSONArray jsonTables = CDL.toJSONArray(jsonNamesTable, String.join(LINE_BREAK, typeTable.getNamesTable()));

        List<Task> tasks = taskDao.getTasks(idUser, typeTable);
        JSONArray jsonTasksUser = new JSONArray();
        jsonTasksUser.put(FIELD_ID);
        jsonTasksUser.put(FIELD_TASK);
        jsonTasksUser.put(FIELD_DATE);
        String strTasks = tasks.stream()
                .map(Object::toString)
                .collect(Collectors.joining(LINE_BREAK));
        JSONArray jsonTasks = CDL.toJSONArray(jsonTasksUser, strTasks);

        JSONArray jsonButtonsTable = new JSONArray();
        jsonButtonsTable.put(FIELD_NAME);
        JSONArray jsonButtons = CDL.toJSONArray(jsonNamesTable, String.join(LINE_BREAK, typeTable.getButtons()));

        return new JsonPage(JSON_TABLES + jsonTables + DELIMITER + JSON_TABLE + typeTable.toString() + JSON_TABLE_END
                + DELIMITER + JSON_TASKS + jsonTasks + DELIMITER + JSON_BUTTONS + jsonButtons + JSON_END);
    }
}