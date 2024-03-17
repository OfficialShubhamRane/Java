package termApp.demo;
import term.TerminalDriver;
import termApp.util.TermActionObject.OnActionListener;
import termApp.util.*;
import static termApp.util.Constants.*;
import static rds.RDSLog.*;
public class IdleScreen 
        extends AbstractDemoScreen {
    private Button nextBtn;
    private TextField tfPrompt1;

    public IdleScreen(TerminalDriver term) {
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

        nextBtn = new Button(160, 810, f, "Next", Align.RIGHT, -1, -1, COLOR_YELLOW, false);
            nextBtn.registerOnActionListener(new OnActionListener() {
                @Override
                public void onAction() {
                    setNextScreen("demo.PrintPackListScreen");
                }
            });
            nextBtn.show();

        tfPrompt1 = new TextField(160, 607, 80, TEXT_COLOR, "Screen 1", Align.LEFT, true);

    }
    /** Performs periodic tasks, once per cycle. */
    public void handleTick() {
        super.handleTick();  // calls handleScan -> processScan
        updateMsg();
    }
    private void updateMsg() {
    }
}