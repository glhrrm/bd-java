package dao;

public enum SQLs {

    INSERT_DEPARTAMENTO("insert into departamento (idDepartamento, nome) values (departamento_seq.nextval, ?)"),
    LISTALL_DEPARTAMENTO("select * from departamento"),
    UPDATE_DEPARTAMENTO("update departamento set nome = ? where idDepartamento = ?"),
    DELETE_DEPARTAMENTO("delete from departamento where idDepartamento = ?"),
    FINDBYID_DEPARTAMENTO("select * from departamento where idDepartamento = ?"),
    
    INSERT_SISTEMA("insert into sistema (idSistema, ativo, criacao, idUsuario) values (sistema_seq.nextval, ?, ?, ?)"),
    LISTALL_SISTEMA("select * from sistema"),
    UPDATE_SISTEMA("update sistema set ativo = ?, criacao = ?, idUsuario = ? where idSistema = ?"),
    DELETE_SISTEMA("delete from sistema where idSistema = ?"),
    FINDBYID_SISTEMA("select * from sistema where idSistema = ?"),
    
    INSERT_PERMISSAO("insert into permissao (idPermissao, nome) values (permissao_seq.nextval, ?)"),
    LISTALL_PERMISSAO("select * from permissao"),
    UPDATE_PERMISSAO("update permissao set nome = ? where idPermissao = ?"),
    DELETE_PERMISSAO("delete from permissao where idPermissao = ?"),
    FINDBYID_PERMISSAO("select * from permissao where idPermissao = ?"),
    
    INSERT_USUARIO("insert into usuario (idUsuario, nome, idDepartamento, idPermissao) values (usuario_seq.nextval, ?, ?, ?)"),
    LISTALL_USUARIO("select * from usuario"),
    UPDATE_USUARIO("update usuario set nome = ?, idDepartamento = ?, idPermissao = ? where idUsuario = ?"),
    DELETE_USUARIO("delete from usuario where idUsuario = ?"),
    FINDBYID_USUARIO("select * from usuario where idUsuario = ?"),
    
    INSERT_VERSAO("insert into versoes (idVersao, versao, novidades, idSistema) values (versoes_seq.nextval, ?, ?, ?)"),
    LISTALL_VERSAO("select * from versoes"),
    UPDATE_VERSAO("update versoes set versao = ?, novidades = ?, idSistema = ? where idVersao = ?"),
    DELETE_VERSAO("delete from versoes where idVersao = ?"),
    FINDBYID_VERSAO("select * from versoes where idVersao = ?");
    
    private final String sql;

    private SQLs(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }

}
