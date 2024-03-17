package termApp.demo;
import term.TerminalDriver;
import termApp.util.TermActionObject.OnActionListener;
import termApp.util.*;
import static termApp.util.Constants.*;
import static rds.RDSLog.*;
public class PrintPackListScreen 
        extends AbstractDemoScreen {
private Button skipBtn;
private Button printBtn;
private TextField tfPrompt1;

public PrintPackListScreen(TerminalDriver term) {
    super(term);
    setLogoutAllowed(true);
}
/** Initializes the screen and lays out UI elements. */
public void initDisplay() {
    initButtons();
    super.initDisplay();
}
public void handleInit() {
    super.handleInit();
    header.init();
    header.updateTitle("Demo");
}
private void initButtons() {
    int f = BTN_FONT;
    
    skipBtn = new Button(160, 810, f, "Skip", Align.RIGHT, -1, -1, COLOR_YELLOW, false);
        skipBtn.registerOnActionListener(new OnActionListener() {
            @Override
            public void onAction() {
                setNextScreen("demo.IdleScreen");
            }
        });
        skipBtn.show();

    printBtn = new Button(1040, 810, f, "Print", Align.RIGHT, -1, -1, COLOR_YELLOW, false);
        printBtn.registerOnActionListener(new OnActionListener() {
            @Override
            public void onAction() {
                setNextScreen("demo.ScanItemScreen");
            }
        });
        printBtn.show();

    tfPrompt1 = new TextField(160, 607, 80, TEXT_COLOR, "Screen 2", Align.LEFT, true);

}
/** Performs periodic tasks, once per cycle. */
public void handleTick() {
    super.handleTick();  // calls handleScan -> processScan
    updateMsg();
}
private void updateMsg() {
}
}