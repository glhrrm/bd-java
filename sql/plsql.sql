-- PROCEDURE #1 SEM PARÂMETRO OUT

create or replace procedure adiciona_versao
(
	p_versao in versoes.versao%type,
	p_novidades in versoes.novidades%type,
	p_id_sistema in versoes.id_sistema%type
) is
begin
	insert into versoes (
		id_versao,
		versao,
		novidades,
		id_sistema
	) values (
		versoes_seq.nextval,
		p_versao,
		p_novidades,
		p_id_sistema
	);
end;
/
show errors;

-- PROCEDURE #2 COM PARÂMETRO OUT

create or replace procedure cont_versoes_sistema (
	p_id_sistema in versoes.id_sistema%type,
	p_contador out number
) is
begin
	select count(*)
	into p_contador
	from versoes
	where id_sistema = p_id_sistema;
end;
/
show errors;

var contador number;
exec cont_versoes_sistema(1, :contador);
print contador;

-- PROCEDURE #3 COM PARÂMETRO OUT + CURSOR

create or replace procedure usuarios_depto (
	p_id_departamento in departamento.id_departamento%type,
	p_usuarios out sys_refcursor
) is
begin
	open p_usuarios for
    select * from usuario
    where id_departamento = p_id_departamento;
end;
/
show errors;

var usuarios refcursor;
exec usuarios_depto(1, :usuarios);
print usuarios;

-- FUNCTION #1

CREATE OR REPLACE FUNCTION nivel_evolucao_sistema (
    p_id_sistema   IN sistema.id_sistema%type
) RETURN VARCHAR2 IS
    v_total    NUMBER;
    p_output   VARCHAR2(50);
BEGIN
    SELECT
        COUNT(*)
    INTO
        v_total
    FROM
        versoes
    where id_sistema = p_id_sistema;

    IF
        v_total = 0
    THEN
        p_output := 'Sistema inalterado';
    ELSIF v_total <= 1 THEN
        p_output := 'Sistema pouco evoluído';
    ELSIF v_total <= 5 THEN
        p_output := 'Sistema razoavelmente evoluído';
    ELSE
        p_output := 'Sistema superevoluído';
    END IF;

    RETURN p_output;
END;
/
show errors;

VAR output VARCHAR2(50);
EXEC :output := nivel_evolucao_sistema(9);
PRINT output;

-- TRIGGER

create or replace trigger trigger_criacao_sistema before
    insert or update of criacao on sistema
    for each row
begin
    if
        (:new.criacao > sysdate )
    then
        raise_application_error(-20000,'Data de criação não pode ser maior do que a data atual.');
    end if;
end;
/
