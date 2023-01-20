
public class BarberAdormit {
    public static void main(String[] args) {
        Barberia barberia = new Barberia();
        Barber barber = new Barber(barberia);
        int cont = 1;
        barber.start();
        Client client;

        for(int i = 0; i < 10; i++){
            try {
                Thread.sleep((long) (Math.random()*5000)+2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            client = new Client(String.valueOf(cont),barberia);
            client.start();
            ++cont;
        }
    }
}