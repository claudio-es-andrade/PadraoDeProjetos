package claudioESandrade.EnvioMsgTelegram.Controller;

import claudioESandrade.EnvioMsgTelegram.Model.Usuario;
import claudioESandrade.EnvioMsgTelegram.Service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<Iterable<Usuario>> buscarTodos() {
        return ResponseEntity.ok(usuarioService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> inserir(@RequestBody Usuario usuario) {
        usuarioService.inserir(usuario);

        String infoUser = " De: " +  usuario.getNome()  + " : A MENSAGEM: " + usuario.getMsg();
        String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
        //Add Telegram token (given Token is fake)
        String apiToken = "239287362:tyhERhehjr-dfg345gDFGWERWg245gwdfge";
        //Add chatId (given chatId is fake)
        String chatId = "8210987654";
        String text = infoUser;

        urlString = String.format(urlString, apiToken, chatId, text);
        RestTemplate restTemplate = new RestTemplate();
        String msgEnviada = restTemplate.getForObject(urlString , String.class );


        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario > atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuarioService.atualizar(id, usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.ok().build();
    }


}
