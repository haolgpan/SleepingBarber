public class Barber extends Thread{
    Barberia barberia;
    public Barber(Barberia barberia){
        this.barberia = barberia;
    }
    @Override
    public void run(){
        System.out.println("Barber entra treballar.");
        for(;;) {
            barberia.tallarCabells();
        }
    }
}
