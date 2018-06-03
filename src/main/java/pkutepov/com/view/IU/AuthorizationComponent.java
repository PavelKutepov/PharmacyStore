package pkutepov.com.view.IU;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;


public class AuthorizationComponent extends UI {

    private final Panel mainPanel =  new Panel();
    private final TextField loginTextField = new TextField();
    private final PasswordField passwordField = new PasswordField();
    private final Button loginButton = new Button("Войти");
    private final Button registrationButton = new Button("Registration");
    private final CheckBox rememberMeCheckBox = new CheckBox("Запомнить");

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Panel panel =  new Panel();
        panel.setSizeFull();
        HorizontalLayout horizontalLayout =  new HorizontalLayout();
        VerticalLayout verticalLayout = new VerticalLayout();
        VerticalLayout components = new VerticalLayout();
        components.addComponent(loginTextField);
        components.addComponent(passwordField);
        components.addComponent(rememberMeCheckBox);
        components.addComponent(loginButton);
        components.addComponent(registrationButton);
        mainPanel.setContent(components);
        mainPanel.setSizeUndefined();
        horizontalLayout.addComponent(verticalLayout);
        horizontalLayout.addComponent(mainPanel);
        horizontalLayout.setComponentAlignment(verticalLayout,Alignment.MIDDLE_CENTER);
        horizontalLayout.setComponentAlignment(mainPanel,Alignment.MIDDLE_CENTER);
    // components.setComponentAlignment(mainPanel,Alignment.MIDDLE_CENTER);



        setContent(horizontalLayout);
    }


    void initListener() {

    }
}
