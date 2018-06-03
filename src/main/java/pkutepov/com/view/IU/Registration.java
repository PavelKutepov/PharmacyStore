package pkutepov.com.view.IU;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

public class Registration extends UI {
    private final Panel mainPanel = new Panel();
    private final TextField loginTextField = new TextField("Введите логин");
    private final PasswordField passwordField = new PasswordField("Введите пароль");
    private final PasswordField passwordFieldTest = new PasswordField("Повторите пароль");
    private final TextField lastName = new TextField("Фамилия");
    private final TextField firstName = new TextField("Имя");
    private final TextField patronymic = new TextField("Отчество");
    private final TextField telephone = new TextField("Телефон");
    private final TextField locality = new TextField("Населенный пункт");
    private final TextField address = new TextField("Адрес");
    private final Label registrationLabel = new Label("Регистрация");

    @Override

    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponent(loginTextField);
        verticalLayout.addComponent(passwordField);
        verticalLayout.addComponent(passwordFieldTest);
        verticalLayout.addComponent(lastName);
        verticalLayout.addComponent(firstName);
        verticalLayout.addComponent(patronymic);
        verticalLayout.addComponent(telephone);
        verticalLayout.addComponent(locality);
        verticalLayout.addComponent(address);
        verticalLayout.addComponent(registrationLabel);
        verticalLayout.setWidth("100%");
//        mainPanel.setContent(registrationLabel);
        registrationLabel.setWidth("100%");
        registrationLabel.setStyleName("v-label-stylename");
        mainPanel.setSizeFull();
        mainPanel.setContent(verticalLayout);
        setContent(mainPanel);


    }
//
//    @WebServlet(value = "/registration", name = "Registr", asyncSupported = true)
//    @VaadinServletConfiguration(ui = Registration.class, productionMode = false)
//    public static class MyUIServlet extends VaadinServlet {
//    }
}
