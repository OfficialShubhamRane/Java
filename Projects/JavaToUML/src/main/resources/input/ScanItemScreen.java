package termApp.demo;
import term.TerminalDriver;
import termApp.util.TermActionObject.OnActionListener;
import termApp.util.*;
import static termApp.util.Constants.*;
import static rds.RDSLog.*;
public class ScanItemScreen 
        extends AbstractDemoScreen {
private Button backBtn;
private TextField tfPrompt1;

public ScanItemScreen(TerminalDriver term) {
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
    
    backBtn = new Button(538, 810, f, "Back", Align.RIGHT, -1, -1, COLOR_YELLOW, false);
        backBtn.registerOnActionListener(new OnActionListener() {
            @Override
            public void onAction() {
                setNextScreen("demo.PrintPackListScreen");
            }
        });
        backBtn.show();

    tfPrompt1 = new TextField(240, 607, 80, TEXT_COLOR, "Screen 3", Align.LEFT, true);

}
/** Performs periodic tasks, once per cycle. */
public void handleTick() {
    super.handleTick();  // calls handleScan -> processScan
    updateMsg();
}
private void updateMsg() {
}
}