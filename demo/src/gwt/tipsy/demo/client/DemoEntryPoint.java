package gwt.tipsy.demo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class DemoEntryPoint implements EntryPoint {
    public void onModuleLoad() {
        RootLayoutPanel.get().add(new DemoView());
    }
}
