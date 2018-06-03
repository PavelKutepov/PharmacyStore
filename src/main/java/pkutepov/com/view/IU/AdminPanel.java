package pkutepov.com.view.IU;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import pkutepov.com.view.component.MedicineGrid;
import pkutepov.com.view.component.UserInfoGrid;
import pkutepov.com.view.modal.MedicineConstructor;

public class AdminPanel extends UI {
    UserInfoGrid userInfoGrid =  new UserInfoGrid();
    MedicineGrid medicineGrid =  new MedicineGrid(true);
    Panel gridPanel=  new Panel();
    Panel menuPanel=  new Panel();
    Button medicineAddButton =  new Button("Добавить");
    TabSheet tabsheet = new TabSheet();
    @Override
    protected void init(VaadinRequest vaadinRequest) {




        tabsheet.setSizeFull();
       HorizontalLayout  mainHorizontalLayout =  new HorizontalLayout();
        mainHorizontalLayout.addComponent(menuPanel);
        mainHorizontalLayout.addComponent(gridPanel);
        mainHorizontalLayout.setExpandRatio(menuPanel, 1);
        mainHorizontalLayout.setExpandRatio(gridPanel, 5);
        mainHorizontalLayout.setSizeFull();
        gridPanel.setSizeFull();

       VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addComponent(userInfoGrid);
        tabsheet.addTab(verticalLayout,"Информация о пользователях");
        VerticalLayout verticalLayout1 = new VerticalLayout();
        verticalLayout1.addComponent(medicineGrid);
        HorizontalLayout medicineButtonHorizontalLayout =  new HorizontalLayout();
        medicineButtonHorizontalLayout.addComponent(medicineAddButton);
        verticalLayout1.addComponent(medicineButtonHorizontalLayout);
        tabsheet.addTab(verticalLayout1, " Информация о лекарствах");
        gridPanel.setContent(tabsheet);



        intListener();
        setSizeFull();
     setContent(mainHorizontalLayout);
    }
    private void intListener(){
        medicineAddButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                addWindow(new MedicineConstructor(medicineGrid));


            }
        });
    }


}
