package com.proj.tech.services;

import com.proj.tech.model.blocks.CodeEntity;
import com.proj.tech.model.blocks.InstructionEntity;

import java.util.Comparator;
import java.util.List;

public class CodeToStringTranslator {

    private final JavaArduinoTranslator javaArduinoTranslator = new JavaArduinoTranslator();

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
