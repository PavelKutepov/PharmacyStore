package pkutepov.com.view.component;

import com.vaadin.ui.*;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import pkutepov.com.dao.role.Role;
import pkutepov.com.dao.role.RoleDao;
import pkutepov.com.dao.user_dao.User;
import pkutepov.com.dao.user_dao.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class UserGrid extends CustomComponent {
    private String caption = "Модерация";
    private RoleDao roleDao;
    private UserService userService;
    private Panel components = new Panel();
    private Panel buttonPanel = new Panel();
    private ApplicationContext context = ContextLoaderListener.getCurrentWebApplicationContext();
    private Button addAdmin = new Button("Сделать Админимтратором");
    private Button delAdmin = new Button("Исключить из админимтраторов");
    private List<User> userList = new ArrayList<>();
    private Grid<User> grid = new Grid<>();

    public UserGrid() {
        userService = context.getBean("userService", UserService.class);
        roleDao = context.getBean("roleDao", RoleDao.class);


        userList = userService.getAllUsers();
        grid.setItems(userList);
        grid.addColumn(User::getLogin).setCaption("Логин");
        grid.addColumn(User::getRolesToString).setCaption("Права");
        grid.setSizeFull();
        HorizontalLayout horizontalLayoutButtonPanel = new HorizontalLayout();
        horizontalLayoutButtonPanel.addComponent(addAdmin);
        horizontalLayoutButtonPanel.addComponent(delAdmin);
        buttonPanel.setContent(horizontalLayoutButtonPanel);
        buttonPanel.setSizeUndefined();

        initListener();
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.addComponent(grid);
        horizontalLayout.setSizeFull();

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponent(horizontalLayout);
        verticalLayout.addComponent(buttonPanel);

        components.setContent(verticalLayout);
        components.setSizeFull();
        setCompositionRoot(components);
        setSizeFull();
    }

    void initListener() {
        Role roleAdm = roleDao.getRoleById(2);
        addAdmin.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                Set<User> users = grid.getSelectedItems();
                for (User user : users) {
                    roleDao.addRole(user, roleAdm);
                }
                update();
            }
        });
        delAdmin.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Set<User> users = grid.getSelectedItems();
                for (User user : users) {
                    roleDao.removeRoleInUser(user, roleAdm);
                }
                update();
            }
        });
    }

    public void update() {
        userList = userService.getAllUsers();
        grid.setItems(userList);
    }

    @Override
    public String getCaption() {
        return caption;
    }
}
