package Calculator.src;


/**
 *
 * @author Junyan Zhu
 */
public class CalculatorModel {


    public static enum Operation {

        ADD("+"), SUB("-"), MUL("*"), DIV("/"), CLEAR("c"), EQUALS("=");

        private final String label;

        /**
         * Construct a new operation
         *
         * @param label The given key for the operation (and how the operation
         * is displayed)
         */
        private Operation(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    public static enum Mode {


        RESULT,
        ENTERING,
        ERROR
    }

    /**
     * Construct a CalculatorModel in default state.
     */
    public CalculatorModel() {
        accumulator = 0;
        num = 0;
        mode = Mode.ENTERING;
        pendingOperation = null;
        lastKeyWasEquals = false;
    }

    /**
     * An individual digit press (0-9)
     *
     * @param theKey The value pressed
     */
    public void digitKey(int theKey) {
    	if(lastKeyWasEquals) {
    		accumulator = 0;
    		num = 0;
    		mode = Mode.ENTERING;
    		pendingOperation = null;
    		lastKeyWasEquals = false;
    	}
        if( mode==Mode.ENTERING ) {
            num = num * 10 + theKey;
        }else if( mode==Mode.RESULT ) {
        	mode = Mode.ENTERING;
            num = theKey;
        }
    }

    /**
     * An operation was pressed
     *
     * @param theNewOp The specific operation (Using the Operation enumeration)
     */
    public void operationKey(Operation theNewOp) {
//    	if(pendingOperation == null)
//    		pendingOperation = theNewOp;
        if( mode==Mode.ENTERING) {
            switch(theNewOp) {
                case ADD:
                case SUB:
                case MUL:
                case DIV:
                    applyPending();
                    pendingOperation = theNewOp;
                    break;
                case CLEAR:
                    pendingOperation = theNewOp;
                    applyPending();
                    break;
                case EQUALS:
                    applyPending();
                    lastKeyWasEquals = true;
                    break;
            }
        }else if( mode==Mode.RESULT) {
            switch(theNewOp) {
                case CLEAR:
                    pendingOperation = theNewOp;
                    applyPending();
                    break;
                case EQUALS:
                    applyPending();
                    lastKeyWasEquals = true;
                    break;
                default:
                    pendingOperation = theNewOp;
                    break;
            }
        }else if( mode==Mode.ERROR) {
        	if(theNewOp == Operation.CLEAR){
        		pendingOperation = theNewOp;
        		applyPending();
        	}
        }
        if(theNewOp!=Operation.EQUALS)
        	lastKeyWasEquals = false;
    }

    /**
     * the value that should be shown on the screen
     *
     * @return string representing the value.
     */
    public String getScreen() {
        String s = "";
        switch(mode) {
            case ENTERING:
                s = num + "";
                break;
            case RESULT:
                s = accumulator + "";
                break;
            case ERROR:
                s = "ERROR";
                break;
        }
        return s;
    }

    private void applyPending() {
    	if(pendingOperation == null) {
    		accumulator = num;
    		mode = Mode.RESULT;
    		return;
    	}
        switch(pendingOperation) {
            case ADD:
                accumulator = accumulator + num;
                break;
            case SUB:
                accumulator = accumulator - num;
                break;
            case MUL:
                accumulator = accumulator*num;
                break;
            case DIV:
                if(num==0) {
                	mode = Mode.ERROR;
                	return;
                }
                accumulator = accumulator/num;
                break;
            case CLEAR:
                accumulator = 0;
                num = 0;
                mode = Mode.ENTERING;
                pendingOperation = null;
                lastKeyWasEquals = false;
                return;
            default:
                break;
        }
        mode = Mode.RESULT;
    }

    
    protected int accumulator;            
    protected int num;                    
    protected Operation pendingOperation; 
    protected Mode mode;                  
    protected boolean lastKeyWasEquals;   
}
