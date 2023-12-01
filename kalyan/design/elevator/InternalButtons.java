package kalyan.design.elevator;


public class InternalButtons {

    InternalDispatcher dispatcher = new InternalDispatcher();
    void pressButton(int destination, Direction direction) {
        dispatcher.submitInternalRequest(destination, direction);
    }

}
