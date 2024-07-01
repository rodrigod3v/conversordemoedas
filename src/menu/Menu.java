package menu;

import conversorApi.Conversor;
import conversorApi.ConversorApi;

import java.util.Scanner;

public class Menu {
    Scanner escolha = new Scanner(System.in);

    public void menu(){
        boolean exibeMenu = true;
        while (exibeMenu){
            System.out.println("""
                ******************************************************
                          Bem vindo ao Conversor de Moedas !
                ******************************************************

                        1) [USD] para [BRL]
                        2) [BRL] para [USD]
                        3) [ARS] para [BRL]
                        4) [BRL] para [ARS]
                        5) [EUR] para [BRL]
                        6) [BRL] para [EUR]
                        ou SAIR para finalizar.
                -------------------------------------------------------
                """);

                System.out.println("Escolha a conversão:");
                String opcao = escolha.next();

                switch (opcao){
                    case "1":
                        this.converter("USD","BRL");
                        break;

                    case "2":
                        this.converter("BRL","USD");
                        break;

                    case "3":
                        this.converter("ARS","BRL");
                        break;

                    case "4":
                        this.converter("BRL","ARS" );
                        break;

                    case "5":
                        this.converter("EUR","BRL");
                        break;

                    case "6":
                        this.converter("BRL","EUR" );
                        break;

                    default:
                        if (opcao.equals("sair")){
                            System.out.println("Operação finalizada com sucesso");
                            exibeMenu = false;
                        }else {
                            System.out.println("Opção Inválida ! " +
                                    "Selecione uma opção valida ou Digite \"sair\" para sair. ");
                        }
                        break;
                }
            }
        }

        public void converter (String base_code, String target_code){
            System.out.println("Informe o valor: ");
            try {
                double valor = this.escolha.nextDouble();
                Conversor conversor = new Conversor(base_code, target_code, valor);
                ConversorApi api = new ConversorApi(conversor);
                System.out.println(api.chamadaApi());
            } catch (Exception e) {
                System.out.println("Digite um valor de 1 a 6 ou digite sair, para sair.");
            }

        }
    }
