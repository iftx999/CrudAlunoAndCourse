package com.loiane.service;

import com.loiane.dto.AlunoDTO;
import com.loiane.dto.mapper.AlunoMapper;
import com.loiane.exception.RecordNotFoundException;
import com.loiane.repository.AlunoRepository;
import com.loiane.repository.AlunoRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Validated
@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final  AlunoMapper alunoMapper ;

    public AlunoService(AlunoRepository alunoRepository, AlunoMapper alunoMapper) {
        this.alunoRepository = alunoRepository;
        this.alunoMapper = alunoMapper;
    }

    public List<AlunoDTO> list() {
        return alunoRepository.findAll()
                .stream()
                .map(alunoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AlunoDTO findById(@PathVariable @NotNull @Positive Long id) {
        return alunoRepository.findById(id).map(alunoMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public AlunoDTO create(@Valid @NotNull AlunoDTO course) {
        return alunoMapper.toDTO(alunoRepository.save(alunoMapper.toEntity(course)));
    }

    public AlunoDTO update(@NotNull @Positive Long id, @Valid @NotNull AlunoDTO aluno) {
        return alunoRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setNome(aluno.nome());
                    recordFound.setCpf(aluno.cpf());
                    return alunoMapper.toDTO(alunoRepository.save(recordFound));
                }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@PathVariable @NotNull @Positive Long id) {
        alunoRepository.delete(alunoRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
