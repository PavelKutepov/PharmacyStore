package pkutepov.com.view.modal;

import com.vaadin.ui.Button;
import com.vaadin.ui.Window;

public class RegistrationSuccess extends Window {

    private com.vaadin.ui.Button OKButton = new Button("Ok");

    public RegistrationSuccess() {
        setCaption("Успешно");
        setContent(OKButton);
        setSizeUndefined();

        initListener();
        center();
    }

    void initListener() {
        OKButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                getUI().getPage().setLocation("/login");
            }
        });
    }
}
