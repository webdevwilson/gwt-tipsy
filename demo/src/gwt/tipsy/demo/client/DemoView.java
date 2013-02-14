package gwt.tipsy.demo.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.tipsy.client.Tipsy;

public class DemoView extends Composite {

    private static DemoViewUiBinder uiBinder = GWT.create(DemoViewUiBinder.class);

    interface DemoViewUiBinder extends UiBinder<Widget, DemoView> {
    }

    @UiField
    Anchor north;

    @UiField
    Anchor south;

    @UiField
    Anchor east;

    @UiField
    Anchor west;

    public DemoView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("north")
    public void showNorth(final MouseOverEvent e) {
        Tipsy.get().showNorthOf(north, "This is north");
    }

    @UiHandler("south")
    public void showSouth(final MouseOverEvent e) {
        Tipsy.get().showSouthOf(south, "This is south");
    }

    @UiHandler("east")
    public void showEast(final MouseOverEvent e) {
        Tipsy.get().showEastOf(east, "This is east");
    }

    @UiHandler("west")
    public void showWest(final MouseOverEvent e) {
        Tipsy.get().showWestOf(west, "This is west");
    }
    
    @UiHandler({"north", "south", "east", "west"})
    public void hide(final MouseOutEvent e) {
//        Tipsy.get().hide();
    }
}
