package com.company.Audiences;

public class SeatAudiences {

    private static Audience[][] audiencePlace = new Audience[4][12];
    private static int nmb = 1;
    private static int index = 0;
    private static int nbPlace = 0;
    private static int k = 0,sign=1,sign1=2;

    public void addSeatAudiences(Audience audience){
        int[] AisleSeat = {2,3,6,7,8,9,3,4,7,8,9,10,5,8,9,10,11,12};//array indexes for aisle seat in array 2D
        int[] WindowSeat = {0,11,1,12,13,14};//array indexes for window seat in array 2D
        int[] MiddleSeat = {1,4,5,10,2,5,6,11,6,7,12,13};//array indexes for middle seat in array 2D

        sortPlaces(audience,AisleSeat,WindowSeat,MiddleSeat );
    }

    public void detk(int n1,int n2,int n3, int n4, int leng){//Function to specify the row in the 2D array which we want to add seats
        if(nmb>=leng && nmb<=n1+leng){//nmb variable to determine the number of seats added to a row of a 2D array
            k=0;
        }else if(nmb>n1+leng && nmb<=n2+leng){
            k=1;
        }else if(nmb>n2+leng && nmb<=n3+leng){
            k=2;
        }else if(nmb>n3+leng && nmb<=n4+leng){
            k=3;
        }else if(nmb==n4+leng+1){
            k=0;
        }
    }

    public void sortPlaces(Audience audience,int[] AisleSeat,int[] WindowSeat,int[] MiddleSeat ){
        int br = 0,i;

        for (i=k; i<=k ;i++){
            for (int j=0; j<audiencePlace[0].length ;j++){
                if(nmb<=AisleSeat.length) {
                    br = addPlace(i,j,AisleSeat,audience,0);//br exit the loop when the seat is added
                    detk(6,12,17,18,0);
                    if(br == 1){ break;}
                }else if(nmb>AisleSeat.length && nmb<=AisleSeat.length+WindowSeat.length){
                    br = addPlace(i,j,WindowSeat,audience,sign);
                    detk(2,4,5,6,AisleSeat.length);
                    sign+=3;
                    if(br == 1){ break;}
                }else if(nmb>AisleSeat.length+WindowSeat.length){
                    br = addPlace(i,j,MiddleSeat,audience,sign1);
                    sign1++;
                    detk(4,8,11,12,AisleSeat.length+WindowSeat.length);
                    if(br == 1){ break;}
                }
            }
            if(br == 1){ break;}
        }
    }

    public int addPlace(int i,int j,int[] tableIndex,Audience audience,int sign){//function to add a seat to a 2D array
        if(sign == 1 || sign == 2){ // sign variable to reset the index variable to start from the first element of the current table
            index = 0;
        }
        if(index < tableIndex.length) {
            if (i + j == tableIndex[index]) {
                if (audiencePlace[i][j] == null) {
                    nbPlace++;// nbPlace a variable to specify the place number
                    audience.setNumberPlace(nbPlace);
                    System.out.println("Place number " + nbPlace);
                    System.out.println("audiencePlace["+i+"]["+j+"]:");
                    audiencePlace[i][j] = audience;
                    System.out.println("user added successfully");
                    ++nmb;
                    ++index;
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void showListPassenger(){
        System.out.println("UserList:");
        for (int i=0; i<audiencePlace.length ;i++){
            for (int j=0; j<audiencePlace[0].length ;j++){
                if(audiencePlace[i][j] != null) {
                    System.out.println("audiencePlace["+i+"]["+j+"]"+audiencePlace[i][j]);
                }
            }
        }
    }
}
