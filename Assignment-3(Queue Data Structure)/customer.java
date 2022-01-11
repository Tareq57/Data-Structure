public class customer {
    private int enter , leave, service, queue,id;

    public customer(int enter, int service) {
        this.enter = enter;
        this.service = service;
    }

    public int getEnter() {
        return enter;
    }

    public void setEnter(int enter) {
        this.enter = enter;
    }

    public int getLeave() {
        return leave;
    }

    public void setLeave(int leave) {
        this.leave = leave;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public int getQueue() {
        return queue;
    }

    public void setQueue(int queue) {
        this.queue = queue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "customer{" +
                "enter=" + enter +
                ", leave=" + leave +
                ", service=" + service +
                ", queue=" + queue +
                ", id=" + id +
                '}';
    }
}
