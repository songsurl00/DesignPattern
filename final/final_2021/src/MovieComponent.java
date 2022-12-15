public interface MovieComponent {
    default String getName() {
        throw new UnsupportedOperationException();
    }
    default int getProductionYear() {
        throw new UnsupportedOperationException();
    }
    default double getPrice() {
        throw new UnsupportedOperationException();
    }
    default MovieComponent getMovie(int i) {
        throw new UnsupportedOperationException();
    }
    default void setProductionYear(int productionYear) {
        throw new UnsupportedOperationException();
    }
    default void setPrice(double price) {
        throw new UnsupportedOperationException();
    }
    default boolean equals(MovieComponent m1, MovieComponent m2) {
        throw new UnsupportedOperationException();
    }
    default void add(MovieComponent m) {
        throw new UnsupportedOperationException();
    }
    default void remove(MovieComponent m) {
        throw new UnsupportedOperationException();
    }
    default void list() {
        throw new UnsupportedOperationException();
    }
    default void insert(MovieComponent m, boolean b) {
        throw new UnsupportedOperationException();
    }
    default void delete(MovieComponent m) {
        throw new UnsupportedOperationException();
    }
}
