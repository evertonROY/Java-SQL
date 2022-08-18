import java.util.Date;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		ContatoDAO contatoDAO = new ContatoDAO();
		Contato contato = new Contato();
		Scanner entrada = new Scanner(System.in);

		contato.setDataCadastro(new Date());

		int ent = -1;

		while (ent != 0) {
			System.out.println("===========================");
			System.out.println("1 - CADASTRAR");
			System.out.println("2 - EXCLUIR");
			System.out.println("3 - ATUALIZAR");
			System.out.println("4 - MOSTRAR CADASTRADOS");
			System.out.println("5 - PESQUISAR POR ID");
			System.out.println("===========================");
			ent = entrada.nextInt();

			if (ent == 1) {
				System.out.println("______________________________");
				System.out.println("Digite o nome do contato");
				contato.setNome(entrada.next());
				System.out.println("______________________________");
				System.out.println("Digite a idade");
				contato.setIdade(entrada.nextInt());
				contatoDAO.save(contato);
				System.out.println("______________________________");
				System.out.println("Contato Cadastrado!");
			} else if (ent == 2) {
				System.out.println("Digite o ID do contato a ser deletado");
				contatoDAO.removeById(entrada.nextInt());
				System.out.println("Contato Deletado!");
			} else if (ent == 3) {
				System.out.println("Digite o ID do contato");
				contato.setId(entrada.nextInt());
				System.out.println("Digite o novo nome do contato");
				contato.setNome(entrada.next());
				System.out.println("Digite a nova idade do contato");
				contato.setIdade(entrada.nextInt());
				contatoDAO.update(contato);
				System.out.println("Contato Atualizado!");
			} else if (ent == 4) {
				System.out.println("Lista de contatos");
				System.out.println("-------------------------------");
				for (Contato c : contatoDAO.getContatos()) {
					System.out.println("ID: " + c.getId());
					System.out.println("NOME: " + c.getNome());
					System.out.println("IDADE: " + c.getIdade());
					System.out.println("DATA CADASTRO: " + c.getDataCadastro());
					System.out.println("-------------------------------");

				}
			} else if (ent == 5) {
				System.out.println("Digite o ID do Contato");
				Contato c = contatoDAO.buscaById(entrada.nextInt());
				
				    System.out.println("-------------------------------");
				    System.out.println("ID: " + c.getId());
					System.out.println("NOME: " + c.getNome());
					System.out.println("IDADE: " + c.getIdade());
					System.out.println("DATA CADASTRO: " + c.getDataCadastro());
					System.out.println("-------------------------------");
				
			}
		}
	}
}