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
