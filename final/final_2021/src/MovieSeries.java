import java.util.ArrayList;

public class MovieSeries implements MovieComponent {
    private ArrayList<MovieComponent> movieSeries = new ArrayList<MovieComponent>();
    private String seriesName;
    private int productionYear;
    private double discountRate;
    private double seriesPrice;
    public MovieSeries(String seriesName, int productionYear, double discountRate) {
        this.seriesName = seriesName;
        this.productionYear = productionYear;
        this.discountRate = discountRate;
        System.out.println("MovieSeries: 영화 시리즈 " + seriesName + " 생성, 할인율: " + discountRate);
    }
    public String getName() {
        return seriesName;
    }

    public int getProductionYear() {
        return productionYear;
    }
    public double getPrice() {
        for (MovieComponent movie: movieSeries) {
            seriesPrice += movie.getPrice();
        }
        seriesPrice = seriesPrice * (100 - discountRate) / 100;
        return seriesPrice;
    }
    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public boolean equals(MovieComponent m1, MovieComponent m2) {
        if (m1.getName() == m2.getName() && m1.getProductionYear() == m2.getProductionYear()) {
            return true;
        }
        return false;
    }
    public void add(MovieComponent m) {
        for (MovieComponent movie: movieSeries) {
            if (equals(movie, m)) {
                double oldPrice = movie.getPrice();
                movie.setPrice(m.getPrice());
                System.out.println("MovieSeries: 영화 " + movie.getName() + "가(이) 교체되었습니다.");
                System.out.println("MovieSeries: 기존 가격: " + oldPrice + "원, 새로운 가격: " + m.getPrice());
                return;
            }
        }
        movieSeries.add(m);
        System.out.println("MovieSeries: 영화 " + m.getName() + "가(이) 추가되었습니다.");
    }
    public void remove(MovieComponent m) {
        for (MovieComponent movie: movieSeries) {
            if (equals(movie, m)) {
                movieSeries.remove(movie);
                System.out.println("MovieSeries: 영화 " + m.getName() + "가(이) 삭제되었습니다.");
            }
        }
    }
    public void list() {
        for (MovieComponent movie: movieSeries) {
            System.out.println("영화: " + movie.getName() + ", 가격: " + movie.getPrice() + " 원");
        }
    }
    public MovieComponent getMovie(int i) {
        if (movieSeries.get(i) != null) {
            return movieSeries.get(i);
        }
        return null;
    }
    public String toString() {
        String str = "";
        for (MovieComponent movie: movieSeries) {
            str += "\t\t" + movie + "\n";
        }
        return "Movie Series Name: " + seriesName + ", Price: " + seriesPrice + "원, Discount rate: " + discountRate + "%" + "\n" + str;
    }
}
