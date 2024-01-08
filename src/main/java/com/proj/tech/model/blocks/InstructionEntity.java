package com.proj.tech.model.blocks;

import jakarta.persistence.*;

/**
 * Represents an instruction entity in the application.
 * Each instruction belongs to a code (CodeEntity) and has a specific order within the code.
 */
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
    private Integer orderInCode;

    /**
     * Gets the unique identifier for the instruction.
     *
     * @return The instruction's ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Gets the name of the instruction.
     *
     * @return The instruction's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the character representation of the instruction.
     *
     * @return The instruction character.
     */
    public Character getInstruction() {
        return instruction;
    }

    /**
     * Gets the code (CodeEntity) to which the instruction belongs.
     *
     * @return The code to which the instruction belongs.
     */
    public CodeEntity getCode() {
        return code;
    }

    /**
     * Gets the order of the instruction within the code.
     *
     * @return The order of the instruction.
     */
    public Integer getOrderInCode() {
        return this.orderInCode;
    }

    /**
     * Sets the unique identifier for the instruction.
     *
     * @param id The instruction's ID.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Sets the name of the instruction.
     *
     * @param name The instruction's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the character representation of the instruction.
     *
     * @param instruction The instruction character.
     */
    public void setInstruction(Character instruction) {
        this.instruction = instruction;
    }

    /**
     * Sets the code (CodeEntity) to which the instruction belongs.
     *
     * @param code The code to which the instruction belongs.
     */
    public void setCode(CodeEntity code) {
        this.code = code;
    }

    /**
     * Sets the order of the instruction within the code.
     *
     * @param orderInCode The order of the instruction.
     */
    public void setOrderInCode(Integer orderInCode) {
        this.orderInCode = orderInCode;
    }

    /**
     * Default constructor for the InstructionEntity class.
     */
    public InstructionEntity() {
    }

    /**
     * Parameterized constructor for the InstructionEntity class with the instruction's name, character representation,
     * associated code, and order within the code.
     *
     * @param name         The name of the instruction.
     * @param instruction  The character representation of the instruction.
     * @param code         The code to which the instruction belongs.
     * @param orderInCode  The order of the instruction within the code.
     */
    public InstructionEntity(String name, Character instruction, CodeEntity code, Integer orderInCode) {
        this.name = name;
        this.instruction = instruction;
        this.code = code;
        this.orderInCode = orderInCode;
    }

    /**
     * Parameterized constructor for the InstructionEntity class with the instruction's ID, name, character representation,
     * associated code, and order within the code.
     *
     * @param id           The ID of the instruction.
     * @param name         The name of the instruction.
     * @param instruction  The character representation of the instruction.
     * @param code         The code to which the instruction belongs.
     * @param orderInCode  The order of the instruction within the code.
     */
    public InstructionEntity(Long id, String name, Character instruction, CodeEntity code, Integer orderInCode) {
        this.id = id;
        this.name = name;
        this.instruction = instruction;
        this.code = code;
        this.orderInCode = orderInCode;
    }
}
