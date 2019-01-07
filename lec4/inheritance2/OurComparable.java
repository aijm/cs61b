public interface OurComparable<T> {
    /** compareTo
     * @param o
     * @return <: -1; =: 0, >: 1
     */
    int compareTo(T o);
}
