package dao;

public enum SQLs {

    INSERT_DEPARTAMENTO("insert into departamento (id_Departamento, nome) values (departamento_seq.nextval, ?)"),
    LISTALL_DEPARTAMENTO("select * from departamento"),
    UPDATE_DEPARTAMENTO("update departamento set nome = ? where id_Departamento = ?"),
    DELETE_DEPARTAMENTO("delete from departamento where id_Departamento = ?"),
    FINDBYID_DEPARTAMENTO("select * from departamento where id_Departamento = ?"),
    
    INSERT_SISTEMA("insert into sistema (id_Sistema, ativo, criacao, id_Usuario) values (sistema_seq.nextval, ?, ?, ?)"),
    LISTALL_SISTEMA("select * from sistema"),
    UPDATE_SISTEMA("update sistema set ativo = ?, criacao = ?, id_Usuario = ? where id_Sistema = ?"),
    DELETE_SISTEMA("delete from sistema where id_Sistema = ?"),
    FINDBYID_SISTEMA("select * from sistema where id_Sistema = ?"),
    
    INSERT_PERMISSAO("insert into permissao (id_Permissao, nome) values (permissao_seq.nextval, ?)"),
    LISTALL_PERMISSAO("select * from permissao"),
    UPDATE_PERMISSAO("update permissao set nome = ? where id_Permissao = ?"),
    DELETE_PERMISSAO("delete from permissao where id_Permissao = ?"),
    FINDBYID_PERMISSAO("select * from permissao where id_Permissao = ?"),
    
    INSERT_USUARIO("insert into usuario (id_Usuario, nome, id_Departamento, id_Permissao) values (usuario_seq.nextval, ?, ?, ?)"),
    LISTALL_USUARIO("select * from usuario"),
    UPDATE_USUARIO("update usuario set nome = ?, id_Departamento = ?, id_Permissao = ? where id_Usuario = ?"),
    DELETE_USUARIO("delete from usuario where id_Usuario = ?"),
    FINDBYID_USUARIO("select * from usuario where id_Usuario = ?"),
    
    INSERT_VERSAO("insert into versoes (id_Versao, versao, novidades, id_Sistema) values (versoes_seq.nextval, ?, ?, ?)"),
    LISTALL_VERSAO("select * from versoes"),
    UPDATE_VERSAO("update versoes set versao = ?, novidades = ?, id_Sistema = ? where id_Versao = ?"),
    DELETE_VERSAO("delete from versoes where id_Versao = ?"),
    FINDBYID_VERSAO("select * from versoes where id_Versao = ?");
    
    private final String sql;

    private SQLs(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }

}
