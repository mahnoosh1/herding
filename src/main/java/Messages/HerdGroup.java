package Messages;

import de.dailab.jiactng.agentcore.knowledge.IFact;

/**
 * Created with IntelliJ IDEA.
 * User: mahnoosh
 * Date: 4/8/15
 * Time: 5:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class HerdGroup implements IFact {



    private String message;

    public HerdGroup(String value) {
        this.message= value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}