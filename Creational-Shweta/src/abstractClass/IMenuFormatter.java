package abstractClass;

import java.util.ArrayList;

import xyz.Xml;

public abstract class IMenuFormatter {

		abstract public void generateMenu(ArrayList<Xml> newData, String format, String country) throws Exception;
}
