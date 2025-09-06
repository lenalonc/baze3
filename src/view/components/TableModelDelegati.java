/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.components;

import entity.Delegat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class TableModelDelegati extends AbstractTableModel {

    List<Delegat> delegati;

    private Class[] columnClass = new Class[]{
        String.class, Long.class, String.class, String.class
    };

    public TableModelDelegati(List<Delegat> delegati) {
        this.delegati = delegati;
    }

    @Override
    public int getRowCount() {
        if (delegati == null) {
            return 0;
        }
        return delegati.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Ime i prezime";
            case 1:
                return "JMBG";
            case 2:
                return "Zaposlenost";
            case 3:
                return "Adresa";
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
        Delegat delegat = delegati.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return delegat.getImePrezime();
            case 1:
                return delegat.getJmbg();
            case 2:
                return delegat.getZaposlenostStatus().name();
            case 3:
                if (delegat.getBroj() != null && delegat.getBroj().getUlica() != null && delegat.getBroj().getUlica().getMesto() != null && delegat.getBroj().getUlica().getMesto().getOpstina() != null) {
                    return delegat.getBroj().getVrednost() + " " + delegat.getBroj().getUlica().getNaziv() + " " + delegat.getBroj().getUlica().getMesto().getNaziv() + " "
                            + delegat.getBroj().getUlica().getMesto().getOpstina().getNaziv();
                } else {
                    return "";
                }

            default:
                return "n/a";
        }
    }

    public List<Delegat> getDelegati() {
        return delegati;
    }

}
