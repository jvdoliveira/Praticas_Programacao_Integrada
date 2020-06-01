/** 
 * Antes de testar
 * Descomentar a lina 39
 * Gerar a chave
 * copiar a senha criptografada para o banco
 * comentar a linha 39
 * tentar logar*/

package criptografia;

import java.io.File;

public class CryptoMethod {
	public String criptografa(String senha) throws Exception {

		File arquivo = new File("C:\\Users\\jvdol\\git\\ECP6AN-MCA1_PratProgInt\\Atividade_PPI_9\\WebContent\\log","key.txt");
		String sMsgClara = senha;
		String sMsgCifrada = null;
		String sMsgDecifrada = null;
		byte[] bMsgClara = null;
		byte[] bMsgCifrada = null;
		byte[] bMsgDecifrada = null;
		Impressora prn = new Impressora();

		System.out.println("-------------------------------------------------------------- -");

		System.out.println(">>> Imprimindo mensagem original...");
		System.out.println("");

		bMsgClara = sMsgClara.getBytes("ISO-8859-1"); 
		System.out.println("Mensagem Clara (Hexadecimal):");

		System.out.print(prn.hexBytesToString(bMsgClara));
		System.out.println("");

		System.out.println("Mensagem Clara (String):");

		System.out.println(sMsgClara);
		System.out.println("");

		System.out.println(">>> Cifrando com o algoritmo AES...");
		System.out.println("");
		CryptoAES caes = new CryptoAES();
		//caes.geraChave(arquivo);
		caes.geraCifra(bMsgClara, arquivo); 										
		bMsgCifrada = caes.getTextoCifrado();
		sMsgCifrada = (new String(bMsgCifrada, "ISO-8859-1")); 
		System.out.println("Mensagem Cifrada (Hexadecimal):");
		System.out.print(prn.hexBytesToString(bMsgCifrada));
		System.out.println("");
		System.out.println("Mensagem Cifrada (String):");
		System.out.println(sMsgCifrada);
		System.out.println("");


		return sMsgCifrada;
	}
}