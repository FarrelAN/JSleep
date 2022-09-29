package MFarrelAthaillahNugrohoJSleepMN;

public class Complaint extends Serializable
{
    public String desc;
    public String date;
    
    public Complaint(int id, String date, String desc)
    {
        super(id);
        this.desc = desc;
        this.date = date;
    }
    
    public String toString(){
        return "Complaint ID: " + super.id + "\nDate: " + this.date + "\nDesc: " + this.desc;
    }

}