package pkutepov.com.view.component;

import com.vaadin.ui.*;
import com.vaadin.ui.renderers.ButtonRenderer;
import com.vaadin.ui.renderers.TextRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import pkutepov.com.dao.medicine_dao.Medicine;
import pkutepov.com.dao.medicine_dao.MedicineService;
import pkutepov.com.view.modal.CountMedicine;

import java.util.ArrayList;
import java.util.List;

public class MedicineGrid extends CustomComponent{
    private String value;
    private List<Medicine> medicineList;
    private Panel components=  new Panel();
    ApplicationContext context = ContextLoaderListener.getCurrentWebApplicationContext();
    MedicineService medicineService;
    Grid<Medicine> grid =  new Grid<>();
    private List<Medicine> selectedMedicineList = new ArrayList<>();
    public MedicineGrid(Boolean isAdmin) {

       medicineService = context.getBean("medicineService",MedicineService.class);
        medicineList= medicineService.getAllMedicine();

        grid.setItems(medicineList);
        grid.addColumn(Medicine::getName).setCaption("Название");
        grid.addColumn(Medicine::getFirm).setCaption("Фирма");
        grid.addColumn(Medicine::getType).setCaption("Тип");
        grid.addColumn(Medicine::getPrice).setCaption("Цена");

        grid.setSizeFull();
        if(isAdmin){
            grid.addColumn(change -> "Изменить",
                    new ButtonRenderer<>(clickEvent -> { }));
            grid.addColumn(delete -> "Удалить",
                    new ButtonRenderer<>(clickEvent -> {
                        medicineList.remove(clickEvent.getItem());
                        medicineService.delMebicine(clickEvent.getItem());
                        grid.setItems(medicineList); }));
        }
        else {
            grid.addComponentColumn(count ->{
                TextField countTxt= new TextField();
                return countTxt;
             }).setCaption("Количество");

        }
        HorizontalLayout horizontalLayout =  new HorizontalLayout();
        horizontalLayout.addComponent(grid);
        horizontalLayout.setSizeFull();

        VerticalLayout verticalLayout =  new VerticalLayout();
        verticalLayout.addComponent(horizontalLayout);

        components.setContent(verticalLayout);
        components.setSizeFull();
        setCompositionRoot(components);
        setSizeFull();
    }
   public void update(){
       medicineList= medicineService.getAllMedicine();
       grid.setItems(medicineList);
   }
}
