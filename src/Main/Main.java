package Main;

public class Main {
    public static void main(String[] args) {
        // Run the GUI construction in the Event Dispatch Thread
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //create loginUI
                LoginUI newUI = new LoginUI();
                // Create the GUI object
                //GUI myGui = new GUI();

                // Show the GUI
                //myGui.show();
            }
        });
    }
}
