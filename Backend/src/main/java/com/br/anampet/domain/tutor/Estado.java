package com.br.anampet.domain.tutor;

import lombok.Getter;

@Getter
public enum Estado {
    AC(1),
    AL(2),
    AP(3),
    AM(4),
    BA(5),
    CE(6),
    DF(7),
    ES(8),
    GO(9),
    MA(10),
    MT(11),
    MS(12),
    MG(13),
    PA(14),
    PB(15),
    PR(16),
    PE(17),
    PI(18),
    RJ(19),
    RN(20),
    RS(21),
    RO(22),
    RR(23),
    SC(24),
    SP(25),
    SE(26),
    TO(27);

    private int codigo_estado;

    private Estado(int codigo) {
        this.codigo_estado = codigo;
    }

    public static Estado valueOf(int codigo) {
        for(Estado estado : Estado.values()) {
            if(estado.getCodigo_estado() == codigo)
                return estado;
        }
        throw new IllegalArgumentException("Estado inválido!");
    }

}