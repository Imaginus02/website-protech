package com.proj.tech.model.blocks;

import com.proj.tech.model.UserProfessorEntity;
import jakarta.persistence.*;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static jakarta.persistence.CascadeType.ALL;

/**
 * Represents a code entity in the application.
 * Each code can have a set of instructions and is associated with a creator (UserProfessorEntity).
 */
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

    /**
     * Gets the unique identifier for the code.
     *
     * @return The code's ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the code.
     *
     * @param id The code's ID.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the code.
     *
     * @return The code's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the code.
     *
     * @param name The code's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the set of instructions associated with the code.
     *
     * @return The set of instructions.
     */
    public Set<InstructionEntity> getInstructions() {
        return instructions;
    }

    /**
     * Sets the set of instructions associated with the code.
     *
     * @param instructions The set of instructions.
     */
    public void setInstructions(Set<InstructionEntity> instructions) {
        this.instructions = instructions;
        this.instructions = this.instructions.stream()
                .sorted(Comparator.comparing(InstructionEntity::getOrderInCode))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /**
     * Gets the creator (UserProfessorEntity) of the code.
     *
     * @return The creator of the code.
     */
    public UserProfessorEntity getCreator() {
        return this.creator;
    }

    /**
     * Sets the creator (UserProfessorEntity) of the code.
     *
     * @param creator The creator of the code.
     */
    public void setCreator(UserProfessorEntity creator) {
        this.creator = creator;
    }

    /**
     * Adds an instruction to the set of instructions associated with the code.
     *
     * @param instruction The instruction to be added.
     */
    public void addInstructions(InstructionEntity instruction) {
        this.instructions.add(instruction);
    }

    /**
     * Default constructor for the CodeEntity class.
     */
    public CodeEntity() {
    }

    /**
     * Parameterized constructor for the CodeEntity class with the code's name.
     *
     * @param name The name of the code.
     */
    public CodeEntity(String name) {
        this.name = name;
    }

    /**
     * Parameterized constructor for the CodeEntity class with the code's name and set of instructions.
     *
     * @param name         The name of the code.
     * @param instructions The set of instructions associated with the code.
     */
    public CodeEntity(String name, Set<InstructionEntity> instructions) {
        this.name = name;
        this.instructions = instructions;
    }

    /**
     * Parameterized constructor for the CodeEntity class with the code's ID, name, and set of instructions.
     *
     * @param id           The ID of the code.
     * @param name         The name of the code.
     * @param instructions The set of instructions associated with the code.
     */
    public CodeEntity(Long id, String name, Set<InstructionEntity> instructions) {
        this.id = id;
        this.name = name;
        this.instructions = instructions;
    }
}