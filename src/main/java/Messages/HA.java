package Messages;

import de.dailab.jiactng.agentcore.knowledge.IFact;

/**
 * Created by mahnoosh on 10/10/2017.
 */
public class HA implements IFact {



    private int message;

    public HA(int value) {
        this.message= value;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

}