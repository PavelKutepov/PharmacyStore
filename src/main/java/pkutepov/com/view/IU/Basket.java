package pkutepov.com.view.IU;

import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import pkutepov.com.view.component.MedicineGrid;
import pkutepov.com.dao.medicine_dao.Medicine;

import java.util.ArrayList;
import java.util.List;

public class Basket extends UI {
    List<Medicine> medicineList = new ArrayList<>();
    private Button createOrderButton = new Button("Сделать заказ");
    private MedicineGrid medicineGrid = new MedicineGrid(false);
    private Panel gridPanel = new Panel();
    private Panel menuPanel = new Panel();
    private Panel pictutePanel = new Panel();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        HorizontalLayout mainHorizontalLayout = new HorizontalLayout();
        mainHorizontalLayout.addComponent(menuPanel);
        mainHorizontalLayout.addComponent(gridPanel);
        mainHorizontalLayout.setExpandRatio(menuPanel, 1);
        mainHorizontalLayout.setExpandRatio(gridPanel, 5);
        mainHorizontalLayout.setSizeFull();
        menuPanel.setWidth("100%");
        gridPanel.setSizeFull();


        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.addComponent(medicineGrid);
        horizontalLayout.setSizeFull();
        HorizontalLayout horizontalLayoutButton = new HorizontalLayout();
        horizontalLayoutButton.addComponent(createOrderButton);
        horizontalLayoutButton.setComponentAlignment(createOrderButton, Alignment.MIDDLE_CENTER);
        horizontalLayoutButton.setSizeFull();
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponent(horizontalLayout);
        verticalLayout.addComponent(horizontalLayoutButton);
        Image image = new Image(null, new ThemeResource("Images/TSitatyi-o-zdorove.jpg"));
        image.setSizeUndefined();
        menuPanel.setContent(image);

        gridPanel.setContent(verticalLayout);


        setContent(mainHorizontalLayout);

    }
}
