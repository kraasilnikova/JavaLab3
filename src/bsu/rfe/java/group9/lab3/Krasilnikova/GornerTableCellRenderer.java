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
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int col)
    {
        // Преобразовать double в строку с помощью форматировщика
        String formattedDouble = formatter.format(value);
        // Установить текст надписи равным строковому представлению числа
        label.setText(formattedDouble);
        if (col==1 && needle!=null && needle.equals(formattedDouble))
            panel.setBackground(Color.RED);
        else panel.setBackground(Color.WHITE);
        return panel;
    }
    public void setNeedle(String needle)
    {
        this.needle = needle;
    }
}
