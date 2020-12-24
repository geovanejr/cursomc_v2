package br.com.geovanejunior.cursomc.domain.enums;

public enum Perfil {

    ADMIN(1, "ROLE_ADMIN"),
    CLIENTE(2, "ROLE_CLIENTE");

    private int codPerfil;
    private String descrPerfil;

    private Perfil(int codPerfil, String descrPerfil) {

        this.codPerfil = codPerfil;
        this.descrPerfil = descrPerfil;
    }

    public int getcodPerfil() {
        return codPerfil;
    }

    public void setcodPerfil(int codPerfil) {
        this.codPerfil = codPerfil;
    }

    public String getdescrPerfil() {
        return descrPerfil;
    }

    public void setdescrPerfil(String descrPerfil) {
        this.descrPerfil = descrPerfil;
    }

    public static Perfil toEnum(Integer codPerfil) {

        if (codPerfil == null) {

            return null;
        }

        for (Perfil perfil : Perfil.values()) {
            if (codPerfil.equals(perfil.getcodPerfil())) {

                return perfil;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + codPerfil);

    }
    
}
