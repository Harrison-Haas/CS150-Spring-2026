public class Borrower {
    private String id;
    private String name;
   
    public Borrower(String id, String name) {
        this.id = requireNotBlank(id, "id");
        this.name = requireNotBlank(name, "name");
    }

    private static String requireNotBlank(String value, String fieldName){
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " must not be null, empty, or whitespace");
        }
        return value;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null) return false;
        if(getClass() != o.getClass()) return false;

        Borrower other = (Borrower) o;
        return this.id.equals(other.id);
    }

    public int hashCode(){
        return id.hashCode();
    }

    public String toString(){
        return "" + name + " (" + id + ")";
    }
}
