package pkutepov.com.view.component;

import com.vaadin.ui.*;
import com.vaadin.ui.renderers.ButtonRenderer;
import pkutepov.com.dao.order_dao.Order;
import pkutepov.com.view.modal.CreateOrder;

import java.util.List;

public class BasketGrid extends CustomComponent {
    private String caption = "Корзина";
    private Panel components = new Panel();
    private List<Order> orders;
    private Button createOrderButton = new Button("Сделать заказ");
    private Grid<Order> grid = new Grid<>();

    public BasketGrid(List<Order> orders) {
        this.orders = orders;

        grid.setItems(orders);
        grid.addColumn(order ->
                order.getMedicine().getName()).setCaption("Название");
        grid.addColumn(Order::getCount).setCaption("Колличество");
        grid.addColumn(order1 -> {
            return order1.getCount() * order1.getMedicine().getPrice();
        }).setCaption("Стоимость");
        grid.addColumn(delete -> "Удалить",
                new ButtonRenderer<>(clickEvent -> {
                    orders.remove(clickEvent.getItem());
                    grid.setItems(orders);
                }));
        grid.setSizeFull();


        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.addComponent(grid);
        horizontalLayout.setSizeFull();

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponent(horizontalLayout);
        verticalLayout.addComponent(createOrderButton);
        // String url= getUI().getUiRootPath();
        initListener();
        components.setContent(verticalLayout);
        components.setSizeFull();
        setCompositionRoot(components);
        setSizeFull();
    }


    @Override
    public String getCaption() {
        return caption;
    }

    void initListener() {
        createOrderButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                CreateOrder createOrder = new CreateOrder(orders);
                getUI().addWindow(createOrder);
            }
        });
    }
}
