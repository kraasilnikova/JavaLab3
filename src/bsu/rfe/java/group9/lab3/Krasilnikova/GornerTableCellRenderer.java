package bsu.rfe.java.group9.lab3.Krasilnikova;

import java.awt.*;
import java.text.*;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class GornerTableCellRenderer implements TableCellRenderer
{
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private String needle = null;
    private DecimalFormat formatter = (DecimalFormat)NumberFormat.getInstance();

    public GornerTableCellRenderer()
    {
        // Показывать только 5 знаков после запятой
        formatter.setMaximumFractionDigits(5);
        // Не использовать группировку (т.е. не отделять тысячи ни запятыми, ни пробелами)
        formatter.setGroupingUsed(false);
        // Установить в качестве разделителя дробной части точку, а не  запятую
        DecimalFormatSymbols dottedDouble = formatter.getDecimalFormatSymbols();
        dottedDouble.setDecimalSeparator('.');
        formatter.setDecimalFormatSymbols(dottedDouble);
        // Разместить надпись внутри панели
        panel.add(label);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    }
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col)
    {
        // Преобразовать double в строку с помощью форматировщика
        String formattedDouble = formatter.format(value);
        // Установить текст надписи равным строковому представлению числа
        label.setText(formattedDouble);
        
        int indexDot = formattedDouble.indexOf(".");
        int count = 0;
        if (indexDot != -1)
        {
            for (int i = indexDot + 1; i < formattedDouble.length(); i++)
            {
                char letter = formattedDouble.charAt(i);
                if (letter == '1' || letter == '3' || letter == '5')
                    count += 1;
            }
        }
        if (count == formattedDouble.length() - formattedDouble.indexOf(".") - 1)
        {
            if (col==1 && needle!=null && needle.equals(formattedDouble))
                panel.setBackground(Color.RED);
            else panel.setBackground(Color.PINK);
        }
        else
        {
            if (col==1 && needle!=null && needle.equals(formattedDouble))
                panel.setBackground(Color.RED);
            else panel.setBackground(Color.WHITE);
        }
        return panel;
    }
    public void setNeedle(String needle)
    {
        this.needle = needle;
    }
}
