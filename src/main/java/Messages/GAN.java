package Messages;

import de.dailab.jiactng.agentcore.knowledge.IFact;

/**
 * Created by mahnoosh on 10/11/2017.
 */
public class GAN implements IFact {



    private int message;

    public GAN(int value) {
        this.message= value;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

}

