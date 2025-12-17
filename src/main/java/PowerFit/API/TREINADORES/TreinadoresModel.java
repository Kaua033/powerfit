package PowerFit.API.TREINADORES;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = ("TREINADORES"))
@AllArgsConstructor
@NoArgsConstructor
@Data

public class TreinadoresModel {

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
