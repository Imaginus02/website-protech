package com.proj.tech.model.blocks;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "SP_CODE")
public class CodeEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @OneToMany
    private List<InstructionEntity> instructions;

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

    public List<InstructionEntity> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<InstructionEntity> instructions) {
        this.instructions = instructions;
    }

    public CodeEntity() {}

    public CodeEntity(Long id, String name, List<InstructionEntity> instructions) {
        this.id = id;
        this.name = name;
        this.instructions = instructions;
    }
}
