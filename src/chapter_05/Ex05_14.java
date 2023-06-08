package chapter_05;

class Ex05_14 {
    static int[] makeArray() {
        int[] temp = new int[4];
        
        for (int i = 0; i < temp.length; i++) {
            temp[i] = i;
        }
        return temp;
    }
    
    public static void main(String[] args) {
        int[] new_arr = makeArray();
        
        for (int j = 0; j < new_arr.length; j++ ) {
            System.out.print(new_arr[j] + " ");
        }
        System.out.println();
    }
}