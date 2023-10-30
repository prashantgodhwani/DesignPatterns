package SpecificationDesignPattern.models;

public class File extends Entry {
    private byte[] content;

    public String getName(){
        return super.getName().substring(0, super.getName().indexOf("."));
    }

    public String getExtension() {
        return super.getName().substring(super.getName().indexOf(".") + 1);
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

    @Override
    public String toString() {
        return "File{" +
                "name='" + this.getName() + '\'' +
                '}';
    }
}
