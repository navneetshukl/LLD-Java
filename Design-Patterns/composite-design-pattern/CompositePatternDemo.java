public class CompositePatternDemo{
    public static void main(String[] args) {
        
        // leaf files
        FileComponent file1=new FileLeaf("notes.txt",10);
        FileComponent file2=new FileLeaf("photo.png",200);
        FileComponent file3=new FileLeaf("resume.pdf",50);

        // folders (composites)
        FolderComposite documents=new FolderComposite("Documents");
        FolderComposite images=new FolderComposite("Images");

        // build structure
        images.add(file2);
        documents.add(file1);
        documents.add(images);
        documents.add(file3);

        documents.showDetails();
        System.out.println("Total Size: " + documents.getSize() + " KB");

        System.out.println("Searching for resume.pdf: " + documents.search("resume.pdf"));
        System.out.println("Searching for video.mp4: " + documents.search("video.mp4"));
    }
}