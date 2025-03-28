import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTable;

public class Table{
    public static void main(String[] args){
        JFrame frame = new JFrame("Tableau avec JFrame");
        String[] titles = {"id", "Matériels informatiques", "Quantites"};

        Object[][] data = {
            {1, "PC", "30"},
            {2, "Tablettes", "45"},
            {3, "Imprimantes", "12"}
        };


JTable table = new JTable(data,titles);
frame.getContentPane().add(table.getTableHeader(), BorderLayout.NORTH);
frame.getContentPane().add(table);
        frame.setSize(450, 250);
        frame.setVisible(true);
    }
}