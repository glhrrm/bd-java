INSERT INTO DEPARTAMENTO ( ID_DEPARTAMENTO, NOME)  
VALUES(DEPARTAMENTO_SEQ.NEXTVAL,'FINANCEIRO')
;

INSERT INTO DEPARTAMENTO ( ID_DEPARTAMENTO, NOME)  
VALUES(DEPARTAMENTO_SEQ.NEXTVAL,'DESENVOLVIMENTO')
;

INSERT INTO DEPARTAMENTO ( ID_DEPARTAMENTO, NOME) 
VALUES(DEPARTAMENTO_SEQ.NEXTVAL,'VENDAS')
;

INSERT INTO DEPARTAMENTO ( ID_DEPARTAMENTO, NOME) 
VALUES(DEPARTAMENTO_SEQ.NEXTVAL,'RH')
;

INSERT INTO DEPARTAMENTO ( ID_DEPARTAMENTO, NOME) 
VALUES(DEPARTAMENTO_SEQ.NEXTVAL,'SUPORTE')
;

INSERT INTO DEPARTAMENTO ( ID_DEPARTAMENTO, NOME) 
VALUES(DEPARTAMENTO_SEQ.NEXTVAL,'EXTERIOR')
;

INSERT INTO DEPARTAMENTO ( ID_DEPARTAMENTO, NOME) 
VALUES(DEPARTAMENTO_SEQ.NEXTVAL,'JURÍDICO')
;

INSERT INTO DEPARTAMENTO ( ID_DEPARTAMENTO, NOME) 
VALUES(DEPARTAMENTO_SEQ.NEXTVAL,'ADMINISTRAÇÃO')
;

INSERT INTO DEPARTAMENTO ( ID_DEPARTAMENTO, NOME) 
VALUES(DEPARTAMENTO_SEQ.NEXTVAL,'DESIGN')
;

INSERT INTO PERMISSAO ( ID_PERMISSAO, NOME)  
VALUES(PERMISSAO_SEQ.NEXTVAL,'DESENVOLVEDOR JUNIOR')
;

INSERT INTO PERMISSAO ( ID_PERMISSAO, NOME) 
VALUES(PERMISSAO_SEQ.NEXTVAL,'DESENVOLVEDOR SENIOR')
;

INSERT INTO PERMISSAO ( ID_PERMISSAO, NOME) 
VALUES(PERMISSAO_SEQ.NEXTVAL,'DESENVOLVEDOR MASTER')
;

INSERT INTO PERMISSAO ( ID_PERMISSAO, NOME) 
VALUES(PERMISSAO_SEQ.NEXTVAL,'ADMIN')
;

INSERT INTO PERMISSAO ( ID_PERMISSAO, NOME) 
VALUES(PERMISSAO_SEQ.NEXTVAL,'DBA')
;

INSERT INTO PERMISSAO ( ID_PERMISSAO, NOME) 
VALUES(PERMISSAO_SEQ.NEXTVAL,'JURÍDICO')
;

INSERT INTO PERMISSAO ( ID_PERMISSAO, NOME) 
VALUES(PERMISSAO_SEQ.NEXTVAL,'ADMIN BASICO')
;

INSERT INTO PERMISSAO ( ID_PERMISSAO, NOME) 
VALUES(PERMISSAO_SEQ.NEXTVAL,'DESIGNER')
;

INSERT INTO USUARIO ( ID_USUARIO, NOME, ID_DEPARTAMENTO, ID_PERMISSAO)  
VALUES(USUARIO_SEQ.NEXTVAL,'MATHEUS',1, 100 )
;

INSERT INTO USUARIO ( ID_USUARIO, NOME, ID_DEPARTAMENTO, ID_PERMISSAO) 
VALUES(USUARIO_SEQ.NEXTVAL,'MARIO', 1, 102)
;

INSERT INTO USUARIO ( ID_USUARIO, NOME, ID_DEPARTAMENTO, ID_PERMISSAO) 
VALUES(USUARIO_SEQ.NEXTVAL,'MATHEOS',1 , 101)
;

INSERT INTO USUARIO ( ID_USUARIO, NOME, ID_DEPARTAMENTO, ID_PERMISSAO) 
VALUES(USUARIO_SEQ.NEXTVAL,'RENAN', 1 , 101)
;

INSERT INTO USUARIO ( ID_USUARIO, NOME, ID_DEPARTAMENTO, ID_PERMISSAO) 
VALUES(USUARIO_SEQ.NEXTVAL,'EDUARDO', 4 , 100)
;

INSERT INTO USUARIO ( ID_USUARIO, NOME, ID_DEPARTAMENTO, ID_PERMISSAO) 
VALUES(USUARIO_SEQ.NEXTVAL,'RITA', 9, 106)
;

INSERT INTO USUARIO ( ID_USUARIO, NOME, ID_DEPARTAMENTO, ID_PERMISSAO) 
VALUES(USUARIO_SEQ.NEXTVAL,'PRISCILA', 8 , 107)
;

INSERT INTO USUARIO ( ID_USUARIO, NOME, ID_DEPARTAMENTO, ID_PERMISSAO) 
VALUES(USUARIO_SEQ.NEXTVAL,'TIAGO', 7, 104)
;

INSERT INTO USUARIO ( ID_USUARIO, NOME, ID_DEPARTAMENTO, ID_PERMISSAO)  
VALUES(USUARIO_SEQ.NEXTVAL,'DENIS',6, 102 )
;

INSERT INTO USUARIO ( ID_USUARIO, NOME, ID_DEPARTAMENTO, ID_PERMISSAO) 
VALUES(USUARIO_SEQ.NEXTVAL,'MARIA', 5, 105)
;

INSERT INTO USUARIO ( ID_USUARIO, NOME, ID_DEPARTAMENTO, ID_PERMISSAO) 
VALUES(USUARIO_SEQ.NEXTVAL,'FERNANDA',2 , 107)
;

INSERT INTO USUARIO ( ID_USUARIO, NOME, ID_DEPARTAMENTO, ID_PERMISSAO) 
VALUES(USUARIO_SEQ.NEXTVAL,'FERNANDO ', 3 , 107)
;

INSERT INTO USUARIO ( ID_USUARIO, NOME, ID_DEPARTAMENTO, ID_PERMISSAO) 
VALUES(USUARIO_SEQ.NEXTVAL,'EDUARDA', 4 , 100)
;

INSERT INTO USUARIO ( ID_USUARIO, NOME, ID_DEPARTAMENTO, ID_PERMISSAO) 
VALUES(USUARIO_SEQ.NEXTVAL,'RAFAEL', 3, 106)
;

INSERT INTO USUARIO ( ID_USUARIO, NOME, ID_DEPARTAMENTO, ID_PERMISSAO) 
VALUES(USUARIO_SEQ.NEXTVAL,'PAULA', 2 , 104)
;

INSERT INTO USUARIO ( ID_USUARIO, NOME, ID_DEPARTAMENTO, ID_PERMISSAO) 
VALUES(USUARIO_SEQ.NEXTVAL,'ROGERIO', 8, 103)
;

insert into SISTEMA (ID_SISTEMA, ATIVO, ID_USUARIO, CRIACAO)
values (SISTEMA_SEQ.nextval, 1, 1, to_date('20/08/2012 14:00','dd/mm/yyyy hh24:mi'));

INSERT INTO SISTEMA ( ID_SISTEMA,ATIVO, ID_USUARIO, CRIACAO)  
VALUES(SISTEMA_SEQ.NEXTVAL,1,1, to_date('01/06/2012 11:00','dd/mm/yyyy hh24:mi') )
;

INSERT INTO SISTEMA ( ID_SISTEMA,ATIVO, ID_USUARIO, CRIACAO) 
VALUES(SISTEMA_SEQ.NEXTVAL,1,2, to_date('02/06/2012 11:00','dd/mm/yyyy hh24:mi'))
;

INSERT INTO SISTEMA ( ID_SISTEMA,ATIVO, ID_USUARIO, CRIACAO)
VALUES(SISTEMA_SEQ.NEXTVAL,1,3, to_date('05/10/2012 18:00','dd/mm/yyyy hh24:mi'))
;

INSERT INTO SISTEMA ( ID_SISTEMA,ATIVO, ID_USUARIO, CRIACAO)
VALUES(SISTEMA_SEQ.NEXTVAL,1,4, to_date('02/02/2018 11:00','dd/mm/yyyy hh24:mi'))
;

INSERT INTO SISTEMA ( ID_SISTEMA,ATIVO, ID_USUARIO, CRIACAO)
VALUES(SISTEMA_SEQ.NEXTVAL,1,2, to_date('14/07/2017 11:00','dd/mm/yyyy hh24:mi'))
;

INSERT INTO SISTEMA ( ID_SISTEMA,ATIVO, ID_USUARIO, CRIACAO) 
VALUES(SISTEMA_SEQ.NEXTVAL,1,2, to_date('09/07/2013 14:00','dd/mm/yyyy hh24:mi'))
;

INSERT INTO SISTEMA ( ID_SISTEMA,ATIVO, ID_USUARIO, CRIACAO)
VALUES(SISTEMA_SEQ.NEXTVAL,1,3, to_date('01/12/2019 11:00','dd/mm/yyyy hh24:mi'))
;

INSERT INTO SISTEMA ( ID_SISTEMA,ATIVO, ID_USUARIO, CRIACAO)
VALUES(SISTEMA_SEQ.NEXTVAL,1,5, to_date('01/06/2012 11:00','dd/mm/yyyy hh24:mi'))
;

INSERT INTO SISTEMA ( ID_SISTEMA,ATIVO, ID_USUARIO, CRIACAO)
VALUES(SISTEMA_SEQ.NEXTVAL,1,5, to_date('01/06/2012 11:00','dd/mm/yyyy hh24:mi') )
;

INSERT INTO SISTEMA ( ID_SISTEMA,ATIVO, ID_USUARIO, CRIACAO) 
VALUES(SISTEMA_SEQ.NEXTVAL,1,6, to_date('01/05/2018 11:00','dd/mm/yyyy hh24:mi'))
;

INSERT INTO SISTEMA ( ID_SISTEMA,ATIVO, ID_USUARIO, CRIACAO)
VALUES(SISTEMA_SEQ.NEXTVAL,1,7, to_date('10/07/2017 11:00','dd/mm/yyyy hh24:mi'))
;

INSERT INTO SISTEMA ( ID_SISTEMA,ATIVO, ID_USUARIO, CRIACAO)
VALUES(SISTEMA_SEQ.NEXTVAL,1,7, to_date('10/07/2017 11:00','dd/mm/yyyy hh24:mi'))
;

INSERT INTO SISTEMA ( ID_SISTEMA,ATIVO, ID_USUARIO, CRIACAO) 
VALUES(SISTEMA_SEQ.NEXTVAL,1,7, to_date('15/01/2010 11:00','dd/mm/yyyy hh24:mi'))
;

INSERT INTO SISTEMA ( ID_SISTEMA,ATIVO, ID_USUARIO, CRIACAO)
VALUES(SISTEMA_SEQ.NEXTVAL,1,2, to_date('16/07/2016 11:00','dd/mm/yyyy hh24:mi'))
;

INSERT INTO SISTEMA ( ID_SISTEMA,ATIVO, ID_USUARIO, CRIACAO)
VALUES(SISTEMA_SEQ.NEXTVAL,1,6, to_date('3/07/2017 11:00','dd/mm/yyyy hh24:mi'))
;

INSERT INTO SISTEMA ( ID_SISTEMA,ATIVO, ID_USUARIO, CRIACAO)
VALUES(SISTEMA_SEQ.NEXTVAL,1,6,SYSDATE)
;

INSERT into VERSOES ( ID_VERSAO,VERSAO, NOVIDADES, ID_SISTEMA)  
VALUES(VERSOES_SEQ.NEXTVAL,'1.0.0','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam finibus efficitur libero at elementum. Vivamus ullamcorper blandit neque et consectetur. Vestibulum.',9)
;

INSERT into VERSOES ( ID_VERSAO,VERSAO, NOVIDADES, ID_SISTEMA)  
VALUES(VERSOES_SEQ.NEXTVAL,'1.0.1','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam finibus efficitur libero at elementum. Vivamus ullamcorper blandit neque et consectetur. Vestibulum.',9)
;

INSERT into VERSOES ( ID_VERSAO,VERSAO, NOVIDADES, ID_SISTEMA)  
VALUES(VERSOES_SEQ.NEXTVAL,'1.2.0','esque magna in semper. Integer pretium mauris eu velit placerat auctor. Integer vel eros nibh. Aliquam varius vitae nisi in rhoncus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Morbi nec pellentesque felis.',9)
;

INSERT into VERSOES ( ID_VERSAO,VERSAO, NOVIDADES, ID_SISTEMA)  
VALUES(VERSOES_SEQ.NEXTVAL,'2.0.0','ibus metus. Nullam ornare et ante eu luctus. Sed sodales pellentesque magna in semper. Integer pretium mauris eu velit Morbi nec pellentesque felis.',9)
;

INSERT into VERSOES ( ID_VERSAO,VERSAO, NOVIDADES, ID_SISTEMA)  
VALUES(VERSOES_SEQ.NEXTVAL,'3.2.1',' Integer vel eros nibh. Aliquam varius vitae nisi in rhoncus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Morbi nec pellentesque felis.',9)
;

INSERT into VERSOES ( ID_VERSAO,VERSAO, NOVIDADES, ID_SISTEMA)  
VALUES(VERSOES_SEQ.NEXTVAL,'5.0.0',' Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Morbi nec pellentesque felis.',9)
;

INSERT into VERSOES ( ID_VERSAO,VERSAO, NOVIDADES, ID_SISTEMA)  
VALUES(VERSOES_SEQ.NEXTVAL,'1.0.0','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam finibus efficitur libero at elementum. Vivamus ullamcorper blandit neque et consectetur. Vestibulum.',1)
;

INSERT into VERSOES ( ID_VERSAO,VERSAO, NOVIDADES, ID_SISTEMA)  
VALUES(VERSOES_SEQ.NEXTVAL,'1.0.1','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam finibus efficitur libero at elementum. Vivamus ullamcorper blandit neque et consectetur. Vestibulum.',1)
;

INSERT into VERSOES ( ID_VERSAO,VERSAO, NOVIDADES, ID_SISTEMA)  
VALUES(VERSOES_SEQ.NEXTVAL,'1.2.0','esque magna in semper. Integer pretium mauris eu velit placerat auctor. Integer vel eros nibh. Aliquam varius vitae nisi in rhoncus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Morbi nec pellentesque felis.',2)
;

INSERT into VERSOES ( ID_VERSAO,VERSAO, NOVIDADES, ID_SISTEMA)  
VALUES(VERSOES_SEQ.NEXTVAL,'2.0.0','ibus metus. Nullam ornare et ante eu luctus. Sed sodales pellentesque magna in semper. Integer pretium mauris eu velit Morbi nec pellentesque felis.',2)
;

INSERT into VERSOES ( ID_VERSAO,VERSAO, NOVIDADES, ID_SISTEMA)  
VALUES(VERSOES_SEQ.NEXTVAL,'3.2.1',' Integer vel eros nibh. Aliquam varius vitae nisi in rhoncus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Morbi nec pellentesque felis.',2)
;

INSERT into VERSOES ( ID_VERSAO,VERSAO, NOVIDADES, ID_SISTEMA)  
VALUES(VERSOES_SEQ.NEXTVAL,'5.0.0',' Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Morbi nec pellentesque felis.',2)
;