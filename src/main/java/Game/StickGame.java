package Game;

public class StickGame {
    int stickLength;
    int pointLength;
    int stickSize;
    int pointSize;
    int currentActiveStick;
    boolean[] activeStickArray;
    String[] namesOwnerArray;

    public StickGame(int stickLength) {
        this.stickLength = stickLength;
        pointLength = stickLength + 1;
        stickSize = 2 * stickLength * pointLength;
        currentActiveStick = 0;
        activeStickArray = new boolean[stickSize];
        namesOwnerArray = new String[stickLength * stickLength];
        pointSize = pointLength * pointLength;
    }

    public void addStick(int number) {
        if (number < stickSize) {
            if (activeStickArray[number] = true) ;
        }
    }

    public int getStickNumber(int firstPointNumber, int secondPointNumber) {
        if ((firstPointNumber > pointSize) || (secondPointNumber > pointSize))
            return -1;
        if ((firstPointNumber < 0) || (secondPointNumber < 0))
            return -1;

        int start = Math.min(firstPointNumber, secondPointNumber);
        int end = Math.max(firstPointNumber, secondPointNumber);

        int startColumn = start % pointLength;
        int endColumn = end % pointLength;
        int startRow = (int) Math.ceil(start / pointLength);
        int endRow = (int) Math.ceil(end / pointLength);

        if ((Math.abs(endColumn - startColumn) == 1) && (startRow == endRow)) {
            return startRow * stickLength + startColumn;
        }
        if ((Math.abs(endRow - startRow) == 1) && (startColumn == endColumn)) {
            return stickLength * pointLength + startColumn * stickLength + startRow;
        }
        return -1;

    }

    public boolean isClosed(int number) {
        int column = number % stickLength;
        int row = (int) Math.ceil(number / stickLength);
        int upStick = number;
        int downStick = upStick + stickLength;
        int leftStick = pointLength * stickLength + stickLength * column + row;
        int rightStick = leftStick + stickLength;

        return (activeStickArray[upStick] && activeStickArray[downStick] && activeStickArray[leftStick] && activeStickArray[rightStick]);
    }

    public boolean[] getActiveStickArray() {
        return activeStickArray;
    }

}
