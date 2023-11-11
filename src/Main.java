package src;

public class Main {
    public static void main(String[] args) {
        // Run the GUI construction in the Event Dispatch Thread
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Create the GUI object
                GUI myGui = new GUI();

                // Show the GUI
                myGui.show();
            }
        });
    }
}
