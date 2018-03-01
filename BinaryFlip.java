class BinaryFlip {
    public static int findComplement(int num) {
        String binary =Integer.toBinaryString(num);
        int flipped = 0;
        for(int i = binary.length() - 1; i >= 0; i--){
            if(binary.charAt(i) == '0'){
                flipped += Math.pow(2, binary.length() - i - 1);
            }
        }
        return flipped;
    }

    public static void main(String[] args){
        int test = 2;
        System.out.println(findComplement(test));
    }
}
