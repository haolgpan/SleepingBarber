public class Client extends Thread{
    Barberia barberia;
    public Client(String name, Barberia barberia){
        super(name);
        this.barberia = barberia;
    }
    @Override
    public void run(){
        barberia.admissioClients(this);
    }
}
