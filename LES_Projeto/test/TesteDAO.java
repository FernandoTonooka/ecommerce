
import dao.CartaoDAO;
import domain.Cartao;
import domain.Cliente;
import java.time.LocalDate;


public class TesteDAO {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(1);
        Cartao cartao = new Cartao();
        cartao.setBandeira("Visa");
        cartao.setNome("Jose da Silva");
        cartao.setNumero("123412341234");
        cartao.setValidade(LocalDate.parse("2023-11-11"));
        cartao.setCvv("367");
        cartao.setCliente(cliente);
       
        CartaoDAO cartaodao = new CartaoDAO(); 
        cartaodao.salvar(cartao);
    }
    
}
