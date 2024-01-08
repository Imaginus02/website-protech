package com.proj.tech.services;

import com.proj.tech.model.blocks.CodeEntity;
import com.proj.tech.model.blocks.InstructionEntity;

import java.util.Comparator;
import java.util.List;

/**
 * Utility class for translating {@link CodeEntity} objects to String representations.
 * This class provides methods to translate a code to a single String and to a list of Strings.
 * The translation is based on the order of instructions in the code.
 */
public class CodeToStringTranslator {

    private final JavaArduinoTranslator javaArduinoTranslator = new JavaArduinoTranslator();

    /**
     * Translates the given {@link CodeEntity} to a single String.
     *
     * @param code The code entity to be translated.
     * @return A String representation of the code.
     */
    public String translate(CodeEntity code) {
        StringBuilder tempo = new StringBuilder();
        List<InstructionEntity> sortedInstructions = code.getInstructions()
                .stream()
                .sorted(Comparator.comparingInt((InstructionEntity::getOrderInCode)))
                .toList();
        for (InstructionEntity instruction : code.getInstructions()) {
            tempo.append(instruction.getInstruction());
        }
        return tempo.toString();
    }

    /**
     * Translates the given {@link CodeEntity} to a list of Strings.
     *
     * @param code The code entity to be translated.
     * @return A list of String representations of the code instructions.
     */
    public List<String> translateToList(CodeEntity code) {
        List<String> tempo = new java.util.ArrayList<>(List.of());
        List<InstructionEntity> sortedInstructions = code.getInstructions()
                .stream()
                .sorted(Comparator.comparingInt((InstructionEntity::getOrderInCode)))
                .toList();
        for (InstructionEntity instruction : code.getInstructions()) {
            tempo.add(javaArduinoTranslator.reverseTranslate(instruction.getInstruction()));
        }
        return tempo;
    }

}
