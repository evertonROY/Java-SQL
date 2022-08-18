import java.util.Scanner;

public class principal {

	public static void main(String[] args) {
		usuarioDAO usuDAO = new usuarioDAO();
		usuario usu = new usuario();
		Scanner entrada = new Scanner(System.in);
		int ent = -1;
		
		while (ent != 0) {
			
			System.out.println("===========================");
			System.out.println("1 - CADASTRAR");
			System.out.println("2 - LOGAR");
			System.out.println("===========================");
			ent = entrada.nextInt();
			if (ent == 1) {
				System.out.println("Digite o email para cadastro");
				usu.setEmail(entrada.next());
				System.out.println("Digite a senha para cadastro");
				usu.setSenha(entrada.nextInt());
				usuDAO.cadastrar(usu);
				System.out.println("Usuario cadastrado com sucesso!");
			} else if(ent == 2) {
				
				System.out.println("Digite o seu Email");
				String logusuario = entrada.next();
				usu = usuDAO.verificar(logusuario);
				System.out.println("Digite a sua Senha");
				int logsenha = entrada.nextInt();
				
				if(logusuario.equals(usu.getEmail()) && logsenha == usu.getSenha()) {
					System.out.println("Você está logado!");
					
				}else {
					System.out.println("Usuario ou Senha incorreta!");
					
				}
				
				
			}
		}
	}

}
