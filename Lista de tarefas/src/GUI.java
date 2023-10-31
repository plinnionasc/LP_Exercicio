public interface GUI {
    import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

    public class ListaDeTarefasGUI extends JFrame {
        private ArrayList<Tarefa> tarefas;

        private JList<String> listaTarefas;
        private DefaultListModel<String> model;
        private JTextField campoTarefa;
        private JButton botaoAdicionar;
        private JButton botaoRemover;

        public ListaDeTarefasGUI(ArrayList<Tarefa> tarefas) {
            this.tarefas = tarefas;

            setTitle("Lista de Tarefas");
            setSize(400, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            model = new DefaultListModel<>();
            for (Tarefa tarefa : tarefas) {
                model.addElement(tarefa.getNome_tarefa());
            }

            listaTarefas = new JList<>(model);
            JScrollPane scrollPane = new JScrollPane(listaTarefas);

            campoTarefa = new JTextField(20);

            botaoAdicionar = new JButton("Adicionar");
            botaoRemover = new JButton("Remover");

            botaoAdicionar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nomeTarefa = campoTarefa.getText();
                    Tarefa novaTarefa = new Tarefa();
                    novaTarefa.setCod_tarefa(tarefas.size()); // Ajuste o código da tarefa conforme necessário
                    novaTarefa.setNome_tarefa(nomeTarefa);
                    adicionarTarefa(novaTarefa);
                    campoTarefa.setText("");
                }
            });

            botaoRemover.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int indiceSelecionado = listaTarefas.getSelectedIndex();
                    if (indiceSelecionado >= 0) {
                        removerTarefa(indiceSelecionado);
                    }
                }
            });

            setLayout(new BorderLayout());

            JPanel painelSuperior = new JPanel();
            painelSuperior.add(campoTarefa);
            painelSuperior.add(botaoAdicionar);
            painelSuperior.add(botaoRemover);

            add(painelSuperior, BorderLayout.NORTH);
            add(scrollPane, BorderLayout.CENTER);
        }

        private void setSize(int i, int i1) {
        }

        private void setTitle(String listaDeTarefas) {
        }

        private void adicionarTarefa(Tarefa tarefa) {
            tarefas.add(tarefa);
            model.addElement(tarefa.getNome_tarefa());
        }

        private void removerTarefa(int indice) {
            tarefas.remove(indice);
            model.remove(indice);
        }

        public static void main(String[] args) {
            ArrayList<Tarefa> tarefas = new ArrayList<>();
            ListaDeTarefasGUI gui = new ListaDeTarefasGUI(tarefas);
            gui.setVisible(true);
        }

        private void setVisible(boolean b) {
        }
    }

}
