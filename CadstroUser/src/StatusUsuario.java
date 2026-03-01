public enum StatusUsuario {

    ATIVO,
    BLOQUEADO,
    INATIVO;

    public boolean podeAtualizar() {
        return this == ATIVO;
    }

    public boolean podeSerRemovido() {
        return this != INATIVO;
    }

    public boolean podeSerBloqueado() {
        return this == ATIVO;
    }

    public boolean podeSerDesbloqueado() {
        return this == BLOQUEADO;
    }

    public StatusUsuario remover() {
        if (!podeSerRemovido()) {
            return this;
        }
        return INATIVO;
    }

    public StatusUsuario bloquear() {
        if (!podeSerBloqueado()) {
            return this;
        }
        return BLOQUEADO;
    }

    public StatusUsuario desbloquear() {
        if (!podeSerDesbloqueado()) {
            return this;
        }
        return ATIVO;
    }
}