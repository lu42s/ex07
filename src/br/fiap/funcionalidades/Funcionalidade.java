package br.fiap.funcionalidades;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;
import br.fiap.fornecedor.Fornecedor;
import br.fiap.produto.Produto;

public class Funcionalidade {
    Fornecedor[] fornecedor=new Fornecedor[2];
    private Produto[] produto=new Produto[4];
    int i,n;

    public void menu(){
            int opcao=0;
            String menu = "1.Cadastrar Produto \n2.Pesquisar por produto \n3.Pesquisar por fornecedor \n4.Finalizar";
            do{
                opcao =parseInt(showInputDialog(menu));
                if(opcao == 1){
                    cadastrarProdutos();
                } else if (opcao == 2) {
                    pesquisaProd();
                } else if (opcao == 3) {
                   pesquisaForn();
                }
            }while(opcao != 4);

    }

    private void cadastrarProdutos(){
        String nome;
        double valor;
        int qtdEstoque;
        Fornecedor fornecedor=pesquisaForn();

        if(fornecedor == null){
            fornecedor=cadastrarForn();
        }

        nome=showInputDialog("Insira o nome do produto:");
        valor=parseDouble(showInputDialog("Insira o valor do produto:"));
        qtdEstoque=parseInt(showInputDialog("Insira a quantidade em estoque do produto:"));

        produto[i]=new Produto(nome,valor,qtdEstoque,fornecedor);
        i++;
    }

    private Fornecedor cadastrarForn(){
        String nome=showInputDialog("Insira o nome do fornecedor:");
        long cnpj=parseLong(showInputDialog("Insira o cnpj do fornecedor:"));
        fornecedor[n] = new Fornecedor(nome,cnpj);
        n++;
        return fornecedor[n-1];
    }

    private Produto pesquisaProd() {
        String aux = "Produto não encontrado";
        String nome = showInputDialog("Informe o nome do produto:");

        for (int l = 0; l < i; l++) {
            if (produto[l].getNome().equalsIgnoreCase(nome)) {
                aux = "Nome produto: " + nome + "\nValor:" + produto[l].getValor() + "\nFornecedor" + produto[l].getFornecedor().getNome();

            }
        }
        return aux;
    }

    private Fornecedor pesquisaForn(){
        long cnpj = parseLong(showInputDialog("Informe o cnpj do fornecedor"));
        for(int j=0;j<i;j++){
            if(fornecedor[j].getCnpj()==cnpj) {
                return fornecedor[j];
            }
        }
        showMessageDialog(null,"CNPJ não encontrado");
        return null;
    }
}
