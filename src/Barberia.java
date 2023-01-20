import java.util.LinkedList;

public class Barberia {
    int cadires;
    final LinkedList<Client> clients;
    public Barberia() {
        cadires = 4;
        clients = new LinkedList<>();
    }
    public synchronized void tallarCabells(){
        Client client;
        synchronized (clients){
            while(clients.size() == 0){
                System.out.println("Barber adormit.");
                System.out.println("En cua hi ha " + clients.size() + " pers.");
                try{
                    clients.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println("Client avisa al Barber.");
            client = clients.poll();
        }
        assert client != null;
        System.out.println("Tallant els cabells del client" + client.getName() + ".");
        long temps;
        try {
            temps =(long) (Math.random()*8000)+6000;
            Thread.sleep(temps);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Temps trigat en tallar els cabells del client" + client.getName() + ": " + temps + "." );
    }
    public void admissioClients(Client client){
        System.out.println("Entra el client: client" + client.getName() + ".");
        synchronized (clients){
            if(clients.size() == cadires){
                System.out.println("No hi han cadires suficients per el client" + client.getName() + ".");
                System.out.println("El client" + client.getName()+ " marxa trist.");
                return;
            }
            clients.offer(client);
            System.out.println("El client" + client.getName() + " s'asseu en una cadira.");
            System.out.println("En cua hi ha " + clients.size() + " pers.");
            if(clients.size() == 1) clients.notifyAll();
        }
    }
}
