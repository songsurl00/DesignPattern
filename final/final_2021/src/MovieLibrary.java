import java.util.ArrayList;

public class MovieLibrary implements MovieComponent {
    private ArrayList<MovieComponent> movieLibrary = new ArrayList<MovieComponent>();
    private String libraryName;
    private double libraryPrice = 0;
    public MovieLibrary(String libraryName) {
        this.libraryName = libraryName;
    }
    public void insert(MovieComponent m, boolean b) {
        if (b) {
            for (MovieComponent movie: movieLibrary) {
                if (movie.getName().equals(m.getName())) {
                    movieLibrary.remove(movie);
                    movieLibrary.add(m);
                }
            }
        }
        else {
            movieLibrary.add(m);
            System.out.println("MovieLibrary: " + m.getProductionYear() + " 년도에 제작된(구성된) 영화(시리즈) " + m.getName() + " 가(이) 추가되었습니다.");
        }
    }
    public void delete(MovieComponent m) {
        for (int i = 0; i < movieLibrary.size(); i++) {
            if (movieLibrary.get(i).getName() == m.getName()) {
                movieLibrary.remove(movieLibrary.get(i));
                System.out.println("MovieLibrary: " + m.getProductionYear() + " 년도에 제작된(구성된) 영화(시리즈) " + m.getName() + " 를(을) 삭제했습니다.");
                return;
            }
        }
        System.out.println("MovieLibrary: " + m.getProductionYear() + " 년도에 제작된(구성된) 영화(시리즈) " + m.getName() + " 가(이) 없습니다.");
    }

    public String toString() {
        String str = "";
        for (MovieComponent movie: movieLibrary) {
            libraryPrice += movie.getPrice();
            str += movie + "\n";
        }
        return "영화 라이브러리: " + libraryName + "\n" + "영화(시리즈) 개수: " + movieLibrary.size() + "\t\t영화 라이브러리 전체 구매 가격: " + libraryPrice + "\n\n" + str;
    }
}
