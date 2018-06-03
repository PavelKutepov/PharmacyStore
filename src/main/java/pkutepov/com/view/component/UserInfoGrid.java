package pkutepov.com.view.component;

import com.vaadin.ui.*;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import pkutepov.com.dao.user_dao.UserInfo;
import pkutepov.com.dao.user_dao.UserService;

import java.util.List;

public class UserInfoGrid extends CustomComponent {
    List<UserInfo> userInfos ;
    private Panel components=  new Panel();
    public UserInfoGrid() {
        ApplicationContext context = ContextLoaderListener.getCurrentWebApplicationContext();
        UserService userService = context.getBean("userService",UserService.class);
        userInfos= userService.getAllUsersInfo();
        Grid<UserInfo> grid =  new Grid<>();
        grid.setItems(userInfos);
        grid.addColumn(UserInfo::getFirstName).setCaption("Имя");
        grid.addColumn(UserInfo::getLastName).setCaption("Фамилия");
        grid.addColumn(UserInfo::getPatronymic).setCaption("Отчество");
        grid.addColumn(UserInfo::getPhoneNumber).setCaption("Телефон");
        grid.setSizeFull();

        HorizontalLayout horizontalLayout =  new HorizontalLayout();
        horizontalLayout.addComponent(grid);
        horizontalLayout.setSizeFull();

        VerticalLayout verticalLayout =  new VerticalLayout();
        verticalLayout.addComponent(horizontalLayout);

        components.setContent(verticalLayout);
        components.setSizeFull();
        setCompositionRoot(components);
        setSizeFull();
    }
}
