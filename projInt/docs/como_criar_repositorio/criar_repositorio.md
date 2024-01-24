# Como crir um repositório para um agregado

## 1. Definir a classe que é centro do agregado

![Aggregate_Root](./images/aggregate_root.png)

**Nota:** Geralmente a mesma fica colocada no *domain package* e tem de implementar a interface **AggregateRoot< ID >**

## 2. Criar a interface do repositório

![Repository_Interface](./images/repository_interface.png)

**Nota:** A class *Domain Repository* não é nossa e sim do projeto base. É importante perceberem a sua implementação. A interface do repositório deve extender a class **DomainRepository<ID, Class>**. Nesta classe deve-se adicionar os métodos de procura específicos que têm de ser implementados posteriormente.

## 3. Adicionar o repositório às RepositoryFactoriy

Na interface RepositoryFactory que fica localizada no package eapli.base.infrastructure.persistence no módulo Core devem adicionar as seguintes linhas de código:

![Repository_Factory_Interface](./images/repository_factory_interface.png)

## 4. Fazer as suas implementações nas JPA e InMemory
### JPARepositoryFactory class
![JPA_Repository_Factory](./images/jpa_repository_factory.png)
### InMemoryRepositoryFactory class
![InMemory_Repotitory_Factory](./images/InMemory_repository_factory.png)

## 5. Criar as classes Repository InMemory e JPA e implementar a interface Repository criada antes

Nestas classes também se colocam as implementações dos métodos que sejam adicionados para querries específicas que tenham sido adicionados na interface Repository criada no ponto 2.
### InMemoryRepository
![InMemory_Repository](./images/InMemory_repository.png)
**Nota:** A class respository tem de extender a class **InMemoryDomainRepository< ID, AggregateRoot< ID > >**

### JPARepository
![JPA_Repository](./images/JPA_repository.png)
**Nota:** A class JPARepository tem de extender a class **JPAAutoTxRepository< Root, ID, ID >** e implementar a interface repositório igualmente.

## 6. Adicionar a classe ao Persistence.xml

![Persistence.xml](./images/persistence.png)

Com isto fica feito o processo de criação de um repositório
