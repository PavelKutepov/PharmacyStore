package pkutepov.com.view.IU;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import pkutepov.com.view.component.BasketGrid;
import pkutepov.com.view.component.CommonView;
import pkutepov.com.view.component.GeneratedOrders;
import pkutepov.com.view.component.MedicineGrid;

public class Index extends UI {


    private MedicineGrid medicineGrid = new MedicineGrid(false);
    private BasketGrid basketGrid;
    private GeneratedOrders generatedOrders = new GeneratedOrders(false);
    private CommonView commonView;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        medicineGrid.getOrderList();
        basketGrid = new BasketGrid(medicineGrid.getOrderList());
        commonView = new CommonView(medicineGrid, basketGrid, generatedOrders);
        setSizeFull();
        setContent(commonView);
    }


}

