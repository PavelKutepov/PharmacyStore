package pkutepov.com.view.IU;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import pkutepov.com.dao.user_dao.User;
import pkutepov.com.dao.user_dao.UserInfo;
import pkutepov.com.dao.user_dao.UserService;
import pkutepov.com.view.modal.RegistrationSuccess;

public class Registration extends UI {
    private final Panel mainPanel = new Panel("Регистрация");
    private final Panel panel = new Panel();
    private final TextField username = new TextField("Введите логин");
    private final PasswordField password = new PasswordField("Введите пароль");
    private final PasswordField passwordFieldTest = new PasswordField("Повторите пароль");
    private final TextField lastName = new TextField("Фамилия");
    private final TextField firstName = new TextField("Имя");
    private final TextField patronymic = new TextField("Отчество");
    private final TextField telephone = new TextField("Телефон");
    private final Label registrationLabel = new Label("Регистрация");
    private final Button registrationButton = new Button("Регистрация");
    private ApplicationContext context = ContextLoaderListener.getCurrentWebApplicationContext();
    private UserService userService;


    @Override

    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout verticalLayout = new VerticalLayout();

        verticalLayout.addComponent(username);
        verticalLayout.addComponent(password);
        verticalLayout.addComponent(passwordFieldTest);
        verticalLayout.addComponent(lastName);
        verticalLayout.addComponent(firstName);
        verticalLayout.addComponent(patronymic);
        verticalLayout.addComponent(telephone);
        verticalLayout.addComponent(registrationButton);
        verticalLayout.setSizeUndefined();
        HorizontalLayout horizontalLayout = new HorizontalLayout();

        horizontalLayout.addComponent(verticalLayout);

        horizontalLayout.setComponentAlignment(verticalLayout, Alignment.MIDDLE_CENTER);
        horizontalLayout.setSizeFull();

        registrationLabel.setWidth("100%");

        initListener();
        mainPanel.setSizeUndefined();
        mainPanel.setContent(horizontalLayout);
        mainPanel.setWidth("100%");
        setContent(panel);
        setContent(mainPanel);


    }

    private void initListener() {
        registrationButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                userService = context.getBean("userService", UserService.class);
                User user = userService.getUserByLogin(username.getValue());
                if (user != null || username.getValue().equals("")) {
                    Notification.show(
                            "Eror",
                            "Логин не задан или пользователь с данным логином уже существует",
                            Notification.TYPE_ERROR_MESSAGE);


                } else if (!password.getValue().equals(passwordFieldTest.getValue()) || password.getValue().equals("")) {
                    Notification.show(
                            "Eror",
                            "Пароли не совпадают или не задан пароль",
                            Notification.TYPE_ERROR_MESSAGE);


                } else {
                    UserInfo userInfo = new UserInfo(lastName.getValue(), firstName.getValue(), patronymic.getValue(), telephone.getValue());
                    userService.addUser(username.getValue(), password.getValue(), userInfo);
                    addWindow(new RegistrationSuccess());
                }
            }
        });
    }
}
