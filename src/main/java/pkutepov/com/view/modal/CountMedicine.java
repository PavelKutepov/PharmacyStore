package pkutepov.com.view.modal;

import com.vaadin.ui.*;

public class CountMedicine extends Window{

    TextField countTextField =  new TextField();
    Button buttonOk = new Button("Ok");
    Button buttonCancel = new Button("Cancel");
    public CountMedicine() {
        super("Количество");

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponent(countTextField);
        HorizontalLayout horizontalLayout =  new HorizontalLayout();
        horizontalLayout.addComponent(buttonOk);
        horizontalLayout.addComponent(buttonCancel);
        verticalLayout.addComponent(horizontalLayout);
        setContent(verticalLayout);
        center();
    }


}
