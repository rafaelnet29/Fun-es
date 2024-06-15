package exemplo.funcoes;

import java.text.MessageFormat;
import javax.swing.JOptionPane;

public class Funcoes {

    private int num;
    private int tempo;
    private double itaxa;
    private double preco;
    private double total;
    private double porcentagem;
    private double juros;
    private double capital;

    //construtores
    public Funcoes(double c, double i, int t) {
        this.capital = c;
        this.itaxa = i;
        this.tempo = t;
    }

    public Funcoes(int numero) {
        this.num = numero;
    }

    public Funcoes(double price, double percent) {
        this.preco = price;
        this.porcentagem = percent;
    }

    /**
     * Função recursiva fatorial de um número
     *
     * @return
     */
    public int RecursivaFatorial() {

        @SuppressWarnings("UnusedAssignment")
        int fatorial = 0;
        if (num == 0) {
            return 1;
        } else {
            fatorial = num * new Funcoes(num - 1).RecursivaFatorial();
        }
        return fatorial;
    }

    /**
     * Função para descobrir se um número é PAR ou ÍMPAR
     *
     * @return
     */
    public int FuncaoParOuImpar() {

        if (num % 2 == 0) {
            JOptionPane.showMessageDialog(null, String.format("O numero %s é PAR ", num),
                    "Numero Par ", 1);
        } else {
            JOptionPane.showMessageDialog(null, String.format("O numero %s é ÍMPAR", num),
                    "Numero Ímpar ", 1);
        }
        return num;
    }

    /**
     * Alipcando descontos
     *
     * @return
     */
    public Double aplicarDesconto() {

        total = (preco - ((porcentagem / 100) * preco));
        JOptionPane.showMessageDialog(null,
                MessageFormat.format("O valor do desconto é = {0} '%' em cima de ${1} reais. Total a pagar: ${2} reais ",
                        porcentagem, preco, total), "Desconto ", 1);
        return total;
    }

    /**
     * "O juro simples é calculado tendo como base o valor inicial, conhecido
     * como capital, a taxa de juro e o tempo. A fórmula do juro simples é J = C
     * ∙ i ∙ t, em que J é o juro, C é o capital, i é a taxa de juro e t o
     * tempo." https://brasilescola.uol.com.br/matematica/juros-simples.htm
     *
     * @return 
     * O Metodo caulcula o juros de período anual
     */
    
    public Double juroSimples() {
        //Juros Anual
        juros = (capital * (itaxa / 100) * tempo);

        //Montante
        total = capital + juros;

        JOptionPane.showMessageDialog(null,
                MessageFormat.format("O valor do juros é: ${0} reais em cima do capital ${1} reais. montante: ${2} reais ",
                        juros, capital, total), "Juros simples ", 1);

        return total;
    }
}
