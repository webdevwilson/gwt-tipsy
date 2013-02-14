package gwt.tipsy.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Tooltips, notification ... <br/>
 *
 * .cw-Tipsy <br/> .cw-Tipsy-inner <br/> .cw-Tipsy-north <br/> .cw-Tipsy-south<br/>
 * .cw-Tipsy-east<br/> .cw-Tipsy-west<br/> .cw-Tipsy-west .cw-Tipsy-inner<br/>
 *
 * @author trung
 *
 */
public class Tipsy extends Composite {

    private static Tipsy INSTANCE;

    private final TipsyResources tipsyResources;

    private final TipsyResources.Css css;

    private final SimplePanel panel = new SimplePanel();

    private final Label innerLabel = new Label();

    private final Element element;

    private Tipsy() {
        initWidget(panel);
        element = panel.getElement();
        tipsyResources = GWT.create(TipsyResources.class);
        css = tipsyResources.css();
        css.ensureInjected();
        panel.setStyleName(css.tipsy());
        panel.add(innerLabel);
        innerLabel.setStyleName(css.tipsyInner());
    }

    public static Tipsy get() {
        if (INSTANCE == null) {
            INSTANCE = new Tipsy();
        }
        return INSTANCE;
    }

    /**
     * Show above the provided widget
     *
     * @param widget
     */
    public void showNorthOf(Widget widget, String text) {
        init(text);
        clearDirection();
        addStyleName(css.south());
        show();
        int top = widget.getAbsoluteTop() - this.getOffsetHeight();
        int left = widget.getAbsoluteLeft() - ((this.getOffsetWidth() - widget.getOffsetWidth()) / 2);
        moveTo(top, left);
    }

    /**
     * Show on the right of the provided widget
     *
     * @param widget
     */
    public void showEastOf(Widget widget, String text) {
        init(text);
        clearDirection();
        addStyleName(css.west());
        show();
        if (this.getOffsetWidth() + widget.getOffsetWidth() + widget.getAbsoluteLeft()
                > Window.getClientWidth()) {
            showNorthOf(widget, text);
            return;
        }
        int top = widget.getAbsoluteTop() - ((this.getOffsetHeight() - widget.getOffsetHeight()) / 2);
        int left = widget.getAbsoluteLeft() + widget.getOffsetWidth() + 1;
        moveTo(top, left);
    }

    /**
     * Show bellow the provided widget
     *
     * @param widget
     */
    public void showSouthOf(Widget widget, String text) {
        init(text);
        clearDirection();
        addStyleName(css.north());
        show();
        int top = widget.getAbsoluteTop() + widget.getOffsetHeight();
        int left = widget.getAbsoluteLeft() - ((this.getOffsetWidth() - widget.getOffsetWidth()) / 2);
        moveTo(top, left);
    }

    /**
     * Show on the left of the provided widget
     *
     * @param widget
     */
    public void showWestOf(Widget widget, String text) {
        init(text);
        clearDirection();
        addStyleName(css.east());
        show();
        int top = widget.getAbsoluteTop() - ((this.getOffsetHeight() - widget.getOffsetHeight()) / 2);
        int left = widget.getAbsoluteLeft() - this.getOffsetWidth() - 1;
        moveTo(top, left);
    }

    private void clearDirection() {
        removeStyleName(css.north());
        removeStyleName(css.south());
        removeStyleName(css.east());
        removeStyleName(css.west());
    }

    private void init(String text) {
        innerLabel.setText(text);
    }

    private void show() {
        DOM.setStyleAttribute(element, "position", "absolute");
        RootPanel.get().add(this);
    }

    private void moveTo(int top, int left) {
        DOM.setStyleAttribute(element, "left", String.valueOf(left) + "px");
        DOM.setStyleAttribute(element, "top", String.valueOf(top) + "px");
    }

    public void hide() {
        RootPanel.get().remove(this);
    }
}
