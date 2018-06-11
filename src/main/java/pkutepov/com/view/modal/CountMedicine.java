package pkutepov.com.view.modal;

import com.vaadin.ui.*;
import pkutepov.com.dao.medicine_dao.Medicine;
import pkutepov.com.dao.order_dao.Order;

import java.util.List;


public class CountMedicine extends Window {

    public Order order;
    private TextField countTextField = new TextField();
    private Button buttonOk = new Button("Ok");
    private Button buttonCancel = new Button("Cancel");
    private Medicine medicine;
    private List<Order> orderList;

    public CountMedicine(Medicine medicine, List<Order> orderList) {
        super("Количество");
        this.orderList = orderList;
        this.medicine = medicine;
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponent(countTextField);
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.addComponent(buttonOk);
        horizontalLayout.addComponent(buttonCancel);
        verticalLayout.addComponent(horizontalLayout);
        initListeners();
        setContent(verticalLayout);
        center();
    }

    private void initListeners() {
        buttonOk.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                int count = Integer.parseInt(countTextField.getValue());
                order = new Order(medicine, count);
                orderList.add(order);
                close();
            }
        });
        buttonCancel.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                close();
            }
        });
    }


}
