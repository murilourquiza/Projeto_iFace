package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entities.Amizades;
import entities.BancoDados;
import entities.Comunidade;
import entities.Conta;
import entities.Feed;
import entities.Mensagem;
import entities.enums.PermissaoFeed;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<String> auxiliar = new ArrayList<>();
		
		int entrada1=0;
		int entradaLogin=0;
		int entradaConfigurarPerfil=0;
		
		BancoDados dados = new BancoDados();
					    
		try {
			System.out.println("Bem-vindo ao iFace!");
			System.out.println("");
			System.out.println("1-> Cadastrar-se");
			System.out.println("2-> Fazer Login");
			System.out.println("3-> Sair do iFace");
			System.out.print("Digite sua op��o: ");
			entrada1 = sc.nextInt();
			sc.nextLine();
			System.out.println("");
		} 
		catch (InputMismatchException e) {
			sc.close();
			System.out.println("Erro na entrada" + "\n" + "Fim do Programa." );
			return;
		}
		
		while(entrada1 != 3) {
			
			switch (entrada1) {
			
			case 1:
				System.out.println("Informe seu login:");
		    	String login = sc.nextLine();
		    	if(dados.buscaList(login) != null) {
		    		System.out.println("Login j� existente.");
		    	} else {
		    		System.out.println("Informe sua senha:");
				    String senha = sc.nextLine();
				    System.out.println("Informe seu nome:");
				    String nome = sc.nextLine();
				    dados.addList(login, senha, nome);
				    System.out.println("Login criado com sucesso.");
		    	}
		    break;
		    
			case 2:
				if(dados.getTamanhoLista() == 0) {
			    	System.out.println("Sem usu�rios cadastrados");
			    } else {
			    	System.out.println("Informe seu login:");
			    	String loginConta = sc.nextLine();
			    	String nome_LoginConta = dados.buscaList(loginConta);
			    	if(nome_LoginConta == null) {
			    		System.out.println("Login n�o cadastrado");
			    	} else {
					    try {
					    	System.out.println("\n---------------------------------------");
					    	System.out.println("L o g i n : " + loginConta);
					    	System.out.println("---------------------------------------");
				    		System.out.println("Solicita��es (" + dados.mostrarSolUsu(loginConta) +")");
				    		System.out.println("Amigos (" + dados.mostrarAmi(loginConta) +")");
				    		System.out.println("Mensagens (" + dados.mostrarMen(loginConta) +")");
				    		System.out.println("Comunidades (" + dados.mostrarCom(loginConta) +")");
					    	System.out.println("");
				    		System.out.println("PERFIL");
						    System.out.println("  01-> Configurar Perfil");
						    System.out.println("  02-> Visualizar Perfil");
						    System.out.println("AMIGOS");
						    System.out.println("  03-> Solicitar Nova Amizade");
						    System.out.println("  04-> Verificar Pedidos de Amizade");
						    System.out.println("  05-> Ver Amigos");
						    System.out.println("MENSAGENS");
						    System.out.println("  06-> Enviar Mensagem para um Usu�rio");
						    System.out.println("  07-> Enviar Mensagem para uma Comunidade");
						    System.out.println("  08-> Visualizar Todas as Mensagens");
						    System.out.println("COMUNIDADES");
						    System.out.println("  09-> Criar comunidade");
							System.out.println("  10-> Entrar em uma comunidade");
							System.out.println("  11-> Visualizar Comunidades Existentes");
							System.out.println("  12-> Ver Minhas Comunidades");
							System.out.println("  13-> Sair de uma Comunidade");
							System.out.println("FEED");
							System.out.println("  14-> Configurar seu Feed de Not�cias");
							System.out.println("  15-> Escrever no Feed de Not�cias");
							System.out.println("  16-> Visualizar Meu Feed");
							System.out.println("  17-> Visualizar Feed Geral");
						    System.out.println("...");
						    System.out.println("  19-> Cancelar Cadastro");
						    System.out.println("  20-> Deslogar");
							System.out.print("Digite sua op��o: ");
					    	entradaLogin = sc.nextInt();
						    sc.nextLine();
						    System.out.println("");
						} 
						catch (InputMismatchException e) {
							sc.close();
							System.out.println("Erro na entrada" + "\n" + "Fim do Programa." );
							return;
						}
					    
					    while (entradaLogin != 20) {
						    switch (entradaLogin) {
						    case 1:
							    try {
							    	System.out.println("1-> Alterar login");
								    System.out.println("2-> Alterar senha");
								    System.out.println("3-> Alterar nome");
								    System.out.print("Digite sua op��o: ");
							    	entradaConfigurarPerfil = sc.nextInt();
								    sc.nextLine();
								} 
								catch (InputMismatchException e) {
									sc.close();
									System.out.println("Erro na entrada" + "\n" + "Fim do Programa." );
									return;
								}
							    
							    switch (entradaConfigurarPerfil) {
							    case 1:
							    	System.out.println("Novo login:");
							    	String loginNovo = sc.nextLine();
							    	dados.mudarLoginList(loginConta, loginNovo);
							    	System.out.println("Login alterado de " + loginConta + " para " + loginNovo + ".");
					    			loginConta = loginNovo;
							    break;
							    case 2:
									System.out.println("Nova senha:");
									String senhaNova = sc.nextLine();
									System.out.println("Senha alterada de " + dados.buscaSenhaList(loginConta) + " para " + senhaNova + ".");
									dados.mudarSenhaList(loginConta, senhaNova);
							    break;
							    case 3:
									System.out.println("Novo nome:");
									String nomeNovo = sc.nextLine();
									System.out.println("Nome alterado de " + dados.buscaList(loginConta) + " para " + nomeNovo + ".");
									dados.mudarNomeList(loginConta, nomeNovo);
							    break;
							    default:
							    	System.out.println("Op��o Inv�lida");
							    }
							break;
						    case 2:
						    	dados.imprimirConta(loginConta);
						    break;
						    case 3:
						    	System.out.println("Informe o Login do amigo desejado: ");
						    	String amigoDesejado = sc.nextLine();
						    	if(loginConta.contentEquals(amigoDesejado) == true) {
						    		System.out.println("Voc� n�o pode ser seu pr�prio amigo.");
						    	} else {
									if(dados.buscaList(amigoDesejado) == null) {
										System.out.println("Login destinat�rio n�o cadastrado");
									} else {
										int verificacaoSolAmi = dados.verificacaoSolAmi(loginConta, amigoDesejado);
										if(dados.verificacaoAmizade(loginConta, amigoDesejado) == 1) {
											System.out.println("Voc� j� � amigo do usu�rio " + amigoDesejado + ".");
										} else if(verificacaoSolAmi == 1) {
											System.out.println("Verifique seus pedidos." + amigoDesejado + " j� lhe enviou um pedido de Amizade.");
										} else if(verificacaoSolAmi == 2) {
											System.out.println("Voc� j� enviou anteriormente um pedido a esse usu�rio.");
										} else{
											dados.addListSolAmi(loginConta, amigoDesejado);
											System.out.println("Solicita��o enviada.");
										}
									}
						    	}
						    break;
						    case 4:
						    	int escolhaSolAmi = 1;
						    	auxiliar = dados.listaSolAmi(loginConta);
						    	if(auxiliar == null) {
						    		System.out.println("Sem solicita��es no momento.");
						    	} else {
						    		System.out.println(auxiliar);
						    		try {
										System.out.println("1-> Aceitar uma solicita��o:");
										System.out.println("2-> Recusar uma solicita��o:");
										System.out.println("3-> Voltar.");
										System.out.print("Digite sua op��o: ");
										escolhaSolAmi = sc.nextInt();
										sc.nextLine();
									} 
									catch (InputMismatchException e) {
										sc.close();
										System.out.println("Erro na entrada" + "\n" + "Fim do Programa." );
										return;
									} 
							    	while (escolhaSolAmi != 3) {
							    		String loginAmigo;
							    		System.out.println("Digite o login de quem fez a solicita��o:");
					    				loginAmigo = sc.nextLine();
					    				if(dados.buscaList(loginAmigo) == null) {
					    					System.out.println("Login n�o cadastrado.");
					    				} else if(dados.verificacaoSolAmi(loginConta, loginAmigo) == 0) {
					    					System.out.println("Login inv�lido.");
					    				} else {
					    					switch (escolhaSolAmi) {
								    			case 1:
								    				dados.addListAmi(loginConta, loginAmigo);
								    				dados.removeListSolAmi(loginConta, loginAmigo);
								    				System.out.println("Solicita��o Aceita");
								    		    break;
								    			case 2:
								    				dados.removeListSolAmi(loginConta, loginAmigo);
								    				System.out.println("Solicita��o Recusada");
								    			break;
								    			default:
								    				System.out.println("Op��o Inv�lida");
								    	    }
					    				}
							    		try {
											System.out.println("1-> Aceitar uma solicita��o:");
											System.out.println("2-> Recusar uma solicita��o:");
											System.out.println("3-> Voltar.");
											System.out.print("Digite sua op��o: ");
											escolhaSolAmi = sc.nextInt();
											sc.nextLine();
										} 
										catch (InputMismatchException e) {
											sc.close();
											System.out.println("Erro na entrada" + "\n" + "Fim do Programa." );
											return;
										} 
							    	}
						    	}
						    break;
						    case 5:
						    	auxiliar = dados.visualizarAmigos(loginConta);
						    	if(auxiliar == null) {
						    		System.out.println("Sem amigos.");
						    	} else {
						    		System.out.println(auxiliar);
						    	}
						    break;
						    case 6:
						    	System.out.println("Informe o login do destinat�rio:");
								String loginDestinatario = sc.nextLine();
								if(dados.buscaList(loginDestinatario) == null) {
									System.out.println("Login destinat�rio n�o cadastrado");
								} else {
									System.out.println("Informe a mensagem:");
									String mensagem = sc.nextLine();
									dados.enviarMenUsuario(loginConta, mensagem, loginDestinatario);
									System.out.println("Mensagem enviada com sucesso!");
								}
						    break;
						    case 7:
						    	if(dados.getTamanhoListaCom() == 0) {
						    		System.out.println("Nao existe comunidade no momento");
						    	} else {
									System.out.println("Informe o nome da comunidade:");
									String loginDestinatario2 = sc.nextLine();
									System.out.println("Informe a mensagem:");
									String mensagem2 = sc.nextLine();
									if(dados.enviarMenComunidade(loginConta, mensagem2, loginDestinatario2) == 0) {
										System.out.println("Comunidade nao cadastrada");
									} else {
										System.out.println("Mensagem enviada com sucesso!");
									}
								}
						    break;
						    case 8:
						    	auxiliar = dados.visualizarMensagens(loginConta);
						    	if(auxiliar == null) {
						    		System.out.println("Nenhuma mensagem encontrada.");
						    	} else {
						    		System.out.println(auxiliar);
						    	}
						    break;
						    case 9:
						    	System.out.println("Informe o nome da comunidade:");
								String nomCom = sc.nextLine();
								System.out.println("Informe a descri��o da comunidade:");
							    String descCom = sc.nextLine();
								if(dados.criarComunidade(loginConta, nomCom, descCom) == 0) {
									System.out.println("Uma comunidade j� existe com esse nome.");
								} else {
									System.out.println("Comunidade criada com sucesso!");
								}
						    break;
						    case 10:
						    	if(dados.getTamanhoListaCom() == 0) {
						    		System.out.println("N�o existe comunidade no momento");
						    	} else {
						    		System.out.println("Comunidades Existentes:");
						    		System.out.println(dados.getListCom());
						    		System.out.println("\nInforme a comunidade de interesse:");
						    		String nomeComunidade = sc.nextLine();
						    		int respostaComunidade = dados.entrarComunidade(loginConta, nomeComunidade);
						    		if(respostaComunidade == 0) {
						    			System.out.println("Comunidade nao encontrada");
						    		} else if(respostaComunidade == 1) {
						    			System.out.println("Voc� j� � o dono dessa comunidade.");
						    		} else if(respostaComunidade == 2) {
						    			System.out.println("Voc� j� faz parte dessa comunidade.");
						    		} else if(respostaComunidade == 3) {
						    			System.out.println("Parab�ns! Agora voc� faz parte dessa comunidade.");
						    		}
						    	}
						    break;
						    case 11:
						    	if(dados.getTamanhoListaCom() == 0) {
						    		System.out.println("N�o existe comunidade no momento");
						    	} else {
						    		System.out.println("Comunidades Existentes:");
						    		System.out.println(dados.getListCom());
						    	}
						    break;
						    case 12:
						    	auxiliar = dados.visualizarComunidades(loginConta);
						    	if(auxiliar == null) {
						    		System.out.println("Nenhuma comunidade encontrada.");
						    	} else {
						    		System.out.println("Comunidades que voc� faz parte:");
						    		System.out.println(auxiliar);
						    	}
						    break;
						    case 13:
						    	auxiliar = dados.visualizarComunidades(loginConta);
						    	if(auxiliar == null) {
						    		System.out.println("Voc� n�o faz parte de nenhuma comunidade.");
						    	} else {
						    		System.out.println("Comunidades que voc� faz parte:");
						    		System.out.println(auxiliar);
						    		System.out.println("Digite o nome da comunidade que deseja sair:");
						    		String nomeComunidadeSair = sc.nextLine();
						    		int respostaComunidade = dados.sairComunidade(loginConta, nomeComunidadeSair);
						    		if(respostaComunidade == 0) {
						    			System.out.println("Comunidade nao encontrada.");
						    		} else if(respostaComunidade == 1) {
						    			System.out.println("Voc� � o(a) dono(a) dessa comunidade e n�o pode sair.");
						    		} else if(respostaComunidade == 2) {
						    			System.out.println("Sa�da efetivada com sucesso!");
						    		} else if(respostaComunidade == 3) {
						    			System.out.println("Voc� n�o faz parte dessa comunidade.");
						    		}
						    	}
						    break;
						    case 14:
						    	try {
						    		System.out.println("Escolha a configura��o do seu feed:");
							    	System.out.println("Publico -> (todos podem visualizar)");
							        System.out.println("Privado -> (apenas amigos conseguem visualizar)");
							    	System.out.print("Escreva exatamente como encima: ");
								    String permissaoFeed = sc.next();
								    PermissaoFeed permissaoFeedEnum = PermissaoFeed.valueOf(permissaoFeed);
								    dados.configurarFeed(loginConta, permissaoFeedEnum);
								    System.out.println("Feed configurado.");
						    	}
						    	catch (IllegalArgumentException e) {
									sc.close();
									System.out.println("Erro na entrada" + "\n" + "Fim do Programa." );
									return;
								} 
						    break;
						    case 15:
						    	if(dados.buscarLoginNoFeed(loginConta) == 0) {
						    		System.out.println("Seu feed precisa ser configurado primeiro");
						    	} else {
						    		System.out.println("Escreva a mensagem para o feed:");
							    	String feedTexto = sc.nextLine();
							    	dados.escreverFeed(loginConta, feedTexto);
							    	System.out.println("Feed atualizado.");
						    	}
						    break;
						    case 16:
						    	if(dados.visualizarFeed(loginConta) == null) {
						    		System.out.println("Nenhuma atividade encontrada no Feed.");
						    	}else {
						    		System.out.println(dados.visualizarFeed(loginConta));
						    	}
						    break;
						    case 17:
						    	int auxFeed=dados.getTamanhoListaFeed();
						    	List <Feed> listaFeed = new ArrayList<>();
						    	listaFeed = dados.getListFeed();
						    	List <Amizades> listaAmi = new ArrayList<>();
						    	listaAmi = dados.getListAmi();
						    	if(auxFeed == 0) {
						    		System.out.println("Feed vazio.");
						    	} else {
						    		for(Feed val : listaFeed) {
						    			int auxAmi=dados.getTamanhoListaAmi();
						    			if(val.getPermissao() == PermissaoFeed.Publico ) {
						    				System.out.println(val);
						    			} else if(loginConta.contentEquals(val.getLogin()) == true){
						    				System.out.println(val);
						    			} else {
						    				if(listaAmi.size() != 0) {
						    					for(Amizades val2 : listaAmi) {
											    	if(loginConta.contentEquals(val2.getUsuario1()) == true && val.getLogin().contentEquals(val2.getUsuario2())) {
											    		System.out.println(val);
											    	} else if(loginConta.contentEquals(val2.getUsuario2()) == true && val.getLogin().contentEquals(val2.getUsuario1())) {
											    		System.out.println(val);
											    	} else {
											    		auxAmi--;
											    	}
						    					}
						    				}
						    				if(auxAmi == 0) {
						    					auxFeed--;
						    				}
						    			}
						    	    }
						    		if(auxFeed == 0) {
						    			System.out.println("Feed vazio.");
						    		}
						    	}
						    break;
						    case 19:
						    	dados.cancelarConta(loginConta);
						    	System.out.println("Cadastro cancelado com sucesso.");
						    break;
						   
							default:
								System.out.println("Op��o Inv�lida.");
					        }
						    if(entradaLogin == 19) {
						    	entradaLogin = 20;
						    } else {
							    try {
							    	System.out.println("\n---------------------------------------");
							    	System.out.println("L o g i n : " + loginConta);
							    	System.out.println("---------------------------------------");
						    		System.out.println("Solicita��es (" + dados.mostrarSolUsu(loginConta) +")");
						    		System.out.println("Amigos (" + dados.mostrarAmi(loginConta) +")");
						    		System.out.println("Mensagens (" + dados.mostrarMen(loginConta) +")");
						    		System.out.println("Comunidades (" + dados.mostrarCom(loginConta) +")");
							    	System.out.println("");
							    	System.out.println("PERFIL");
								    System.out.println("  01-> Configurar Perfil");
								    System.out.println("  02-> Visualizar Perfil");
								    System.out.println("AMIGOS");
								    System.out.println("  03-> Solicitar Nova Amizade");
								    System.out.println("  04-> Verificar Pedidos de Amizade");
								    System.out.println("  05-> Ver Amigos");
								    System.out.println("MENSAGENS");
								    System.out.println("  06-> Enviar Mensagem para um Usu�rio");
								    System.out.println("  07-> Enviar Mensagem para uma Comunidade");
								    System.out.println("  08-> Visualizar Todas as Mensagens");
								    System.out.println("COMUNIDADES");
								    System.out.println("  09-> Criar comunidade");
									System.out.println("  10-> Entrar em uma comunidade");
									System.out.println("  11-> Visualizar Comunidades Existentes");
									System.out.println("  12-> Ver Minhas Comunidades");
									System.out.println("  13-> Sair de uma Comunidade");
									System.out.println("FEED");
									System.out.println("  14-> Configurar seu Feed de Not�cias");
									System.out.println("  15-> Escrever no Feed de Not�cias");
									System.out.println("  16-> Visualizar Meu Feed");
									System.out.println("  17-> Visualizar Feed Geral");
								    System.out.println("...");
								    System.out.println("  19-> Cancelar Cadastro");
								    System.out.println("  20-> Deslogar");
									System.out.print("Digite sua op��o: ");
							    	entradaLogin = sc.nextInt();
								    sc.nextLine();
								    System.out.println("");
								} 
								catch (InputMismatchException e) {
									sc.close();
									System.out.println("Erro na entrada" + "\n" + "Fim do Programa." );
									return;
								}
						    }
					    }
			    	}
		        }
			break;
			
			default:
				System.out.println("Digite um n�mero correto");
			}
			
			try {
				System.out.println("");
				System.out.println("1-> Cadastrar-se");
				System.out.println("2-> Fazer Login");
				System.out.println("3-> Sair do iFace");
				System.out.print("Digite sua op��o: ");
				entrada1 = sc.nextInt();
				sc.nextLine();
				System.out.println("");
			} 
			catch (InputMismatchException e) {
				sc.close();
				System.out.println("Erro na entrada" + "\n" + "Fim do Programa." );
				return;
			}
		}
		
		System.out.println("\nObrigado por confiar no iFace.");

	    sc.close();

	}
}
