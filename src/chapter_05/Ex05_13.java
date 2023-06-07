package chapter_05;

class Ex05_13 {
    public static void main(String[] args) {
        int[][] ex_arr = new int[4][];
        ex_arr[0] = new int[3];
        ex_arr[1] = new int[2];
        ex_arr[2] = new int[3];
        ex_arr[3] = new int[4];
    
        
     
        for (int i = 0; i < ex_arr.length; i++) {
            for(int j = 0; j < ex_arr[i].length; j++) {
                ex_arr[i][j] = (i + 1)*10 + j;
            }
        }
        
        for (int i = 0; i < ex_arr.length; i++) {
            for (int j = 0; j < ex_arr[i].length; j++) {
                System.out.print(ex_arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}