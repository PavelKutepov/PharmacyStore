package pkutepov.com.view.modal;

import com.vaadin.ui.*;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import pkutepov.com.dao.medicine_dao.Medicine;
import pkutepov.com.dao.medicine_dao.MedicineService;
import pkutepov.com.view.component.MedicineGrid;

import java.util.List;

public class MedicineConstructor extends Window {

    private TextField nameTextField = new TextField("Название");
    private TextField firmTextField = new TextField("Фирма");
    private TextField typeTextField = new TextField("Тип");
    private TextField priceTextField = new TextField("Цена");
    private Button addButton = new Button("Добавить");

    public MedicineConstructor(Grid grid) {
        super("Добавить");
        VerticalLayout verticalLayout = new VerticalLayout();

        verticalLayout.addComponent(nameTextField);
        verticalLayout.addComponent(firmTextField);
        verticalLayout.addComponent(typeTextField);
        verticalLayout.addComponent(priceTextField);
        verticalLayout.addComponent(addButton);
        verticalLayout.setSizeFull();
        setWidth("300px");
        setHeight("400px");
        initListener(grid);
        setContent(verticalLayout);

    }

    private void initListener(Grid grid) {
        addButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                ApplicationContext context = ContextLoaderListener.getCurrentWebApplicationContext();
                MedicineService medicineService = context.getBean("medicineService", MedicineService.class);
                medicineService.addMedicine(nameTextField.getValue(), firmTextField.getValue(),
                        typeTextField.getValue(), Double.parseDouble(priceTextField.getValue()));
                List<Medicine> medicines = medicineService.getAllMedicine();
                grid.setItems(medicines);
                close();

            }
        });
    }
}
