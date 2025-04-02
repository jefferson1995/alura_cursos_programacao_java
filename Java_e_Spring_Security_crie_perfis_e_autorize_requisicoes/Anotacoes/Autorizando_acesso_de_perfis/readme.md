
# Preparando o ambiente: código da migration de perfis

```bash

ALTER TABLE usuarios ADD COLUMN perfil ENUM('ATENDENTE', 'MEDICO', 'PACIENTE') NOT NULL;

```

# Criando os perfis dos usuários

Claro! Na aula sobre "Autorizando o acesso de perfis", aprendemos a criar perfis de usuários em um sistema de gerenciamento de clínica. 
Transformamos pacientes em usuários e configuramos a Bruna como uma paciente com ID 5. 
Identificamos que ela não deveria ter acesso a certas funcionalidades, como cadastrar ou excluir médicos, e que os dados de outros pacientes são sigilosos.Para resolver isso, criamos um enum chamado Perfil, que possui três categorias: atendente, médico e paciente. Adicionamos um campo perfil na classe Usuario, utilizando a anotação @Enumerated para garantir que o perfil seja salvo como uma string no banco de dados.
Também atualizamos o construtor da classe Usuario e criamos um método getPerfil().
Em seguida, fizemos uma migração para adicionar a coluna de perfil na tabela de usuários. 
Atualizamos o método salvarUsuario nas classes UsuarioService e MedicoService para incluir o perfil ao salvar novos usuários. 
Após essas configurações, verificamos se a nova coluna estava preenchida corretamente e nos preparamos para definir as permissões de acesso às URLs para cada perfil.

# Restringindo acessos dos perfis

restringir o acesso a diferentes URLs com base nos perfis de usuários em uma aplicação Java utilizando Spring Security.

Os perfis de usuários, como médico, paciente e atendente, têm diferentes permissões de acesso. Por exemplo, o médico pode acessar apenas suas consultas, enquanto o paciente pode visualizar e gerenciar consultas e o atendente tem acesso total a todas as URLs.

Utilizamos a anotação @AuthenticationPrincipal para capturar o usuário logado e verificar seu perfil. Com isso, implementamos uma lógica no MedicoController.java para redirecionar usuários médicos que tentam acessar a URL /medicos para uma página de erro, enquanto pacientes e atendentes têm acesso permitido.

Além disso, foi mencionado que é necessário configurar as permissões para outras URLs e que a aplicação deve ser testada após as alterações. Essa configuração é essencial para garantir que cada usuário tenha acesso apenas às funcionalidades que lhe são permitidas.

# Autorização com Spring Security

abordamos a autorização de acesso de perfis utilizando o Spring Security. Inicialmente, discutimos a poluição do código com verificações manuais de perfil nas URLs do MedicoController, que foram removidas para simplificar a implementação.

Aprendemos que o Spring Security pode gerenciar as permissões de acesso automaticamente. Para isso, modificamos o método getAuthorities() na classe Usuario, retornando uma coleção de objetos GrantedAuthority que representam os perfis do usuário, utilizando Collections.singleton() e SimpleGrantedAuthority() com o prefixo "ROLE_".

Em seguida, configuramos as permissões de acesso nas requisições HTTP na classe ConfiguracoesSeguranca.java. Utilizamos requestMatchers() para definir quais perfis podem acessar determinadas URLs. Por exemplo, a URL /pacientes é restrita ao perfil de atendente, enquanto o método GET da URL /medicos é acessível tanto para atendentes quanto para pacientes.

A ordem das configurações é crucial, pois o Spring Security analisa as regras linha por linha, priorizando as mais específicas. Por fim, ficou a atividade prática de implementar as permissões para as demais requisições de médicos.

Essa aula nos mostrou como o Spring Security facilita a gestão de permissões, tornando o código mais limpo e eficiente.


# Definindo permissões por anotações 

aprendemos sobre como autorizar o acesso de perfis em uma aplicação utilizando Java e Spring Security. A configuração das permissões foi feita para que diferentes perfis, como atendentes, pacientes e médicos, possam acessar ou não determinadas rotas.

Os métodos POST e PUT foram configurados para serem acessados por atendentes e pacientes, enquanto outras requisições foram definidas para exigir autenticação. Testamos as permissões no navegador, confirmando que cada perfil tinha acesso apenas às URLs permitidas.

Além disso, discutimos a utilização de anotações para definir permissões de forma mais granular. Para isso, ativamos o @EnableMethodSecurity, que permite o uso de anotações como @PreAuthorize nos métodos dos controllers. Aprendemos a aplicar essas anotações para proteger rotas específicas, garantindo que apenas os perfis corretos possam acessar determinadas funcionalidades.

Por fim, abordamos a importância de organizar as permissões de forma clara, considerando a prioridade das configurações, e discutimos as duas abordagens para trabalhar com permissões: através de requisições na classe de segurança ou utilizando anotações.

A classe MedicoController tem diferenças entre os métodos. Não podemos usar a anotação para a classe toda, precisamos anotar método por método, caso contrário bloquearemos a classe. Copiaremos a linha com "hasRole('ATENDENTE')" e voltaremos ao MedicoController.java. A página de listagem é acessada por atendente ou paciente, então usaremos OR para indicar que o perfil pode ser atendente ou paciente:

exemplo

usar anotação na classe de configuração 

@EnableMethodSecurity

```bash

@GetMapping
@PreAuthorize("hasRole('ATENDENTE') OR hasRole('PACIENTE')")
```
Para os outros métodos, que são acessados apenas por atendentes, copiaremos novamente @PreAuthorize("hasRole('ATENDENTE') e a colaremos em todos os métodos, indicando que são acessados apenas por atendentes:

```bash

@GetMapping("formulario")
@PreAuthorize("hasRole('ATENDENTE'))
```
```bash

@PostMapping
@PreAuthorize("hasRole('ATENDENTE'))
```

Para saber mais: Spring Language: https://drive.google.com/file/d/1BSm1_yJ17DCAJtjsMkxmAC_Rt35ev9e3/view?usp=drive_link

Para saber mais: outras anotações para permissões: https://drive.google.com/file/d/1Y0qa4_12nSqRcuaQv-iJxKPAvgoxBODo/view?usp=drive_link


Desafio: restringindo o acesso a consultas: https://drive.google.com/file/d/1e1bX93_VKJmAuOR__XMNZhVNIKEBKpMZ/view?usp=drive_link







### Nessa aula, você aprendeu:

- Categorizar os usuários em diversos tipos diferentes. Criamos o enum Perfil e adicionamos à classe de usuário. No escopo do nosso projeto, o foco está em ter um único perfil para cada usuário, mas podemos evoluir e fazer com que cada usuário tenha vários perfis.

- Usar a anotação @AuthenticationPrincipal para obter o usuário logado. Precisamos utilizar essa anotação para autorizar ou não as requisições dos usuários. Porém, vimos que essa estratégia de verificar manualmente é muito trabalhosa.

- Configurar diferentes perfis de usuários usando Spring Security. Sobrecarregamos o método getAuthorities para retornar perfis usando a interface GrantedAuthority. Dessa forma, o Spring passa a entender que estamos trabalhando com perfis diferentes na aplicação.

- Trabalhar com permissões de URL usando o método authorizeHttpRequests. Utilizamos esse método para definir as permissões de cada perfil, com métodos como hasRole e hasAnyRole. Também entendemos que a ordem em que definimos essas permissões é importante: devemos passar restrições mais específicas antes das mais genéricas.

- Utilizar anotações do Spring Security para definir os acessos de cada perfil. Vimos que, ao usar o método authorizeHttpRequests, definimos configurações globais de permissão. Mas existe também a possibilidade de trabalhar com configurações locais nas classes, utilizando anotações do Spring Security. Para isso, habilitamos essa função com @EnableMethodSecurity e utilizamos anotações como @PreAuthorize e @PostAuthorize, além de várias outras.

- Fazer operações sofisticadas com Spring Language. Entendemos que as anotações do Spring Security usam Strings com um formato específico, que permitem que façamos várias operações diferentes.




```bash

```

# Autor/Professor

Yasmin araujo
https://cursos.alura.com.br/course/java-spring-security-crie-perfis-autorize-requisicoes
![Nome imagem](link) ![Nome imagem 2](link)

