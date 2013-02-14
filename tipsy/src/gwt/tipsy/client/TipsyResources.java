package gwt.tipsy.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.DataResource;

public interface TipsyResources extends ClientBundle {

    static TipsyResources INSTANCE = GWT.create(TipsyResources.class);
    
    interface Css extends CssResource {

        @CssResource.ClassName("cw-Tipsy")
        String tipsy();

        @CssResource.ClassName("cw-Tipsy-inner")
        String tipsyInner();

        @CssResource.ClassName("cw-Tipsy-north")
        String north();

        @CssResource.ClassName("cw-Tipsy-south")
        String south();

        @CssResource.ClassName("cw-Tipsy-east")
        String east();

        @CssResource.ClassName("cw-Tipsy-west")
        String west();
    }

    @ClientBundle.Source("tipsy.css")
    Css css();

    @ClientBundle.Source("tipsy-north.gif")
    DataResource north();

    @ClientBundle.Source("tipsy-east.gif")
    DataResource east();

    @ClientBundle.Source("tipsy-west.gif")
    DataResource west();

    @ClientBundle.Source("tipsy-south.gif")
    DataResource south();
}
