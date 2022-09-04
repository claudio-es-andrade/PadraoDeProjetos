package claudioESandrade.EnvioMsgTelegram.Model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String msg;


    public Usuario() {
        super();
    }

    public Usuario(Long id, String nome, String msg) {
        super();
        this.id = id;
        this.nome = nome;
        this.msg = msg;
    }

    public Usuario(String nome, String msg) {
        super();
        this.nome = nome;
        this.msg = msg;
    }

    public Long  getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
