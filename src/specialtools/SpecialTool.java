package specialtools;
import exceptions.BoxAlreadyFixedException;
import mains.BoxGrid;

public interface SpecialTool {
    public void useTool(BoxGrid boxGrid)throws BoxAlreadyFixedException;
    public String getName();
}
