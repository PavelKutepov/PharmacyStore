package pkutepov.com.view.component;

import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.ContextLoaderListener;
import pkutepov.com.dao.role.Role;
import pkutepov.com.dao.user_dao.User;
import pkutepov.com.dao.user_dao.UserService;
import pkutepov.com.view.modal.MedicineConstructor;

public class CommonView extends CustomComponent {


    private MedicineGrid medicineGrid = new MedicineGrid(true);


    private Panel gridPanel = new Panel();
    private Panel menuPanel = new Panel();
    private Panel infoPanel = new Panel();

    private TabSheet tabsheet = new TabSheet();
    private ApplicationContext context = ContextLoaderListener.getCurrentWebApplicationContext();

    private Button indexButton = new Button("На главную");
    private Button adminButton = new Button("Администрирование");
    private Button logoutButton = new Button("Выход");
    private Label label = new Label();

    public CommonView(CustomComponent... customComponents) {


        VerticalLayout mainVerticalLayout = new VerticalLayout();
        mainVerticalLayout.addComponent(infoPanel);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        label.setValue("Вы вошли как: " + username);
        label.setContentMode(ContentMode.TEXT);
        label.setSizeUndefined();
        infoPanel.setSizeUndefined();
        infoPanel.setContent(label);
        tabsheet.setSizeFull();
        HorizontalLayout mainHorizontalLayout = new HorizontalLayout();
        VerticalLayout menuPanelVerticalLayout = new VerticalLayout();
        menuPanelVerticalLayout.setSizeFull();
        menuPanelVerticalLayout.addComponent(indexButton);
        indexButton.setWidth("100%");
        UserService userService = context.getBean("userService", UserService.class);
        User user = userService.getUserByLogin(auth.getName());
        for (Role role : user.getRoles()) {
            if (role.getName().equals("ROLE_ADMIN")) {
                menuPanelVerticalLayout.addComponent(adminButton);
                adminButton.setWidth("100%");
            }
        }
        menuPanelVerticalLayout.addComponent(logoutButton);
        logoutButton.setWidth("100%");
        menuPanel.setContent(menuPanelVerticalLayout);
        mainHorizontalLayout.addComponent(menuPanel);
        mainHorizontalLayout.addComponent(gridPanel);
        mainHorizontalLayout.setExpandRatio(menuPanel, 1);
        mainHorizontalLayout.setExpandRatio(gridPanel, 5);
        mainHorizontalLayout.setSizeFull();
        gridPanel.setSizeFull();

        for (CustomComponent component : customComponents) {
            VerticalLayout verticalLayout = new VerticalLayout(component);
            verticalLayout.setSizeFull();
            tabsheet.addTab(verticalLayout, component.getCaption());

        }

        gridPanel.setContent(tabsheet);
        intListener();
        mainVerticalLayout.addComponent(infoPanel);
        mainVerticalLayout.addComponent(mainHorizontalLayout);

        setSizeFull();
        setCompositionRoot(mainVerticalLayout);

    }

    private void intListener() {

        indexButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                getUI().getPage().setLocation("/index");
            }
        });
        logoutButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                SecurityContextHolder.clearContext();
                getUI().getPage().setLocation("/login");
            }
        });
        adminButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                getUI().getPage().setLocation("/admin");
            }
        });
    }


}
