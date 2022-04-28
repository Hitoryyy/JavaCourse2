package Lesson2.poly;

public class TransportApp {
    public static void main(String[] args) {
        Transport[] transports = new Transport[]{new Cater(), new Ship(), new Bus()}; //is a
        for(Transport transport : transports){
            transport.load();

            if (transport instanceof Swimmable) {
                System.out.println("Это штука плавает");
                Swimmable swimmable = (Swimmable) transport; //type-cast приведение типа
                swimmable.swim();
            }

            if (transport instanceof Bus) {
                Bus bus = (Bus) transport; //приведение типа
                System.out.println("маршрут " + bus.getMarshroute());
            }
            System.out.println();
        }

        NewsService newsService = new OracleNewsService();

        ///complex logic

        newsService.getNews();
    }
}
