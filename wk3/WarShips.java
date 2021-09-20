

public class WarShips {
    
    public void placeWarShipHorizontal(String[][] ship, int row, int col){
        row--;
        col--;
        int count = 0;
        if(ship[row][col] == "*"){
            for(int i = 0; i < ship.length; i++){
                for(int j = 0; j < ship[i].length; j++){
                    if(col + 5 > ship[i].length){
                        while(count < 5){
                            ship[row][col--] = "P1";
                            count++;
                        }
                    }else{
                        while(count < 5){
                            ship[row][col++] = "P1";
                            count++;
                        }
                    }
                }
            }
        }else{
            System.out.println("There is already a vessel at this location.");
        }
    }

        public void placeWarShipVertical(String[][] ship, int row, int col){
        row--;
        col--;
        int count = 0;
        if(ship[row][col] == "*"){
            for(int i = 0; i < ship.length; i++){
                for(int j = 0; j < ship[i].length; j++){
                    if(row + 5 > 15){
                        while(count < 5){
                            ship[row--][col] = "P2";
                            count++;
                        }
                    }else{
                        while(count < 5){
                            ship[row++][col] = "P2";
                            count++;
                        }
                    }
                }
            }
        }else{
            System.out.println("There is already a vessel at this location.");
        }
    }

}