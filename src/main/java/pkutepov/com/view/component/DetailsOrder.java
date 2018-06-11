package pkutepov.com.view.component;

import com.vaadin.ui.*;
import pkutepov.com.dao.order_dao.Order;

import java.util.List;

public class DetailsOrder extends Window {

    private Grid<Order> grid = new Grid<>();
    private Panel panel = new Panel();
    private Label resultPriceLabel = new Label();
    private Button buttonOk = new Button("OK");

    public DetailsOrder(List<Order> orders) {

        grid.addColumn(order -> order.getMedicine().getName()).setCaption("Название");
        grid.addColumn(order -> order.getCount()).setCaption("Количество");
        grid.addColumn(order -> order.getCount() * order.getMedicine().getPrice()).setCaption("Стоимость");
        double resultPrice = 0;
        for (Order order : orders) {
            double price = order.getMedicine().getPrice() * order.getCount();
            resultPrice += price;
        }
        resultPriceLabel.setValue("Итого: " + resultPrice + "р");
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.addComponent(resultPriceLabel);
        horizontalLayout.addComponent(buttonOk);
        horizontalLayout.setSizeFull();
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponent(grid);
        verticalLayout.addComponent(horizontalLayout);
        buttonOk.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                close();
            }
        });

        panel.setContent(verticalLayout);
        grid.setWidth("500px");
        grid.setItems(orders);
        setSizeUndefined();
        setContent(panel);
    }

}
