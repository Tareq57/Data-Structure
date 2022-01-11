public class Item {
   private int id,push_time,item_id;

    public Item(int id, int push_time, int item_id) {
        this.id = id;
        this.push_time = push_time;
        this.item_id = item_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPush_time() {
        return push_time;
    }

    public void setPush_time(int push_time) {
        this.push_time = push_time;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", push_time=" + push_time +
                ", item_id=" + item_id +
                '}';
    }
}
