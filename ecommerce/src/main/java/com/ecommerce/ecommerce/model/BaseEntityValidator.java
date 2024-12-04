package com.ecommerce.ecommerce.model;


public class BaseEntityValidator {

    public static void validarItem(Produto item) {
        if (item.getNome() == null || item.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
        }

        // Adicione outras validações conforme necessário
    }
}
