package pkutepov.com.view.IU;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import pkutepov.com.view.component.MedicineGrid;
import pkutepov.com.dao.medicine_dao.Medicine;

import java.util.ArrayList;
import java.util.List;

public class Index extends UI {

    private String value;
    private List<Medicine> medicineList;
    private Panel components = new Panel();
    private Button button= new Button("Сделать заказ");
    private List<Medicine> selectedMedicineList = new ArrayList<>();
    MedicineGrid medicineGrid = new MedicineGrid(false);
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        HorizontalLayout horizontalLayout =  new HorizontalLayout();
        horizontalLayout.addComponent(medicineGrid);
        horizontalLayout.setSizeFull();

        HorizontalLayout horizontalLayoutButton = new HorizontalLayout();
        horizontalLayoutButton.setSizeFull();
        horizontalLayoutButton.addComponent(button);
        horizontalLayoutButton.setComponentAlignment(button, Alignment.MIDDLE_CENTER);

        VerticalLayout verticalLayout =  new VerticalLayout();
        verticalLayout.addComponent(horizontalLayout);
        verticalLayout.addComponent(horizontalLayoutButton);


        button.setWidth("20%");

        components.setContent(verticalLayout);
        components.setSizeFull();
        setContent(components);
        setSizeFull();
    }
}
