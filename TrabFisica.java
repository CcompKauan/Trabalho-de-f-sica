import javax.swing.*;

public class TrabFisica2 {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Calculadora de Corrida");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        
        JTextField tempoCorredor1Min = new JTextField(10);
        JTextField tempoCorredor1Seg = new JTextField(10);
        panel.add(new JLabel("Tempo do Corredor 1 (minutos):"));
        panel.add(tempoCorredor1Min);
        panel.add(new JLabel("Tempo do Corredor 1 (segundos):"));
        panel.add(tempoCorredor1Seg);

        
        JTextField tempoCorredor2Min = new JTextField(10);
        JTextField tempoCorredor2Seg = new JTextField(10);
        panel.add(new JLabel("Tempo do Corredor 2 (minutos):"));
        panel.add(tempoCorredor2Min);
        panel.add(new JLabel("Tempo do Corredor 2 (segundos):"));
        panel.add(tempoCorredor2Seg);

       
        JTextField comprimentoRaia1 = new JTextField(10);
        panel.add(new JLabel("Comprimento da Raia 1 (metros):"));
        panel.add(comprimentoRaia1);

        
        JButton calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(e -> {
            try {
                
                int min1 = Integer.parseInt(tempoCorredor1Min.getText());
                double seg1 = Double.parseDouble(tempoCorredor1Seg.getText());
                int min2 = Integer.parseInt(tempoCorredor2Min.getText());
                double seg2 = Double.parseDouble(tempoCorredor2Seg.getText());

               
                double t1 = min1 * 60 + seg1;
                double t2 = min2 * 60 + seg2;

                
                double L1 = Double.parseDouble(comprimentoRaia1.getText());

                
                double deltaL = (t2 * L1 - t1 * L1) / t1;

                JOptionPane.showMessageDialog(frame, String.format("A diferença máxima permitida (L2 - L1) é: %.3f metros", deltaL));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Por favor, insira valores válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(calcularButton);

        
        frame.add(panel);
        frame.setVisible(true);
    }
}
