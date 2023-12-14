package com.proj.tech.model.blocks;

import jakarta.persistence.*;

@Entity
@Table(name = "SP_INSTRUCTION")
public class InstructionEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private Character instruction;

    @ManyToOne(optional = false)
    private CodeEntity code;

    @Column
    private Long orderInCode;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Character getInstruction() {
        return instruction;
    }

    public CodeEntity getCode() {
        return code;
    }

    public Long getOrderInCode() {
        return this.orderInCode;
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

    public void setCode(CodeEntity code) {
        this.code = code;
    }

    public void setOrderInCode(Long order) {
        this.orderInCode = order;
    }

    public InstructionEntity() {
    }

    public InstructionEntity(String name, Character instruction, CodeEntity code, Long orderInCode) {
        this.name = name;
        this.instruction = instruction;
        this.code = code;
        this.orderInCode = orderInCode;
    }

    public InstructionEntity(Long id, String name, Character instruction, CodeEntity code, Long orderInCode) {
        this.id = id;
        this.name = name;
        this.instruction = instruction;
        this.code = code;
        this.orderInCode = orderInCode;
    }
}
