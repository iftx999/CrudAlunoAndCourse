package com.loiane.dto.mapper;

import com.loiane.dto.AlunoDTO;
import com.loiane.dto.AlunoDTO;
import com.loiane.model.Aluno;
import com.loiane.model.Course;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {
    public AlunoDTO toDTO(Aluno aluno) {
        if (aluno == null) {
            return null;
        }
        return new AlunoDTO(aluno.getId(), aluno.getNome(), aluno.getCpf());
    }

    public Aluno toEntity(AlunoDTO alunoDTO) {

        if (alunoDTO == null) {
            return null;
        }

        Aluno aluno = new Aluno();
        if (alunoDTO.id() != null) {
            aluno.setId(alunoDTO.id());
        }
        aluno.setNome(alunoDTO.nome());
        aluno.setCpf(alunoDTO.cpf());
        return aluno;
    }
}
