package _bits.LegalizaMais.utils;

public class CnpjValidator {
    /**
     * Valida um número de CNPJ.
     *
     * @param cnpj String contendo o CNPJ (com ou sem pontuação)
     * @return true se o CNPJ for válido, false caso contrário
     */
    public static boolean isValid(String cnpj) {
        if (cnpj == null) return false;

        // Remove caracteres não numéricos
        cnpj = cnpj.replaceAll("[^\\d]", "");

        // Verifica se tem 14 dígitos
        if (cnpj.length() != 14) return false;

        // Elimina CNPJs formados por dígitos iguais (ex: 11111111111111)
        if (cnpj.matches("(\\d)\\1{13}")) return false;

        try {
            // Calcula os dois dígitos verificadores
            int[] peso1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
            int[] peso2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

            int soma = 0;
            for (int i = 0; i < 12; i++) {
                soma += (cnpj.charAt(i) - '0') * peso1[i];
            }
            int digito1 = soma % 11 < 2 ? 0 : 11 - (soma % 11);

            soma = 0;
            for (int i = 0; i < 13; i++) {
                soma += (cnpj.charAt(i) - '0') * peso2[i];
            }
            int digito2 = soma % 11 < 2 ? 0 : 11 - (soma % 11);

            // Verifica se os dígitos calculados são iguais aos informados
            return (digito1 == (cnpj.charAt(12) - '0')) && (digito2 == (cnpj.charAt(13) - '0'));
        } catch (Exception e) {
            return false;
        }
    }
}
