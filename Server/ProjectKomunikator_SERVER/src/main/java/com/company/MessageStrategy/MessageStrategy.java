package com.company.MessageStrategy;

import com.company.Message;

/**
 * Created by Repcak on 19.03.2017.
 */
public interface MessageStrategy {
    boolean isApplicable(Message type);
    void execute(Message msg);
}
