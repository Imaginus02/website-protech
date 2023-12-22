package com.proj.tech.model.blocks;

import com.proj.tech.model.UserProfessorEntity;
import jakarta.persistence.*;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table(name = "SP_CODE")
public class CodeEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @OneToMany(cascade = ALL, mappedBy = "code")
    private Set<InstructionEntity> instructions = Set.of();

    @ManyToOne
    private UserProfessorEntity creator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<InstructionEntity> getInstructions() {
        return instructions;
    }

    public void setInstructions(Set<InstructionEntity> instructions) {
        this.instructions = instructions;
        this.instructions = this.instructions.stream().sorted(Comparator.comparing(InstructionEntity::getOrderInCode)).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public UserProfessorEntity getCreator() {
        return this.creator;
    }

    public void setCreator(UserProfessorEntity creator) {
        this.creator = creator;
    }

    public void addInstructions(InstructionEntity instruction) {
        this.instructions.add(instruction);
    }

    public CodeEntity() {
    }

    public CodeEntity(String name) {
        this.name = name;
    }

    public CodeEntity(String name, Set<InstructionEntity> instructions) {
        this.name = name;
        this.instructions = instructions;
    }

    public CodeEntity(Long id, String name, Set<InstructionEntity> instructions) {
        this.id = id;
        this.name = name;
        this.instructions = instructions;
    }
}
