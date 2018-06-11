package pkutepov.com.view.component;

import com.vaadin.ui.*;
import com.vaadin.ui.renderers.ButtonRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import pkutepov.com.dao.medicine_dao.Medicine;
import pkutepov.com.dao.medicine_dao.MedicineService;
import pkutepov.com.dao.order_dao.Order;
import pkutepov.com.view.modal.CountMedicine;
import pkutepov.com.view.modal.MedicineConstructor;

import java.util.ArrayList;
import java.util.List;

public class MedicineGrid extends CustomComponent {
    private String caption = "Информация о лекарствах";
    private List<Medicine> medicineList;
    private Panel components = new Panel();
    private ApplicationContext context = ContextLoaderListener.getCurrentWebApplicationContext();
    private MedicineService medicineService;
    private Button addMedicineButton = new Button("Добавить");

    private Grid<Medicine> grid = new Grid<>();
    private List<Order> orderList = new ArrayList<>();

    public MedicineGrid(Boolean isAdmin) {

        medicineService = context.getBean("medicineService", MedicineService.class);
        medicineList = medicineService.getAllMedicine();

        grid.setItems(medicineList);
        grid.addColumn(Medicine::getName).setCaption("Название");
        grid.addColumn(Medicine::getFirm).setCaption("Фирма");
        grid.addColumn(Medicine::getType).setCaption("Тип");
        grid.addColumn(Medicine::getPrice).setCaption("Цена");
        addMedicineButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Window window = new MedicineConstructor(grid);
                getUI().addWindow(window);
                window.center();

            }
        });
        grid.setSizeFull();
        if (isAdmin) {

            grid.addColumn(delete -> "Удалить",
                    new ButtonRenderer<>(clickEvent -> {
                        medicineList.remove(clickEvent.getItem());
                        medicineService.delMebicine(clickEvent.getItem());
                        grid.setItems(medicineList);
                    }));
        } else {
            grid.addColumn(count -> "Добавить в корзину",
                    new ButtonRenderer<>(clickEvent -> {

                        Medicine medicine = clickEvent.getItem();
                        CountMedicine window = new CountMedicine(medicine, orderList);
                        getUI().addWindow(window);

                    }));

        }
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.addComponent(grid);
        horizontalLayout.setSizeFull();

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponent(horizontalLayout);
        
        if (isAdmin) {
            verticalLayout.addComponent(addMedicineButton);
        }
        components.setContent(verticalLayout);
        components.setSizeFull();
        setCompositionRoot(components);
        setSizeFull();
    }

    public void update() {
        medicineList = medicineService.getAllMedicine();
        grid.setItems(medicineList);
    }

    @Override
    public String getCaption() {
        return caption;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public Button getAddMedicineButton() {
        return addMedicineButton;
    }
}
