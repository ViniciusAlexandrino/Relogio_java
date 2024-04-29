import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Calendar;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	// Objetos e variáveis globais para a interface do relógio
	Calendar calendar;// Objeto para acessar a data e hora atuais
	SimpleDateFormat timeFormat;// Formato para exibir o tempo (horas, minutos, segundos)
	SimpleDateFormat dayFormat;// Formato para exibir o dia da semana
	SimpleDateFormat dateFormat;// Formato para exibir a data completa
	JLabel timeLabel;// Rótulo para exibir o tempo
	JLabel dayLabel;// Rótulo para exibir o dia da semana
	JLabel dateLabel; // Rótulo para exibir a data
	String time;// Armazenar o tempo como string
	String day;// Armazenar o dia da semana como string
	String date;// Armazenar a data como string

	MyFrame() {
		
		// Configurações básicas da janela
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Fechar ao clicar no X
		this.setTitle("Relógio");// Define o título da janela
		this.setLayout(new FlowLayout());// Usa um layout de fluxo para organizar componentes
		this.setSize(350,200);// Define o tamanho da janela
		this.setResizable(false);// Impede que a janela seja redimensionada
		
		// Inicializa os formatos de data/hora
		timeFormat = new SimpleDateFormat("hh:mm:ss a");// Exibe tempo no formato 12 horas
		dayFormat = new SimpleDateFormat("EEEE");// Exibe o dia da semana por extenso
		dateFormat = new SimpleDateFormat("dd 'de' MMMMM, yyyy");// Exibe a data por extenso
		
		// Configura o rótulo para o tempo
		timeLabel = new JLabel();// Cria um rótulo para o tempo
		timeLabel.setFont(new Font("Verdana",Font.PLAIN,50));// Define a fonte para o tempo
		timeLabel.setForeground(new Color(0x00FF00));// Define a cor do texto para verde
		timeLabel.setBackground(Color.black);// Define a cor de fundo para preto
		timeLabel.setOpaque(true);// Torna o rótulo opaco para que a cor de fundo seja visível
		
		// Configura o rótulo para o dia da semana
		dayLabel = new JLabel();// Cria um rótulo para o dia
		dayLabel.setFont(new Font("Ink Free",Font.PLAIN,35));// Define a fonte para o dia
		
		// Configura o rótulo para a data
		dateLabel = new JLabel();// Cria um rótulo para a data
		dateLabel.setFont(new Font("Ink Free",Font.PLAIN,25));// Define a fonte para a data
		
		// Adiciona os rótulos à janela
		this.add(timeLabel); // Adiciona o rótulo para o tempo
		this.add(dayLabel);// Adiciona o rótulo para o dia
		this.add(dateLabel);// Adiciona o rótulo para a data
		this.setVisible(true);// Torna a janela visível
		
		 // Inicia o relógio para exibir o tempo em tempo real
		setTime(); // Inicia a atualização do tempo
	}
	
	public void setTime() {
		// Atualiza os rótulos do relógio em tempo real
		while(true) {// Loop infinito para manter a atualização contínua
			time = timeFormat.format(Calendar.getInstance().getTime());// Obtem a data e hora atuais e formata
			timeLabel.setText(time);// Atualiza o rótulo do tempo
			
			day = dayFormat.format(Calendar.getInstance().getTime());
			dayLabel.setText(day);// Atualiza o rótulo do dia da semana
			
			date = dateFormat.format(Calendar.getInstance().getTime());
			dateLabel.setText(date);// Atualiza o rótulo da data
			
			try {
				Thread.sleep(1000);// Aguarda 1 segundo antes de atualizar novamente
			}catch (InterruptedException e) {
				e.printStackTrace();// Lida com a exceção de interrupção
			}
		}
	}
}
