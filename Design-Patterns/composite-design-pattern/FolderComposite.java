
import java.util.ArrayList;
import java.util.List;

public class FolderComposite implements FileComponent{
    private String name;
    private List<FileComponent> children=new ArrayList<>();

    public FolderComposite(String name){
        this.name=name;
    }

    public void add(FileComponent component){
        children.add(component);
    }

    public void remove(FileComponent component){
        children.remove(component);
    }

    @Override
    public void showDetails(){
        System.out.println("Folder: "+ name);
        for(FileComponent child:children){
            child.showDetails();
        }
    }
    @Override
    public int getSize(){
        int total=0;
        for(FileComponent child:children){
            total+=child.getSize();
        }
        return total;
    }

    @Override
    public boolean search(String name){
        for(FileComponent child: children){
            if(child.search(name)) return true;
        }
        return false;
    }
}