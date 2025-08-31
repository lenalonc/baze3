/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.components;

import entity.Ugovor;
import java.time.LocalDate;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class TableModelUgovori extends AbstractTableModel {

    List<Ugovor> ugovori;

    private Class[] columnClass = new Class[]{
        LocalDate.class, String.class, String.class, String.class
    };

    public TableModelUgovori(List<Ugovor> ugovori) {
        this.ugovori = ugovori;
    }

    @Override
    public int getRowCount() {
        if (ugovori == null) {
            return 0;
        }
        return ugovori.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Datum";
            case 1:
                return "Adresa";
            case 2:
                return "Delegat";
            case 3:
                return "Zajednica klubova";
            default:
                return "n/a";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIdx) {
        if (columnIdx > columnClass.length) {
            return Object.class;
        } else {
            return columnClass[columnIdx];
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ugovor ugovor = ugovori.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ugovor.getDatum();
            case 1:
                return ugovor.getMesto() != null ? ugovor.getMesto().getNaziv() : "";
            case 2:
                return ugovor.getDelegat() != null ? ugovor.getDelegat().getImePrezime() : "";
            case 3:
                return ugovor.getZk() != null ? ugovor.getZk().getNaziv() : "";

            default:
                return "n/a";
        }
    }

    public List<Ugovor> getUgovori() {
        return ugovori;
    }

}
