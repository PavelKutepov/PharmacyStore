package pkutepov.com.view.IU;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import pkutepov.com.view.component.*;

public class AdminPanel extends UI {

    private UserInfoGrid userInfoGrid = new UserInfoGrid();
    private MedicineGrid medicineGrid = new MedicineGrid(true);
    private UserGrid userGrid = new UserGrid();
    private GeneratedOrders generatedOrders = new GeneratedOrders(true);

    CommonView commonView = new CommonView(medicineGrid, userInfoGrid, userGrid, generatedOrders);

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setSizeFull();
        setContent(commonView);
    }


}
