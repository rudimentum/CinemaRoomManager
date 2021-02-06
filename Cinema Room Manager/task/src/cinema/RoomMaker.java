package cinema;

public class RoomMaker {
    private int[] sizes;
    private String[][] room;

    public RoomMaker() {}

    public void setSizes(int[] sizes) {
        this.sizes = sizes;
    }

    public String[][] getRoom() {
        return createRoom();
    }

    public String [][] createRoom() {
        int rows = sizes[0];
        int seats = sizes[1];
        room = new String[++rows][++seats];
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                if (i == 0 && j == 0) {
                    room[i][j] = " ";
                }
                else if (i == 0) {
                    room[i][j] = String.valueOf(j);
                } else if (j == 0){
                    room[i][j] = String.valueOf(i);
                } else {
                    room[i][j] = "S";
                }
            }
        }
        return room;
    }
}
