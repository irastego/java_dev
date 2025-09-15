public class GlavniProgram {
    public static void main(String[] args) {
        Window prozor1 = new Window();

        prozor1.naslov = "Moj prvi prozor";
        prozor1.oznaka = "win_001";
        prozor1.x1 = 10;
        prozor1.y1 = 10;
        prozor1.x2 = 100;
        prozor1.y2 = 50;
        prozor1.bojaR = 255;
        prozor1.bojaG = 255;
        prozor1.bojaB = 255;
        prozor1.isAktivan = true;

        System.out.println("Naslov: " + prozor1.naslov);
        System.out.println("Oznaka: " + prozor1.oznaka);
        System.out.println("Koordinate: (" + prozor1.x1 + ", " + prozor1.y1 + ") - (" + prozor1.x2 + ", " + prozor1.y2 + ")");
        System.out.println("Aktivan: " + prozor1.isAktivan);
    }
}