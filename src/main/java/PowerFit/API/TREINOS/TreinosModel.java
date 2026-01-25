package PowerFit.API.TREINOS;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = ("TREINOS"))
@AllArgsConstructor
@NoArgsConstructor
@Data

public class TreinosModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", unique = true)
    Long ID;
    @Column(name = "nome")
    String nome;


    public void setNome(String nome) {
        this.nome = nome;
    }
  }
