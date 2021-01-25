package JdiHomework.main.entities;

import com.epam.jdi.tools.DataClass;

import java.util.Arrays;

public class MetalsAndColorsDataset extends DataClass<MetalsAndColorsDataset> {
    public int[] summary;
    public int sum;
    public String[] elements;
    public String color;
    public String metals;
    public String[] vegetables;

    public int[] getSummary() {
        return summary;
    }

    public int getSum(){
        if(this.summary != null) return this.sum = this.summary[0] + this.summary[1];
        else return sum;
    }

    public String[] getElements() {
        return elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetals() {
        return metals;
    }

    public String[] getVegetables() {
        return vegetables;
    }

    @Override
    public String toString() {
        return "Dataset{" +
                "sum =" + getSum() +
                ", elements=" + Arrays.toString(elements) +
                ", color='" + color + '\'' +
                ", metals='" + metals + '\'' +
                ", vegetables=" + Arrays.toString(vegetables) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MetalsAndColorsDataset))
            return false;
        MetalsAndColorsDataset other = (MetalsAndColorsDataset) o;

        if (!(this.getSum() == other.getSum())) return false;
        if (!(Arrays.equals(this.elements, other.elements))) return false;
        if (!(this.color.equals(other.color))) return false;
        if (!(this.metals.equals(other.metals))) return false;
        if (!(Arrays.equals(this.vegetables, other.vegetables))) return false;
        return true;
    }
}