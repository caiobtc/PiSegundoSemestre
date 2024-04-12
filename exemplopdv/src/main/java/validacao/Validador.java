/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validacao;

import java.awt.Color;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author fernando.tfernandes
 */
public class Validador {
    
    public ArrayList<String> mensagensErro = new ArrayList<>();
    
    /**
     * Valida somente campos inteiros
     * @param txt Recebe um objeto do tipo JTextField
     */
    public void validarNumero(JTextField txt){
    
        try{
            
            //Verifico se o campo está vazio
            if(txt.getText().trim().equals("")){
                throw new IllegalArgumentException();
            }
            
            int valorConvertido = Integer.parseInt(txt.getText());
            txt.setBackground(Color.WHITE);
            
        }catch(NumberFormatException e){
        
            this.mensagensErro.add("Falha ao converter o valor do campo " + txt.getName() + " em inteiro");
            txt.setBackground(Color.red);
        }catch(IllegalArgumentException e){
            this.mensagensErro.add("Digite um valor para o campo " + txt.getName());
            txt.setBackground(Color.red);
        }
    
    }
    
    /**
     * Valida somente campos texto
     * @param txt Recebe um objeto do tipo JTextField
     */
     public void validarTexto(JTextField txt){
     
         try{
            
            //Verifico se o campo está vazio
            if(txt.getText().trim().equals("")){
                throw new IllegalArgumentException();
            }
            
            txt.setBackground(Color.white);
            
        }catch(IllegalArgumentException e){
            this.mensagensErro.add("Digite um valor para o campo " + txt.getName());
            txt.setBackground(Color.red);
        }
     
     }
     
    public void limparMensagens() {
     
         this.mensagensErro.clear();
     }
     
     /**@deprecated substituida por {@link #getMensagensErro()}
      * Método para exibir mensagens de erro na tela com JOptionPane
      */
    public void ExibirMensagensErro(){
         
        String errosFormulario = "";
        for (String msg : this.mensagensErro) {
            errosFormulario += msg + "\n";
        }
        
        if(!errosFormulario.equals("")){
            JOptionPane.showMessageDialog(null, errosFormulario);
            this.limparMensagens();
        }
        
     }
     
     /**
      * Resgata todos os erros gerados em uma única String
      * @return 
      */
    public String getMensagensErro(){
         
        String errosFormulario = "";
        
        //Percorro o arrayList e concateno na variável errosFormulario
        for (String msg : this.mensagensErro) {
            errosFormulario += msg + "\n";
        }
        
        if(!errosFormulario.equals("")){
            this.limparMensagens();
        }     
        
        return errosFormulario;
        
     }
     
    public boolean hasErro(){
     
        if(this.mensagensErro.size()>0){
           return true;    
        }else{
             return false;
           }
        }
    public static void verificaEmail(String email) {
        // Expressão regular para validar o email
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        
        // Compilando a expressão regular
        Pattern pattern = Pattern.compile(regex);
        
        // Criando um Matcher com o email fornecido
        Matcher matcher = pattern.matcher(email);
        
        // Verificando se o email corresponde ao padrão
        if (matcher.matches()) {
            
        } else {
            JOptionPane.showMessageDialog(null, "email invalido");
        }
        
    }
    
    public String format(Double txtValorProduto) {
        Locale locale = new Locale("pt", "BR");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        return numberFormat.format(txtValorProduto);
    
    }
        
     
}
