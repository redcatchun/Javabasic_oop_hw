package Bai2;

import java.util.Objects;

/**
 * Class Document
 */
public class Document {
    // id, ten, nha xuat ban, so ban phat hanh, number of Type: vd Book = 2, Journal = 2,...
    protected int id;
    protected String name;
    protected String nxb;
    protected int releaseNum;
    protected int numType;

    public Document(int id) {
        this.id = id;
    }

    public Document(int id, String name, String nxb, int releaseNum) {
        this.id = id;
        this.name = name;
        this.nxb = nxb;
        this.releaseNum = releaseNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public int getReleaseNum() {
        return releaseNum;
    }

    public void setReleaseNum(int releaseNum) {
        this.releaseNum = releaseNum;
    }

    public int getNumType() {
        return numType;
    }

    /**
     * @description: ham so sanh
     * @param: object, su dung mot object thuoc class Document
     * @return: true neu 2 obj trung ID
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Document)) return false;
        Document document = (Document) o;
        return id == document.id;
    }

    /**
     * @description: sua lai hashcode tra ve theo id de dung voi hashset
     * @param:
     * @return: hashcode cua id
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
