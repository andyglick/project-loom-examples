import jdk.internal.vm.Continuation;
import jdk.internal.vm.ContinuationScope;

import static java.lang.System.out;

public class Continuations {

    public static void main(String[] args) {
        new Continuations().continuations();
    }

    void continuations() {
    // The scope is a tool for creating nested continuations.
    // to enable.
        ContinuationScope scope = new ContinuationScope("demo");
        Continuation a = new Continuation(scope, () -> {
            out.print("To be");
    // the function is "frozen" here
    // and gives control to the caller.
            Continuation.yield(scope);
            out.println("continued!");
        });
        a.run();
        out.print(" ... ");
    // the continuation can be moved from where it was stopped,
    // be continued.
        a.run();
    // ...
    }
}
