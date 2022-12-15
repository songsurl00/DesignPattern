public class Movie implements MovieComponent{
    private String movieName;
    private int year;
    private double price;
    private String resolution;
    public Movie(String movieName, int year, double price, String resolution) {
        this.movieName = movieName;
        this.year = year;
        this.price = price;
        this.resolution = resolution;
    }

    public String getName() {
        return movieName;
    }

    public int getProductionYear() {
        return year;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean equals(MovieComponent m1, MovieComponent m2) {
        if (m1.getName() == m2.getName() && m1.getProductionYear() == m2.getProductionYear()) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "영화: " + movieName + ", 가격: " + price + " 원, 해상도: " + resolution;
    }
}
