class HammingDistance {
    public int hammingDistance(int x, int y) {
        String b1 = Integer.toBinaryString(x);
        String b2 = Integer.toBinaryString(y);
        if(x > y){
            b2 = String.format("%1$" + b1.length() + "s",  b2).replace(' ', '0');
        } else {
            b1 = String.format("%1$" + b2.length() + "s", b1).replace(' ', '0');
        }
        int diff = 0;
        for(int i=b1.length()-1; i >= 0; i--){
            if(b1.charAt(i) != b2.charAt(i)){
                diff += 1;
            }
        }
        return diff;
    }
    
    public static void main(String[] args){
        HammingDistance hd = new HammingDistance();
        int diff = hd.hammingDistance(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        System.out.println(diff);
    }
}
