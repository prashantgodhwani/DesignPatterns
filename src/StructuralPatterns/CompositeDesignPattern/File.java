package StructuralPatterns.CompositeDesignPattern;

public class File extends Entry {
    private byte[] content;

    public String getFileName(){
        return this.getName().substring(0, super.getName().indexOf("."));
    }

    public String getExtension() {
        return this.getName().substring(this.getName().indexOf(".") + 1);
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public byte[] getContent() {
        return content;
    }

    @Override
    public int getSize() {
        return content.length;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    public void ls(){
        System.out.println("*" + this.getName());
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + this.getName() + '\'' +
                '}';
    }
}
