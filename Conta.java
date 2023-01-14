package contaBancoPOO;

import javax.swing.JOptionPane;
import java.util.Random;

public class Conta {
    private int numero;
    private int agencia;
    private String nome;
    private String tipo;
    private float saldo;
    private boolean status;
    //private float credito;
    Random aleatorio = new Random();




    public Conta() {

        setNumero(aleatorio.nextInt((100000)* 9));
        this.setAgencia(5600);
        
    }

    /*public float getCredito() {
        return credito;
    }

    public void setCredito(float credito) {
        this.credito = credito;
    }*/


    
    public int getNumero() {

        return numero;
    }


    public void setNumero(int numero) {

        this.numero = numero;
    }


    public int getAgencia() {
        
        return agencia;
    }


    public void setAgencia(int agencia) {

        this.agencia = agencia;
    }


    public String getNome() {

        return nome;
    }


    public void setNome(String nome) {

        this.nome = nome;
    }


    public String getTipo() {

        return tipo;
    }


    public void setTipo(String tipo) {

        this.tipo = tipo;
    }


    public float getSaldo() {

        return saldo;
    }


    public void setSaldo(float saldo) {

        this.saldo = saldo;
    }


    public boolean isStatus() {

        return status;
    }


    public void setStatus(boolean status) {

        this.status = status;
    }

   

    public void status() {
        if (isStatus()== true) {
            
        
            JOptionPane.showMessageDialog(null,"Dados da Conta\n" +
            "Dono Da conta: " + this.getNome() +
            "\n Agencia: " + this.getAgencia() +
            "\n Conta: " + this.getNumero() +
            "\n Tipo da Conta: " + this.getTipo() +
            "\n Saldo da Conta: " + this.getSaldo() +
          //  "\n Credito: " + this.getCredito() +
            "\n Status da Conta: " + this.isStatus());
        }
        
        if (isStatus()== false) {
            JOptionPane.showMessageDialog(null,"Dados da Conta\n" +
            "Dono Da conta: " +
            "\n Agencia: "  +
            "\n Conta: " +
            "\n Tipo da Conta: " +
            "\n Saldo da Conta: " +
           // "\n Credito: " +
            "\n Status da Conta: " + this.isStatus());
        }
    }

    

    public void abrirConta(String t) {
   
        t = "cc";
        String p = "p";
        
        int j;
        this.nome = JOptionPane.showInputDialog("Qual é o seu nome?");
        
        this.setSaldo(Float.parseFloat(JOptionPane.showInputDialog("Digite o valor que você deseja depositar? ")));
       
       /* j = JOptionPane.showConfirmDialog(null,"Deseja cartão de credito? ");
        
        if(j == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null,"Sua linha de credito está aberta");
            this.setCredito(500);
        }*/
        
       
        
        if(this.tipo.equals(p)){

            JOptionPane.showMessageDialog(null, this.nome + " sua Conta Polpança está aberta");
            setStatus(true);
        }

        if (this.tipo.equals(t)){

            JOptionPane.showMessageDialog(null,this.nome + " sua Conta Corrente está aberta");
            setStatus(true);
        }   
    }



    public void fecharConta() {
 
       // para fechar conta saldo tem que ser 0 

       int d = Integer.parseInt(JOptionPane.showInputDialog(null,"Deseja fechar a sua conta? \n 1- Sim\n 2- Não "));
       
       if(isStatus() == true && this.saldo == 0 && d == 1) {
          
           
           JOptionPane.showMessageDialog(null, "Sua conta foi fechada");
           
           // System.exit(d);
        }

       // se tiver dinheiro na conta ele não permite fechar

       else if(this.getSaldo()> 0 ){
           
           JOptionPane.showMessageDialog(null, "Sua conta possui saldo você não pode fechar a conta");
        }
       
       // se saldo for negativo também não pode fechar

       else if (this.getSaldo() < 0) {

           JOptionPane.showMessageDialog(null,"Seu saldo é negativo impossivel fechar sua conta");
        }
       
       else{
           JOptionPane.showMessageDialog(null,"Sua conta continua aberta");
        }
    }



    public void depositar(float v) {

       // o valor é passado como parametro
       //CREDITO
      /* if(this.saldo == 1000 || this.saldo == 5000 || this.saldo == 10000){
           float c = 500;
           this.credito = getCredito() + c;
           JOptionPane.showMessageDialog(null,"Você liberou um novo credito de " + c);
        }*/
       
       //CONTA P OU CC
        if (isStatus() == true && this.getSaldo() >= 0) {
            v =(Float.parseFloat(JOptionPane.showInputDialog("Digite o valor que você deseja depositar? ")));
            
            this.saldo = getSaldo() + v;  
        }
       
        if (isStatus() == false) {
           JOptionPane.showMessageDialog(null,"Para realizar essa operação uma conta precisa estar aberta");
        }
    }
    
    

    public void sacar(float v) {
      
        if(this.isStatus() == true){
            
          v = Float.parseFloat(JOptionPane.showInputDialog("Qual valor deseja sacar? "));
        }
        
        if(this.getSaldo() > 0 && this.getSaldo() >= v){
           
           JOptionPane.showMessageDialog(null,"Saque realizado com Sucesso!!");
            this.saldo = this.getSaldo() - v;
        }
        
        else if (this.getSaldo() <= 0 && this.getSaldo() <= v){
            JOptionPane.showMessageDialog(null,"Sem Saldo impossivel sacar");
        }
        
        else if (this.getSaldo() < v) {
            JOptionPane.showMessageDialog(null,"Impossivel sacar, valor superior ao seu saldo!!!!");
        }
        
        if (isStatus() == false) {
            JOptionPane.showMessageDialog(null,"Para realizar essa operação uma conta precisa estar aberta");
        }
    }

   /* public void saqueCredito(float x){
        
         if(this.isStatus() == true){
            
         x = Float.parseFloat(JOptionPane.showInputDialog("Qual valor deseja passar no credito? "));
        }
        
        if(this.getCredito() > 0 && this.getCredito() >= x){
           
           JOptionPane.showMessageDialog(null,"Saque realizado com Sucesso!!");
            this.credito = this.getCredito() - x;
        }
        
        else if (this.getSaldo() < 0){
            JOptionPane.showMessageDialog(null,"Sem Saldo impossivel sacar");
        }
        
        else if (this.getSaldo() < x) {
            JOptionPane.showMessageDialog(null,"Impossivel sacar, valor superior ao seu saldo!!!!");
        }
        
        if (isStatus() == false) {
            JOptionPane.showMessageDialog(null,"Para realizar essa operação uma conta precisa estar aberta");
        }
        
    
    }*/

   /* public void Taxa(){
        //LINHA DE CREDITO
        if (isStatus() == true && this.credito < 500 && this.credito > 0) {
            float x = 5;
            
            this.setSaldo(this.getSaldo() - x);
            JOptionPane.showMessageDialog(null,this.nome + 
            " O valor da sua mensalidade é " + x + " O saldo da sua conta é " + 
            this.getSaldo());
            
        }
        if (isStatus() == true && this.credito == 0) {
            float l = 20;
            this.setSaldo(this.getSaldo() - l);
            JOptionPane.showMessageDialog(null,this.nome + 
            " O valor da sua mensalidade é " + l + " O saldo da sua conta é " + 
            this.getSaldo()); 
        }
        if (isStatus() == false) {
            
            JOptionPane.showMessageDialog(null,"Para realizar essa operação uma conta precisa estar aberta");
        }
    }*/

    public void pagarMensal(){

      // pagar mensalidade manutenção de conta
     
        //CONTA CORRENTE
      if(isStatus()== true && this.saldo >= 5 && "cc".equals(getTipo())){
           float c = 5;
      
          this.setSaldo(this.getSaldo() - c);
          JOptionPane.showMessageDialog(null,this.nome + 
          " O valor da sua mensalidade é " + c + " O saldo da sua conta é " + 
          this.getSaldo());
        }
      if(this.saldo == 0){
          JOptionPane.showMessageDialog(null,"Deposita ai que a gente pega");
      }
        if ("p".equals(getTipo())) {
            JOptionPane.showMessageDialog(null,"Conta Polpança não tem taxas");
        }
        if (isStatus() == false) {
            
            JOptionPane.showMessageDialog(null,"Para realizar essa operação uma conta precisa estar aberta");
        }
    }     
}
