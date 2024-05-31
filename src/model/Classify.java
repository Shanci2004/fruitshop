package model;

public class Classify {
    private int classifyId;
    private String classifyName;

    public int getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(int classifyId) {
        this.classifyId = classifyId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public Classify(int classifyId, String classifyName) {
        this.classifyId = classifyId;
        this.classifyName = classifyName;
    }

    public Classify() {
    }

    @Override
    public String toString() {
        return "Classify{" +
                "classifyId=" + classifyId +
                ", classifyName='" + classifyName + '\'' +
                '}';
    }
}
