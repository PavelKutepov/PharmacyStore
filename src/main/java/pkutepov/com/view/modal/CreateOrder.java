package pkutepov.com.view.modal;

import com.vaadin.ui.*;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.ContextLoaderListener;
import pkutepov.com.dao.address_dao.Address;
import pkutepov.com.dao.address_dao.Locality;
import pkutepov.com.dao.order_dao.Order;
import pkutepov.com.dao.order_dao.OrderInfo;
import pkutepov.com.dao.order_dao.OrderService;
import pkutepov.com.dao.user_dao.User;
import pkutepov.com.dao.user_dao.UserInfo;
import pkutepov.com.dao.user_dao.UserService;

import java.util.Date;
import java.util.List;

public class CreateOrder extends Window {

    private TextField streetTextField = new TextField("Улица");
    private TextField houseTextField = new TextField("Дом");
    private TextField apartmentTextField = new TextField("Квартира");
    private TextField cityTextField = new TextField("Город");
    private TextField districtTextField = new TextField("Область");
    private TextField localTextField = new TextField("Населенный пункт");
    private ApplicationContext context = ContextLoaderListener.getCurrentWebApplicationContext();
    private UserService userService;
    private OrderService orderService;
    private Button createOrderButton = new Button("Сделать заказ");
    private Label resultPriceLabel = new Label();
    private List<Order> orders;

    public CreateOrder(List<Order> orders) {
        super("Сделать заказ");
        this.orders = orders;
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponent(cityTextField);
        verticalLayout.addComponent(districtTextField);
        verticalLayout.addComponent(localTextField);
        verticalLayout.addComponent(streetTextField);
        verticalLayout.addComponent(houseTextField);
        verticalLayout.addComponent(apartmentTextField);
        double resultPrice = 0;
        for (Order order : orders) {
            double price = order.getMedicine().getPrice() * order.getCount();
            resultPrice += price;
        }
        resultPriceLabel.setValue("Итого: " + resultPrice + "р");
        verticalLayout.addComponent(resultPriceLabel);
        verticalLayout.addComponent(createOrderButton);
        verticalLayout.setSizeUndefined();
        setContent(verticalLayout);
        initListener();
        center();
    }

    void initListener() {
        createOrderButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Locality locality = new Locality(cityTextField.getValue(), districtTextField.getValue(), localTextField.getValue());
                Address address = new Address(streetTextField.getValue(), Integer.parseInt(houseTextField.getValue()),
                        Integer.parseInt(apartmentTextField.getValue()), locality);
                userService = context.getBean("userService", UserService.class);
                orderService = context.getBean("orderService", OrderService.class);
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                User user = userService.getUserByLogin(auth.getName());
                UserInfo userInfo = userService.getUserInfoById(user.getUserId());
                OrderInfo orderInfo = new OrderInfo(userInfo, address, new Date());
                orderService.addOrderList(orders, orderInfo);
                close();
            }
        });
    }
}
