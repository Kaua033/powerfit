package PowerFit.API.ALUNOS;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.coyote.http11.Constants.a;

@Controller
@RequestMapping("/alunos")
public class AlunoControllerUI {

    private final AlunosService alunosService;

    public AlunoControllerUI(AlunosService alunosService) {
        this.alunosService = alunosService;
    }

    @GetMapping
    public String listarTodos(Model model) {
        List<AlunosDTO> alunos = alunosService.listar();
        model.addAttribute("alunos", alunos);
        model.addAttribute("usuario", new AlunosDTO());
        return "alunos";
    }

    @PostMapping("/criar")
    public String criar(@ModelAttribute AlunosDTO aluno, RedirectAttributes redirect) {
        try {
            alunosService.CRIAR(aluno);
            redirect.addFlashAttribute("sucesso", "Aluno cadastrado!");
        } catch (Exception e) {
            redirect.addFlashAttribute("erro", "Erro: " + e.getMessage());
        }
        return "redirect:/alunos";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        AlunosDTO aluno = alunosService.LISTARID(id);
        model.addAttribute("aluno", aluno);
        return "aluno-form";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable Long id, @ModelAttribute AlunosDTO aluno, RedirectAttributes redirect) {
        try {
            alunosService.ATUALIZAR(aluno, id);
            redirect.addFlashAttribute("sucesso", "Aluno atualizado!");
        } catch (Exception e) {
            redirect.addFlashAttribute("erro", "Erro: " + e.getMessage());
        }
        return "redirect:/alunos";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id, RedirectAttributes redirect) {
        try {
            alunosService.deletar(id);
            redirect.addFlashAttribute("sucesso", "Aluno deletado!");
        } catch (Exception e) {
            redirect.addFlashAttribute("erro", "Erro: " + e.getMessage());
        }
        return "redirect:/alunos";
    }
}