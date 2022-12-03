package A4_Flights;

//*** NOTE: this class is complete ***//
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * CSV Parser class
 *
 * Goals: - encapsulate the file open and reading in one class - remove the need
 * to try..catch in the calling code - design the interface to allow for future
 * extension (eg. quotes and commas within fields)
 */
public class CSV_Parser implements CSV_RecordSource {

    private Scanner sc = null;
    private String delimiter = ",";

    public boolean open(String filename) {
        try {
            resetRecord();
            sc = new Scanner(new File(filename));
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("CSV Parser, open exception=" + ex.getMessage());
            return false;
        }
    }

    public void close() {
        resetRecord();
        if (sc == null)
            return;
        try {
            sc.close();
        } catch (Exception ex) {
            System.out.println("CSV Parser, close exception=" + ex.getMessage());
        }
        sc = null;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    private String currentLine = null;
    private String[] currentFields = null;
    private boolean errorDetected = false;

    private void resetRecord() {
        currentLine = null;
        currentFields = null;
        errorDetected = false;
    }

    public boolean getNextLine() {
        resetRecord();
        if (sc == null)
            return false;

        if (!sc.hasNextLine())
            return false;

        currentLine = sc.nextLine();
        currentFields = currentLine.split(delimiter);
        return true;
    }

    public String getLine() {
        return currentLine;
    }

    public String[] nextLineParts() {
        return currentFields;
    }

    @Override
    public String getString(int iField) {
        if (currentFields == null)
            return null;
        if (iField < 0 || iField >= currentFields.length)
            return null;
        return currentFields[iField];
    }

    @Override
    public int getInteger(int iField) {
        String s = getString(iField);
        try {
            if (s != null)
                return Integer.valueOf(s);
        } catch (NumberFormatException ex) {
        }
        errorDetected = true;
        return 0;
    }

    @Override
    public double getDouble(int iField) {
        String s = getString(iField);
        try {
            if (s != null)
                return Double.valueOf(s);
        } catch (NumberFormatException ex) {
        }
        errorDetected = true;
        return 0;
    }

    @Override
    public boolean errorsDetected() {
        return errorDetected;
    }
}
