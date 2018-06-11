package pkutepov.com.view.component;

import com.vaadin.ui.*;
import com.vaadin.ui.renderers.ButtonRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.ContextLoaderListener;
import pkutepov.com.dao.order_dao.Order;
import pkutepov.com.dao.order_dao.OrderInfo;
import pkutepov.com.dao.order_dao.OrderService;
import pkutepov.com.dao.user_dao.User;
import pkutepov.com.dao.user_dao.UserService;

import java.util.ArrayList;
import java.util.List;

public class GeneratedOrders extends CustomComponent {


    private String caption = "Мои заказы";

    private Panel components = new Panel();
    private ApplicationContext context = ContextLoaderListener.getCurrentWebApplicationContext();
    private OrderService orderService;
    private UserService userService;
    private Grid<OrderInfo> grid = new Grid<>();
    private List<OrderInfo> orderInfoList = new ArrayList<>();

    public GeneratedOrders(boolean isAdmin) {
        orderService = context.getBean("orderService", OrderService.class);
        userService = context.getBean("userService", UserService.class);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User thisUser = userService.getUserByLogin(auth.getName());
        if (isAdmin) {
            grid.addColumn(orderInfo -> {
                User user = userService.getUserById(orderInfo.getUserInfo().getUserInfoId());
                return user.getLogin();
            }).setCaption("Логин");
            orderInfoList = orderService.getAllOrderInfo();
        } else {
            orderInfoList = orderService.getOrderInfoByUserId(thisUser.getUserId());
        }

        grid.addColumn(OrderInfo::getDate).setCaption("Дата");
        grid.addColumn(OrderInfo::getAddress).setCaption("Адрес");
        grid.setItems(orderInfoList);
        if (isAdmin) {
            grid.addColumn(orderInfo -> {
                User user = userService.getUserById(orderInfo.getUserInfo().getUserInfoId());
                return user.getLogin();
            }).setCaption("Логин");
            orderInfoList = orderService.getAllOrderInfo();
        } else {
            orderInfoList = orderService.getOrderInfoByUserId(thisUser.getUserId());
        }

        grid.setSizeFull();

        grid.addColumn(change -> "Подробности",
                new ButtonRenderer<>(clickEvent -> {
                    List<Order> orders = orderService.getOrderListByOrderInfoId(clickEvent.getItem().getOrderInfoId());
                    DetailsOrder detailsOrder = new DetailsOrder(orders);
                    getUI().addWindow(detailsOrder);
                    detailsOrder.center();
                }));

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.addComponent(grid);
        horizontalLayout.setSizeFull();

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponent(horizontalLayout);
        components.setContent(verticalLayout);
        components.setSizeFull();
        setCompositionRoot(components);
        setSizeFull();
    }

    @Override
    public String getCaption() {
        return caption;
    }
}
