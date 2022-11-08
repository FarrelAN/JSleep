package com.MFarrelAthaillahNugrohoJSleepMN;
/**
 * Ini adalah class Rating
 * @author M. Farrel Athaillah Nugroho
 * @version Modul 7
 */
public class Rating
{
    private long total;
    private long count;
    
   public Rating (){
       this.total = 0;
       this.count = 0;
   }
   public void insert(int rating){
       this.total = this.total + (long)rating;
       this.count+=1;
   }
      public double getAverage(){
       if(this.count == 0){
           return 0;
       }
       return (double)this.total/this.count;
   }
   public long getCount(){
       return this.count;
   }
   public long getTotal(){
       return this.total;
   }
   public String toString(){
       return "====Rating====\n" + "Total : " + total + "\nCount : " + count; 
   }
}
