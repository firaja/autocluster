package org.autocluster;

import org.springframework.stereotype.Component;


@Component
public class Library implements BorderInterface
{

    public String execute()
    {
        return "Normal Execution";
    }




}
