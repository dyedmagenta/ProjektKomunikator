package com.company.MessageStrategy;

import com.company.Message;

/**
 * Created by Repcak on 19.03.2017.
 */
public class PublicMessage implements MessageStrategy {


    @Override
    public boolean isApplicable(Message type) {
        return false;
    }

    @Override
    public void execute(Message msg) {

    }
}
