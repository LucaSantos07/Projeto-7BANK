
package contaBancoPOO;

import javax.swing.JOptionPane;


public class Dados extends Conta {
    
    public void informações(){
        
        int op;
        
        String Menu = "Banco 7BANK\n"+
        "1- Cadastro \n"+
        "2- Status \n"+
        "3- Deposito \n"+
        "4- Sacar \n"+
        //"5 - Credito\n"+
        "6- Fechar Conta \n"+
       // "7- Taxas \n"+
        "8- Mensalidade \n"+       
        "9- Sair";
        try{
        do{
            op = Integer.parseInt(JOptionPane.showInputDialog(Menu));
        
            switch(op){
            
                case 1:
                   String x;
                    x = JOptionPane.showInputDialog("Digite uma das opções para abertura de conta \n"
                     + " P- Polpança\n" + " cc- Corrente\n");
                    this.setTipo(x);
                    
                    abrirConta(this.getTipo());
                    
                break;
                
                case 2:
                    status();   
                break;
            
                case 3:
                    depositar(0);    
                break;
                
                case 4:
                    sacar(0);    
                break;
                
                /*case 5:
                    saqueCredito(0);
                break;*/
                
                case 6:
                    if (isStatus() == false) {
                      JOptionPane.showMessageDialog(null,"Para realizar essa operação uma conta precisa estar aberta");
        
                      break;
                    }
                    
                    fecharConta();
                
               /* case 7:
                    Taxa();
                break;*/
                    
                case 8:
                    
                    pagarMensal();  
                break;
                
                case 9:
                    JOptionPane.showMessageDialog(null,"Obrigado pela Preferência");
                break;
               
                default:
                    JOptionPane.showMessageDialog(null,"Opção invaladia");
                break;
            }
        }
        while(op != 9);
           }catch(NumberFormatException e){
               JOptionPane.showMessageDialog(null,"Insira um numero. Erro \n" + e);
    
           }
    }
 
}
