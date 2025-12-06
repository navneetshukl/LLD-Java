public class FileLeaf implements FileComponent{
    private String name;
    private int size;

    public FileLeaf(String name,int size){
        this.name=name;
        this.size=size;
    }
@Override
    public void showDetails(){
        System.out.println("File: "+name + " (" +size + " KB)");

    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean search(String name){
        return this.name.equalsIgnoreCase(name);

    }
}