package com.proj.tech.model.blocks;

import jakarta.persistence.*;

@Entity
@Table(name = "SP_INSTRUCTION")
public abstract class InstructionEntity {

    @Id
    @GeneratedValue
    private Long id;


    @Column
    private String name;

    @Column
    private Character instruction;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Character getInstruction() {
        return instruction;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInstruction(Character instruction) {
        this.instruction = instruction;
    }

    public InstructionEntity() {}

    public InstructionEntity(Long id, String name, Character instruction) {
        this.id = id;
        this.name = name;
        this.instruction = instruction;
    }
}
