package entities;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List <Conta> list = new ArrayList<>();
		List <Comunidade> listCom = new ArrayList<>();
		List <Mensagem> listMen = new ArrayList<>();
		List <SolicitacaoAmizade> listSolAmi = new ArrayList<>();
		List <Amizades> listAmi = new ArrayList<>();
		List <Feed> listFeed = new ArrayList<>();
		
		int entrada1=0;
		int entradaLogin=0;
		int entradaConfigurarPerfil=0;
		int tamanhoLista = 0;
		int tamanhoListaCom = 0;
		int tamanhoListaMen = 0;
		int tamanhoListaSolAmi = 0;
		int tamanhoListaAmi = 0;
		int tamanhoListaFeed = 0;
					    
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
				tamanhoLista = list.size();
				System.out.println("Informe seu login:");
		    	String login = sc.nextLine();
		    	if(tamanhoLista != 0) {
		    		for(Conta val : list) {
			    		if(login.contentEquals(val.getLogin()) == true) {
			    			break;
			    		} else {
			    			tamanhoLista--;
			    		}
			    	}
			    }
			    if(tamanhoLista == 0) {
			    	System.out.println("Informe sua senha:");
				    String senha = sc.nextLine();
				    System.out.println("Informe seu nome:");
				    String nome = sc.nextLine();
				    list.add(new Conta(login, senha, nome));
				    System.out.println("Login criado com sucesso.");
			    } else {
			    	System.out.println("Login j� existente.");
			    }
		    break;
		    
			case 2:
				tamanhoLista = list.size();
				if(tamanhoLista == 0) {
			    	System.out.println("Sem usu�rios cadastrados");
			    } else {
			    	System.out.println("Informe seu login:");
			    	String loginConta = sc.nextLine();
			    	tamanhoLista = list.size();
			    	for(Conta val : list) {
			    		if(loginConta.contentEquals(val.getLogin()) == true) {
			    			System.out.println("Ol�, " + val.getNome());
			    			break;
			    		} else {
			    			tamanhoLista--;
			    		}
			    	}
			    	if(tamanhoLista == 0) {
			    		System.out.println("Login n�o cadastrado");
			    	} else {
					    try {
					    	System.out.println("");
				    		System.out.println("PERFIL");
						    System.out.println("01-> Configurar Perfil");
						    System.out.println("02-> Visualizar Perfil");
						    System.out.println("AMIGOS");
						    System.out.println("03-> Solicitar Nova Amizade");
						    System.out.println("04-> Verificar Pedidos de Amizade");
						    System.out.println("05-> Ver Amigos");
						    System.out.println("MENSAGENS");
						    System.out.println("06-> Enviar Mensagem para um Usu�rio");
						    System.out.println("07-> Enviar Mensagem para uma Comunidade");
						    System.out.println("08-> Visualizar Todas as Mensagens");
						    System.out.println("COMUNIDADES");
						    System.out.println("09-> Criar comunidade");
							System.out.println("10-> Entrar em uma comunidade");
							System.out.println("11-> Ver Minhas Comunidades");
							System.out.println("FEED");
							System.out.println("12-> Configurar seu Feed de Not�cias");
							System.out.println("13-> Escrever no Feed de Not�cias");
							System.out.println("14-> Visualizar Meu Feed");
							System.out.println("15-> Visualizar Feed Geral");
						    System.out.println("...");
						    System.out.println("19-> Cancelar Cadastro");
						    System.out.println("20-> Deslogar");
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
							    	String login1 = sc.nextLine();
							    	for(Conta val : list) {
							    		if(loginConta.contentEquals(val.getLogin()) == true) {
							    			System.out.println("Login alterado de " + val.getLogin() + " para " + login1 + ".");
							    			loginConta = login1;
							    			val.setLogin(login1);
							    			break;
							    		}
							    	}
							    break;
							    case 2:
									System.out.println("Nova senha:");
									String senha1 = sc.nextLine();
									for(Conta val : list) {
										if(loginConta.contentEquals(val.getLogin()) == true) {
											System.out.println("Senha alterado de " + val.getSenha() + " para " + senha1 + ".");
											val.setSenha(senha1);
											break;
										}
									}
							    break;
							    case 3:
									System.out.println("Novo nome:");
									String nome1 = sc.nextLine();
									for(Conta val : list) {
										if(loginConta.contentEquals(val.getLogin()) == true) {
											System.out.println("Nome alterado de " + val.getNome() + " para " + nome1 + ".");
											val.setNome(nome1);
											break;
										}
									}
							    break;
							    default:
							    	System.out.println("Op��o Inv�lida");
							    }
							break;
						    case 2:
						    	for(Conta val : list) {
									if(loginConta.contentEquals(val.getLogin()) == true) {
										System.out.println(val);
										break;
									}
								}
						    break;
						    case 3:
						    	tamanhoListaAmi = listAmi.size();
						    	tamanhoListaSolAmi = listSolAmi.size();
						    	System.out.println("Informe o Login do amigo desejado: ");
						    	String amigoDesejado = sc.nextLine();
						    	if(loginConta.contentEquals(amigoDesejado) == true) {
						    		System.out.println("Voc� n�o pode ser seu pr�prio amigo.");
						    	} else {
						    		tamanhoLista = list.size();
									for(Conta val : list) {
										if(amigoDesejado.contentEquals(val.getLogin()) == true){
											break;
										} else {
											tamanhoLista--;
										}
									}
									if(tamanhoLista == 0) {
										System.out.println("Login destinat�rio n�o cadastrado");
									} else {
										for(Amizades val : listAmi) {
								    		if(loginConta.contentEquals(val.getAmigo1()) == true && amigoDesejado.contentEquals(val.getAmigo2()) == true) {
								    			System.out.println("Voc� j� � amigo do " + amigoDesejado + ".");
								    			break;
								    		} else if(loginConta.contentEquals(val.getAmigo2()) == true && amigoDesejado.contentEquals(val.getAmigo1()) == true) {
								    			System.out.println("Voc� j� � amigo do " + amigoDesejado + ".");
								    			break;
								    		} else {
								    			tamanhoListaAmi--;
								    		}
								    	}
										for(SolicitacaoAmizade val : listSolAmi) {
								    		if(loginConta.contentEquals(val.getAmigoDesejado()) == true && amigoDesejado.contentEquals(val.getLoginSolicitante()) == true){
								    			System.out.println(amigoDesejado + " j� lhe enviou um pedido de Amizade.\nVerifique seus pedidos.");
									    		break;
											} else if(loginConta.contentEquals(val.getLoginSolicitante()) == true && amigoDesejado.contentEquals(val.getAmigoDesejado()) == true){
								    			System.out.println("Voc� j� enviou anteriormente um pedido a esse usu�rio.");
									    		break;
											} else {
												tamanhoListaSolAmi--;
											}
								    	}
										if(tamanhoListaAmi == 0 && tamanhoListaSolAmi == 0) {
											listSolAmi.add(new SolicitacaoAmizade(loginConta, amigoDesejado));
										    System.out.println("Solicita��o enviada.");
										}
									}
						    	}
						    break;
						    case 4:
						    	tamanhoListaSolAmi = listSolAmi.size();
								if(tamanhoLista == 0) {
									System.out.println("Sem solicita��es no momento");
								} else {
									int resposta;
							    	for(Iterator<SolicitacaoAmizade> iterator = listSolAmi.iterator(); iterator.hasNext(); ) {
							    		SolicitacaoAmizade val = iterator.next();
							    		if(loginConta.contentEquals(val.getAmigoDesejado()) == true){
							    			System.out.println("Aceitar amizade de " + val.getLoginSolicitante() + " ? (s=1/n=2)");
							    			try {
							    				resposta = sc.nextInt();
							    				sc.nextLine();
							    				System.out.println("");
							    			} 
							    			catch (InputMismatchException e) {
							    				sc.close();
							    				System.out.println("Erro na entrada" + "\n" + "Fim do Programa." );
							    				return;
							    			}
							    			if(resposta == 1) {
							    				listAmi.add(new Amizades(loginConta, val.getLoginSolicitante()));
							    				System.out.println("Amizade aceita.");
							    				iterator.remove();
							    			} else if(resposta == 2){
							    				System.out.println("Amizade recusada.");
							    				iterator.remove();
							    			} else {
							    				System.out.println("Op��o Inv�lida.");
							    			}
										} else {
											tamanhoListaSolAmi--;
										}
							    	}
							    	if(tamanhoListaSolAmi == 0) {
										System.out.println("Sem solicita��es no momento");
									}
								}
						    break;
						    case 5:
						    	tamanhoListaAmi = listAmi.size();
						    	if(tamanhoListaAmi == 0) {
						    		System.out.println("Nenhum amigo encontrado.");
						    	} else {
							    	for(Amizades val : listAmi) {
							    		if(loginConta.contentEquals(val.getAmigo1()) == true) {
							    			System.out.println(val.getAmigo2());
							    		} else if(loginConta.contentEquals(val.getAmigo2()) == true) {
							    			System.out.println(val.getAmigo1());
							    		} else {
							    			tamanhoListaAmi--;
							    		}
							    	}
							    	if(tamanhoListaAmi == 0) {
							    		System.out.println("Nenhum amigo encontrado.");
							    	}
						    	}
						    break;
						    case 6:
						    	System.out.println("Informe o login do destinat�rio:");
								String loginDestinatario = sc.nextLine();
								System.out.println("Informe a mensagem:");
								String mensagem = sc.nextLine();
								tamanhoLista = list.size();
								for(Conta val : list) {
									if(loginDestinatario.contentEquals(val.getLogin()) == true){
										listMen.add(new Mensagem(loginConta, mensagem, loginDestinatario));
									    System.out.println("Mensagem enviada com sucesso.");
										break;
									} else {
										tamanhoLista--;
									}
								}
								if(tamanhoLista == 0) {
									System.out.println("Login destinat�rio n�o cadastrado");
								}
						    break;
						    case 7:
						    	if(listCom.size() == 0) {
						    		System.out.println("Nao existe comunidade no momento");
						    	} else {
									System.out.println("Informe o nome da comunidade:");
									String loginDestinatario2 = sc.nextLine();
									System.out.println("Informe a mensagem:");
									String mensagem2 = sc.nextLine();
									tamanhoListaCom = listCom.size();
									for(Comunidade val : listCom) {
										if(loginDestinatario2.contentEquals(val.getNome()) == true) {
											listMen.add(new Mensagem(loginConta, mensagem2, loginDestinatario2));
										    System.out.println("Mensagem enviada com sucesso.");
											break;
										} else {
											tamanhoListaCom--;
									    }
									}
									if(tamanhoListaCom == 0) {
										System.out.println("Comunidade nao cadastrada");
									}
								}
						    break;
						    case 8:
						    	tamanhoListaMen = listMen.size();
						    	if(tamanhoListaMen == 0) {
						    		System.out.println("Nenhuma mensagem encontrada.");
						    	} else {
							    	for(Mensagem val : listMen) {
							    		if(loginConta.contentEquals(val.getLoginItinerario()) == true) {
							    			System.out.println(val);
							    		} else if(loginConta.contentEquals(val.getLoginDestinatario()) == true) {
							    			System.out.println(val);
							    		} else {
							    			tamanhoListaMen--;
							    		}
							    	}
							    	if(tamanhoListaMen == 0) {
							    		System.out.println("Nenhuma mensagem encontrada.");
							    	}
						    	}
						    break;
						    case 9:
						    	System.out.println("Informe o nome da comunidade:");
								String nomCom = sc.nextLine();
								tamanhoListaCom = listCom.size();
					    		if(tamanhoListaCom != 0) {
					    			for(Comunidade val2 : listCom) {
						    			if(nomCom.contentEquals(val2.getNome()) == true) {
						    				System.out.println("Uma comunidade j� existe com esse nome.");
						    				break;
						    			} else {
						    				tamanhoListaCom--;
						    			}
						    		}
					    		} 
					    		if(tamanhoListaCom == 0) {
						    	     System.out.println("Informe a descri��o da comunidade:");
									 String descCom = sc.nextLine();
									 listCom.add(new Comunidade(nomCom, descCom, loginConta));
									 System.out.println("Comunidade criada com sucesso.");
						    	}	
						    break;
						    case 10:
						    	if(listCom.size() == 0) {
						    		System.out.println("Nao existe comunidade no momento");
						    	} else {
						    		System.out.println("Comunidades Existentes:");
						    		for(Comunidade val2 : listCom) {
						    			System.out.println(val2);
						    		}
						    		System.out.println("");
						    		System.out.println("Informe a comunidade de interesse:");
						    		String nomeComunidade = sc.nextLine();
						    		tamanhoListaCom = listCom.size();
						    		for(Comunidade val2 : listCom) {
						    			if(nomeComunidade.contentEquals(val2.getNome()) == true) {
						    				if(loginConta.contentEquals(val2.getLoginDono()) == true) {
						    					System.out.println("Voc� j� � o dono dessa comunidade.");
						    				} else if(val2.buscarMembro(loginConta) == 1){
						    					System.out.println("Voc� j� faz parte dessa comunidade.");
						    				} else {
						    					val2.addMembro(loginConta);
						    				    System.out.println("Parab�ns! Agora voc� faz parte dessa comunidade.");
						    				}
						    				break;
						    			} else {
						    				tamanhoListaCom--;
						    			}
						    		}
						    		if(tamanhoListaCom == 0) {
						    			System.out.println("Comunidade nao encontrada");
						    		}
						    	} 
						    break;
						    case 11:
						    	tamanhoListaCom = listCom.size();
						    	if(tamanhoListaCom == 0) {
						    		System.out.println("Nenhuma comunidade encontrada.");
						    	} else {
							    	for(Comunidade val : listCom) {
							    		if(loginConta.contentEquals(val.getLoginDono()) == true) {
							    			System.out.println(val.getNome() + " (dono)");
							    		} else if (val.buscarMembro(loginConta) == 1){
							    			System.out.println(val.getNome());
							    		} else {
							    			tamanhoListaCom--;
							    		}
							    	}
							    	if(tamanhoListaCom == 0) {
							    		System.out.println("Nenhuma comunidade encontrada.");
							    	}
						    	}
						    break;
						    case 12:
						    	tamanhoListaFeed = listFeed.size();
						    	int tamanhoListaFeedFixa = tamanhoListaFeed;
						    	int feed=0;
						    	
						    	try {
						    		System.out.println("Escolha a configura��o do seu feed:");
						    	    System.out.println("1-> P�blico (todos podem visualizar)");
						    	    System.out.println("2-> Privado (apenas amigos conseguem visualizar)");
									feed = sc.nextInt();
									sc.nextLine();
									System.out.println("");
								} 
								catch (InputMismatchException e) {
									sc.close();
									System.out.println("Erro na entrada" + "\n" + "Fim do Programa." );
									return;
								}
						    	if(tamanhoListaFeed != 0) {
						    		for(int i=0; i<tamanhoListaFeedFixa; i++) {
							    		Feed val2 = new Feed();
							    		val2 = listFeed.get(i);
							    		if(loginConta.contentEquals(val2.getLogin()) == true) {
							    			if(feed == 1) {
									    		val2.setPermissao("P�blico");
									    		System.out.println("Feed configurado.");
									    	} else if (feed == 2) {
									    		val2.setPermissao("Privado");
									    		System.out.println("Feed configurado.");
									    	} else {
									    		System.out.println("Op��o Inv�lida.");
									    	}
							    			break;
							    		} else {
							    			--tamanhoListaFeed;
							    		}      
							        }
						    	}
							    if(tamanhoListaFeed == 0) {
							    	if(feed == 1) {
										listFeed.add(new Feed(loginConta, "P�blico"));
										System.out.println("Feed configurado.");
									} else if (feed == 2) {
										listFeed.add(new Feed(loginConta, "Privado"));
										System.out.println("Feed configurado.");
									} else {
										System.out.println("Op��o Inv�lida.");
									}
							    }
						    break;
						    case 13:
						    	tamanhoListaFeed = listFeed.size();
						    	if(tamanhoListaFeed != 0) {
						    		for(Feed val2 : listFeed) {
							    		if(loginConta.contentEquals(val2.getLogin()) == true) {
							    			System.out.println("Escreva a mensagem para o feed:");
							    	        String feedTexto = sc.nextLine();
							    	        val2.addMensagem(feedTexto);
							    	        System.out.println("Feed atualizado.");
							    	        break;
							    		} else {
							    			tamanhoListaFeed--;   
							        }
						    	}
						    	if(tamanhoListaFeed == 0)
							    	System.out.println("Seu feed precisa ser configurado primeiro");
							    }
						    break;
						    case 14:
						    	tamanhoListaFeed = listFeed.size();
						    	if(tamanhoListaFeed != 0) {
						    		for(Feed val : listFeed) {
							    		if(loginConta.contentEquals(val.getLogin()) == true) {
							    			System.out.println(val);
							    		} else {
							    			tamanhoListaFeed--;
							    		}
							    	}
						    	}
							    if(tamanhoListaFeed == 0) {
							    	System.out.println("Nenhuma atividade encontrada no Feed.");
							    }
						    break;
						    case 15:
						    	if(listFeed.size() == 0) {
						    		System.out.println("Feed vazio.");
						    	} else {
						    		for(Feed val : listFeed) {
						    			if(val.getPermissao().contentEquals("P�blico") == true) {
						    				System.out.println(val);
						    			} else if(loginConta.contentEquals(val.getLogin()) == true){
						    				System.out.println(val);
						    			} else {
						    				if(listAmi.size()>0) {
						    					for(Amizades val2 : listAmi) {
											    	if(loginConta.contentEquals(val2.getAmigo1()) == true && val.getLogin().contentEquals(val2.getAmigo2())) {
											    		System.out.println(val);
											    	} else if(loginConta.contentEquals(val2.getAmigo2()) == true && val.getLogin().contentEquals(val2.getAmigo1())) {
											    		System.out.println(val);
											    	}
						    					}
						    				}
						    			}
						    	    }
						    	}
						    break;
						    case 19:
						    	for (Iterator<Conta> iterator = list.iterator(); iterator.hasNext(); ) {
						    		Conta val = iterator.next();
						    		if(loginConta.contentEquals(val.getLogin()) == true) {
						    			iterator.remove();
						    		}
						    	}
						    	for(Iterator<Comunidade> iterator = listCom.iterator(); iterator.hasNext(); ) {
						    		Comunidade val = iterator.next();
						    		if(loginConta.contentEquals(val.getLoginDono()) == true) {
						    			iterator.remove();
						    		} else if (val.buscarMembro(loginConta) == 1){
						    			val.removeMembro(loginConta);
						    		}
						    	}
						    	for(Iterator<Mensagem> iterator = listMen.iterator(); iterator.hasNext(); ) {
						    		Mensagem val = iterator.next();
						    		if(loginConta.contentEquals(val.getLoginItinerario()) == true) {
						    			iterator.remove();
						    		} else if(loginConta.contentEquals(val.getLoginDestinatario()) == true) {
						    			iterator.remove();
						    		}
						    	}
						    	for(Iterator<SolicitacaoAmizade> iterator = listSolAmi.iterator(); iterator.hasNext(); ) {
						    		SolicitacaoAmizade val = iterator.next();
									if(loginConta.contentEquals(val.getAmigoDesejado()) == true){
										iterator.remove();
									} else if (loginConta.contentEquals(val.getLoginSolicitante()) == true) {
										iterator.remove();
									}
								}
						    	for(Iterator<Amizades> iterator = listAmi.iterator(); iterator.hasNext(); ) {
						    		Amizades val = iterator.next();
						    		if(loginConta.contentEquals(val.getAmigo1()) == true) {
						    			iterator.remove();
						    		} else if(loginConta.contentEquals(val.getAmigo2()) == true) {
						    			iterator.remove();
						    		}
						    	}
						    	for(Iterator<Feed> iterator = listFeed.iterator(); iterator.hasNext(); ) {
						    		Feed val = iterator.next();
						    		if(loginConta.contentEquals(val.getLogin()) == true) {
						    			iterator.remove();
						    		}
						    	}
						    	System.out.println("Cadastro cancelado com sucesso.");
						    break;
						    case 20:
						    break;
						   
							default:
								System.out.println("Op��o Inv�lida.");
					        }
						    if(entradaLogin == 19) {
						    	entradaLogin = 20;
						    } else {
							    try {
							    	System.out.println("");
						    		System.out.println("PERFIL");
								    System.out.println("01-> Configurar Perfil");
								    System.out.println("02-> Visualizar Perfil");
								    System.out.println("AMIGOS");
								    System.out.println("03-> Solicitar Nova Amizade");
								    System.out.println("04-> Verificar Pedidos de Amizade");
								    System.out.println("05-> Ver Amigos");
								    System.out.println("MENSAGENS");
								    System.out.println("06-> Enviar Mensagem para um Usu�rio");
								    System.out.println("07-> Enviar Mensagem para uma Comunidade");
								    System.out.println("08-> Visualizar Todas as Mensagens");
								    System.out.println("COMUNIDADES");
								    System.out.println("09-> Criar comunidade");
									System.out.println("10-> Entrar em uma comunidade");
									System.out.println("11-> Ver Minhas Comunidades");
									System.out.println("FEED");
									System.out.println("12-> Configurar seu Feed de Not�cias");
									System.out.println("13-> Escrever no Feed de Not�cias");
									System.out.println("14-> Visualizar Meu Feed");
									System.out.println("15-> Visualizar Feed Geral");
								    System.out.println("...");
								    System.out.println("19-> Cancelar Cadastro");
								    System.out.println("20-> Deslogar");
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
