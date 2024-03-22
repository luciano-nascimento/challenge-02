package lucianonascimento.challenge02.model;

public enum UserTypeEnum {

    DEFAULT("DEFAULT"),
    SHOPKEEPER("SHOPKEEPER");
    private String description;

    UserTypeEnum(String descricao) {
        this.description = descricao;
    }

    public String getDescricao() {
        return description;
    }
}
