package com.patterns.structural.proxy;

import java.io.IOException;

interface ExecutorCommand {
    void execute(String cmd);
}


// Concrete class implementing ExecutorCommand interface
class ExecutorCommandImpl implements ExecutorCommand {
    @Override
    public void execute(String cmd) {
        try {
            Runtime.getRuntime().exec(cmd);
            System.out.println("'" + cmd + "' command executed.");
        } catch (IOException e) {
            System.out.println("Error while executing command: " + e.getMessage());
        }
    }
   
}

// Now we want to provide only admin users to have full access of above class,
// if the user is not admin then only limited commands will be allowed.
// Proxy class
class ExecutorCommandProxy implements ExecutorCommand {
    private boolean isAdmin;
    private final ExecutorCommand executorCommand;

    public ExecutorCommandProxy(String user, String pwd) {
        if ("admin".equals(user) && "123".equals(pwd))
            isAdmin = true;
        executorCommand = new ExecutorCommandImpl();
    }

    @Override
    public void execute(String cmd) {
        if (isAdmin) {
            executorCommand.execute(cmd);
        } else {
            if (cmd.trim().startsWith("rm")) {
                System.out.println("rm command is not allowed for non-admin users.");
            } else {
                executorCommand.execute(cmd);
            }
        }
    }
}


class Demo {
    public static void main(String[] args) {
        ExecutorCommand executorCommand = new ExecutorCommandProxy("normalUser", "111");
        executorCommand.execute("ls -ltr");
        executorCommand.execute("rm -rf abc.pdf");
        executorCommand.execute("ls -ltr");
    }
}