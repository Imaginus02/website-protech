package com.proj.tech.model.blocks;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

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
