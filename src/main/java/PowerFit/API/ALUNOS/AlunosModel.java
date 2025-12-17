package PowerFit.API.ALUNOS;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = ("ALUNOS"))
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlunosModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
@Column(name = "ID", unique = true)
    Long ID;
@Column(name = "nome")
    String nome;
@Column(name = "idade")
    int idade;
@Column(name = "telefone", unique = true)
    String telefone;
@Column(name = "email", unique = true)
    String email;

}
