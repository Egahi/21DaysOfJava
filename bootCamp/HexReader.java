class HexReader  {
    String[] input = {"00A110D1D260219", "78700F1318141E0C", "6A197D450FFFFFF"};

    public static void main(String[] arguments) {
        HexReader hex = new HexReader();
        for (int i = 0, j = hex.input.length; i < j; i++) {
            hex.readLine(hex.input[i]);
        }
    }

    void readLine(String code) {
        try {
            for (int j = 0, k = code.length(); j + 1 < k; j++) {
                String sub = code.substring(j, j + 2);
                int num = Integer.parseInt(sub, 16);
                if (num == 255)
                    return;
                System.out.print(num + " ");
            }
        } finally {
            System.out.println("***");
        }

        return;
    }
}