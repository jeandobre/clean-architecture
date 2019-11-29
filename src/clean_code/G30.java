package clean_code;

import java.util.List;

public class G30 {

    private final List<Employee> employes;

    public G30(List<Employee> employes) {
        this.employes = employes;
    }

    class Money{

    }

    class Employee{
        boolean isPayday(){
            return true;
        }
        void devliveryPay(Money pay){

        }
        Money calculatePay(){
            return new Money();
        }
    }
    // Exemplo de como refatorar
    public void pay_ruim(){
        for(Employee e : employes){
            if(e.isPayday()){
                Money pay = e.calculatePay();
                e.devliveryPay(pay);
            }
        }
    }

    /**
     * As funções devem fazer uma coisa só
     */
    public void pay(){
        for(Employee e: employes)
            payIfNecessary(e);
    }

    private void payIfNecessary(Employee e){
        if(e.isPayday())
            caculateAndDeliveryPay(e);
    }

    private void caculateAndDeliveryPay(Employee e){
        Money pay = e.calculatePay();
        e.devliveryPay(pay);
    }
}
