import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new Human[0];
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void addChild(Human child) {
        Human[] newChildren = Arrays.copyOf(children, children.length + 1);
        newChildren[children.length] = child;
        children = newChildren;
        child.setFamily(this);
    }

    public boolean deleteChild(Human child) {
        int index = -1;
        for (int i = 0; i < children.length; i++) {
            if (Objects.equals(children[i], child)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            Human[] newChildren = new Human[children.length - 1];
            System.arraycopy(children, 0, newChildren, 0, index);
            System.arraycopy(children, index + 1, newChildren, index, children.length - index - 1);
            children = newChildren;
            child.setFamily(null);
            return true;
        }

        return false;
    }

    public int countFamily() {
        return 2 + children.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Family: \n");
        sb.append("Mother: ").append(mother.toString()).append("\n");
        sb.append("Father: ").append(father.toString()).append("\n");
        sb.append("Children: \n");
        for (Human child : children) {
            sb.append(child.toString()).append("\n");
        }
        if (pet != null) {
            sb.append("Pet: ").append(pet.toString()).append("\n");
        }
        return sb.toString();
    }
}
